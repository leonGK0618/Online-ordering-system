package com.orderdish.service;

import com.orderdish.dto.MenuDto;
import com.orderdish.model.Menu;
import com.orderdish.result.PageTableRequest;
import com.orderdish.result.Results;

import java.util.List;

/**
 * @Author: Leon
 * @Date: 2021/7/21
 */
public interface MenuService {
    Results<MenuDto> list(PageTableRequest request);

    Results<MenuDto> findMenuByFuzzyName(PageTableRequest request, String dishName, Integer typeId);

    Results<Menu> add(Menu dish);

    Results update(Menu dish);

    Results delete(Integer id);

    Menu findMenuById(Integer dishId);

    List<MenuDto> getAllById(Integer id);
}
