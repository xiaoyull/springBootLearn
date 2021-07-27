package com.yu.springcloud.service;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/7/26 8:50 下午
 */
public interface PaymentService {

    public String paymentInfoOk(Integer id);

    public String paymentInfoTimeout(Integer id);


    /*下面是熔断方法*/
    public String paymentInfoCircuitBreaker(Integer id);
}
