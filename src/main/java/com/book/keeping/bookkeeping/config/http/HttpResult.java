package com.book.keeping.bookkeeping.config.http;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * HttpClient返回封装
 * @author zhang.penghao
 * @date 2019/11/18
 */
@Data
@AllArgsConstructor
public class HttpResult {

    // 响应码
    private Integer code;

    // 响应体
    private String body;
}
