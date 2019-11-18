package com.book.keeping.bookkeeping.mapper;

import com.book.keeping.bookkeeping.common.BaseMapper;
import com.book.keeping.bookkeeping.entity.KeepingBook;
import com.book.keeping.bookkeeping.entity.reflect.KeepingBookListItem;
import com.book.keeping.bookkeeping.entity.reflect.UserMonthDayBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 账单Mapper
 * @author zhang.penghao
 * @date 2019/11/18
 */
public interface KeepingBookMapper extends BaseMapper<KeepingBook> {

    /**
     * 功能描述:
     * @author zhang.penghao
     * @param month 月份
     * @param userId 用户ID
     * @date 2019/11/18
     * @return {@link UserMonthDayBook}
     */
    List<UserMonthDayBook> listUserMonthDayBook(@Param("month") String month, @Param("userId") String userId);

    /**
     * 功能描述:
     * @author zhang.penghao
     * @param bookDate 账单日期
     * @param userId 用户ID
     * @date 2019/11/18
     * @return {@link KeepingBookListItem}
     */
    List<KeepingBookListItem> listUserDayBook(@Param("bookDate") String bookDate, @Param("userId") String userId);
}