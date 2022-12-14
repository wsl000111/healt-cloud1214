package com.healt.cloud.checkup.vo.appointmentReg.unitPersonAppointReg;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-04-24 10:40
 * @description: TODO
 */
@Data
public class BatchUnitPersonsDeleteItemsListVo implements Serializable {

    private List<BatchUnitPersonsDeleteItemsVo> batchUnitPersonsDeleteItems;

}
