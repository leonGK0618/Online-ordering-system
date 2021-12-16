package com.orderdish.controller.before;

import com.orderdish.dto.OrderDetailDto;
import com.orderdish.dto.OrderWithMenu;
import com.orderdish.model.User;
import com.orderdish.service.DishTypeService;
import com.orderdish.service.MenuService;
import com.orderdish.service.OrderService;
import com.orderdish.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * @Author: Leon
 * @Date: 2021/7/21
 */
@Controller
@RequestMapping("/before")
public class indexController {
    @Autowired
    private DishTypeService dishTypeService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("typeList",dishTypeService.getAll());
        return "before/index";
    }
    @RequestMapping("/getMenuByType/{id}")
    public String getMenuByType(@PathVariable("id")Integer id,Model model){
        model.addAttribute("menuList",menuService.getAllById(id));
        return "before/menu";
    }
    @RequestMapping("/addUser")
    public String addUser(){
        return "before/user";
    }
    @RequestMapping("/addUserWithOrder/{userId}")
    @ResponseBody
    public String addUserWithOrder(@PathVariable("userId") Integer userId,@RequestBody OrderDetailDto[] orderDetailDto, Model model){
        orderService.save(userId,orderDetailDto);
        return "success";
    }
    @RequestMapping("/UserLogin")
    @ResponseBody
    public User userLogin(User user, Model model){
        return userService.addUser(user);
    }
    @RequestMapping("/order/{userId}")
    public String userLogin(@PathVariable("userId") Integer userId, Model model){
        List<OrderWithMenu> orderWithMenuList = orderService.getOrderDetailByUserId(userId);
        model.addAttribute("orderList",orderWithMenuList);
        model.addAttribute("userId",userId);
        return "before/order";
    }
    @RequestMapping("/orderPay/{userId}")
    public String orderPay(@PathVariable("userId") Integer userId, Model model){
        orderService.pay(userId);
        List<OrderWithMenu> orderWithMenuList = orderService.getOrderDetailByUserId(userId);
        model.addAttribute("orderList",orderWithMenuList);
        return "before/success";
    }
}
