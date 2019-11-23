package com.book.keeping.bookkeeping.config.filter;

import com.book.keeping.bookkeeping.common.Constant;
import com.book.keeping.bookkeeping.utils.TokenUtil;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.*;

/**
 * 功能描述
 *
 * @author zhang.penghao
 * @date 2019/3/12 09:13
 */
@Slf4j
public class GlobalServletRequestWrapper extends HttpServletRequestWrapper {

    GlobalServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }
    /**
     * 会通过此方法获取所有的请求参数并进行遍历，对pojo属性赋值
     */
    @Override
    public Enumeration<String> getParameterNames() {
        Enumeration<String> enumeration = super.getParameterNames();
        ArrayList<String> list = Collections.list(enumeration);
        if (!list.contains("userId")){
            list.add("userId");
            return Collections.enumeration(list);
        }else {
            return super.getParameterNames();
        }
    }
    @Override
    public String[] getParameterValues(String name) {
        if ("userId".equals(name)){
            Object isCheckToken = super.getAttribute(Constant.CHECK_TOKEN_INDEX);
            if(isCheckToken == null){
                return new String[]{TokenUtil.getUserId(super.getHeader("token"))};
            }
        }
        return super.getParameterValues(name);
    }
}
