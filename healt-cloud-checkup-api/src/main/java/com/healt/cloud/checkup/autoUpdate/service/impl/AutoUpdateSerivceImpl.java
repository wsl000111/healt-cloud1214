package com.healt.cloud.checkup.autoUpdate.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.autoUpdate.vo.*;
import com.healt.cloud.checkup.entity.HealtApplicationsPara;
import com.healt.cloud.checkup.entity.HealtUpdatePara;
import com.healt.cloud.checkup.autoUpdate.mapper.AutoUpdateMapper;
import com.healt.cloud.checkup.autoUpdate.service.AutoUpdateSerivce;
import com.healt.cloud.checkup.service.HealtApplicationsParaService;
import com.healt.cloud.checkup.service.HealtUpdateLogService;
import com.healt.cloud.checkup.service.HealtUpdateParaService;
import com.healt.cloud.resultex.exception.CommonException;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-06-07 17:45
 * @description: TODO
 */
@Service
@AllArgsConstructor
public class AutoUpdateSerivceImpl implements AutoUpdateSerivce {

    private AutoUpdateMapper autoUpdateMapper;

    private HealtUpdateParaService healtUpdateParaService;

    private HealtApplicationsParaService healtApplicationsParaService;

    private HealtUpdateLogService healtUpdateLogService;

    @Override
    public String lastUpLoadTime(ApplicationsParaVo applicationsParaVo) {
        String strWhere = " where ";
        if(StringUtils.isNotEmpty(applicationsParaVo.getCODE())){
            strWhere += " code = '" +applicationsParaVo.getCODE()+"'";
        }
        if(StringUtils.isNotEmpty(applicationsParaVo.getISDOWNLOAD())){
            strWhere += " and ISDOWNLOAD = '" + applicationsParaVo.getISDOWNLOAD()+"'";
        }
        if(StringUtils.isNotEmpty(applicationsParaVo.getCondition())){
            strWhere += applicationsParaVo.getCondition();
        }
        String lastuploadtime = autoUpdateMapper.selectLastUpLoadTime(strWhere);
        return lastuploadtime == null ? "" : lastuploadtime;
    }

    @Override
    public String lastUpLoadTime(String code) {
        return autoUpdateMapper.selectLastUpLoadTimeByCode(code);
    }

    @Override
    public List<AppParsVo> getAppPars(String isdownload) {
        if(StringUtils.isEmpty(isdownload)){
            isdownload = "Y";
        }
        List<AppParsVo> list = autoUpdateMapper.getAppPars(isdownload);
        if(list.size() == 0){
            list.add(new AppParsVo());
        }
        return list;
    }

    @Override
    public String getFtpValue(String hospitalId, String code) {
        String value = autoUpdateMapper.getFtpValue(hospitalId, code);
        return value == null ? "" : value;
    }

    @Override
    public List<HealtUpdatePara> getUpdatePara(String hospitalId, String bz) {
        QueryWrapper<HealtUpdatePara> queryWrapper = new QueryWrapper<>();
        if(!"*".equals(hospitalId)){
            queryWrapper.eq("his_unit_code", hospitalId);
        }
        if(!"*".equals(bz)){
            queryWrapper.eq("bz", bz);
        }
        List<HealtUpdatePara> list = healtUpdateParaService.list(queryWrapper);
        if(list.size() == 0){
            list.add(new HealtUpdatePara());
        }
        return list;
    }

    @Override
    public void saveHealtUpdatePara(SaveHealtUpdateParaListVo saveHealtUpdateParaListVo) {
        for(SaveHealtUpdateParaVo saveHealtUpdateParaVo : saveHealtUpdateParaListVo.getSaveHealtUpdateParaList()){
            switch (saveHealtUpdateParaVo.getStat()){
                case "add":
                    healtUpdateParaService.saveBatch(saveHealtUpdateParaVo.getHealtUpdateParaList());
                    break;
                case "update":
                    for (HealtUpdatePara healtUpdatePara : saveHealtUpdateParaVo.getHealtUpdateParaList()){
                        UpdateWrapper<HealtUpdatePara> updateWrapper = new UpdateWrapper<>();
                        updateWrapper.eq("code", healtUpdatePara.getCode());
                        healtUpdateParaService.update(healtUpdatePara, updateWrapper);
                    }
                    break;
                case "delete":
                    for (HealtUpdatePara healtUpdatePara : saveHealtUpdateParaVo.getHealtUpdateParaList()){
                        QueryWrapper<HealtUpdatePara> queryWrapper = new QueryWrapper<>();
                        queryWrapper.eq("code", healtUpdatePara.getCode());
                        healtUpdateParaService.remove(queryWrapper);
                    }
                    break;
            }
        }
    }

    @Override
    public String getRemotepath(String hospitalId, String code) {
        QueryWrapper<HealtApplicationsPara> queryWrapper = new QueryWrapper<>();
        if(!"*".equals(hospitalId)){
            queryWrapper.eq("his_unit_code", hospitalId);
        }
        queryWrapper.eq("code", code);
        List<HealtApplicationsPara> list = healtApplicationsParaService.list(queryWrapper);
        if(list.size() == 0){
            return "";
        }
        return list.get(0).getRemotepath();
    }

    @Override
    public void updateLastuploadtime(String hospitalId, String code) {
        if(!autoUpdateMapper.updateLastuploadtime(hospitalId, code)){
            throw new CommonException(500, "更新失败，没有找到相关记录");
        }
    }

    @Override
    public void saveHealtUpdateLog(HealtUpdateLogListVo healtUpdateLogListVo) {
        healtUpdateLogService.saveBatch(healtUpdateLogListVo.getHealtUpdateLogList());
    }

}
