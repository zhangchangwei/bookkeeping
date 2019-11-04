package com.breamer.cloud.product.client.dao;

import com.breamer.cloud.product.client.domain.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 产品持久层
 *
 * @author zhang.penghao
 * @date 2019/3/5 15:06
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductInfo, String> {
}
