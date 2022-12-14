package com.healt.cloud.checkup.vo.appointmentReg.hcPersonDict;

import com.healt.cloud.checkup.entity.HcPersonInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-22 9:24
 * @description: TODO
 */
@Data
public class SaveHcPersonDictVo implements Serializable {
    private static final long serialVersionUID=1L;
    private String stat;
    private List<HcPersonInfo> hcPersonInfo;

}
