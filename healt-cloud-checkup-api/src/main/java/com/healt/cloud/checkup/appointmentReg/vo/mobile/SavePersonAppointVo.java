package com.healt.cloud.checkup.appointmentReg.vo.mobile;

import com.healt.cloud.checkup.entity.HcPersonAppregItems;
import com.healt.cloud.checkup.entity.HcPersonInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-06-26 16:46
 * @description: TODO
 */
@Data
public class SavePersonAppointVo implements Serializable {

    private HcPersonInfo hcPersonInfo;

    private List<HcPersonAppregItems> hcPersonAppregItemsList;

}
