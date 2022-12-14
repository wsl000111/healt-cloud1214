package com.healt.cloud.checkup.vo.busniess.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.healt.cloud.common.pages.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-03-11 9:58
 * @description: TODO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class HcItemDictVo extends PageRequest implements Serializable {
    private static final long serialVersionUID=1L;

    private String hospitalId;

    private String deptClass;

    private String deptId;

    @JsonProperty("INPUT_CODE")
    private String inputCode;

}
