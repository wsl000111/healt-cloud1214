package com.healt.cloud.checkup.sysDict.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-05-27 14:18
 */
@Data
public class SaveUserRoleListVo implements Serializable {

    private static final long serialVersionUID=1L;

    private List<SaveUserRoleVo> saveUserRole;
}
