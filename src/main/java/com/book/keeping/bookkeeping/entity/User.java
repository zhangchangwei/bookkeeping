package com.book.keeping.bookkeeping.entity;

import javax.persistence.*;

public class User {
    /**
     * 用户ID
     */
    @Id
    @Column(name = "user_id")
    private String userId;

    /**
     * 微信用户信息ID
     */
    @Column(name = "open_id")
    private String openId;

    /**
     * 用户昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 用户密码MD5
     */
    private String password;

    /**
     * 用户头像
     */
    @Column(name = "face_image")
    private String faceImage;

    /**
     * 用户状态
     */
    private Integer status;

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取微信用户信息ID
     *
     * @return open_id - 微信用户信息ID
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置微信用户信息ID
     *
     * @param openId 微信用户信息ID
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 获取用户昵称
     *
     * @return nick_name - 用户昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置用户昵称
     *
     * @param nickName 用户昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取用户密码MD5
     *
     * @return password - 用户密码MD5
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置用户密码MD5
     *
     * @param password 用户密码MD5
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取用户头像
     *
     * @return face_image - 用户头像
     */
    public String getFaceImage() {
        return faceImage;
    }

    /**
     * 设置用户头像
     *
     * @param faceImage 用户头像
     */
    public void setFaceImage(String faceImage) {
        this.faceImage = faceImage;
    }

    /**
     * 获取用户状态
     *
     * @return status - 用户状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置用户状态
     *
     * @param status 用户状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}