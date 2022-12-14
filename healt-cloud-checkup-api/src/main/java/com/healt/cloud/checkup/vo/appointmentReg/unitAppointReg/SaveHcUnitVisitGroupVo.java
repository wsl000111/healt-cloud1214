package com.healt.cloud.checkup.vo.appointmentReg.unitAppointReg;

import com.healt.cloud.checkup.entity.HcUnitGroup;
import com.healt.cloud.checkup.entity.HcUnitGroupItems;
import com.healt.cloud.checkup.entity.HcUnitInfo;
import com.healt.cloud.checkup.entity.HcUnitVisitInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-04-21 11:07
 * @description: TODO
 */
@Data
public class SaveHcUnitVisitGroupVo implements Serializable {

    private String stat;

    private List<HcUnitInfo> hcUnitInfo;

    private List<HcUnitVisitInfo> hcUnitVisitInfo;

    private List<HcUnitGroup> hcUnitGroup;

    private List<HcUnitGroupItems> hcUnitGroupItems;

}
