package com.healt.cloud.checkup.queryReport.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-31 10:36
 */
@Data
public class SettleMasterQueryDictVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String hospitalId;

    private String unitId;

    private String unitVisitId;

    private String beginDate;

    private String endDate;

    private String personId;

    private String personVisitId;

    private String name;
}
