package com.book.keeping.bookkeeping.entity.reflect;

import com.book.keeping.bookkeeping.entity.KeepingBook;
import lombok.Data;

import java.util.List;

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
