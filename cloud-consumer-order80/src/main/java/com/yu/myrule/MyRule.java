package com.yu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/7/25 10:43 上午
 * 替换轮询算法成随机算法
 */
@Configuration
public class MyRule {
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
