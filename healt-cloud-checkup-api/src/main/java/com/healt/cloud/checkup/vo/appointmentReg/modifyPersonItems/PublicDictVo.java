package com.healt.cloud.checkup.vo.appointmentReg.modifyPersonItems;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-04-21 15:14
 */
@Data
public class PublicDictVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "名称")
    @TableField("NAME")
    @JsonProperty("NAME")
    private String name;

    @ApiModelProperty(value = "输入码")
    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;

}
