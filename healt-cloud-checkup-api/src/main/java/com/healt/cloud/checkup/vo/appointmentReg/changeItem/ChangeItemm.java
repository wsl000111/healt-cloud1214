package com.healt.cloud.checkup.vo.appointmentReg.changeItem;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-16 16:28
 */
@Data
public class ChangeItemm implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "兑换项目编码")
    @TableId(value = "CHANGE_ITEM_CODE")
    @JsonProperty("CHANGE_ITEM_CODE")
    private String changeItemCode;

    @ApiModelProperty(value = "兑换项目名称")
    @TableId(value = "CHANGE_ITEM_NAME")
    @JsonProperty("CHANGE_ITEM_NAME")
    private String changeItemName;
}
