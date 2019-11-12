package com.book.keeping.bookkeeping.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "admin_user")
public class AdminUser {
    /**
     * 用户ID
     */
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    /**
     * 用户账号
     */
    private String account;

    /**
     * 用户密码（sha）
     */
    private String password;

    /**
     * 用户姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户手机号
     */
    private String mobile;

    /**
     * 用户性别，0女1男
     */
    private Byte sex;

    /**
     * 用户头像
     */
    private String portrait;

    /**
     * 是否通过手机号校验0未通过1通过
     */
    @Column(name = "is_mobile_true")
    private Byte isMobileTrue;

    /**
     * 是否通过邮箱校验0未通过1通过
     */
    @Column(name = "is_email_true")
    private Byte isEmailTrue;

    /**
     * 用户类型
     */
    @Column(name = "user_type")
    private Byte userType;

    /**
     * 0激活1禁用2删除
     */
    @Column(name = "user_status")
    private Byte userStatus;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取用户账号
     *
     * @return account - 用户账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置用户账号
     *
     * @param account 用户账号
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取用户密码（sha）
     *
     * @return password - 用户密码（sha）
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置用户密码（sha）
     *
     * @param password 用户密码（sha）
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取用户姓名
     *
     * @return real_name - 用户姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置用户姓名
     *
     * @param realName 用户姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取用户邮箱
     *
     * @return email - 用户邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置用户邮箱
     *
     * @param email 用户邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取用户手机号
     *
     * @return mobile - 用户手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置用户手机号
     *
     * @param mobile 用户手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取用户性别，0女1男
     *
     * @return sex - 用户性别，0女1男
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 设置用户性别，0女1男
     *
     * @param sex 用户性别，0女1男
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * 获取用户头像
     *
     * @return portrait - 用户头像
     */
    public String getPortrait() {
        return portrait;
    }

    /**
     * 设置用户头像
     *
     * @param portrait 用户头像
     */
    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    /**
     * 获取是否通过手机号校验0未通过1通过
     *
     * @return is_mobile_true - 是否通过手机号校验0未通过1通过
     */
    public Byte getIsMobileTrue() {
        return isMobileTrue;
    }

    /**
     * 设置是否通过手机号校验0未通过1通过
     *
     * @param isMobileTrue 是否通过手机号校验0未通过1通过
     */
    public void setIsMobileTrue(Byte isMobileTrue) {
        this.isMobileTrue = isMobileTrue;
    }

    /**
     * 获取是否通过邮箱校验0未通过1通过
     *
     * @return is_email_true - 是否通过邮箱校验0未通过1通过
     */
    public Byte getIsEmailTrue() {
        return isEmailTrue;
    }

    /**
     * 设置是否通过邮箱校验0未通过1通过
     *
     * @param isEmailTrue 是否通过邮箱校验0未通过1通过
     */
    public void setIsEmailTrue(Byte isEmailTrue) {
        this.isEmailTrue = isEmailTrue;
    }

    /**
     * 获取用户类型
     *
     * @return user_type - 用户类型
     */
    public Byte getUserType() {
        return userType;
    }

    /**
     * 设置用户类型
     *
     * @param userType 用户类型
     */
    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    /**
     * 获取0激活1禁用2删除
     *
     * @return user_status - 0激活1禁用2删除
     */
    public Byte getUserStatus() {
        return userStatus;
    }

    /**
     * 设置0激活1禁用2删除
     *
     * @param userStatus 0激活1禁用2删除
     */
    public void setUserStatus(Byte userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}