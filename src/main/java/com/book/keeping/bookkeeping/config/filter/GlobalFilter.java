package com.book.keeping.bookkeeping.config.filter;

import com.book.keeping.bookkeeping.common.AesOperator;
import com.book.keeping.bookkeeping.common.Constant;
import com.book.keeping.bookkeeping.common.exception.TokenInvalidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 过滤器配置
 * @author zhang.penghao
 * @date 2018/7/11 11:38
 */
@Component
@Slf4j
@WebFilter(urlPatterns = "/*", filterName = "authFilter")
public class GlobalFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        String path = ((HttpServletRequest) req).getRequestURI();
        log.info(path);
        if (path.startsWith("/book/user/wx/info")) {
            chain.doFilter(req, res); // 排除的url
        }else{
            String token = ((HttpServletRequest)req).getHeader("token");
            if(token == null || AesOperator.getInstance().decrypt(token) == null || AesOperator.getInstance().decrypt(token).indexOf(Constant.TOKEN_SLAT ) < 1){
                req.setAttribute(Constant.CHECK_TOKEN_INDEX,false);
            }
            chain.doFilter(new GlobalServletRequestWrapper((HttpServletRequest) req), res);
        }
    }

    @Override
    public void destroy() {

    }
}
