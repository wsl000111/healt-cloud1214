package com.healt.cloud.checkup.frmDivDocDepart.vo;

import com.healt.cloud.common.pages.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-05-26 12:51
 * @description: TODO
 */
@Data
public class FrmGetUnitPersonVo extends PageRequest implements Serializable {
    private String hospitalId, unitId, unitVisitId, deptCode;
}
