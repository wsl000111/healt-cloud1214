package com.healt.cloud.resultex.handler;

import com.healt.cloud.common.http.HttpStatus;
import lombok.Data;

/**
 * @author GuYue
 * @date 2022-02-25 10:46
 * @description: 异常信息业务类
 */
@Data
public class ErrorHandler {

    private int code;
    private String msg;
    private Object data;

    //私有构造器，约束外部不允许new
    private ErrorHandler(){

    }

    public static ErrorHandler ok(Object data) {
        return restResult(HttpStatus.SUCCESS.getStatus(), HttpStatus.SUCCESS.getMessage(), data);
    }

    public static ErrorHandler ok(String msg, Object data){
        return restResult(HttpStatus.SUCCESS.getStatus(), msg, data);
    }

    public static ErrorHandler error(int code, String msg) {
        return restResult(code, msg, null);
    }

    public static ErrorHandler error(int code, String msg, Object data){
        return restResult(code, msg, data);
    }

    private static ErrorHandler restResult(int code, String msg, Object data){
        ErrorHandler e = new ErrorHandler();
        e.setCode(code);
        e.setMsg(msg);
        e.setData(data);
        return e;
    }

}
