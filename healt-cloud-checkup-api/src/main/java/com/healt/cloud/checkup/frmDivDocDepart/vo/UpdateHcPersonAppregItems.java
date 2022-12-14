package com.healt.cloud.checkup.frmDivDocDepart.vo;

import com.healt.cloud.checkup.entity.HcPersonAppregItems;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-05-23 20:22
 * @description: TODO
 */
@Data
public class UpdateHcPersonAppregItems implements Serializable {
    public String stat; //add  delete update
    public List<HcPersonAppregItems> hcPersonAppregItems;
}
