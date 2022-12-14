package com.healt.cloud.checkup.queryReport.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-29 16:02
 */
@Data
public class AbnormalResultsDictVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String hospitalId;
    private String unitId;
    private String unitVisitId;
    private String recClass;
    private String recContentValue;
}
