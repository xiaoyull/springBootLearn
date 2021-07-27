package com.yu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/7/22 11:32 下午
 */
@SpringBootApplication
@EnableDiscoveryClient //zookeeper作为注册中心的时候，需要提交
public class PaymentZkMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentZkMain8004.class);
    }
}
