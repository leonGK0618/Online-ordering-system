package com.orderdish.controller.admin;

import com.orderdish.dto.MenuDto;
import com.orderdish.dto.OrderAndUser;
import com.orderdish.dto.OrderDetailDto;
import com.orderdish.dto.OrderWithMenu;
import com.orderdish.model.Menu;
import com.orderdish.model.Order;
import com.orderdish.result.PageTableRequest;
import com.orderdish.result.Results;
import com.orderdish.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * @Author: Leon
 * @Date: 2021/7/22
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/list")
    @ResponseBody
    public Results<OrderAndUser> list(PageTableRequest request){
        request.countOffset();
        return orderService.list(request);
    }
    @GetMapping("/detail/{orderId}")
    public String edit(@PathVariable("orderId")Integer orderId, Model model){
        List<OrderWithMenu> orderDetails = orderService.getOrderDetailByOrderId(orderId);
        model.addAttribute("orderDetails",orderDetails);
        return "order/order-detail";
    }
    @GetMapping("/delete/{id}")
    @ResponseBody
    public Results delete(@PathVariable("id") Integer id){
        return orderService.delete(id);
    }
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request){
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),true));
    };
}
