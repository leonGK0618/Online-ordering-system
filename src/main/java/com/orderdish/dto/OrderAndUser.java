package com.orderdish.dto;

import com.orderdish.model.Order;

/**
 * @Author: Leon
 * @Date: 2021/7/22
 */
public class OrderAndUser extends Order {
    private String username;
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
