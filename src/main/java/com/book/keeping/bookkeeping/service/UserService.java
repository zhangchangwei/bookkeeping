package com.book.keeping.bookkeeping.service;

import com.book.keeping.bookkeeping.entity.KeepingBook;
import com.book.keeping.bookkeeping.entity.User;
import com.book.keeping.bookkeeping.entity.reflect.UserMonthDayBook;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 功能描述
 *
 * @author zhang.penghao
 * @version V1.0
 * @date 2019/11/7
 */
public interface UserService {

    PageInfo<User> listUser(Integer page, Integer pageSize);


    List<UserMonthDayBook> listUserMonthDayBook(String month,String userId);

    List<KeepingBook> listUserDayBook(String month, String userId);
}
