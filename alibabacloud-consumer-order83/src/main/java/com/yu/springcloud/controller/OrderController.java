package com.yu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/8/4 5:20 下午
 */
@RestController
@Slf4j
public class OrderController {

    @Value("${service-url.nacos-user-service}")
    private String url;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/getPort")
    public String getPort(){
        return restTemplate.getForObject(url+"/getPort",String.class);
    }
}
