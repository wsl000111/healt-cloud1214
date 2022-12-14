package com.healt.cloud.checkup.vo.sys.knowledge;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-05-29 10:25
 * @description: TODO
 */
@Data
public class HcKnowledgeDictVoReq implements Serializable {

    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @JsonProperty("KNOWLEDGE_TYPE")
    private String knowledgeType;

    @JsonProperty("ITEM_CODE")
    private String itemCode;

    @JsonProperty("DEPT_ID")
    private String deptId;

    @JsonProperty("INPUT_CODE")
    private String inputCode;

    @JsonProperty("DISEASE_CODE")
    private String diseaseCode;

    @JsonProperty("ITEM_NAME_FLAG")
    private String itemNameFlag;

    @JsonProperty("KNOWLEDGE_NAME")
    private String knowledgeName;
}