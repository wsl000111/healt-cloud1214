package com.healt.cloud.checkup.vo.appointmentReg.hcPersonDict;

import com.healt.cloud.common.pages.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author GuYue
 * @date 2022-04-08 9:58
 * @description: TODO
 */
@Data
@EqualsAndHashCode(callSuper=false)
@ApiModel(value="HcPersonInfoVo对象", description="人员信息请求VO对象")
public class HcPersonInfoVo extends PageRequest {

    @ApiModelProperty(name = "hospitalCode", value = "医院id", required = true)
    private String hospitalCode;

    @ApiModelProperty(name = "unitId", value = "单位id", required = false)
    private String unitId;

    @ApiModelProperty(name = "glzdmc", value = "条件查询名称", required = false)
    private String  glzdmc;

    @ApiModelProperty(name = "glzdnr", value = "条件查询值", required = false)
    private String glzdnr;

}
