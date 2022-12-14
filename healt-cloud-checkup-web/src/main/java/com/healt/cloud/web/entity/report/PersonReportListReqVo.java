package com.healt.cloud.web.entity.report;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-09-16 15:03
 * @description: TODO
 */
@Data
public class PersonReportListReqVo implements Serializable {
    private String queryType;
    private String phone;
    private String queryNo;
}
