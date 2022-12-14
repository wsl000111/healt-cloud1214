package com.healt.cloud.checkup.sysDict.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-27 16:11
 */
@Data
public class UnallocatedRolesVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "机构编号")
    @TableId(value = "HOSPITAL_ID", type = IdType.ASSIGN_ID)
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @ApiModelProperty(value = "角色编码")
    @TableField("ROLE_ID")
    @JsonProperty("ROLE_ID")
    private String roleId;

    @ApiModelProperty(value = "角色名称")
    @TableField("ROLE_NAME")
    @JsonProperty("ROLE_NAME")
    private String roleName;

}
