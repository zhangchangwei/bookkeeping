package com.book.keeping.bookkeeping.entity.reflect;

import com.book.keeping.bookkeeping.entity.KeepingBook;
import lombok.Data;

import java.util.List;

@Data
public class KeepingBookListItem {

    private Integer id;
    private String bookTag;
    private String tagName;
    private String tagIcon;
    private String bookCoast;
    private String remark;

}
