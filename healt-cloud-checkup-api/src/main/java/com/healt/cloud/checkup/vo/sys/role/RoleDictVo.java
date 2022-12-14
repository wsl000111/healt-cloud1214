package com.healt.cloud.checkup.vo.sys.role;

import com.healt.cloud.checkup.entity.RoleDict;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-07 18:14
 * @description: TODO
 */
@Data
public class RoleDictVo implements Serializable {
    private static final long serialVersionUID=1L;

    private String stat;

    private List<RoleDict> roleDict;

}
