package com.orderdish.dao;

import com.orderdish.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * @Author: Leon
 * @Date: 2021/7/20
 */
@Mapper
public interface UserDao {
    @Insert("insert into user(username,phone) values(#{username},#{phone})")
    @Options(useGeneratedKeys = true,keyProperty = "userId",keyColumn = "user_id")
    void add(User user);
}
