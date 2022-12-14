package com.healt.cloud.checkup.printReport.vo;

import com.healt.cloud.common.pages.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-06-01 9:21
 */
@Data
public class PrintPersonDictVo extends PageRequest implements Serializable {

    private static final long serialVersionUID=1L;

    private String hospitalId;
    private String unitId;
    private String unitVisitId;
    private String beginDate;
    private String endDate;
    private String personId;
    private String personVisitId;
    private String name;
    private String printDate;
}
