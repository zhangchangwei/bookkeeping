package com.book.keeping.bookkeeping.entity.reflect;

import lombok.Data;

/**
 * 账单列表
 * @author zhang.penghao
 * @date 2019/11/18
 */
@Data
public class KeepingBookListItem {

    private Integer id;
    private String bookTag;
    private String tagName;
    private String tagIcon;
    private String bookCoast;
    private String remark;

}
