package com.yu.springcloud.service.impl;

import com.yu.springcloud.dao.OrderDao;
import com.yu.springcloud.domain.Order;
import com.yu.springcloud.service.AccountService;
import com.yu.springcloud.service.OrderService;
import com.yu.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 小鱼
 * @version 1.0
 * @date 2021/8/10 9:39 下午
 */
@Service
@Slf4j
public class OrderServiceImpl  implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    @Override
    public void addOrder(Order order) {
        log.info("开始新增订单");
        orderDao.addOrder(order);
        log.info("订单已新增，开始减少库存");
        storageService.reduceStorage(order.getCount());
        log.info("减少库存成功，开始减少个人账户钱");
        accountService.reduceAccountMoney(order.getUserId(),order.getMoney());
        log.info("减少个人账户钱成功，开始修改订单状态");
        updateOrder(order.getId(),0);
        log.info("----------恭喜你购买成功---------------   ^_^   ^_^");
    }

    @Override
    public void updateOrder(Integer id, Integer status) {
        orderDao.updateOrder(id,status);
    }
}
