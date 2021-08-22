package com.yu.springcloud.service;

import com.yu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Param;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/8/10 9:39 下午
 */
public interface OrderService {
    void  addOrder(Order order);

    void updateOrder(@Param("id")Integer id, @Param("status") Integer status);
}
