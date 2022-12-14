package com.healt.cloud.web.entity.report;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GuYue
 * @date 2022-09-16 15:49
 * @description: TODO
 */
@Data
public class PersonReportListResVo implements Serializable {

    private String personId;

    private String insertDate;

    private String personType;

    private String beforeDate;

    private String name;

    private String idNo;
}
