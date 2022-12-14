package com.healt.cloud.checkup.physicalExa.vo.frmChiefDoct;

import com.healt.cloud.checkup.entity.HcDiagnosisRecord;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-05-26 22:34
 * @description: TODO
 */
@Data
public class SaveHcDiagnosisRecord implements Serializable {

    public String stat; //add  delete update 值为 "" 空自己根据主键判断新增还是修改
    public List<HcDiagnosisRecord> hcDiagnosisRecord;

}
