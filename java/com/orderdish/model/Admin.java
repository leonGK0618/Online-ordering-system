package com.orderdish.model;
/**
 * admin
 *
 * @Leon
 * @version 1.0.0 2021-07-20
 */
public class Admin implements java.io.Serializable {
    /** version num */
    private static final long serialVersionUID = 7057969159655477641L;


    /** adminId */
    private Integer adminId;

    /** adminUsername */
    private String adminUsername;

    /** adminPassword */
    private String adminPassword;


    /**
     * get adminId
     *
     * @return adminId
     */
    public Integer getAdminId() {
        return this.adminId;
    }

    /**
     * set adminId
     *
     * @param adminId
     */
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    /**
     * get adminUsername
     *
     * @return adminUsername
     */
    public String getAdminUsername() {
        return this.adminUsername;
    }

    /**
     * 设置adminUsername
     *
     * @param adminUsername
     */
    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    /**
     * get adminPassword
     *
     * @return adminPassword
     */
    public String getAdminPassword() {
        return this.adminPassword;
    }

    /**
     * set adminPassword
     *
     * @param adminPassword
     */
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }


}
