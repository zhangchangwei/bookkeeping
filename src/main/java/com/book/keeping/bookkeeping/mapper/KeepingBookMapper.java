package com.book.keeping.bookkeeping.mapper;

import com.book.keeping.bookkeeping.common.BaseMapper;
import com.book.keeping.bookkeeping.entity.KeepingBook;
import com.book.keeping.bookkeeping.entity.reflect.UserMonthDayBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KeepingBookMapper extends BaseMapper<KeepingBook> {

    List<UserMonthDayBook> listUserMonthDayBook(@Param("month") String month, @Param("userId") String userId);

    List<KeepingBook> listUserDayBook(@Param("bookDate") String bookDate, @Param("userId") String userId);
}