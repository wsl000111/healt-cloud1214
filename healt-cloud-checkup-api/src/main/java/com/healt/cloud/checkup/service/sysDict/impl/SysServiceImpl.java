package com.healt.cloud.checkup.service.sysDict.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.healt.cloud.checkup.entity.HospitalDict;
import com.healt.cloud.checkup.entity.VHospitalDict;
import com.healt.cloud.checkup.mapper.UsersMapper;
import com.healt.cloud.checkup.service.HospitalDictService;
import com.healt.cloud.checkup.service.VHospitalDictService;
import com.healt.cloud.checkup.vo.UserMenuRightVoResult;
import com.healt.cloud.checkup.vo.sys.HospitalVo1;
import com.healt.cloud.checkup.vo.sys.user.UsersVo;
import com.healt.cloud.checkup.service.sysDict.SysService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-05 14:17
 * @description: TODO
 */
@Service
@AllArgsConstructor
public class SysServiceImpl implements SysService {

    private UsersMapper usersMapper;
    private VHospitalDictService vHospitalDictService;
    private HospitalDictService hospitalDictService;

    @Override
    public List<UserMenuRightVoResult> findUserMenuRight(UsersVo usersVo) {
        List<UserMenuRightVoResult> list = usersMapper.findUserMenuRight(usersVo);
        if(list.size() == 0){
            list.add(new UserMenuRightVoResult());
        }
        return list;
    }

    @Override
    public List<HospitalDict> getHospitalDict(String hospitalId) {
        QueryWrapper<HospitalDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hospital_id", hospitalId);
        List<HospitalDict> list = hospitalDictService.list(queryWrapper);
        if(list.size() == 0){
            list.add(new HospitalDict());
        }
        return list;
    }

    @Override
    public List<VHospitalDict> findHospitalDict() {
        List<VHospitalDict> list = vHospitalDictService.list();
        if(list.size() == 0){
            list.add(new VHospitalDict());
        }
        return list;
    }

    @Override
    public List<VHospitalDict> findHospitalDict(HospitalVo1 hospitalVo1){
        QueryWrapper<VHospitalDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hospital_id", hospitalVo1.getHosId());
        List<VHospitalDict> list = vHospitalDictService.list(queryWrapper);
        if(list.size() == 0){
            list.add(new VHospitalDict());
        }
        return list;
    }

}
