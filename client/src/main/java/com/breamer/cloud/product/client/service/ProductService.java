package com.breamer.cloud.product.client.service;

import com.breamer.cloud.product.client.domain.entity.Order;
import com.breamer.cloud.product.client.domain.entity.ProductInfo;

import java.util.List;

/**
 * 功能描述
 *
 * @author zhang.penghao
 * @date 2019/3/5 15:08
 */
public interface ProductService {

    List<ProductInfo> findAll();

    void testMQ(Order order);
}
