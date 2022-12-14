package com.healt.cloud.checkup.appointmentReg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.healt.cloud.checkup.appointmentReg.mapper.PersonAppointRegMapper;
import com.healt.cloud.checkup.entity.*;
import com.healt.cloud.checkup.service.*;
import com.healt.cloud.checkup.vo.appointmentReg.unitPersonAppointReg.*;
import com.healt.cloud.checkup.appointmentReg.mapper.UnitPersonAppointRegMapper;
import com.healt.cloud.checkup.appointmentReg.service.UnitPersonAppointRegService;
import com.healt.cloud.checkup.vo.settlement.PersonsInfoDictVo;
import com.healt.cloud.checkup.vo.settlement.PersonsInfoVo;
import com.healt.cloud.resultex.exception.CommonException;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-04-08 0:03
 * @description: TODO
 */
@Service
@AllArgsConstructor
public class UnitPersonAppointRegServiceImpl implements UnitPersonAppointRegService {

    private HcUnitVisitInfoService hcUnitVisitInfoService;

    private HcUnitGroupService hcUnitGroupService;

    private UnitPersonAppointRegMapper unitPersonAppointRegMapper;

    private HcPersonAppregItemsService hcPersonAppregItemsService;

    private VHcItemPackDictService vHcItemPackDictService;

    private HcPackSetDictService hcPackSetDictService;

    private VDepartDictService vDepartDictService;

    private PersonAppointRegMapper personAppointRegMapper;

    @Override
    public List<HcUnitVisitInfo> findDtUnitVisit(String hospitalId, String unitId) {
        QueryWrapper<HcUnitVisitInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("HOSPITAL_ID", hospitalId);
        queryWrapper.eq("UNIT_ID", unitId);
        queryWrapper.orderByDesc("UNIT_VISIT_ID");
        List<HcUnitVisitInfo> list = hcUnitVisitInfoService.list(queryWrapper);
        if(list.size() == 0){
            list.add(new HcUnitVisitInfo());
        }
        return list;
    }

    @Override
    public List<HcUnitVisitInfo> findDtUnitVisit(String hospitalId, String unitId, String visitId) {
        QueryWrapper<HcUnitVisitInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("HOSPITAL_ID", hospitalId);
        queryWrapper.eq("UNIT_ID", unitId);
        queryWrapper.eq("UNIT_VISIT_ID", visitId);
        queryWrapper.orderByDesc("UNIT_VISIT_ID");
        List<HcUnitVisitInfo> list = hcUnitVisitInfoService.list(queryWrapper);
        if(list.size() == 0){
            list.add(new HcUnitVisitInfo());
        }
        return list;
    }

    @Override
    public List<HcUnitGroup> findDtUnitGroup(String hospitalId, String unitId, String unitVisitId) {
        QueryWrapper<HcUnitGroup> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("HOSPITAL_ID", hospitalId);
        queryWrapper.eq("UNIT_ID", unitId);
        queryWrapper.eq("UNIT_VISIT_ID", unitVisitId);
        List<HcUnitGroup> list = hcUnitGroupService.list(queryWrapper);
        if(list.size() == 0){
            list.add(new HcUnitGroup());
        }
        return list;
    }

    @Override
    public List<DtUnitGroupItemsVo> findDtUnitGroupItems(String hospitalId, String unitId, String unitVisitId, String groupCode) {
        if("*".equals(groupCode) || groupCode == null){
            groupCode = null;
        }
        List<DtUnitGroupItemsVo> list = unitPersonAppointRegMapper.findDtUnitGroupItems(hospitalId, unitId, unitVisitId, groupCode);
        if(list.size() == 0){
            list.add(new DtUnitGroupItemsVo());
        }
        return list;
    }

    @Override
    public List<HcPersonAppregItems> findDtPersonItems(String hospitalId, String personId, String personVisitId) {
        QueryWrapper<HcPersonAppregItems> queryWrapper = new QueryWrapper();
        queryWrapper.eq("HOSPITAL_ID",hospitalId);
        queryWrapper.eq("PERSON_ID",personId);
        if(!"*".equals(personVisitId)){
            queryWrapper.eq("PERSON_VISIT_ID",personVisitId);
        }
        List<HcPersonAppregItems> list = hcPersonAppregItemsService.list(queryWrapper);
        if(list.size() == 0){
            list.add(new HcPersonAppregItems());
        }
        return list;
    }

