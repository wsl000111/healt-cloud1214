package com.healt.cloud.checkup.vo.sys.knowledge;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author GuYue
 * @date 2022-05-29 10:25
 * @description: TODO
 */
@Data
public class HcKnowledgeDictVoRsp implements Serializable {
    @ApiModelProperty(value = "机构编号")
    private String HOSPITAL_ID;

    @ApiModelProperty(value = "模板编号")
    private String KNOWLEDGE_CODE;

    private String KNOWLEDGE_NAME;

    private String KNOWLEDGE_TYPE;

    private String ITEM_CODE;

    private String DEPT_ID;

    private String POSITIVE_INDICATOR;

    private String GUIDE_SUGGEST;

    private String INPUT_CODE;

    private String DISEASE_CODE;

    private String POPULAR_SCIENCE;

    private BigDecimal BOTTOM_LIMIT;

    private BigDecimal TOP_LIMIT;

    private String sex;

    private BigDecimal AGE_TOP;

    private String ITEM_RESULT;

    private String ITEM_PACK;

    private BigDecimal AGE_BOTTOM;

    private String ITEM_DETERMINE;

    private BigDecimal SORT_NO;

    private String UNIT_REPORT_SHOW;

    private String ITEM_NAME_FLAG;

    private String DISEASE_NAME;
}
