package com.healt.cloud.checkup.vo.busniess.itemExtern;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-03-18 15:03
 * @description: TODO
 */
@Data
public class ItemPackLabVo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "ITEM_PACK_CODE")
    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;

    @TableId(value = "ITEM_PACK_NAME")
    @JsonProperty("ITEM_PACK_NAME")
    private String itemPackName;

    @TableId(value = "ITEM_CODE")
    @JsonProperty("ITEM_CODE")
    private String itemCode;

    @TableId(value = "ITEM_NAME")
    @JsonProperty("ITEM_NAME")
    private String itemName;
}
