package com.healt.cloud.checkup.vo.sys.role;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-07 18:04
 * @description: TODO
 */
@Data
public class SaveRoleDictListVo implements Serializable {
    private static final long serialVersionUID=1L;

    private List<RoleDictVo> roleDictList;

}
