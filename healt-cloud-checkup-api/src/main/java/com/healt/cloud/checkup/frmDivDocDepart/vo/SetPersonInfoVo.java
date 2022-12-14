package com.healt.cloud.checkup.frmDivDocDepart.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GuYue
 * @date 2022-05-27 13:23
 * @description: TODO
 */
@Data
public class SetPersonInfoVo implements Serializable {
    private String NAME;
    private String SEX;
    private Date BARTHDAY;
    private String UNIT_NAME;
    private String PERSON_ID;
    private String PERSON_VISIT_ID;
    private String UNIT_ID;
    private String UNIT_VISIT_ID;
    private String AGE;
    private String PERSON_CHARGE;
    private String RESULT_STATUS;
    private String MARITAL_STATUS;
}
