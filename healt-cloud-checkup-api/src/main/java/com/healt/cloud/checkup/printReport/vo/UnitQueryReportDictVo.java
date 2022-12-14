package com.healt.cloud.checkup.printReport.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-06-02 8:56
 */
@Data
public class UnitQueryReportDictVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String unitId;

    private String classTypeValue;

    private String addressValue;

}
