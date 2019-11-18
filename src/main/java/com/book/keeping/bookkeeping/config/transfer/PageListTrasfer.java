package com.book.keeping.bookkeeping.config.transfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 功能描述
 *
 * @author zhang.penghao
 * @version V1.0
 * @date 2019/11/18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageListTrasfer<T>  {

    private long total;
    private List<T> list;
    private int pageNum;
    private int pageSize;
    private int pages;

}
