package com.orderdish.dao;

import com.orderdish.model.DishType;
import org.apache.ibatis.annotations.*;

import java.util.List;
/**
 * @Author: Leon
 * @Date: 2021/7/20
 */
@Mapper
public interface DishTypeDao {
    @Select("select count(*) from dish_type")
    int count();

    @Select("select * from dish_type order by type_id limit #{offset},#{limit}")
    List<DishType> getAllDishTypesByPage(Integer offset, Integer limit);

    @Select("select count(*) from dish_type where type_name like '%${typeName}%'")
    Long countByDishTypeName(@Param("typeName") String typeName);

    @Select("select * from dish_type where type_name like '%${typeName}%' limit #{offset}, #{limit}")
    List<DishType> findDishTypeByFuzzyName(@Param("typeName") String dish_typeName,@Param("offset") Integer offset,@Param("limit") Integer limit);

    int update(DishType dish_type);

    @Delete("delete from dish_type where type_id = #{typeId}")
    int delete(Integer typeId);

    @Select("select * from dish_type where type_id = #{typeId}")
    DishType findDishTypeById(Integer typeId);

    @Insert("insert into dish_type(type_name,type_image) values(#{typeName},#{typeImage})")
    @Options(useGeneratedKeys = true,keyProperty = "typeId",keyColumn = "type_id")
    int add(DishType dishtype);

    @Select("select * from dish_type")
    List<DishType> getAll();
}
