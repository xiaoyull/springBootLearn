package com.yu.springcloud.controller;

import com.yu.springcloud.entities.CommonResult;
import com.yu.springcloud.entities.Payment;
import com.yu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/7/26 8:53 下午
 */
@RestController
@Slf4j
public class PaymentNacosController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/getPort")
    public String getPort(){
        return "it  is PaymentNacos port "+port;
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            log.info("查询成功" + payment + "哈哈哈哈哈哈");
            return new CommonResult(200, "查询成功,端口：" + port, payment);
        } else {
            log.info("查询失败：" + id);
            return new CommonResult(444, "未找到该记录：" + id + ",端口：" + port, payment);
        }
    }

    @GetMapping("/payment/testBlockHandler")
    public CommonResult testBlockHandler() {
        return new CommonResult(444, "我是正常测试testBlockHandler：" +  "端口：" + port, null);
    }

    @GetMapping("/payment/testFallback")
    public CommonResult testFallback() {
        int num=10/0;
        return new CommonResult(444, "我是正常测试testFallback：" +  "端口：" + port, null);
    }
}
