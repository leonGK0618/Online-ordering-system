package com.orderdish.dao;

import com.orderdish.dto.OrderAndUser;
import com.orderdish.dto.OrderWithMenu;
import com.orderdish.model.Order;
import com.orderdish.result.Results;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: Leon
 * @Date: 2021/7/20
 */
@Mapper
public interface OrderDao {
    @Insert(" INSERT INTO `order` (\n" +
            "         time, subtotal, table_number, user_id,status\n" +
            "        ) VALUES (\n" +
            "            now(),\n" +
            "            #{subtotal},\n" +
            "            #{tableNumber},\n" +
            "            #{userId},\n" +
            "            \"unpaid\"\n" +
            "        )")
    @Options(useGeneratedKeys = true,keyProperty = "orderId",keyColumn = "order_id")
    void save(Order order);

    @Select("select * from `order` o left join order_detail od on o.order_id = od.order_id left join menu m on od.dish_id =  m.dish_id where o.user_id = #{userId}")
    List<OrderWithMenu> getOrderDetailByUserId(Integer userId);

    @Update("update `order` set status = 'paid' where user_id = #{userId}")
    void pay(Integer userId);

    @Select("select * from `order` o join user u on o.user_id = u.user_id order by order_id limit #{offset},#{limit}")
    List<OrderAndUser> getAllOrdersByPage(Integer offset, Integer limit);

    @Select("select count(*) from `order`")
    int count();

    @Select("select * from `order` o left join order_detail od on o.order_id = od.order_id left join menu m on od.dish_id =  m.dish_id where o.order_id = #{orderId}")
    List<OrderWithMenu> getOrderDetailByOrderId(Integer orderId);

    @Delete("delete from `order` where order_id = #{id}")
    Integer delete(Integer id);
}