    @Override
    public List<VHcItemPackDict> findDtItemPackEffectiveFlag(String hospitalId) {
        QueryWrapper<VHcItemPackDict> queryWrapper = new QueryWrapper();
        queryWrapper.eq("HOSPITAL_ID",hospitalId)
                .eq("EFFECTIVE_FLAG","1");
        List<VHcItemPackDict> list = vHcItemPackDictService.list(queryWrapper);
        if(list.size() == 0){
            list.add(new VHcItemPackDict());
        }
        return list;
    }

    @Override
    public List<HcPersonInfoVo> findDtUnitPersons(String hospitalId, String unitId) {
        List<HcPersonInfoVo> list = unitPersonAppointRegMapper.findDtUnitPersons(hospitalId, unitId);
        if(list.size() == 0){
            list.add(new HcPersonInfoVo());
        }
        return list;
    }

    @Override
    public Integer findMaxPersonVisitId(String hospitalId, String personId) {
        return unitPersonAppointRegMapper.findMaxPersonVisitId(hospitalId, personId);
    }

    @Override
    public List<DtUnitPersonsVisitVo> findDtUnitPersonsVisit(String hospitalId, String unitId, String visitId) {
        List<DtUnitPersonsVisitVo> list = unitPersonAppointRegMapper.findDtUnitPersonsVisit(hospitalId, unitId, visitId);
        if(list.size() == 0){
            list.add(new DtUnitPersonsVisitVo());
        }
        return list;
    }

    @Override
    public String findSetSex(String hospitalId, String setName) {
        QueryWrapper<HcPackSetDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hospital_id", hospitalId)
                .eq("set_name", setName);
        HcPackSetDict hcPackSetDict = hcPackSetDictService.getOne(queryWrapper);
        if(hcPackSetDict == null){
            return "";
        }
        return hcPackSetDict.getSex();
    }

