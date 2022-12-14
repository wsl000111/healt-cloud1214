package com.healt.cloud.checkup.queryReport.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-06-02 17:00
 */
@Data
public class SettleBillDictVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String unitId;

    private String unitVisitId;

    private String beginDate;

    private String endDate;

    private String personId;

    private String personVisitId;

    private String hospitalId;
}
