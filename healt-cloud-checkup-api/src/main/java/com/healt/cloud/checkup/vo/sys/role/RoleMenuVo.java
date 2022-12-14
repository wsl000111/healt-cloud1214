package com.healt.cloud.checkup.vo.sys.role;

import com.healt.cloud.checkup.entity.RoleMenu;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-08 10:08
 * @description: TODO
 */
@Data
public class RoleMenuVo implements Serializable {
    private static final long serialVersionUID=1L;

    private String stat;

    private List<RoleMenu> roleMenu;

}
