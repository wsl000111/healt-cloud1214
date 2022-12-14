package com.healt.cloud.checkup.frmDivDocDepart.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author GuYue
 * @date 2022-05-26 16:51
 * @description: TODO
 */
@Data
public class FrmSetDivSourceVoRes implements Serializable {

    private String HOSPITAL_ID;
    private String PERSON_ID;
    private Integer PERSON_VISIT_ID;
    private String UNIT_ID;
    private Integer UNIT_VISIT_ID;
    private String ITEM_PACK_CODE;
    private String ITEM_PACK_NAME;
    private Date REGISTER_DATE;
    private String REGISTER;
    private String REGISTER_NAME;
    private String ADD_ITEM;
    private String CHART_CODE;
    private String APPLY_NO;
    private String SUBMIT_APPLY;
    private String APPLY_NO_PRINT;
    private BigDecimal COSTS;
    private BigDecimal CHARGES;
    private String BILL_INDICATOR;
    private String FINISHED_SIGN;
    private BigDecimal NUM;
    private String SET_CODE;
    private Integer ITEM_NO;
    private Date FINISHED_DATE;
    private String DEPT_ID;
    private String DEPT_NAME;
    private String DOCTOR_ID;
    private String DOCTOR_NAME;
    private String EDITER_ID;
    private String EDITER_NAME;
    private String AUTO_FINISHED;
    private String FUTURE_CONTINUE;
    private String IMAGEPATH;
    private String DOUBLE_DOCTOR_NAME;
    private String HB_PRINT_FLAG;
    private Date HB_PRINT_DATE;


    private String ITEM_CODE;
    private String ITEM_NAME;
    private String RLT_VAL;
    private String UNIT;
    private String NORMAL_VALUE;
    private String RESULT_TYPE;
    private String DEFAULT_VALUE;
    private String SHOW_TYPE;
    private String PRINT_CONTEXT;
    private String TOP_LIMIT;
    private String BOTTOM_LIMIT;
    private String FMTOP_LIMIT;
    private String FMBOTTOM_LIMIT;
    private String SORT_NO;
    private String ITEM_ORDER_NO;
    private String ABNORMAL_INDICATOR;

}
