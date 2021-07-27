package com.yu.springcloud.controller;

import com.yu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/7/26 8:53 下午
 */
@RestController
public class PaymentHystrixController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/hystrix/paymentInfoOk/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id){
        return paymentService.paymentInfoOk(id);
    }
    @GetMapping("/payment/hystrix/paymentInfoTimeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id")Integer id){
        return paymentService.paymentInfoTimeout(id);
    }


    @GetMapping("/payment/hystrix/paymentInfoCircuitBreaker/{id}")
    public String paymentInfoCircuitBreaker(@PathVariable("id")Integer id){
        return paymentService.paymentInfoCircuitBreaker(id);
    }

}
