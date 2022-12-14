package com.healt.cloud.checkup.queryReport.vo;

import lombok.Data;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-30 16:21
 */
@Data
public class AbnormalResultsPersonDictVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String hospitalId;
    private String unitId;
    private String unitVisitId;
    private String recClass;

    private String beginDate;
    private String endDate;
}
