package com.healt.cloud.checkup.vo.busniess.itemPack;

import com.healt.cloud.checkup.entity.HcItemPackDict;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-15 13:42
 * @description: TODO
 */
@Data
public class SaveHcItemPackDicVo implements Serializable {
    private static final long serialVersionUID=1L;

    private String stat;

    private List<HcItemPackDict> hcItemPackDict;

}
