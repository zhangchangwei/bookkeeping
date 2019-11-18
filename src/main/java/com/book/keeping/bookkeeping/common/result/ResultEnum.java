package com.book.keeping.bookkeeping.common.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 返回值类型枚举
 *
 * @author zhang.penghao
 * @version V1.0
 * @date 2019/11/18
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ResultEnum {
    /**
     * 成功信息
     */
    SUCCESS(2000, "success"),

    /**
     * 参数错误
     */
    FAIL_ERROR_PARAM(10000, "fail - parameter error"),
    FAIL_ERROR_PARAM_INVALID(10001, "fail - parameter is invalid"),
    FAIL_ERROR_PARAM_BLANK(10002, "fail - parameter is blank"),
    FAIL_ERROR_PARAM_TYPE(10003, "fail - parameter type is error"),
    FAIL_ERROR_PARAM_COMPLETE(10004, "fail - parameter is not complete"),

    /**
     * 用户错误
     */
    FAIL_ERROR_ACCOUNT(20000, "fail - user does not exist"),
    USER_NOT_LOGGED_IN(20001, "fail - the user is not logged in"),
    FAIL_ERROR_PASSWORD(20002, "fail - the password error"),
    USER_LOGIN_ERROR(20003, "fail - the account or password error"),
    USER_ACCOUNT_FORBIDDEN(20004, "fail - the account is forbidden"),
    USER_NOT_EXIST(20005, "fail - the user not exist"),
    USER_HAS_EXISTED(20006, "fail - the user has existed"),
    /**
     * 业务错误
     */
    FAIL_ERROR_BUSINESS(30001, "fail - business error"),
    /**
     * 系统错误
     */
    FAIL_ERROR_SYSTEM(40001, "fail - system error"),

    /**
     * 数据错误
     */
    FAIL_NOT_FOUND(50000, "fail - data not found"),
    RESULT_DATA_NONE(50001, "fail - data is none"),
    DATA_IS_WRONG(50002, "fail - data is wrong"),
    DATA_ALREADY_EXISTED(50003, "fail - data already existed"),
    /**
     * 接口错误
     */
    FAIL_ERROR_UNKNOWN(60000, "fail - Unknown"),
    INTERFACE_INNER_INVOKE_ERROR(60001, "fail -interface inner invoke error"),
    INTERFACE_OUTTER_INVOKE_ERROR(60002, "fail -interface outter invoke error"),
    INTERFACE_FORBID_VISIT(60003, "fail -interface forbid visit"),
    INTERFACE_ADDRESS_INVALID(60004, "fail -interface address invalid"),
    INTERFACE_REQUEST_TIMEOUT(60005, "fail -interface request timeout"),
    INTERFACE_EXCEED_LOAD(60006, "fail - interface exceed load"),
    /**
     * 权限错误
     */
    FAIL_ERROR_TOKEN(70001, "fail - token error"),
    FAIL_ERROR_AUTHORIZATION(70002, "fail - authorization error"),
    FAIL_ERROR_LOGIN_CODE(70003, "fail - login code error");

    private int code;
    private String message;
}
