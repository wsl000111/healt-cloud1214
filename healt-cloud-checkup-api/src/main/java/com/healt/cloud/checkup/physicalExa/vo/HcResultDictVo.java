package com.healt.cloud.checkup.physicalExa.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-23 16:10
 */
@Data
public class HcResultDictVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String hcDeptCode;
    private String hospitalId;
    private String personId;
    private String personVisitId;
    private String itemAssemCode;

}
