package com.healt.cloud.checkup.appointmentReg.vo.finishedSign;

import com.healt.cloud.common.pages.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-05-20 14:18
 * @description: TODO
 */
@Data
public class FinishedSignPersonByWherePageVo extends PageRequest implements Serializable {

    private String hospitalCode;

    private String unitId;

    private String unitVisitId;

    private String personId;

    private String personVisitId;

    private String tel;

}
