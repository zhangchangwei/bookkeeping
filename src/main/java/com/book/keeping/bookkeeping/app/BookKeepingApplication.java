package com.book.keeping.bookkeeping.app;

import com.book.keeping.bookkeeping.config.handler.AppInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 启动类
 * @author zhang.penghao
 * @date 2019/11/7
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.book.keeping.bookkeeping.controller", "com.book.keeping.bookkeeping.service",
        "com.book.keeping.bookkeeping.entity", "com.book.keeping.bookkeeping.config"})
@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.book.keeping.bookkeeping.mapper")
public class BookKeepingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookKeepingApplication.class, args);
    }

    @Bean
    public AppInterceptor setAppInterceptorBean(){
        return new AppInterceptor();
    }

    @Bean
    public WebMvcConfigurer crossOriginConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry){

                registry.addInterceptor(setAppInterceptorBean())
                        .addPathPatterns("/**")
                        .excludePathPatterns(
                                "/book/user/wx/info"
                        );
            }

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/book/**")
                        .allowedOrigins("*")
                        .allowCredentials(true)
                        .allowedMethods("GET", "POST", "DELETE", "PUT","PATCH")
                        .maxAge(3600);
            }
        };
    }

}
