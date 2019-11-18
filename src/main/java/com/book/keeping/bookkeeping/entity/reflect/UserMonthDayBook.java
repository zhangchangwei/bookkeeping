package com.book.keeping.bookkeeping.entity.reflect;

import com.book.keeping.bookkeeping.entity.KeepingBook;
import lombok.Data;

import java.util.List;

/**
 * 用户月度日期账单汇总对象
 * @author zhang.penghao
 * @date 2019/11/18
 */
@Data
public class UserMonthDayBook {

    private String monthDate;
    private String weekDate;
    private String bookDate;
    private String sumCoast;
    private String month;
    private String userId;
    private List<KeepingBook> keepingBooks;

}
