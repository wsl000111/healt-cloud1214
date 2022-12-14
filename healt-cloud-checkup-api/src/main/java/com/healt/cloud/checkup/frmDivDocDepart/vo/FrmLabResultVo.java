package com.healt.cloud.checkup.frmDivDocDepart.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-05-25 0:28
 * @description: TODO
 */
@Data
public class FrmLabResultVo implements Serializable {
    private String REPORT_ITEM_NAME;
    private String REPORT_ITEM_CODE;
    private String RESULT;
    private String UNITS;
    private String ABNORMAL_INDICATOR;
    private String INSTRUMENT_ID;
    private String RESULT_DATE_TIME;
    private String PRINT_CONTEXT;
    private String TEST_NO;
}
