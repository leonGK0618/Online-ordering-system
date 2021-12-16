package com.orderdish.service;

import com.orderdish.model.DishType;
import com.orderdish.result.PageTableRequest;
import com.orderdish.result.Results;

import java.util.List;

public interface DishTypeService {
    Results<DishType> list(PageTableRequest request);

    Results<DishType> findDishTypeByFuzzyName(PageTableRequest request, String productName);

    Results<DishType> add(DishType product);

    Results update(DishType product);

    Results delete(Integer id);

    DishType findDishTypeById(Integer productId);

    List<DishType> getAll();
}
