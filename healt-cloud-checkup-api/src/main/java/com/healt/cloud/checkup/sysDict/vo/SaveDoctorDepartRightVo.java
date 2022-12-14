package com.healt.cloud.checkup.sysDict.vo;

import com.healt.cloud.checkup.entity.DoctorDepartRight;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-05-27 15:20
 */
@Data
public class SaveDoctorDepartRightVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String stat;

    private List<DoctorDepartRight> doctorDepartRight;
}
