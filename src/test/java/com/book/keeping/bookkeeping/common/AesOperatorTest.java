package com.book.keeping.bookkeeping.common;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chen.hailin
 * @version V1.0
 * @date 2019/3/21 13:46
 */
@Slf4j
public class AesOperatorTest {

    public static void main(String[] args) throws Exception {
           String str =  AesOperator.getInstance().encrypt("sadasddsadasdaswqeqweqwewqewqeqweqweqweqweqweqeqweqweqw");
           log.info(str);
        log.info(AesOperator.getInstance().decrypt(str));

    }
}
