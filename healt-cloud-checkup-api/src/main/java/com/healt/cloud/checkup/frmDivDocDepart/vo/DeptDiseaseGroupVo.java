package com.healt.cloud.checkup.frmDivDocDepart.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-05-30 16:39
 * @description: TODO
 */
@Data
public class DeptDiseaseGroupVo implements Serializable {
    @JsonProperty("DISEASE_GROUP_CODE")
    private String DISEASE_GROUP_CODE;
    @JsonProperty("DISEASE_GROUP_NAME")
    private String DISEASE_GROUP_NAME;
    @JsonProperty("HC_DEPT_CODE")
    private String HC_DEPT_CODE;
}
