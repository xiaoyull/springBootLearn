package com.yu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/8/4 11:20 上午
 *  @EnableDiscoveryClient：能够让注册中心能够发现，扫描到改服务
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosPaymentMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentMain9001.class);
    }
}