    @Override
    public void batchAddItems(BatchAddItemsVo batchAddItems) {
        //查询项目是否存在
        QueryWrapper<VHcItemPackDict> vHcItemPackDictQueryWrapper = new QueryWrapper<>();
        vHcItemPackDictQueryWrapper.eq("HOSPITAL_ID", batchAddItems.getHospitalId());
        vHcItemPackDictQueryWrapper.eq("ITEM_PACK_CODE", batchAddItems.getItemPackCode());
        List<VHcItemPackDict> vHcItemPackDicts = vHcItemPackDictService.list(vHcItemPackDictQueryWrapper);
        if(vHcItemPackDicts.size() < 1){
            throw new CommonException(500, "没有查询到具体项目名称！");
        }
        VHcItemPackDict vHcItemPackDict = vHcItemPackDicts.get(0);
        Date sysDate = new Date();
        //int age = 0;
        int count = 0;
        List<HcPersonAppregItems> hcPersonAppregItemsList = new ArrayList<>();
        List<SelectUnitPersonVo> selectUnitPersons = batchAddItems.getSelectUnitPersons();
        for(SelectUnitPersonVo selectUnitPersonVo : selectUnitPersons){
            int maxPersonVisitId = this.findMaxPersonVisitId(batchAddItems.getHospitalId(), selectUnitPersonVo.getPersonId());
            if(maxPersonVisitId < 1){
                continue;
            }
            String resultStatus = selectUnitPersonVo.getResultStatus();
            if(!"未完成".equals(resultStatus)){//只有预约后的未完成的可以增加项目
                continue;
            }
//            if(selectUnitPersonVo.getBirthday() == null){
//                age = -1;
//            } else {
//                age = DateUtils.getAgeByBirthday(DateUtils.parseString(selectUnitPersonVo.getBirthday(),"yyyy-MM-dd"));
//            }
            HcPersonAppregItems hcPersonAppregItems = new HcPersonAppregItems();
            hcPersonAppregItems.setHospitalId(batchAddItems.getHospitalId());
            hcPersonAppregItems.setPersonId(selectUnitPersonVo.getPersonId());
            hcPersonAppregItems.setPersonVisitId(maxPersonVisitId);
            hcPersonAppregItems.setUnitId(batchAddItems.getUnitId());
            hcPersonAppregItems.setUnitVisitId(Integer.parseInt(batchAddItems.getVisitId()));
            hcPersonAppregItems.setItemPackCode(vHcItemPackDict.getItemPackCode());
            hcPersonAppregItems.setItemPackName(vHcItemPackDict.getItemPackName());
            hcPersonAppregItems.setRegisterDate(sysDate);
            hcPersonAppregItems.setRegister(batchAddItems.getUserName());
            hcPersonAppregItems.setRegisterName(batchAddItems.getUserRealName());
            hcPersonAppregItems.setAddItem("1"); //加项标志
            hcPersonAppregItems.setChartCode(vHcItemPackDict.getGuidegroupCode()); //指引单分组代码
            hcPersonAppregItems.setCosts(vHcItemPackDict.getItemPackPrice() == null ? BigDecimal.valueOf(0) : vHcItemPackDict.getItemPackPrice()); //组合金额
            hcPersonAppregItems.setCharges(hcPersonAppregItems.getCosts()); //组合金额
            hcPersonAppregItems.setBillIndicator("0");
            hcPersonAppregItems.setFinishedSign("未完成");
            hcPersonAppregItems.setNum(BigDecimal.valueOf(1));
            hcPersonAppregItems.setSetCode("");
            hcPersonAppregItems.setDeptId(vHcItemPackDict.getDeptId());
            hcPersonAppregItems.setDeptName(vHcItemPackDict.getDeptName());
            QueryWrapper<HcPersonAppregItems> hcPersonAppregItemsQueryWrapper = new QueryWrapper<>();
            hcPersonAppregItemsQueryWrapper.eq("HOSPITAL_ID", batchAddItems.getHospitalId());
            hcPersonAppregItemsQueryWrapper.eq("PERSON_ID", selectUnitPersonVo.getPersonId());
            hcPersonAppregItemsQueryWrapper.eq("PERSON_VISIT_ID", maxPersonVisitId);
            hcPersonAppregItemsQueryWrapper.eq("ITEM_PACK_CODE", batchAddItems.getItemPackCode());
            int countItems = (int)hcPersonAppregItemsService.count(hcPersonAppregItemsQueryWrapper);
            if(countItems > 0){
                hcPersonAppregItems.setItemNo(countItems+1);
            }else{
                hcPersonAppregItems.setItemNo(1);
            }
            hcPersonAppregItemsList.add(hcPersonAppregItems);
            count++;
        }
        if (count > 0) {
            for(HcPersonAppregItems hcPersonAppregItems : hcPersonAppregItemsList){
                String orderId = personAppointRegMapper.selectOrderId().toString();
                hcPersonAppregItems.setOrderId(orderId);
            }
            boolean success = hcPersonAppregItemsService.saveBatch(hcPersonAppregItemsList);
            if (!success) {
                throw new CommonException(500, "批量新增项目失败");
            }
        } else {
            throw new CommonException(500, "没有需要增加的项目");
        }

    }

    @Override
    public List<BatchUnitPersonsDeleteItemsVo> selectBatchDelItems(SelectBatchDelItemsListVo selectBatchDelItemsListVo) {
        List<SelectBatchDelItemsVo> selectBatchDelItemsVos = selectBatchDelItemsListVo.getSelectBatchDelItems();
        List<BatchUnitPersonsDeleteItemsVo> batchUnitPersonsDeleteItemsVos = new ArrayList<>();
        for (SelectBatchDelItemsVo selectBatchDelItemsVo : selectBatchDelItemsVos){
            BatchUnitPersonsDeleteItemsVo batchUnitPersonsDeleteItemsVo = unitPersonAppointRegMapper.selectBatchDelItems(selectBatchDelItemsVo);
            batchUnitPersonsDeleteItemsVo.setPersonId(selectBatchDelItemsVo.getPersonId());
            batchUnitPersonsDeleteItemsVo.setPersonVisitId(selectBatchDelItemsVo.getPersonVisitId());
            batchUnitPersonsDeleteItemsVo.setItemPackCode(selectBatchDelItemsVo.getItemPackCode());
            batchUnitPersonsDeleteItemsVos.add(batchUnitPersonsDeleteItemsVo);
        }
        return batchUnitPersonsDeleteItemsVos;
    }

