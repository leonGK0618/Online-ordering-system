package com.orderdish.result;

public enum ResponseCode {
    // Public request information
    SUCCESS(200, "Request successful!"),
    TABLE_SUCCESS(0, "Request successful!"),
    FAIL(500, "Request failed."),
    PARAMETER_MISSING(600,"Missing parameters."),
    UNAUTHORIZED(401,"Unauthorised."),
    // ..Add to the end
    TECHNICIAN_CODE_REPEAT(500,"The user already exists."),
    RECRUIT_REPEAT(500,"Failed"),
    USERNAME_MISS(500,"The user does not exists"),
    PASSWORD_ERROR(500,"Incorrect password."),
    USERNAME_REPEAT(500,"Username already exists."),
    //Equipment Associated Information
    //5000201 - 5000300
     CONNECT_NO_CLEAR(500,"This information has associated data and cannot be deleted.")
    ;
    private Integer code;

    private String message;

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String getMessage(String name) {
        for (ResponseCode item : ResponseCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return null;
    }

    public static Integer getCode(String name) {
        for (ResponseCode item : ResponseCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }
}
