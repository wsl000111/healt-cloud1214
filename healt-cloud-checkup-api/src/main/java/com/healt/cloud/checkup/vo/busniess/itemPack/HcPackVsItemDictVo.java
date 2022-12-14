package com.healt.cloud.checkup.vo.busniess.itemPack;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-03-14 10:13
 * @description: TODO
 */
@Data
public class HcPackVsItemDictVo implements Serializable {
    private static final long serialVersionUID=1L;

    private String hospitalId;

    private String itemPackCode;
}
