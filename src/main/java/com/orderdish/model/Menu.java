package com.orderdish.model;

import java.math.BigDecimal;

/**
 * dish
 *
 * @author Leon
 * @version 1.0.0 2021-07-20
 */
public class Menu implements java.io.Serializable {
    /** version num */
    private static final long serialVersionUID = 1708418673897250955L;


    /** dishId */
    private Integer dishId;

    /** dishName */
    private String dishName;

    /** typeId */
    private Integer typeId;

    /** introduction */
    private String introduction;

    /** dishImage */
    private String dishImage;

    /** price */
    private BigDecimal price;

    /**
     *  get dishId
     *
     * @return dishId
     */
    public Integer getDishId() {
        return this.dishId;
    }

    /**
     * set dishId
     *
     * @param dishId
     */
    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    /**
     * get dishName
     *
     * @return dishName
     */
    public String getDishName() {
        return this.dishName;
    }

    /**
     * set dishName
     *
     * @param dishName
     */
    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    /**
     * get typeId
     *
     * @return typeId
     */
    public Integer getTypeId() {
        return this.typeId;
    }

    /**
     * set typeId
     *
     * @param typeId
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * get introduction
     *
     * @return introduction
     */
    public String getIntroduction() {
        return this.introduction;
    }

    /**
     * set introduction
     *
     * @param introduction
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * 获取dishImage
     *
     * @return dishImage
     */
    public String getDishImage() {
        return this.dishImage;
    }

    /**
     * set dishImage
     *
     * @param dishImage
     */
    public void setDishImage(String dishImage) {
        this.dishImage = dishImage;
    }

    /**
     *  get price
     *
     * @return price
     */
    public BigDecimal getPrice() {
        return this.price;
    }

    /**
     * set price
     *
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }


}
