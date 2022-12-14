package com.healt.cloud.checkup.vo.appointmentReg.hcUintDict;

import com.healt.cloud.checkup.entity.HcUnitInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-28 10:09
 * @description: TODO
 */
@Data
public class SaveHcUnitDictVo implements Serializable {
    private static final long serialVersionUID=1L;

    private String stat;

    private List<HcUnitInfo> hcUnitInfo;

}
