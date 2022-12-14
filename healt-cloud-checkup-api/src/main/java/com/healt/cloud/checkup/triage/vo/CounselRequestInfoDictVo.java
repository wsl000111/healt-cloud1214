package com.healt.cloud.checkup.triage.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-06-19 9:55
 */
@Data
public class CounselRequestInfoDictVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String queueDate;
    private String counselNo;
    private String hospitalId;

}
