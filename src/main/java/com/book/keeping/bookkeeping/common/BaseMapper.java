package com.book.keeping.bookkeeping.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 基础mapper
 *
 * @author zhang.penghao
 * @version V1.0
 * @date 2019/11/7
 */
public interface BaseMapper<T> extends Mapper<T>,MySqlMapper<T> {
}
