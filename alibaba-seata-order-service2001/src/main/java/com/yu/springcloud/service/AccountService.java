package com.yu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/8/11 3:55 下午
 */
@Component
@FeignClient("seata-account-service")
public interface AccountService {

    @PostMapping("/storage/reduceAccountMoney")
    public void reduceAccountMoney(Integer userId, BigDecimal money);
}
