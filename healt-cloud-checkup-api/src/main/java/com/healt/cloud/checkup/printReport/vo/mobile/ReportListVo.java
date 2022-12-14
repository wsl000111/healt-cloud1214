package com.healt.cloud.checkup.printReport.vo.mobile;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GuYue
 * @date 2022-06-18 11:26
 * @description: TODO
 */
@Data
public class ReportListVo implements Serializable {
    private String hospitalId;
    private String personId;
    private Integer personVisitId;
    private Date beforeDate;
//    private String unitId;
//    private Integer unitVisitId;
//    private Date finishedDate;
}
