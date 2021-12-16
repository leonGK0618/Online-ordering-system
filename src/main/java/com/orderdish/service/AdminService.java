package com.orderdish.service;

import com.orderdish.model.Admin;

/**
 * @Author: Leon
 * @Date: 2021/7/20
 */
public interface AdminService {
    Admin getAdminByUsername(Admin admin);
}
