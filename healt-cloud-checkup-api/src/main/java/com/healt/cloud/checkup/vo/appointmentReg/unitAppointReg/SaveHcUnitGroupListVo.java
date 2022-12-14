package com.healt.cloud.checkup.vo.appointmentReg.unitAppointReg;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-04-19 11:44
 * @description: TODO
 */
@Data
public class SaveHcUnitGroupListVo implements Serializable {

    private List<UpdateHcUnitInfo> updateHcUnitInfo;

    private List<UpdateHcUnitVisitInfo> updateHcUnitVisitInfo;

    private List<SaveHcUnitGroupVo> saveHcUnitGroupList;

}
