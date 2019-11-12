package com.book.keeping.bookkeeping.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * 启动类
 * @author zhang.penghao
 * @date 2019/11/7
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.book.keeping.bookkeeping.controller", "com.book.keeping.bookkeeping.service",
        "com.book.keeping.bookkeeping.entity"})
@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.book.keeping.bookkeeping.mapper")
public class BookKeepingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookKeepingApplication.class, args);
    }

}
