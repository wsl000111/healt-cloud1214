package com.healt.cloud.checkup.physicalExa.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-25 14:44
 */
@Data
public class HcDeptResultDictVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String hospitalId;

    private String personId;

    private String personVisitId;

    private String deptId;
}
