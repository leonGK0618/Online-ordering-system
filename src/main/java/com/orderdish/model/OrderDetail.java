package com.orderdish.model;

/**
 * order_detail
 *
 * @author Leon
 * @version 1.0.0 2021-07-20
 */
public class OrderDetail implements java.io.Serializable {
    /** version num */
    private static final long serialVersionUID = 8143294507344415356L;

    /** detailId */
    private Integer detailId;

    /** dishId */
    private Integer dishId;

    /** dishQuantity */
    private Integer dishQuantity;

    /** orderId */
    private Integer orderId;



    /**
     * get detailId
     *
     * @return detailId
     */
    public Integer getDetailId() {
        return this.detailId;
    }

    /**
     * set detailId
     *
     * @param detailId
     */
    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    /**
     * get dishId
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
     * get dishQuantity
     *
     * @return dishQuantity
     */
    public Integer getDishQuantity() {
        return this.dishQuantity;
    }

    /**
     * set dishQuantity
     *
     * @param dishQuantity
     */
    public void setDishQuantity(Integer dishQuantity) {
        this.dishQuantity = dishQuantity;
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


}
