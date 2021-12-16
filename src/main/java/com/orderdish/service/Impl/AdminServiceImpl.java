package com.orderdish.service.Impl;

import com.orderdish.dao.AdminDao;
import com.orderdish.model.Admin;
import com.orderdish.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Leon
 * @Date: 2021/7/20
 */
@Service
public class AdminServiceImpl implements AdminService{

    @Resource
    private AdminDao adminDao;

    @Override
    public Admin getAdminByUsername(Admin admin) {
        return adminDao.getAdminByUsername(admin);
    }
}
