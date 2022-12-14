package com.healt.cloud.common.http;

/**
 * HTTP状态码
 * @author Louis
 * @date Jan 12, 2019
 */
public enum HttpStatus {

    SUCCESS(200, "SUCCESS"),
    INTERNAL_SERVER_ERROR(500, "INTERNAL_SERVER_ERROR"),
    SQL_INTEGRITY_CONSTRAINT_VIOLATION_EXCEPTION(100001, "新增记录已存在");

    HttpStatus(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    private Integer status;
    private String message;

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

}
