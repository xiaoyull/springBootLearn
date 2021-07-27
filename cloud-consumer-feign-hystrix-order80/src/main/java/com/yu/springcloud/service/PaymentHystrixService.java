package com.yu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/7/26 9:33 下午
 * @FeignClient：
 *      1.配置了远程调用生产者的微服务名称。
 *      2.fallback配置了生产者微服务的默认服务降级
 */
@FeignClient(value = "cloud-payment-hystrix-service",fallback = PaymentHystrixFallbackService.class)
@Component
public interface PaymentHystrixService {
    @GetMapping("/payment/hystrix/paymentInfoOk/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id);
    @GetMapping("/payment/hystrix/paymentInfoTimeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id")Integer id);
}
