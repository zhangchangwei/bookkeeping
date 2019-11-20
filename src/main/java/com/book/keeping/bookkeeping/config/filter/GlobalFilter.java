package com.book.keeping.bookkeeping.config.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 过滤器配置
 * @author zhang.penghao
 * @date 2018/7/11 11:38
 */
@Component
@Slf4j
public class GlobalFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(new GlobalServletRequestWrapper((HttpServletRequest) req), res);
    }

    @Override
    public void destroy() {

    }
}
