package com.orderdish.model;

/**
 * user
 *
 * @author Leon
 * @version 1.0.0 2021-07-20
 */
public class User implements java.io.Serializable {
    /** version num */
    private static final long serialVersionUID = -1228481410837507868L;



    /** userId */
    private Integer userId;

    /** username */
    private String username;

    /** password */
    private String password;

    /** phone */
    private String phone;



    /**
     * get userId
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

    /**
     * get username
     *
     * @return username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * set username
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * get password
     *
     * @return password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * set password
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * get phone
     *
     * @return phone
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * set phone
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }


}
