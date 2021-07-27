package com.yu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/7/27 8:26 下午
 */
@Component
public class PaymentHystrixFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "生产者服务出错或者服务繁忙！";
    }
    @Override
    public String paymentInfoTimeout(Integer id) {
        return "生产者服务出错或者服务繁忙！o(╥﹏╥)o";
    }
}
