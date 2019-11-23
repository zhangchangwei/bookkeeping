package com.book.keeping.bookkeeping.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.book.keeping.bookkeeping.common.exception.TokenInvalidException;
import com.book.keeping.bookkeeping.common.result.Result;
import com.book.keeping.bookkeeping.common.result.ResultEnum;
import com.book.keeping.bookkeeping.config.http.HttpService;
import com.book.keeping.bookkeeping.entity.KeepingBook;
import com.book.keeping.bookkeeping.entity.User;
import com.book.keeping.bookkeeping.entity.parameter.WeiXInPostInfo;
import com.book.keeping.bookkeeping.entity.reflect.UserMonthDayBook;
import com.book.keeping.bookkeeping.service.UserService;
import com.book.keeping.bookkeeping.utils.GlobalIdUtil;
import com.book.keeping.bookkeeping.utils.TokenUtil;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户控制层
 *
 * @author zhang.penghao
 * @version V1.0
 * @date 2019/11/7
 */
@Slf4j
@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final String APP_ID = "wx6553d8ca833c75af";
    private final String SECRET_ID = "c5cceae911489c4d691d52ecf746ccba";

    @Autowired
    UserService userService;

    @Autowired
    HttpService httpService;

    @GetMapping
    public Result listUser( User user) {
//        if(true){
//            throw new TokenInvalidException();
//        }
        return Result.success(userService.listUser(1, 1));
    }

    @PostMapping
    public Result insertUser(String userId,@RequestBody User user) {
        user.setUserId(userId);
        return Result.success(userService.listUser(1, 1));
    }

    /**
     * 初次授权  获取 token 用信息
     *
     * 之后登陆 获取用户信息
     *
     * */
    @PostMapping("/wx/info")
    public Result checkWinXinInfo(@RequestBody WeiXInPostInfo weiXInPostInfo) throws Exception {
        String uri = "https://api.weixin.qq.com/sns/jscode2session?appid=" + APP_ID
                + "&secret=" + SECRET_ID
                + "&grant_type=authorization_code&js_code="
                + weiXInPostInfo.getJsCode();
        JSONObject result  = (JSONObject)JSON.parse(httpService.doGet(uri));
        log.info(weiXInPostInfo.toString());
        log.info(result.toString());
        if(result.getInteger("errcode") == null){
            String userId = GlobalIdUtil.nextId();
            User user = new User();
            user.setNickName(weiXInPostInfo.getNickName());
            user.setUserId(userId);
            user.setOpenId(result.getString("openid"));
            user.setFaceImage(weiXInPostInfo.getAvatarUrl());
            user.setPassword(DigestUtils.sha1Hex(userId.substring(0,8)));
            user.setStatus(0);
            if(userService.insertUser(user) > 0){
                result.put("userId", userId);
                result.put("token", TokenUtil.createToken(userId));
                return Result.success(result);
            }else{
                return Result.error(ResultEnum.FAIL_ERROR_PARAM);
            }
        }else{
            return Result.error(result.getInteger("errcode"), result.getString("errmsg"));
        }
    }
}


