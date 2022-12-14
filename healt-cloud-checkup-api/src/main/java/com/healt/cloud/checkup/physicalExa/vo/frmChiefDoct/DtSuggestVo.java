package com.healt.cloud.checkup.physicalExa.vo.frmChiefDoct;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-06-01 17:15
 * @description: TODO
 */
@Data
public class DtSuggestVo implements Serializable {

    private String dept_name;

    private String SUGGEST_TEXT;
}
