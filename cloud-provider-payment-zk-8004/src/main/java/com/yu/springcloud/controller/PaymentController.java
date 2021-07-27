package com.yu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/7/22 11:37 下午
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/getPort")
    public String getPort(){
        return "往zookeeper注册端口为："+port+"  后面是token"+ UUID.randomUUID().toString();
    }
}
