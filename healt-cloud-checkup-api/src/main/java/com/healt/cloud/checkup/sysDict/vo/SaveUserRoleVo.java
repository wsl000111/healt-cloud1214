package com.healt.cloud.checkup.sysDict.vo;

import com.healt.cloud.checkup.entity.UserRole;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-05-27 14:33
 */
@Data
public class SaveUserRoleVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String stat;

    private List<UserRole> userRole;
}
