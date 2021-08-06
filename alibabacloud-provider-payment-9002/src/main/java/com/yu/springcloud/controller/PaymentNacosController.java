package com.yu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/7/26 8:53 下午
 */
@RestController
public class PaymentNacosController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/getPort")
    public String getPort(){
        return "it  is PaymentNacos port "+port;
    }
}
