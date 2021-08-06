package com.yu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/8/4 5:22 下午
 * @LoadBalanced:开启负载均衡，默认轮询算法
 */
@Configuration
public class MyRest {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
