package com.healt.cloud.checkup.service.sysDict;

import com.healt.cloud.checkup.entity.RoleDict;
import com.healt.cloud.checkup.vo.HospitalVo;
import com.healt.cloud.checkup.vo.sys.role.*;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-07 16:55
 * @description: TODO
 */
public interface RoleService {

    List<RoleDict> findRoleDict(HospitalVo hospitalVo);

    List<MaxRoleCode> createRoleCode(HospitalVo hospitalVo);

    void saveRoleDict(SaveRoleDictListVo saveRoleDictListVo);

    List<RoleMenuVoResult> findUnallocatedMenuList(RoleVsMenuVo roleVsMenuVo);

    List<RoleMenuVoResult> findAlreadyMenuList(RoleVsMenuVo roleVsMenuVo);

    void saveRoleMenu(SaveRoleMenuListVo saveRoleMenuListVo);
}
