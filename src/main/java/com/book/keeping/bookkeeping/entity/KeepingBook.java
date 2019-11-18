package com.book.keeping.bookkeeping.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * 账单表实体类
 * @author zhang.penghao
 * @date 2019/11/18
 */
@Table(name = "keeping_book")
public class KeepingBook {
    /**
     * 账单ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 账单时间
     */
    @Column(name = "book_date")
    private Date bookDate;

    /**
     * 账单类目
     */
    @Column(name = "book_tag")
    private Integer bookTag;

    /**
     * 账单金额
     */
    @Column(name = "book_coast")
    private BigDecimal bookCoast;

    /**
     * 记录生成时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 账户
     */
    private Long account;

    /**
     * 获取账单ID
     *
     * @return id - 账单ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置账单ID
     *
     * @param id 账单ID
     */
    public void setId(Long id) {
        this.id = id;
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
     * 获取账单时间
     *
     * @return book_date - 账单时间
     */
    public Date getBookDate() {
        return bookDate;
    }

    /**
     * 设置账单时间
     *
     * @param bookDate 账单时间
     */
    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    /**
     * 获取账单类目
     *
     * @return book_tag - 账单类目
     */
    public Integer getBookTag() {
        return bookTag;
    }

    /**
     * 设置账单类目
     *
     * @param bookTag 账单类目
     */
    public void setBookTag(Integer bookTag) {
        this.bookTag = bookTag;
    }

    /**
     * 获取账单金额
     *
     * @return book_coast - 账单金额
     */
    public BigDecimal getBookCoast() {
        return bookCoast;
    }

    /**
     * 设置账单金额
     *
     * @param bookCoast 账单金额
     */
    public void setBookCoast(BigDecimal bookCoast) {
        this.bookCoast = bookCoast;
    }

    /**
     * 获取记录生成时间
     *
     * @return create_time - 记录生成时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置记录生成时间
     *
     * @param createTime 记录生成时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取备注
     *
     * @return remake - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取账户
     *
     * @return account - 账户
     */
    public Long getAccount() {
        return account;
    }

    /**
     * 设置账户
     *
     * @param account 账户
     */
    public void setAccount(Long account) {
        this.account = account;
    }
}