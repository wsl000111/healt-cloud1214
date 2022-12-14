package com.healt.cloud.checkup.frmDivDocDepart.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GuYue
 * @date 2022-05-24 15:25
 * @description: TODO
 */
@Data
public class FrmGetUnitPersonVoRsp implements Serializable {
    @TableField("NAME")
    @JsonProperty("NAME")
    private String name;

    @TableField("SEX")
    @JsonProperty("SEX")
    private String SEX;

    @TableField("UNIT_NAME")
    @JsonProperty("UNIT_NAME")
    private String unitName;

    @TableField("PERSON_ID")
    @JsonProperty("PERSON_ID")
    private String personId;

    @TableField("PERSON_VISIT_ID")
    @JsonProperty("PERSON_VISIT_ID")
    private String personVisitId;

    @TableField("UNIT_ID")
    @JsonProperty("UNIT_ID")
    private String unitId;

    @TableField("UNIT_VISIT_ID")
    @JsonProperty("UNIT_VISIT_ID")
    private String unitVisitId;

    @TableField("AGE")
    @JsonProperty("AGE")
    private String age;

    @TableField("APPOINTS_DATE")
    @JsonProperty("APPOINTS_DATE")
    private String appointsDate;

    @TableField("BEFORE_DATE")
    @JsonProperty("BEFORE_DATE")
    private Date beforeDate;

    @TableField("FINISHED_SIGN")
    @JsonProperty("FINISHED_SIGN")
    private String finishedSign;

    @TableField("FINISHED_DATE")
    @JsonProperty("FINISHED_DATE")
    private Date finishedDate;
}
