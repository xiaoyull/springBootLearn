package com.yu.springcloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/7/26 8:50 下午
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "线程："+Thread.currentThread().getName()+"  paymentOK,id: "+id;
    }

    /**
     * @HystrixCommand：服务降级注解
     *      fallbackMethod：方法发生了异常，将调用哪个方法返回符合预期并且正常的数据集
     *      commandProperties：@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000"
     *          表示服务请求超过了3秒自我判断是不正常的流程，返回符合预期并且正常的数据集
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler" ,commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfoTimeout(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程："+Thread.currentThread().getName()+"  paymentInfoTimeout,id: "+id+"  ^_^";
    }

    public String paymentInfoTimeoutHandler(Integer id){
        return "线程："+Thread.currentThread().getName()+"  请求错误或者系统繁忙请稍后再试,id: "+id+"  o(╥﹏╥)o";
    }

    /*下面是熔断代码测试*/

    /**
     *
     * @param id
     * @return
     *  circuitBreaker.enabled:是否开启断路器
     *  circuitBreaker.requestVolumeThreshold:默认值20。含义是一段时间内至少有20个请求才进行errorThresholdPercentage计算。比如一段时间了有19个请求，且这些请求全部失败了，错误率是100%，但熔断器不会打开，总请求数不满足20。
     *  circuitBreaker.sleepWindowInMilliseconds:半开状态试探睡眠时间，默认值5000ms。如：当熔断器开启5000ms之后，会尝试放过去一部分流量进行试探，确定依赖服务是否恢复
     *  circuitBreaker.errorThresholdPercentage:错误率，默认值50%，例如一段时间（10s）内有100个请求，其中有54个超时或者异常，那么这段时间内的错误率是54%，大于了默认值50%，这种情况下会触发熔断器打开。
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler" ,commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),
    })
    public String paymentInfoCircuitBreaker(Integer id) {
        if(id<0){
            throw new  RuntimeException();
        }
        return "线程："+Thread.currentThread().getName()+"  请求超过,id: "+id+" 哈哈哈";
    }
}
