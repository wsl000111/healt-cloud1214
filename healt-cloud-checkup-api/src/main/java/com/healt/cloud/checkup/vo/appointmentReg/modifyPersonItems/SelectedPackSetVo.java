package com.healt.cloud.checkup.vo.appointmentReg.modifyPersonItems;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-04-21 11:09
 */
@Data
public class SelectedPackSetVo implements Serializable{

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "套餐编码")
    @TableId(value = "SET_CODE")
    @JsonProperty("SET_CODE")
    private String setCode;

    @ApiModelProperty(value = "套餐名称")
    @TableField("SET_NAME")
    @JsonProperty("SET_NAME")
    private String setName;

    @ApiModelProperty(value = "性别")
    @TableField("SEX")
    @JsonProperty("SEX")
    private String sex;

    @TableField("IMG")
    @JsonProperty("IMG")
    private String img;

    @ApiModelProperty(value = "性别识别码")
    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;
}
