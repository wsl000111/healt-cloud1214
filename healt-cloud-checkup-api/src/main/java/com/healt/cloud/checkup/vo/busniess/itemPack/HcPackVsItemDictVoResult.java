package com.healt.cloud.checkup.vo.busniess.itemPack;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-03-14 10:13
 * @description: TODO
 */
@Data
public class HcPackVsItemDictVoResult implements Serializable {

    private static final long serialVersionUID=1L;

    private String ITEM_PACK_CODE;

    private String ITEM_CODE;

    private Integer ITEM_NO;

    private String HOSPITAL_ID;

    private String ITEM_NAME;

}
