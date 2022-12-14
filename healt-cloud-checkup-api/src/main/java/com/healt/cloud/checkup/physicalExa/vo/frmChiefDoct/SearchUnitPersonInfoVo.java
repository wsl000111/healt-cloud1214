package com.healt.cloud.checkup.physicalExa.vo.frmChiefDoct;

import com.healt.cloud.common.pages.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-06-02 10:34
 * @description: TODO
 */
@Data
public class SearchUnitPersonInfoVo extends PageRequest implements Serializable {
    private String hospitalId, unitId, unitVisitId;
}
