package com.book.keeping.bookkeeping.controller;

import com.book.keeping.bookkeeping.entity.User;
import com.book.keeping.bookkeeping.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;

/**
 * 功能描述
 *
 * @author zhang.penghao
 * @version V1.0
 * @date 2019/11/7
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public PageInfo<User> listUser(Integer page,Integer pageSize){
        return userService.listUser(page,pageSize);
    }
}
