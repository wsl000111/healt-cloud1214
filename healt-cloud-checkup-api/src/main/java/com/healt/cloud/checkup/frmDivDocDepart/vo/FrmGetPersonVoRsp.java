package com.healt.cloud.checkup.frmDivDocDepart.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GuYue
 * @date 2022-05-24 9:34
 * @description: TODO
 */
@Data
public class FrmGetPersonVoRsp implements Serializable {

    private String NAME;
    private String SEX;
    private String UNIT_NAME;
    private String PERSON_ID;
    private String PERSON_VISIT_ID;
    private String AGE;
    private Date APPOINTS_DATE;
    private Date BEFORE_DATE;
    private String FINISHED_SIGN;
    private Date FINISHED_DATE;

}
