package com.healt.cloud.checkup.vo.queryReport;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author linklee
 * @create 2022-05-19 15:53
 */
@Data
public class UnitQueryDictVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String beginDate;

    private String endDate;

    private String unitId;

    private String classTypeName;

    private String classTypeValue;

    private String addressName;

    private String addressValue;
}
