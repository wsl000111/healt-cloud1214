package com.healt.cloud.checkup.printReport.vo.mobile;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-06-18 11:30
 * @description: TODO
 */
@Data
public class QueryReportListVo implements Serializable {
    private String hospitalId;
    private String queryNo;
    private String phone;
    private String queryType;
}
