package com.healt.cloud.checkup.vo.busniess.itemPack;

import com.healt.cloud.checkup.entity.HcPackVsItemDict;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-17 13:28
 * @description: TODO
 */
@Data
public class SavePackVsItemDictVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String stat;

    private List<HcPackVsItemDict> hcPackVsItemDict;
}
