package com.yu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/8/11 3:55 下午
 */
@Component
@FeignClient("seata-storage-service")
public interface StorageService {

    @PostMapping("/storage/reduceStorage")
    public void reduceStorage(Integer count);
}
