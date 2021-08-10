package com.yu.springcloud.service;

import com.yu.springcloud.entities.Payment;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/7/17 3:13 下午
 */
public interface PaymentService {
    public int addPayment(Payment payment);
    public Payment getPaymentById(Long id);
}
