package com.orderdish.dto;

import com.orderdish.model.Order;

/**
 * @Author: Leon
 * @Date: 2021/7/22
 */
public class OrderWithMenu extends Order {
    private Integer dishQuantity;
    private String dishName;
    private String dishImage;
    private Double price;

    public Integer getDishQuantity() {
        return dishQuantity;
    }

    public void setDishQuantity(Integer dishQuantity) {
        this.dishQuantity = dishQuantity;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishImage() {
        return dishImage;
    }

    public void setDishImage(String dishImage) {
        this.dishImage = dishImage;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
