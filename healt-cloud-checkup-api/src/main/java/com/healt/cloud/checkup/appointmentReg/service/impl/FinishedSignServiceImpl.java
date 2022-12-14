package com.healt.cloud.checkup.appointmentReg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.HcPersonAppregItems;
import com.healt.cloud.checkup.appointmentReg.mapper.FinishedSignMapper;
import com.healt.cloud.checkup.appointmentReg.service.FinishedSignService;
import com.healt.cloud.checkup.appointmentReg.vo.finishedSign.FinishedSignPerson;
import com.healt.cloud.checkup.appointmentReg.vo.finishedSign.FinishedSignPersonByWherePageVo;
import com.healt.cloud.checkup.appointmentReg.vo.finishedSign.SaveFinishedSignListVo;
import com.healt.cloud.checkup.appointmentReg.vo.finishedSign.UpdateHcPersonVistInfoFinishedVo;
import com.healt.cloud.checkup.entity.HcPersonVisitInfo;
import com.healt.cloud.checkup.service.HcPersonAppregItemsService;
import com.healt.cloud.checkup.service.HcPersonVisitInfoService;
import com.healt.cloud.common.pages.PageResult;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author linklee
 * @create 2022-04-18 14:07
 */
@Service
@AllArgsConstructor
public class FinishedSignServiceImpl implements FinishedSignService {

    private HcPersonVisitInfoService hcPersonVisitInfoService;

    private HcPersonAppregItemsService hcPersonAppregItemsService;

    private FinishedSignMapper finishedSignMapper;

    @Override
    public PageResult<FinishedSignPerson> findPersonByWherePage(FinishedSignPersonByWherePageVo finishedSignPersonByWherePageVo) {
        int pageNum = finishedSignPersonByWherePageVo.getPageNum();
        int pageSize = finishedSignPersonByWherePageVo.getPageSize();
        String strWhere = "";
        if(StringUtils.isNotEmpty(finishedSignPersonByWherePageVo.getHospitalCode())){
            strWhere += " and a.hospital_id = '" + finishedSignPersonByWherePageVo.getHospitalCode()+"'";
        }
        if(StringUtils.isNotEmpty(finishedSignPersonByWherePageVo.getUnitId())&&!("*".equals(finishedSignPersonByWherePageVo.getUnitId()))){// 单位次数 如果 空或者* 就不需要过滤
            strWhere += " and a.unit_id = '" + finishedSignPersonByWherePageVo.getUnitId()+"'";
        }
        if(StringUtils.isNotEmpty(finishedSignPersonByWherePageVo.getUnitVisitId())){
            strWhere += " and a.unit_visit_id = '" + finishedSignPersonByWherePageVo.getUnitVisitId()+"'";
        }
        if(StringUtils.isNotEmpty(finishedSignPersonByWherePageVo.getPersonId())){
            strWhere += " and a.person_id = '" + finishedSignPersonByWherePageVo.getPersonId()+"'";
        }
        if(StringUtils.isNotEmpty(finishedSignPersonByWherePageVo.getPersonVisitId())){
            strWhere += " and a.person_visit_id = '" + finishedSignPersonByWherePageVo.getPersonVisitId()+"'";
        }
        if(StringUtils.isNotEmpty(finishedSignPersonByWherePageVo.getTel())){
            strWhere += " and (b.PHONE_NUMBER = '" + finishedSignPersonByWherePageVo.getTel()+ "' or b.MOBILE = '" + finishedSignPersonByWherePageVo.getTel()+"')";
        }
        List<FinishedSignPerson> list = finishedSignMapper.findPersonByWherePage(pageNum, pageSize, strWhere);
        long totalSize = finishedSignMapper.selectPersonByWhereTotal(strWhere);
        long totalPages = totalSize%pageSize == 0 ? totalSize/pageSize : totalSize/pageSize+1;
        PageResult pageResult = new PageResult(pageNum, pageSize, totalSize, totalPages, list);
        return pageResult;
    }

    @Override
    @Transactional
    public String saveFinishedSignList(SaveFinishedSignListVo saveFinishedSignListVo) {
        List<UpdateHcPersonVistInfoFinishedVo> list = saveFinishedSignListVo.getUpdateHcPersonVistInfoFinished();
        String tmemo = "";
        for(UpdateHcPersonVistInfoFinishedVo item : list){
            int result = finishedSignMapper.updateHcPersonVistInfoFinished(item.getPersonId(), item.getPersonVisitId(), item.getHospitalId(), item.getValues());
            if(result == 0){
                tmemo += "体检号:" + item.getPersonId() + "，";
            }
        }
        return tmemo;
    }

    @Override
    public String findResultStatus(String hospitalId, String personId, String personVisitId) {
        QueryWrapper<HcPersonVisitInfo> hcPersonVisitInfoQueryWrapper = new QueryWrapper<>();
        hcPersonVisitInfoQueryWrapper.eq("hospital_id", hospitalId)
                .eq("person_id", personId)
                .eq("person_visit_id", Integer.parseInt(personVisitId));
        HcPersonVisitInfo hcPersonVisitInfo = hcPersonVisitInfoService.getOne(hcPersonVisitInfoQueryWrapper);
        if(hcPersonVisitInfo!=null){
            //if(hcPersonVisitInfo.getResultStatus().equals("9")){
                return hcPersonVisitInfo.getResultStatus();
            //}
        }
        return "";
    }

    @Override
    @Transactional
    public void updateFinshedSignRefusal(String hospitaId, String personId, String personVisitId, String itemPackCode, String itemNo, String editerId, String editerName) {
        UpdateWrapper<HcPersonAppregItems> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("FINISHED_SIGN", "拒检")
                .set("FINISHED_DATE", new Date())
                .set("EDITER_ID", editerId)
                .set("EDITER_NAME", editerName);
        updateWrapper.eq("hospital_id", hospitaId)
                .eq("person_id", personId)
                .eq("person_visit_id", personVisitId)
                .eq("item_pack_code", itemPackCode)
                .eq("item_no", itemNo);
        hcPersonAppregItemsService.update(updateWrapper);
    }

    @Override
    @Transactional
    public void updateFinshedSignCancelRefusal(String hospitaId, String personId, String personVisitId, String itemPackCode, String itemNo, String editerId, String editerName) {
        UpdateWrapper<HcPersonAppregItems> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("FINISHED_SIGN", "未完成")
                .set("FINISHED_DATE", null)
                .set("EDITER_ID", editerId)
                .set("EDITER_NAME", editerName);
        updateWrapper.eq("hospital_id", hospitaId)
                .eq("person_id", personId)
                .eq("person_visit_id", personVisitId)
                .eq("item_pack_code", itemPackCode)
                .eq("item_no", itemNo);
        hcPersonAppregItemsService.update();
    }

}
