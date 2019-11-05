package com.breamer.cloud.product.client.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 功能描述
 *
 * @author zhang.penghao
 * @date 2019/3/13 14:03
 */
@Data
public class Order implements Serializable {

    private String orderId;
    private String orderName;
    private String time;
}
