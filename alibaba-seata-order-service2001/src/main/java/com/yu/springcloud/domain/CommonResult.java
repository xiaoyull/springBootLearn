package com.yu.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/7/17 2:58 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private int code;
    private String message;
    private T data;
    
    public CommonResult(int code, String message){
        this(code,message,null);
    }
}
