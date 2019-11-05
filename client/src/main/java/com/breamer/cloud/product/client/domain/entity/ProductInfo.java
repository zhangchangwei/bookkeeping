package com.breamer.cloud.product.client.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 功能描述
 *
 * @author zhang.penghao
 * @date 2019/3/5 15:05
 */
@Entity
@Table(name = "product_info")
@Data
public class ProductInfo implements Serializable {

    @Id
    private String productId;
}
