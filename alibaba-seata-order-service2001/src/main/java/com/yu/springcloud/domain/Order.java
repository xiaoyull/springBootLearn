package com.yu.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/8/10 9:38 下午
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {

    private Integer id;
    private Integer userId;
    private Integer productId;
    private Integer count;
    private BigDecimal money;
    private Integer status;

}
