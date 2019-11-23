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

    /**
     * 功能描述:
     * @author zhang.penghao
     * @param page 页码
     * @param pageSize 每页记录数
     * @date 2019/11/18
     * @return {@link User}
     */
    PageInfo<User> listUser(Integer page, Integer pageSize);

    /**
     * 功能描述:
     * @author zhang.penghao
     * @param user {@link User}
     * @date 2019/11/18
     * @return int
     */
    int insertUser(User user);
}
