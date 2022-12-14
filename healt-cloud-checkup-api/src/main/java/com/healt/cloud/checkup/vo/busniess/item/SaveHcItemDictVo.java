package com.healt.cloud.checkup.vo.busniess.item;

import com.healt.cloud.checkup.entity.HcItemDict;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-11 10:43
 * @description: TODO
 */
@Data
public class SaveHcItemDictVo implements Serializable {
    private static final long serialVersionUID=1L;

    private String stat;

    private List<HcItemDict> hcItemDict;

}
