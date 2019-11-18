package com.book.keeping.bookkeeping.service;

import com.book.keeping.bookkeeping.entity.reflect.KeepingBookListItem;
import com.book.keeping.bookkeeping.entity.reflect.UserMonthDayBook;

import java.util.List;

/**
 * 功能描述
 *
 * @author zhang.penghao
 * @version V1.0
 * @date 2019/11/7
 */
public interface KeepingBookService {

    /**
     * 功能描述:
     * @author zhang.penghao
     * @param month 月份
     * @param userId 用户ID
     * @date 2019/11/18
     * @return {@link UserMonthDayBook}
     */
    List<UserMonthDayBook> listUserMonthDayBook(String month, String userId);

    /**
     * 功能描述:
     * @author zhang.penghao
     * @param bookDate 账单日期
     * @param userId 用户ID
     * @date 2019/11/18
     * @return {@link KeepingBookListItem}
     */
    List<KeepingBookListItem> listUserDayBook(String bookDate, String userId);
}
