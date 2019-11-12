package com.book.keeping.bookkeeping.service;

import com.book.keeping.bookkeeping.entity.User;
import com.github.pagehelper.PageInfo;

/**
 * 功能描述
 *
 * @author zhang.penghao
 * @version V1.0
 * @date 2019/11/7
 */
public interface UserService {

    PageInfo<User> listUser(Integer page, Integer pageSize);
}
