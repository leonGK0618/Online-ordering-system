package com.orderdish.service;

import com.orderdish.dto.MenuDto;
import com.orderdish.dto.OrderAndUser;
import com.orderdish.dto.OrderDetailDto;
import com.orderdish.dto.OrderWithMenu;
import com.orderdish.model.Order;
import com.orderdish.result.PageTableRequest;
import com.orderdish.result.Results;

import java.util.List;

/**
 * @Author: Leon
 * @Date: 2021/7/22
 */
public interface OrderService {
    void save(Integer userId, OrderDetailDto[] orderDetailDto);

    List<OrderWithMenu> getOrderDetailByUserId(Integer userId);

    void pay(Integer userId);

    Results<OrderAndUser> list(PageTableRequest request);

    List<OrderWithMenu> getOrderDetailByOrderId(Integer orderId);

    Results delete(Integer id);
}
