package com.healt.cloud.checkup.appointmentReg.vo.suggestItemSelect;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-05-31 15:54
 * @description: TODO
 */
@Data
public class SuggestDepartDictVo implements Serializable {

    @JsonProperty("DEPT_ID")
    private String dept_id;

    @JsonProperty("DEPT_NAME")
    private String dept_name;

    @JsonProperty("CLASS_ID")
    private String class_id;

    @JsonProperty("SORT_NO")
    private String sort_no;

}
