package com.book.keeping.bookkeeping.controller;


import com.book.keeping.bookkeeping.entity.reflect.UserMonthDayBook;
import com.book.keeping.bookkeeping.service.KeepingBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 账单控制层
 * @author zhang.penghao
 * @date 2019/11/18
 */
@RestController
@RequestMapping(value = "/book")
public class KeepingBookController {

    @Autowired
    KeepingBookService keepingBookService;

    @GetMapping("/test")
    public List<UserMonthDayBook> listUserMonthDayBook(String month, String userId){
        return keepingBookService.listUserMonthDayBook(month,userId);
    }

}
