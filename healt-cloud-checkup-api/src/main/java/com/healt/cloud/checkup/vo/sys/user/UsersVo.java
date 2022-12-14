package com.healt.cloud.checkup.vo.sys.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-03-05 14:30
 * @description: TODO
 */
@Data
@ApiModel(value="UsersVo对象", description="用户信息查询Vo")
public class UsersVo implements Serializable {
    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "机构编号")
    private String hosId;

    @ApiModelProperty(value = "科室编号")
    private String deptId;

}
