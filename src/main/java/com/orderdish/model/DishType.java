package com.orderdish.model;
/**
 * type
 *
 * @author Leon
 * @version 1.0.0 2021-07-20
 */
public class DishType implements java.io.Serializable {
    /** version num */
    private static final long serialVersionUID = 3669688430607670693L;



    /** typeId */
    private Integer typeId;

    /** typeName */
    private String typeName;

    /** typeImage */
    private String typeImage;



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
     * get typeName
     *
     * @return typeName
     */
    public String getTypeName() {
        return this.typeName;
    }

    /**
     * set typeName
     *
     * @param typeName
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * 获取typeImage
     *
     * @return typeImage
     */
    public String getTypeImage() {
        return this.typeImage;
    }

    /**
     * set typeImage
     *
     * @param typeImage
     */
    public void setTypeImage(String typeImage) {
        this.typeImage = typeImage;
    }


}
