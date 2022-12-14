package com.healt.cloud.checkup.queryReport.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-26 15:00
 */
@Data
public class SumItemsVo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("DEPT_NAME")
    @JsonProperty("DEPT_NAME")
    private String deptName;

    @TableField("ITEM_PACK_NAME")
    @JsonProperty("ITEM_PACK_NAME")
    private String itemPackName;

    @JsonProperty("FINISHED_AMOUNT")
    private String finishedAmount;

    @JsonProperty("NO_FINISHED_AMOUNT")
    private String noFinishedAmount;

    @JsonProperty("SUM_AMOUNT")
    private String sumAmount;
}
