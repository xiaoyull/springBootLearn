package com.yu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/8/3 10:35 上午
 */
@RestController
public class ConfigController {

    @Value("${config.info}")
    private String info;

    @GetMapping("/getConfig")
    public String getConfig(){
        return info;
    }

}
