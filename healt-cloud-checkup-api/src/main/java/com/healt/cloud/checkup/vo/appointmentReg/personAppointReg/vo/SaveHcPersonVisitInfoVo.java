package com.healt.cloud.checkup.vo.appointmentReg.personAppointReg.vo;

import com.healt.cloud.checkup.entity.HcPersonAppregItems;
import com.healt.cloud.checkup.entity.HcPersonVisitInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-03-29 17:08
 */
@Data
public class SaveHcPersonVisitInfoVo implements Serializable {
    private static final long serialVersionUID=1L;

    private String stat;

    private List<HcPersonVisitInfo> hcPersonVisitInfo;

    private List<HcPersonAppregItems> hcPersonAppregItems;
}
