package com.healt.cloud.checkup.physicalExa.vo.frmChiefDoct;

import com.healt.cloud.checkup.entity.HcAppendResult;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-05-26 22:29
 * @description: TODO
 */
@Data
public class SaveHcAppendResult implements Serializable {
    public String stat; //add  delete update 值为 "" 空自己根据主键判断新增还是修改
    public List<HcAppendResult> hcAppendResult;
}
