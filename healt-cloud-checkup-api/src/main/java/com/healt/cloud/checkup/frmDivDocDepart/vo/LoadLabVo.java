package com.healt.cloud.checkup.frmDivDocDepart.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-05-30 9:46
 * @description: TODO
 */
@Data
public class LoadLabVo implements Serializable {
//{"hcDeptCode":"","hospitalId":"0001","itemAssemCode":"","personId":"2022072000003","personVisitId":"2","result_status":"1"}
    //@JsonProperty("hospital_id")
    private String hospitalId;

    //@JsonProperty("person_id")
    private String personId;

    //@JsonProperty("visitid")
    private int personVisitId;

    @JsonProperty("UserName")
    private String userName;

    @JsonProperty("UserRealName")
    private String userRealName;

    @JsonProperty("result_status")
    private int resStatus;

    private String hcDeptCode;

    private String itemAssemCode;

}

