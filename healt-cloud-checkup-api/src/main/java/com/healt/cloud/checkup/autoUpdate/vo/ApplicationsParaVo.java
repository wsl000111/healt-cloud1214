package com.healt.cloud.checkup.autoUpdate.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-06-07 17:43
 * @description: TODO
 */
@Data
public class ApplicationsParaVo implements Serializable {
    private String CODE;
    private String ISDOWNLOAD;
    private String condition;
}
