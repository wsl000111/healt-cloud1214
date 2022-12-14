package com.healt.cloud.checkup.vo.busniess.costDetail;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-08-01 12:42
 */
@Data
public class CostDetailBillingDictVo implements Serializable {

    private static final long serialVersionUID=1L;

    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @JsonProperty("REKID")
    private String rekid;

    @JsonProperty("UNIT_ID")
    private String unitId;

    @JsonProperty("UNIT_VISIT_ID")
    private String unitVisitId;

    @JsonProperty("PERSON_ID")
    private String personId;

    @JsonProperty("PERSON_VISIT_ID")
    private String personVisitId;

    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;
}
