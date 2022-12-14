package com.healt.cloud.checkup.queryReport.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-19 14:26
 */
@Data
public class DtUnitDictVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String hospitalId;

    private String unitId;
}
