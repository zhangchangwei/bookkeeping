package com.book.keeping.bookkeeping.entity;

import javax.persistence.*;

/**
 * 用户类目表实体类
 * @author zhang.penghao
 * @date 2019/11/18
 */
@Table(name = "book_user_tag")
public class BookUserTag {
    /**
     * 类目ID
     */
    @Id
    @Column(name = "tag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 类目名称
     */
    @Column(name = "tag_name")
    private String tagName;

    /**
     * 类目标识
     */
    @Column(name = "tag_icon")
    private String tagIcon;

    /**
     * 获取类目ID
     *
     * @return tag_id - 类目ID
     */
    public Long getTagId() {
        return tagId;
    }

    /**
     * 设置类目ID
     *
     * @param tagId 类目ID
     */
    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

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
     * 获取类目名称
     *
     * @return tag_name - 类目名称
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * 设置类目名称
     *
     * @param tagName 类目名称
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    /**
     * 获取类目标识
     *
     * @return tag_icon - 类目标识
     */
    public String getTagIcon() {
        return tagIcon;
    }

    /**
     * 设置类目标识
     *
     * @param tagIcon 类目标识
     */
    public void setTagIcon(String tagIcon) {
        this.tagIcon = tagIcon;
    }
}