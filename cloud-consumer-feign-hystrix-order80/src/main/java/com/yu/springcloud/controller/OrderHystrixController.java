package com.yu.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yu.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/7/26 9:32 下午
 * @DefaultProperties:
 *      1.设置默认的通一的服务降级调用方法。
 *      2.需要设置默认的必须加上@HystrixCommand
 *      3.定制化的可以加上@HystrixCommand(fallbackMethod = "XXXXXXXXXXXX")对应的方法
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallback")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/paymentInfoOk/{id}")
    @HystrixCommand()
    public String paymentInfoOk(@PathVariable("id") Integer id){
        int i= 1000/0;
        return  paymentHystrixService.paymentInfoOk(id);
    }
    @GetMapping("/consumer/payment/hystrix/paymentInfoTimeout/{id}")
    @HystrixCommand
    public String paymentInfoTimeout(@PathVariable("id")Integer id){
        return paymentHystrixService.paymentInfoTimeout(id);
    }

    public String paymentGlobalFallback(){
        return "消费者出错误或者系统繁忙";
    }
}
