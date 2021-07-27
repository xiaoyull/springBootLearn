package com.yu.springcloud.controller;

import com.yu.springcloud.entities.CommonResult;
import com.yu.springcloud.entities.Payment;
import com.yu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/7/25 12:14 下午
 */
@RestController
@Slf4j
public class PaymentFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @PostMapping("/consumerFeign/payment/add")
    public CommonResult addPayment(@RequestBody Payment payment){
        return paymentFeignService.addPayment(payment);
    }

    @GetMapping("/consumerFeign/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        CommonResult payment = paymentFeignService.getPaymentById(id);
        log.info("查询id："+id+"  返回数据："+payment);
        return payment;
    }

    @GetMapping("/consumerFeign/payment/feign/timeout")
    public String timeout(){
       return paymentFeignService.timeout();
    }
}
