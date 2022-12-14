package com.healt.cloud.checkup.vo.appointmentReg.vo;

import com.healt.cloud.checkup.vo.appointmentReg.personAppointReg.PackSetDictVo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-03-29 17:08
 */
@Data
public class FindPackSetDictVo implements Serializable {
    private static final long serialVersionUID=1L;

    private String stat;

    private List<PackSetDictVo> packSetDictVo;
}
