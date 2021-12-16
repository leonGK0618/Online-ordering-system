package com.orderdish.result;


import lombok.Data;

import java.io.Serializable;
import java.util.List;


/**
 * @Author: Leon
 * @Date: 2021/5/26
 */
@Data
public class Results<T> implements Serializable {
    int count;//count quantity
    Integer code;//code
    String msg;//message
    List<T> datas;//return data
    T data;//type

    public Results() {
    }

    public Results(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public Results(Integer code, String msg, T data, Integer count, List<T> datas) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.count = count;
        this.datas = datas;
    }

    /* No data transferred Successful return */
    public static <T> Results<T> success() {
        return new Results<T>( ResponseCode.SUCCESS.getCode(),  ResponseCode.SUCCESS.getMessage());
    }

    public static <T> Results<T> success(String msg) {
        return new Results<T>(ResponseCode.SUCCESS.getCode(), msg);
    }

    public static <T> Results<T> success(ResponseCode resultCode) {
        return new Results<T>( resultCode.getCode(),  resultCode.getMessage());
    }

    /* Successful return of a single data transfer */
    public static <T> Results<T> success(T data) {
        return new Results<T>( ResponseCode.SUCCESS.getCode(),  ResponseCode.SUCCESS.getMessage(), data, 0, null);
    }

    public static <T> Results<T> success(String msg, T data) {
        return new Results<T>(ResponseCode.SUCCESS.getCode(), msg, data, 0, null);
    }

    public static <T> Results<T> success(ResponseCode resultCode, T data) {
        return new Results<T>( resultCode.getCode(),  resultCode.getMessage(), data, 0, null);
    }

    /* Successful return of paged data transfer*/
    public static <T> Results<T> success(Integer count, List<T> datas) {
        return new Results<T>(ResponseCode.TABLE_SUCCESS.getCode(),ResponseCode.SUCCESS.getMessage(),null,count, datas);
    }

    public static <T> Results<T> success(String msg, Integer count, List<T> datas) {
        return new Results<T>(ResponseCode.TABLE_SUCCESS.getCode(), msg, null, count, datas);
    }

    public static <T> Results<T> success(ResponseCode resultCode, Integer count, List<T> datas) {
        return new Results<T>( resultCode.getCode(),  resultCode.getMessage(), null, count, datas);
    }
    /* Failure to return without data transfer */
    public static <T> Results<T> failure() {
        return new Results<T>( ResponseCode.FAIL.getCode(), ResponseCode.FAIL.getMessage());
    }

    public static <T> Results<T> failure(ResponseCode resultCode) {
        return new Results<T>( resultCode.getCode(),  resultCode.getMessage());
    }

    public static <T> Results<T> failure(Integer code, String msg) {
        return new Results<T>( code,  msg);
    }

    public static Results ok() {
        return new Results();
    }

}
