package com.healt.cloud.checkup.vo.sys.role;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-03-08 12:37
 * @description: TODO
 */
@Data
public class RoleVsMenuVo implements Serializable {
    private static final long serialVersionUID=1L;

    private String hospitalId;

    private String roleId;
}
