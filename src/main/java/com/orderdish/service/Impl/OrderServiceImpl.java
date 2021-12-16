package com.orderdish.service.Impl;

import com.orderdish.dao.OrderDao;
import com.orderdish.dao.OrderDetailDao;
import com.orderdish.dto.MenuDto;
import com.orderdish.dto.OrderAndUser;
import com.orderdish.dto.OrderDetailDto;
import com.orderdish.dto.OrderWithMenu;
import com.orderdish.model.Order;
import com.orderdish.model.OrderDetail;
import com.orderdish.result.PageTableRequest;
import com.orderdish.result.Results;
import com.orderdish.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import javax.annotation.Resource;

/**
 * @Author: Leon
 * @Date: 2021/7/22
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private OrderDetailDao orderDetailDao;
    @Override
    @Transactional
    public void save(Integer userId, OrderDetailDto[] orderDetailDto) {
        Order order = new Order();
        int num = 0;
        double subtotal = 0;
        for (OrderDetailDto detailDto : orderDetailDto) {
            num = num + detailDto.getNumber();
            subtotal = subtotal+detailDto.getPrice()*detailDto.getNumber();
        }
        order.setUserId(userId);
        order.setTableNumber(num);
        order.setSubtotal(subtotal);
        orderDao.save(order);
        for (OrderDetailDto detailDto : orderDetailDto) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setDishId(detailDto.getId());
            orderDetail.setDishQuantity(detailDto.getNumber());
            orderDetail.setOrderId(order.getOrderId());
            orderDetailDao.save(orderDetail);
        }
    }

    @Override
    public List<OrderWithMenu> getOrderDetailByUserId(Integer userId) {
        List<OrderWithMenu> orderWithMenuList = orderDao.getOrderDetailByUserId(userId);
        return orderWithMenuList;
    }

    @Override
    public void pay(Integer userId) {
        orderDao.pay(userId);
    }

    @Override
    public Results<OrderAndUser> list(PageTableRequest request) {
        return Results.success(orderDao.count(), orderDao.getAllOrdersByPage(request.getOffset(), request.getLimit()));
    }

    @Override
    public List<OrderWithMenu> getOrderDetailByOrderId(Integer orderId) {
        List<OrderWithMenu> orderWithMenuList = orderDao.getOrderDetailByOrderId(orderId);
        return orderWithMenuList;
    }

    @Override
    public Results delete(Integer id) {
        orderDao.delete(id);
        orderDetailDao.delete(id);
        return Results.success();
    }
}
