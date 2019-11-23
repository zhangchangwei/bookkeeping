package com.book.keeping.bookkeeping.utils;


import com.book.keeping.bookkeeping.common.AesOperator;
import com.book.keeping.bookkeeping.common.Constant;
import com.book.keeping.bookkeeping.common.exception.TokenInvalidException;
import lombok.extern.slf4j.Slf4j;

/**
 * 用户验证Token工具类
 *
 * @author zhang.penghao
 * @version V1.0
 * @date 2018/12/25 16:39
 */
@Slf4j
public class TokenUtil {


    /**
     * 创建token并缓存
     *
     * @param userId        用户ID
     * @return String token
     * @author zhang.penghao
     */
    public static String createToken(String userId) {
        String tokenOrigin = String.join(Constant.TOKEN_HEADER, userId, String.valueOf(System.currentTimeMillis()));
        return AesOperator.getInstance().encrypt(tokenOrigin + Constant.TOKEN_SLAT  + userId);
    }

    /**
     * 获取token缓存
     * @return String token
     * @author zhang.penghao
     * @date 2019/1/4 14:44
     * @since V1.0
     */
    public static String getUserId(String token) {
        String tokenOrigin = AesOperator.getInstance().decrypt(token);
        return tokenOrigin.split(Constant.TOKEN_SLAT)[1];
    }

}
