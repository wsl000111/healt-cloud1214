package com.healt.cloud.pdf.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @author GuYue
 * @date 2022-09-16 15:03
 * @description: TODO
 */
@Data
public class CheckUpOrderVo implements Serializable{

    private String id;
    private String appointId;
    private String setCode;
    private String appointsDate;
}
