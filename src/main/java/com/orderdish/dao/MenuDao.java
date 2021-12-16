package com.orderdish.dao;

import com.orderdish.dto.MenuDto;
import com.orderdish.model.Menu;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Leon
 * @Date: 2021/7/20
 */
@Mapper
public interface MenuDao {
    @Select("select count(*) from menu m left join dish_type d on m.type_id = d.type_id")
    int count();

    @Select("select * from menu m left join dish_type d on m.type_id = d.type_id order by dish_id limit #{offset},#{limit}")
    List<MenuDto> getAllMenusByPage(Integer offset, Integer limit);

    Long countByDishName(@Param("dishName") String dishName,@Param("typeId")  Integer typeId);

    List<MenuDto> findMenuByFuzzyName(@Param("dishName") String dishName,@Param("typeId") Integer typeId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    int update(Menu menu);

    @Delete("delete from menu where dish_id = #{dishId}")
    int delete(Integer dishId);

    @Select("select * from menu m left join dish_type d on m.type_id = d.type_id where dish_id = #{dishId}")
    Menu findMenuById(Integer dishId);

    @Insert("insert into menu(dish_name,type_id,introduction,dish_image,price)" +
            " values(#{dishName},#{typeId},#{introduction},#{dishImage},#{price})")
    @Options(useGeneratedKeys = true,keyProperty = "dishId",keyColumn = "dish_id")
    int add(Menu dish);

    @Select("select * from menu m left join dish_type d on m.type_id = d.type_id")
    List<MenuDto> getAll();

    @Select("select * from menu m where m.type_id = #{id}")
    List<MenuDto> getAllByTypeId(Integer id);
}
