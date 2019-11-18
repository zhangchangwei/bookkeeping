package com.book.keeping.bookkeeping.common.exception;

import lombok.Getter;

/**
 * 参数异常
 * @author zhang.penghao
 * @date 2018/12/6 16:48
 */
@Getter
public class TokenInvalidException extends RuntimeException{

    public TokenInvalidException() {
        super();
    }

    public TokenInvalidException(String message) {
        super(message);
    }
}
