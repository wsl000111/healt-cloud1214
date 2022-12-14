package com.healt.cloud.checkup.appointmentReg.vo.unitModifyLastAudit;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-06-25 10:03
 */
@Data
public class UpdateUnitModifyLastAuditListVo implements Serializable{

    private static final long serialVersionUID=1L;

    private List<UpdateUnitModifyLastAuditVo> updateUnitModifyLastAudit;
}
