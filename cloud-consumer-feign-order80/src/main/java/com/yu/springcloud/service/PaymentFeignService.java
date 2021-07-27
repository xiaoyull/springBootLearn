package com.yu.springcloud.service;

import com.yu.springcloud.entities.CommonResult;
import com.yu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/7/25 12:11 下午
 * @FeignClient：标准这是一个Feign类型的接口,并且name属性告知是需要调用那个微服务
 */
@FeignClient(name = "cloud-payment-service")
@Component
public interface PaymentFeignService {
    /**
     * 定义一个接口和远程调用的微服务cloud-payment-service生产者中的Controller方法头一致
     * @param payment
     * @return
     */
    @PostMapping("/payment/add")
    public CommonResult addPayment(@RequestBody Payment payment);

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeout")
    public String timeout();
}
