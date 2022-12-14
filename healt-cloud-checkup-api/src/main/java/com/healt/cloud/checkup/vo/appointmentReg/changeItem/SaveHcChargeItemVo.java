package com.healt.cloud.checkup.vo.appointmentReg.changeItem;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author linklee
 * @create 2022-05-16 16:13
 */
@Data
public class SaveHcChargeItemVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "机构ID")
    @TableId(value = "HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "被兑换项目编码")
    @TableId(value = "ITEM_PACK_CODE")
    @JsonProperty("ITEM_PACK_CODE")
    private String itemPackCode;

    @ApiModelProperty(value = "被兑换项目名称")
    @TableId(value = "ITEM_PACK_NAME")
    @JsonProperty("ITEM_PACK_NAME")
    private String itemPackName;

    public List<ChangeItemm> changeItemm;

    @ApiModelProperty(value = "产生时间")
    @TableId(value = "OPER_DATE")
    @JsonProperty("OPER_DATE")
    private Date operDate;

    @ApiModelProperty(value = "操作人")
    @TableId(value = "OPER_ID")
    @JsonProperty("OPER_ID")
    private String operId;

    @ApiModelProperty(value = "操作人姓名")
    @TableId(value = "OPER_NAME")
    @JsonProperty("OPER_NAME")
    private String operName;

    @ApiModelProperty(value = "人员编号")
    @TableId(value = "PERSON_ID")
    @JsonProperty("PERSON_ID")
    private String personId;

    @ApiModelProperty(value = "体检次数")
    @TableId(value = "PERSON_VISIT_ID")
    @JsonProperty("PERSON_VISIT_ID")
    private Integer personVisitId;

    @ApiModelProperty(value = "序号")
    @TableId(value = "ITEM_NO")
    @JsonProperty("ITEM_NO")
    private Integer itemNo;

}
