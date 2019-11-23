package com.book.keeping.bookkeeping.config.handler;

import com.book.keeping.bookkeeping.common.Constant;
import com.book.keeping.bookkeeping.common.exception.TokenInvalidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器配置
 * @author zhang.penghao
 * @date 2018/7/11 11:36
 */
@Slf4j
@Configuration
public class AppInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if(request.getAttribute(Constant.CHECK_TOKEN_INDEX) != null){
            throw new TokenInvalidException();
        }
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        log.info("test AppInterceptor postHandle");
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        log.info("test AppInterceptor afterCompletion");
    }

}
