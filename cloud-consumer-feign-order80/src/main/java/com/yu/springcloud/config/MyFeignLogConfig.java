package com.yu.springcloud.config;

import feign.Feign;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/7/25 10:18 下午
 */
@Configuration
public class MyFeignLogConfig {
    @Bean
    public Logger.Level getMyFeignLog(){
        return Logger.Level.FULL;
    }
}
