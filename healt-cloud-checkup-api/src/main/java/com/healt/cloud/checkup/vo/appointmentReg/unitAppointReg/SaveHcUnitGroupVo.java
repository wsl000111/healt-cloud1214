package com.healt.cloud.checkup.vo.appointmentReg.unitAppointReg;

import com.healt.cloud.checkup.entity.HcUnitGroup;
import com.healt.cloud.checkup.entity.HcUnitGroupItems;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-04-19 14:48
 * @description: TODO
 */
@Data
public class SaveHcUnitGroupVo implements Serializable {

    private String stat;

    private List<HcUnitGroup> hcUnitGroup;

    private List<HcUnitGroupItems> hcUnitGroupItems;

}
