package com.healt.cloud.resultex.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author GuYue
 * @date 2022-02-25 9:28
 * @description: 自定义统一异常
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class CommonException extends RuntimeException{

    private int code;

    private String msg;

}
