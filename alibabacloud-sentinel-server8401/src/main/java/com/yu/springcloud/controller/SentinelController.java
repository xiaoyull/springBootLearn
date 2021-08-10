package com.yu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.concurrent.TimeUnit;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/8/6 4:27 下午
 */
@RestController
@Slf4j
public class SentinelController {
    /**
     *测试
     * @return
     */
    @GetMapping("getA")
    public String getA(){
        return "it is A";
    }
    @GetMapping("getB")
    public String getB(){
        return "it is B";
    }


    @GetMapping("/getC")
    public String getC(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "it is C";
    }

    /**
     * @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
     *      当浏览器访问请求时候超过了web配置的规则（这里配置了热点规则），会进入到deal_testHotKey方法进行处理
     * @param p1
     * @param p2
     * @return
     */
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1, @RequestParam(value = "p1",required = false) String p2 ){
        return "it is testHotKey";
    }

    /**
     * sentinel规则达到之后后处理方法
     * @param p1
     * @param p2
     * @param blockException
     * @return
     */
    public String deal_testHotKey (String p1, String p2, BlockException blockException){
        return "it is deal_testHotKey";
    }

    /**
     * 异常比例 (ERROR_RATIO)
     * 直接写一个异常，每次都是异常
     * @return
     */
    @GetMapping("getD")
    public String getD(){
        int num=10/0;
        return "it is C";
    }
}
