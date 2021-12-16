package com.orderdish.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * order
 *
 * @author Leon
 * @version 1.0.0 2021-07-20
 */
public class Order implements java.io.Serializable {
    /** version num */
    private static final long serialVersionUID = -8213292151629218667L;


    /** orderId */
    private Integer orderId;

    /** time */
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date time;

    /** subtotal */
    private Double subtotal;

    /** tableNumber */
    private Integer tableNumber;

    /** userId */
    private Integer userId;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * get orderId
     *
     * @return orderId
     */
    public Integer getOrderId() {
        return this.orderId;
    }

    /**
     * set orderId
     *
     * @param orderId
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * get time
     *
     * @return time
     */
    public Date getTime() {
        return this.time;
    }

    /**
     * set time
     *
     * @param time
     */
    public void setTime(Date time) {
        this.time = time;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * get tableNumber
     *
     * @return tableNumber
     */
    public Integer getTableNumber() {
        return this.tableNumber;
    }

    /**
     * set tableNumber
     *
     * @param tableNumber
     */
    public void setTableNumber(Integer tableNumber) {
        this.tableNumber = tableNumber;
    }

    /**
     * set userId
     *
     * @return userId
     */
    public Integer getUserId() {
        return this.userId;
    }

    /**
     * set userId
     *
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }


}
