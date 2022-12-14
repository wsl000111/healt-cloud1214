package com.healt.cloud.checkup.queryReport.vo;

import com.healt.cloud.common.pages.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-26 10:35
 */
@Data
public class PersonQueryDictVo extends PageRequest implements Serializable {

    private static final long serialVersionUID=1L;

    private String unitId;
    private String beginDate;
    private String endDate;
    private String name;
    private String sex;
    private String maritalStatus;
}
