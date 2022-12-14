package com.healt.cloud.checkup.appointmentReg.vo.suggestItemSelect;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-05-31 16:14
 * @description: TODO
 */
@Data
public class SuggestVDepartDictVo implements Serializable {
    @JsonProperty("DEPT_ID")
    private String DEPT_ID;
    @JsonProperty("DEPT_NAME")
    private String DEPT_NAME;
    @JsonProperty("CLASS_NAME")
    private String CLASS_NAME;
    @JsonProperty("SORT_NO")
    private String SORT_NO;
    @JsonProperty("INPUT_CODE")
    private String INPUT_CODE;

}
