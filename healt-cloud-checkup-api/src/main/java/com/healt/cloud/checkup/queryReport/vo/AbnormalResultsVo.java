package com.healt.cloud.checkup.queryReport.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-29 16:01
 */
@Data
public class AbnormalResultsVo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "ROWNUM")
    @JsonProperty("ROWNUM")
    private String rownum;

    @TableId(value = "REC_CONTENT")
    @JsonProperty("REC_CONTENT")
    private String recContent;

    @TableId(value = "MANSL1")
    @JsonProperty("MANSL1")
    private String mansl1;

    @TableId(value = "WOMANSL1")
    @JsonProperty("WOMANSL1")
    private String womansl1;

    @TableId(value = "ZSL1")
    @JsonProperty("ZSL1")
    private String zsl1;

    @TableId(value = "CJMANRS")
    @JsonProperty("CJMANRS")
    private String cjmanrs;

    @TableId(value = "CJWOMANRS")
    @JsonProperty("CJWOMANRS")
    private String cjwomanrs;

    @TableId(value = "CJZRS")
    @JsonProperty("CJZRS")
    private String cjzrs;

    @TableId(value = "MANBFB")
    @JsonProperty("MANBFB")
    private String manbfb;

    @TableId(value = "WOMANBFB")
    @JsonProperty("WOMANBFB")
    private String womanbfb;

    @TableId(value = "PJBFB")
    @JsonProperty("PJBFB")
    private String pjbfb;

    @TableId(value = "RECCONTENT_SL")
    @JsonProperty("RECCONTENT_SL")
    private String reccontentSl;

    @TableId(value = "GUIDE_SUGGEST")
    @JsonProperty("GUIDE_SUGGEST")
    private String guideSuggest;

}
