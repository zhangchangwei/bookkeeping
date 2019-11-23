package com.book.keeping.bookkeeping.common;

import com.book.keeping.bookkeeping.utils.GlobalIdUtil;
import com.book.keeping.bookkeeping.utils.TokenUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chen.hailin
 * @version V1.0
 * @date 2019/3/21 13:46
 */
@Slf4j
public class AesOperatorTest {

    public static void main(String[] args) throws Exception {
        Long s = GlobalIdUtil.nextId();
        String token = TokenUtil.createToken(String.valueOf(s));
        log.info("{}", s);
           log.info(token);
        log.info(TokenUtil.getUserId(token));

    }
}
