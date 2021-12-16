package com.orderdish.dao;

import com.orderdish.model.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Leon
 * @Date: 2021/7/20
 */
@Mapper
public interface AdminDao {
    Admin getAdminByUsername(Admin admin);
}
