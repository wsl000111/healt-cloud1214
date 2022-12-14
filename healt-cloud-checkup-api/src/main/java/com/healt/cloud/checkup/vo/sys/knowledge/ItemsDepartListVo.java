package com.healt.cloud.checkup.vo.sys.knowledge;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-03-21 14:10
 * @description: TODO
 */
@Data
public class ItemsDepartListVo implements Serializable {

    private static final long serialVersionUID=1L;

    @JsonProperty("CLASS_NAME")
    private String className;
    @JsonProperty("DEPT_NAME")
    private String deptName;
    @JsonProperty("ITEM_CODE")
    private String itemCode;
    @JsonProperty("ITEM_NAME")
    private String itemName;
    @JsonProperty("SEX")
    private String sex;
    @JsonProperty("INPUT_TYPE")
    private String inputType;
    @JsonProperty("RESULT_TYPE")
    private String normal_value;
    @JsonProperty("NORMAL_VALUE")
    private String normalValue;
    @JsonProperty("DEFAULT_VALUE")
    private String defaultValue;
    @JsonProperty("SORT_NO")
    private String sortNo;
    @JsonProperty("DEPT_ID")
    private String deptId;
}
