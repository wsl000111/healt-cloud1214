package com.healt.cloud.checkup.vo.appointmentReg.unitAppointReg;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-04-21 9:21
 * @description: TODO
 */
@Data
public class SaveHcUnitVisitGroupListVo implements Serializable {

    private List<UpdateHcUnitInfo> updateHcUnitInfo;

    private List<SaveHcUnitVisitGroupVo> saveHcUnitVisitGroupList;
}
