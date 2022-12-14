package com.healt.cloud.checkup.vo.appointmentReg.personAppointReg;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-03-31 15:21
 */
@Data
public class UnitGroupVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "分组编码")
    @TableId(value = "GROUP_CODE")
    @JsonProperty("GROUP_CODE")
    private String groupCode;

    @ApiModelProperty(value = "分组名称")
    @TableField("GROUP_NAME")
    @JsonProperty("GROUP_NAME")
    private String groupName;

    @ApiModelProperty(value = "输入码")
    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;
}
