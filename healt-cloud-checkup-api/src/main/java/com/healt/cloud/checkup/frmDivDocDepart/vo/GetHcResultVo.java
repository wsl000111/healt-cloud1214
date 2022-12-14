package com.healt.cloud.checkup.frmDivDocDepart.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-05-27 15:00
 * @description: TODO
 */
@Data
public class GetHcResultVo implements Serializable {

    private String PERSON_ID;
    private String PERSON_VISIT_ID;
    private String UNIT_ID;
    private String UNIT_VISIT_ID;
    private String DEPT_ID;
    private String DEPT_NAME;
    private String ITEM_ASSEM_CODE;
    private String ITEM_ASSEM_NAME;
    private String HC_ITEM_CODE;
    private String HC_ITEM_NAME;
    private String ASSEM_SORT_NO;
    private String ITEM_ORDER_NO;
    private String SHOW_TYPE;
    private String RESULT_TYPE;
    private String KEY_NAME;
    private String HC_RESULT;
    private String RESULT_DECIMAL;
    private String RESULT_DATE;
    private String UNIT;
    private String PRINT_CONTEXT;
    private String ABNORMAL_INDICATOR;
}
