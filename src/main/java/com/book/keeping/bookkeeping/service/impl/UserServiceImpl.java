package com.book.keeping.bookkeeping.service.impl;

import com.book.keeping.bookkeeping.entity.KeepingBook;
import com.book.keeping.bookkeeping.entity.User;
import com.book.keeping.bookkeeping.entity.reflect.UserMonthDayBook;
import com.book.keeping.bookkeeping.mapper.KeepingBookMapper;
import com.book.keeping.bookkeeping.mapper.UserMapper;
import com.book.keeping.bookkeeping.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述
 *
 * @author zhang.penghao
 * @version V1.0
 * @date 2019/11/7
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    private final KeepingBookMapper keepingBookMapper;

    @Override
    public PageInfo<User> listUser(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<User> users =  userMapper.selectAll();
        return new PageInfo<>(users);
    }

    @Override
    public List<UserMonthDayBook> listUserMonthDayBook(String month, String userId) {
        return keepingBookMapper.listUserMonthDayBook(month,userId);
    }

    @Override
    public List<KeepingBook> listUserDayBook(String month, String userId) {
        return keepingBookMapper.listUserDayBook(month,userId);
    }
}