    @Override
    public void batchUnitPersonsDeleteItems(BatchUnitPersonsDeleteItemsListVo batchUnitPersonsDeleteItemsListVo) {
        List<BatchUnitPersonsDeleteItemsVo> batchUnitPersonsDeleteItemsVos= batchUnitPersonsDeleteItemsListVo.getBatchUnitPersonsDeleteItems();
        for(BatchUnitPersonsDeleteItemsVo batchUnitPersonsDeleteItem : batchUnitPersonsDeleteItemsVos){
            QueryWrapper<HcPersonAppregItems> hcPersonAppregItemsQueryWrapper = new QueryWrapper<>();
            hcPersonAppregItemsQueryWrapper.eq("PERSON_ID", batchUnitPersonsDeleteItem.getPersonId());
            hcPersonAppregItemsQueryWrapper.eq("PERSON_VISIT_ID", batchUnitPersonsDeleteItem.getPersonVisitId());
            hcPersonAppregItemsQueryWrapper.eq("ITEM_PACK_CODE", batchUnitPersonsDeleteItem.getItemPackCode());
            if(!"*".equals(batchUnitPersonsDeleteItem.getMaxItemNo())){
                hcPersonAppregItemsQueryWrapper.eq("ITEM_NO", batchUnitPersonsDeleteItem.getMaxItemNo());
            }
            List<HcPersonAppregItems> hcPersonAppregItemsList = hcPersonAppregItemsService.list(hcPersonAppregItemsQueryWrapper);
            if(hcPersonAppregItemsList.size()>0){
                String finishedSign = hcPersonAppregItemsList.get(0).getFinishedSign();
                if(!"未完成".equals(finishedSign)){ //该项目已完成，跳过)
                    continue;
                }
                String billIndicator = hcPersonAppregItemsList.get(0).getBillIndicator();
                if(!"0".equals(billIndicator)){
                    // TODO 已经收费和退费的怎么处理
                    continue;
                }
                String applyNo = hcPersonAppregItemsList.get(0).getApplyNo();
                // TODO 调用外部资源接口
                if(StringUtils.isNotEmpty(applyNo)){
                    QueryWrapper<VDepartDict> vDepartDictQueryWrapper = new QueryWrapper<>();
                    vDepartDictQueryWrapper.eq("HOSPITAL_ID", hcPersonAppregItemsList.get(0).getHospitalId());
                    vDepartDictQueryWrapper.eq("DEPT_ID", hcPersonAppregItemsList.get(0).getDeptId());
                    String className = vDepartDictService.list(vDepartDictQueryWrapper).get(0).getClassName();
                    int ret = 1;
                    if("检查".equals(className)){
                        //ret = 0;
                    }
                    if("检验".equals(className)){
                        //ret = 0;
                    }
                    if (ret < 1){
                        // TODO 删除失败，回滚外部接口
                        throw new CommonException(500, "删除检查检验项目失败！[" +
                                batchUnitPersonsDeleteItem.getPersonId() + "]" +
                                className + ":"+ applyNo);
                    }
                }
                // 删除项目
                hcPersonAppregItemsService.remove(hcPersonAppregItemsQueryWrapper);
            }

        }
    }

    @Override
    public List<PersonsInfoVo> findPersonsInfo(String hospitalId, String unitId) {
        List<PersonsInfoVo> list = unitPersonAppointRegMapper.findPersonsInfo(hospitalId, unitId);
        if(list.size() == 0){
            list.add(new PersonsInfoVo());
        }
        return list;
    }

    @Override
    public List<PersonsInfoVo> findPersonsInfoByTime(PersonsInfoDictVo personsInfoDictVo) {
        List<PersonsInfoVo> list = unitPersonAppointRegMapper.findPersonsInfoByTime(personsInfoDictVo);
        if(list.size() == 0){
            list.add(new PersonsInfoVo());
        }
        return list;
    }
}
