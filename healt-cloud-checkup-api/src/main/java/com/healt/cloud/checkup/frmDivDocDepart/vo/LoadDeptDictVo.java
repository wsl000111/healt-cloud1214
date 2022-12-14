package com.healt.cloud.checkup.frmDivDocDepart.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-05-30 16:15
 * @description: TODO
 */
@Data
public class LoadDeptDictVo implements Serializable {
    private String DEPT_ID;
    private String DEPT_NAME;
    private String CLASS_NAME;
}
