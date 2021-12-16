package com.orderdish.dao;

import com.orderdish.dto.OrderDetailDto;
import com.orderdish.model.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Leon
 * @Date: 2021/7/20
 */
@Mapper
public interface OrderDetailDao {
    void save(OrderDetail detail);

    void delete(Integer id);
}
