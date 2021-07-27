package com.yu.springcloud.dao;

import com.yu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/7/17 3:04 下午
 */
@Mapper
public interface PaymentDao {
    public int addPayment(Payment payment);
    public Payment getPaymentById(Long id);
}
