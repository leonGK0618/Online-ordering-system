package com.orderdish.dto;

import com.orderdish.model.Menu;

/**
 * @Author: Leon
 * @Date: 2021/7/21
 */
public class MenuDto extends Menu {

    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
