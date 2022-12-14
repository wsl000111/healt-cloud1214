package com.healt.cloud.checkup.vo.appointmentReg.unitPersonAppointReg;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-04-24 15:21
 * @description: TODO
 */
@Data
public class SelectBatchDelItemsListVo implements Serializable {

    private List<SelectBatchDelItemsVo> selectBatchDelItems;

}
