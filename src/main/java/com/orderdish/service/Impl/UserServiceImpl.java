package com.orderdish.service.Impl;

import com.orderdish.dao.UserDao;
import com.orderdish.model.User;
import com.orderdish.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author: Leon
 * @Date: 2021/7/22
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    @Transactional
    public User addUser(User user) {
         userDao.add(user);
         return user;
    }
}
