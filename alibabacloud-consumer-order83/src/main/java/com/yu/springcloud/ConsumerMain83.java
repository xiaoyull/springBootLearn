package com.yu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/8/4 5:16 下午
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerMain83 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain83.class);
    }
}
