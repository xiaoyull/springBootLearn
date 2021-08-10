package com.yu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.yu.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/8/4 5:20 下午
 */
@RestController
@Slf4j
public class OrderController {

    @Value("${service-url.nacos-user-service}")
    private String url;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/getPort")
    public String getPort(){
        return restTemplate.getForObject(url+"/getPort",String.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(url+"/payment/get/"+id,CommonResult.class);
    }

    /**
     * 测试sentinel页面配置的规则
     *  @SentinelResource：
     *      blockHandler：contentTestBlockHandler方法用于 超过规则时候调用
     * @return
     */
    @GetMapping("/consumer/payment/testBlockHandler")
    @SentinelResource(value = "testBlockHandler",blockHandler = "contentTestBlockHandler")
    public CommonResult testBlockHandler() {
        return restTemplate.getForObject(url+"/payment/testBlockHandler",CommonResult.class);
    }
    public CommonResult contentTestBlockHandler(BlockException blockException) {
        return new CommonResult(444, "我是sentinel的控制台违规处理："+blockException.getMessage() , null);
    }

    /**
     * @SentinelResource:
     *      fallback:java业务代码出现异常的时候出现调用的降级方法
     * @return
     */
    @GetMapping("/consumer/payment/testFallback")
    @SentinelResource(value = "testFallback",fallback = "contentTestFallback")
    public CommonResult testFallback() {
        return restTemplate.getForObject(url+"/payment/testFallback",CommonResult.class);
    }
    public CommonResult contentTestFallback(Throwable throwable) {
        return new CommonResult(444, "我是业务异常处理降级："+throwable.getMessage() , null);
    }

    @GetMapping("/consumer/payment/testAll")
    @SentinelResource(value = "testAll",fallback = "contentTestFallback",blockHandler = "contentTestBlockHandler" )
    public CommonResult testAll() {
        return restTemplate.getForObject(url+"/payment/testFallback",CommonResult.class);
    }
}
