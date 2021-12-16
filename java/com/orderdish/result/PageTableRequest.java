package com.orderdish.result;

import lombok.Data;

import java.io.Serializable;


/**
 * @Author: Leon
 * @Date: 2021/5/26
 */
@Data
public class PageTableRequest implements Serializable {

    private static final long serialVersionUID = -3040947145421219790L;

    private Integer page;
    private Integer limit;
    private Integer offset;
    public void countOffset(){
        if(null == this.page || null == this.limit){
            this.offset = 0;
            return;
        }
        this.offset = (this.page -1)*limit;
    }
}
