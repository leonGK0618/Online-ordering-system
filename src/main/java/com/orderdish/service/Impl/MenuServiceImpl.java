package com.orderdish.service.Impl;

import com.orderdish.dao.MenuDao;
import com.orderdish.dto.MenuDto;
import com.orderdish.model.Menu;
import com.orderdish.result.PageTableRequest;
import com.orderdish.result.Results;
import com.orderdish.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Leon
 * @Date: 2021/7/21
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuDao menuDao;
    @Override
    public Results<MenuDto> list(PageTableRequest request) {
        return Results.success(menuDao.count(), menuDao.getAllMenusByPage(request.getOffset(), request.getLimit()));
    }

    @Override
    public Results<MenuDto> findMenuByFuzzyName(PageTableRequest request, String dishName, Integer typeId) {
        return Results.success(menuDao.countByDishName(dishName,typeId).intValue(),menuDao.findMenuByFuzzyName(dishName,typeId,request.getOffset(),request.getLimit()));
    }


    @Override
    public Menu findMenuById(Integer dishId) {
        return menuDao.findMenuById(dishId);
    }

    @Override
    public List<MenuDto> getAllById(Integer id) {
        return menuDao.getAllByTypeId(id);
    }

    @Override
    @Transactional
    public Results update(Menu menu) {
        int countData = menuDao.update(menu);
        //update dish data
        if(countData > 0){
            return Results.success();
        }else{
            return Results.failure();
        }
    }

    @Override
    public Results delete(Integer id) {
        return menuDao.delete(id)>0?Results.success():Results.failure();
    }
    @Override
    public Results add(Menu menu) {
        return menuDao.add(menu)>0?Results.success():Results.failure();
    }
}
