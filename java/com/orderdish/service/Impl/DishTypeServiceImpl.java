package com.orderdish.service.Impl;

import com.orderdish.dao.DishTypeDao;
import com.orderdish.model.DishType;
import com.orderdish.result.PageTableRequest;
import com.orderdish.result.Results;
import com.orderdish.service.DishTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DishTypeServiceImpl implements DishTypeService {
    @Resource
    private DishTypeDao dishTypeDao;
    @Override
    public Results<DishType> list(PageTableRequest request) {
        return Results.success(dishTypeDao.count(), dishTypeDao.getAllDishTypesByPage(request.getOffset(), request.getLimit()));
    }

    @Override
    public Results<DishType> findDishTypeByFuzzyName(PageTableRequest request, String dishTypeName) {
        return Results.success(dishTypeDao.countByDishTypeName(dishTypeName).intValue(),dishTypeDao.findDishTypeByFuzzyName(dishTypeName,request.getOffset(),request.getLimit()));
    }


    @Override
    public DishType findDishTypeById(Integer dishTypeId) {
        return dishTypeDao.findDishTypeById(dishTypeId);
    }

    @Override
    public List<DishType> getAll() {
        return dishTypeDao.getAll();
    }

    @Override
    @Transactional
    public Results update(DishType dishType) {
        int countData = dishTypeDao.update(dishType);
        //更新商品信息
        if(countData > 0){
            return Results.success();
        }else{
            return Results.failure();
        }
    }

    @Override
    public Results delete(Integer id) {
           return dishTypeDao.delete(id)>0?Results.success():Results.failure();
    }
    @Override
    public Results add(DishType dishType) {
        return dishTypeDao.add(dishType)>0?Results.success():Results.failure();
    }
}


