package com.healt.cloud.checkup.frmDivDocDepart.vo;

import com.healt.cloud.checkup.entity.HcResultDict;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-05-23 20:24
 * @description: TODO
 */
@Data
public class SaveHcResultDict implements Serializable {
    public String stat; //add  delete update
    public List<HcResultDict> hcResultDict;
}
