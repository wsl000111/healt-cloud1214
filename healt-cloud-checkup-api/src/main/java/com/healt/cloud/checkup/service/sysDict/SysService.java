package com.healt.cloud.checkup.service.sysDict;

import com.healt.cloud.checkup.entity.HospitalDict;
import com.healt.cloud.checkup.entity.VHospitalDict;
import com.healt.cloud.checkup.vo.UserMenuRightVoResult;
import com.healt.cloud.checkup.vo.sys.HospitalVo1;
import com.healt.cloud.checkup.vo.sys.user.UsersVo;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-05 14:17
 * @description: TODO
 */
public interface SysService {

    List<VHospitalDict> findHospitalDict();

    List<VHospitalDict> findHospitalDict(HospitalVo1 hospitalVo1);

    List<UserMenuRightVoResult> findUserMenuRight(UsersVo usersVo);

    List<HospitalDict> getHospitalDict(String hospitalId);
}
