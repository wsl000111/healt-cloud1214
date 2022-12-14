package com.healt.cloud.resultex.handler;

import com.healt.cloud.common.http.HttpStatus;
import com.healt.cloud.resultex.exception.CommonException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.BatchUpdateException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author GuYue
 * @date 2022-02-25 9:12
 * @description: 统一异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    //拦截所有异常
    @ExceptionHandler(Exception.class)
    public ErrorHandler error(Exception e){
        String msg = e.getMessage();
        if(e instanceof NullPointerException){
            e.printStackTrace();
            msg = "空值异常！" + msg;
        }else if (e instanceof ClassCastException) {
            msg = "类型转换错误！" + msg;
        }else if (e instanceof NumberFormatException){
            msg = "字符串转数字异常！" + msg;
        }else if (e instanceof SQLException){
            msg = "数据库操作异常！请检查参数是否正确";
        }else if (e instanceof BatchUpdateException){
            msg = "主键重复！";
        }
        return ErrorHandler.error(HttpStatus.INTERNAL_SERVER_ERROR.getStatus(), msg);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ErrorHandler errorSql(SQLIntegrityConstraintViolationException e){
        return ErrorHandler.error(HttpStatus.SQL_INTEGRITY_CONSTRAINT_VIOLATION_EXCEPTION.getStatus(), HttpStatus.SQL_INTEGRITY_CONSTRAINT_VIOLATION_EXCEPTION.getMessage());
    }

    //拦截统一异常
    @ExceptionHandler(CommonException.class)
    public ErrorHandler errorCommon(CommonException e){
        return ErrorHandler.error(e.getCode(), e.getMsg());
    }

    //拦截自定义异常（业务异常）

}
