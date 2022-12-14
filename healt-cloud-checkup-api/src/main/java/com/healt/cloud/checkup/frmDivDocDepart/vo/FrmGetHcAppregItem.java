package com.healt.cloud.checkup.frmDivDocDepart.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GuYue
 * @date 2022-05-25 14:55
 * @description: TODO
 */
@Data
public class FrmGetHcAppregItem implements Serializable {
    private String PERSON_ID;
    private String PERSON_VISIT_ID;
    private String UNIT_ID;
    private String UNIT_VISIT_ID;
    private String ITEM_PACK_CODE;
    private String ITEM_PACK_NAME;
    private String ITEM_NO;
    private String PERSON_CHARGE;
    private String FINISHED_SIGN;
    private String DEPT_CODE;
    private String DEPT_NAME;
    private String CHART_CODE;
    private String APPLY_NO;
    private String COSTS;
    private String CHARGES;
    private String SUBMIT_APPLY;
    private String SET_CODE;
    private Date FINISHED_DATE;
    private String USER_ID;
    private String USER_NAME;
    private String FINAL_DOCOTER;
    private String FINISHED_NAME;

}
