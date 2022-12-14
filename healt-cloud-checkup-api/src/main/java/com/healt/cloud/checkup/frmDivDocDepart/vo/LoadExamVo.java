package com.healt.cloud.checkup.frmDivDocDepart.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-05-31 11:33
 * @description: TODO
 */
@Data
public class LoadExamVo implements Serializable {
    @JsonProperty("hospitalId")
    private String hospitalId;

    @JsonProperty("itemAssemCode")
    private String itemAssemCode;

    @JsonProperty("hcDeptCode")
    private String hcDeptCode;

    @JsonProperty("personId")
    private String personId;

    @JsonProperty("personVisitId")
    private int personVisitId;

    @JsonProperty("UserName")
    private String userName;

    @JsonProperty("UserRealName")
    private String userRealName;

    @JsonProperty("result_status")
    private int resStatus;

//    {"hcDeptCode":"","hospitalId":"0001","itemAssemCode":"","personId":"2022070500003","personVisitId":"1","result_status":"0"}
//    @JsonProperty("hospital_id")
//    private String hospitalId;
//
//    @JsonProperty("person_id")
//    private String personId;
//
//    @JsonProperty("visitid")
//    private int personVisitId;
//
//    @JsonProperty("UserName")
//    private String userName;
//
//    @JsonProperty("UserRealName")
//    private String userRealName;
//
//
//    @JsonProperty("RES_STATUS")
//    private int resStatus;

}
