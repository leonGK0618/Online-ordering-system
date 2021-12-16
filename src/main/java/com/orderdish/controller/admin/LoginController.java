package com.orderdish.controller.admin;

import com.orderdish.model.Admin;
import com.orderdish.result.ResponseCode;
import com.orderdish.result.Results;
import com.orderdish.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Leon
 * @Date: 2021/7/20
 */
@Controller
public class LoginController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login.html")
    public String loginPage(){
        return "login";
    }
    @RequestMapping("/index.html")
    public String indexPage(){
        return "index";
    }
    @PostMapping("/login")
    @ResponseBody
    public Results login(Admin admin, HttpServletRequest request){
        Admin findAdmin = adminService.getAdminByUsername(admin);
        if(findAdmin == null){
            return Results.failure(ResponseCode.USERNAME_MISS);
        }
        if(findAdmin.getAdminPassword().equals(admin.getAdminPassword())){
            request.getSession().setAttribute("admin",findAdmin);
            findAdmin.setAdminPassword(null);
            return Results.success(findAdmin);
        }
        return Results.failure(ResponseCode.PASSWORD_ERROR);
    }
    @GetMapping("/logout")
    public String loginout(HttpServletRequest request){
        request.getSession().removeAttribute("admin");
        return "login";
    }
}
