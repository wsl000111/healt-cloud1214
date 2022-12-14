package com.healt.cloud.checkup.frmDivDocDepart.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-05-24 23:42
 * @description: TODO
 */
@Data
public class FrmPackVsItems implements Serializable {
    private String ITEM_PACK_CODE;
    private String ITEM_CODE;
    private String ITEM_NO;
    private String ITEM_NAME;
    private String HC_DEPT_CODE;
    private String INPUT_TYPE;
    private String RESULT_TYPE;
    private String UNIT;
    private String TOP_LIMIT;
    private String BOTTOM_LIMIT;
    private String SEX;
    private String FMTOP_LIMIT;
    private String FMBOTTOM_LIMIT;
    private String NORMAL_VALUE;
}
