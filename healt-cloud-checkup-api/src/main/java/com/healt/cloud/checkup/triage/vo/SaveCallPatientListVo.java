package com.healt.cloud.checkup.triage.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-06-19 12:51
 */
@Data
public class SaveCallPatientListVo implements Serializable {

    private static final long serialVersionUID=1L;

    private List<SaveCallPatientVo> saveCallPatient;
}
