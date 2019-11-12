package com.breamer.cloud.product.client.service.impl;

import com.breamer.cloud.product.client.config.RabbitMQConfig;
import com.breamer.cloud.product.client.dao.ProductRepository;
import com.breamer.cloud.product.client.domain.entity.Order;
import com.breamer.cloud.product.client.domain.entity.ProductInfo;
import com.breamer.cloud.product.client.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 产品业务实现
 *
 * @author zhang.penghao
 * @date 2019/3/5 15:09
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public List<ProductInfo> findAll() {
        return productRepository.findAll();
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    @Override
    public void testMQ(Order order) {
        log.info("监听消息传输 -- {}", order);
    }
}
