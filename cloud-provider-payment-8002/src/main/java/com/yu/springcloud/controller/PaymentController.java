package com.yu.springcloud.controller;

import com.yu.springcloud.entities.CommonResult;
import com.yu.springcloud.entities.Payment;
import com.yu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/7/17 3:17 下午
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping("/payment/add")
    public CommonResult addPayment(@RequestBody Payment payment){
        int result = paymentService.addPayment(payment);
        if(result>0){
            return new CommonResult(200,"添加成功,端口："+port,result);
        }else {
            return new CommonResult(444,"添加失败,端口："+port,result);
        }
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment!=null){
            log.info("查询成功"+payment+"哈哈哈哈哈哈");
            return new CommonResult(200,"查询成功,端口："+port,payment);
        }else {
            log.info("查询失败："+id);
            return new CommonResult(444,"未找到该记录："+id+",端口："+port,payment);
        }
    }
}
