package com.healt.cloud.checkup.service.commonBase.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.healt.cloud.checkup.entity.SystemParam;
import com.healt.cloud.checkup.service.SystemParamService;
import com.healt.cloud.checkup.service.commonBase.FunctionService;
import com.healt.cloud.checkup.vo.commonBase.function.SystemParamVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-04-07 13:50
 * @description: TODO
 */
@AllArgsConstructor
@Service
public class FunctionServiceImpl implements FunctionService {

    private SystemParamService systemParamService;

    @Override
    public String findConfigPara(SystemParamVo systemParamVo) {
        QueryWrapper<SystemParam> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("DEPT_ID", systemParamVo.getDeptCode());
        queryWrapper.eq("USER_ID", systemParamVo.getOper());
        queryWrapper.eq("PARAM_NAME", systemParamVo.getParaName());
        queryWrapper.eq("HOSPITAL_ID", systemParamVo.getHospCode());
        List<SystemParam> list = systemParamService.list(queryWrapper);
        if(list.size()>0){
            return list.get(0).getParamValue();
        }
        return "";
    }
}
