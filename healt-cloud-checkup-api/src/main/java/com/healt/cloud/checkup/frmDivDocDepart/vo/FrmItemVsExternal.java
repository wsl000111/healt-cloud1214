package com.healt.cloud.checkup.frmDivDocDepart.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-05-25 0:09
 * @description: TODO
 */
@Data
public class FrmItemVsExternal implements Serializable {

    private String hc_item_code;
    private String item_no;
    private String ext_code;
}
