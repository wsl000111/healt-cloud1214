package com.healt.cloud.checkup.vo.appointmentReg.hcUintDict;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-28 10:06
 * @description: TODO
 */
@Data
public class SaveHcUnitDictListVo implements Serializable {
    private static final long serialVersionUID=1L;

    private List<SaveHcUnitDictVo> saveHcUnitDictList;

}
