package com.healt.cloud.checkup.vo.appointmentReg.modifyPersonItems;

import com.healt.cloud.checkup.entity.HcPersonAppregItems;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-05-24 11:01
 * @description: TODO
 */
@Data
public class SaveModifyPersonItemsVo implements Serializable {

    private String stat;

    private List<HcPersonAppregItems> hcPersonAppregItems;
}
