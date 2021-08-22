package com.yu.springcloud.dao;

import com.yu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/8/10 9:35 下午
 */
@Mapper
public interface OrderDao {

    void  addOrder(Order order);

    void updateOrder(@Param("id")Integer id,@Param("status") Integer status);
}
