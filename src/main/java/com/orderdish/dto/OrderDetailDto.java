package com.orderdish.dto;

/**
 * @Author: Leon
 * @Date: 2021/7/22
 */
public class OrderDetailDto {
    private Integer id;
    private Integer number;
    private Double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderDetailDto{" +
                "id=" + id +
                ", number=" + number +
                ", price=" + price +
                '}';
    }
}
