package com.yu.springcloud;

import com.yu.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/7/17 4:18 下午
 */
@SpringBootApplication
//EurekaClient客户端
@EnableEurekaClient
//开启自定义或者替换默认轮询算法
@RibbonClient(name = "cloud-payment-service",configuration = MyRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class);
    }
}
