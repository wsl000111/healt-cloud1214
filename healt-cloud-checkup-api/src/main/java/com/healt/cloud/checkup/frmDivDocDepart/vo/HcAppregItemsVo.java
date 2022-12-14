package com.healt.cloud.checkup.frmDivDocDepart.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-05-27 16:06
 * @description: TODO
 */
@Data
public class HcAppregItemsVo implements Serializable {
    private String PERSON_ID;
    private String PERSON_VISIT_ID;
    private String UNIT_ID;
    private String UNIT_VISIT_ID;
    private String APPOINTS_DATE;
    private String ITEM_PACK_CODE;
    private String ITEM_PACK_NAME;
    private String APPLY_NO;
    private String FINISHED_SIGN;
    private String FINISHED_DATE;
    private String DEPT_NAME;
    private String DOCTOR_ID;
    private String DOCTOR_NAME;
    private String ITEM_NO;
    private String HIS_DEPART_NAME;
    private String RESULT_HANDLE;
    private String HIS_DEPART_CODE;
    private String APPLY_SENDTO;
    private String RESULT_RECIEVED;
    private String HC_DEPT_CODE;
    private String HC_DEPT_CODE1;
    private String CLASS_NAME;
}
