package com.healt.cloud.checkup.vo.appointmentReg.unitAppointReg;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author GuYue
 * @date 2022-04-18 14:27
 * @description: TODO
 */
@Data
public class SetPacksVo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("SET_CODE")
    @JsonProperty("SET_CODE")
    private String groupCode;
    @TableField("ITEM_PACK_CODE")
    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;
    @TableField("ITEM_NO")
    @JsonProperty("ITEM_NO")
    private String itemNo;
    @TableField("ITEM_PACK_NAME")
    @JsonProperty("ITEM_PACK_NAME")
    private String itemPackName;
    @TableField("ITEM_PACK_PRICE")
    @JsonProperty("ITEM_PACK_PRICE")
    private BigDecimal itemPackPrice;
    @TableField("CLASS_NAME")
    @JsonProperty("CLASS_NAME")
    private String className;

}
