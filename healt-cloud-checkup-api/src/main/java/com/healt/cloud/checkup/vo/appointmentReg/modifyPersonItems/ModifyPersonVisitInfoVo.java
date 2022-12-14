package com.healt.cloud.checkup.vo.appointmentReg.modifyPersonItems;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-04-22 13:56
 */
@Data
public class ModifyPersonVisitInfoVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "人员编号")
    @TableField("PERSON_ID")
    @JsonProperty("PERSON_ID")
    private String personId;

    @ApiModelProperty(value = "体检次数")
    @TableField("PERSON_VISIT_ID")
    @JsonProperty("PERSON_VISIT_ID")
    private Integer personVisitId;

    @TableField("FINISHED_SIGN")
    @JsonProperty("FINISHED_SIGN")
    private String finishedSign;

    @TableField("RESULT_STATUS")
    @JsonProperty("RESULT_STATUS")
    private String resultStatus;

    @TableField("BEFORE_SIGN")
    @JsonProperty("BEFORE_SIGN")
    private String beforeSign;
}
