package com.healt.cloud.checkup.vo.appointmentReg.personAppointReg.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-03-29 17:08
 */
@Data
public class SaveHcPersonVisitInfoList implements Serializable {

    private static final long serialVersionUID=1L;

    List<HcPersonVisitInfoVo> hcPersonVisitInfoVo;
}
