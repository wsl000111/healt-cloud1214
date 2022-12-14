package com.healt.cloud.checkup.vo.appointmentReg.unitAppointReg;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-04-15 17:19
 * @description: TODO
 */
@Data
public class DtParentUnitVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "单位编码")
    @TableField("UNIT_ID")
    @JsonProperty("UNIT_ID")
    private String unitId;

    @ApiModelProperty(value = "单位名称")
    @TableField("UNIT_NAME")
    @JsonProperty("UNIT_NAME")
    private String unitName;

    @ApiModelProperty(value = "地址")
    @TableField("ADDRESS")
    @JsonProperty("ADDRESS")
    private String address;

    @ApiModelProperty(value = "联系人")
    @TableField("CONTACTS")
    @JsonProperty("CONTACTS")
    private String contacts;

    @ApiModelProperty(value = "电话")
    @TableField("PHONE")
    @JsonProperty("PHONE")
    private String phone;

    @ApiModelProperty(value = "单位类型")
    @TableField("UNIT_TYPE")
    @JsonProperty("UNIT_TYPE")
    private String unitType;

    @ApiModelProperty(value = "拼音简码")
    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;

}
