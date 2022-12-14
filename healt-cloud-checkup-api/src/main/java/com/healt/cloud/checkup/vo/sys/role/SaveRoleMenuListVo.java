package com.healt.cloud.checkup.vo.sys.role;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-08 15:04
 * @description: TODO
 */
@Data
public class SaveRoleMenuListVo implements Serializable {

    private List<RoleMenuVo> roleMenuList;

}
