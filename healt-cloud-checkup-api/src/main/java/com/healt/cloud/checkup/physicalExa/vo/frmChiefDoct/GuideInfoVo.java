package com.healt.cloud.checkup.physicalExa.vo.frmChiefDoct;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-06-02 17:48
 * @description: TODO
 */
@Data
public class GuideInfoVo implements Serializable {
    @JsonProperty("GUIDE_CLASS")
    private String guide_class;

    @JsonProperty("KNOWLEDGE_CODE")
    private String knowledge_code;

    @JsonProperty("GUIDE_CONTENT")
    private String guide_content;

    @JsonProperty("SORT_NO")
    private String sort_no;

}
