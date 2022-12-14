package com.healt.cloud.checkup.queryReport.vo;

import com.healt.cloud.common.pages.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-29 9:33
 */
@Data
public class PersonDeptInfoDictVo extends PageRequest implements Serializable {

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
