package com.healt.cloud.checkup.appointmentReg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.*;
import com.healt.cloud.checkup.service.*;
import com.healt.cloud.checkup.vo.appointmentReg.unitAppointReg.*;
import com.healt.cloud.checkup.appointmentReg.mapper.UnitAppointRegMapper;
import com.healt.cloud.checkup.appointmentReg.service.UnitAppointRegService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-04-15 12:49
 * @description: TODO
 */
@Service
@AllArgsConstructor
public class UnitAppointRegServiceImpl implements UnitAppointRegService {

    private UnitAppointRegMapper unitAppointRegMapper;

    private HcPersonVisitInfoService hcPersonVisitInfoService;

    private HcUnitInfoService hcUnitInfoService;

    private HcUnitVisitInfoService hcUnitVisitInfoService;

    private HcUnitGroupService hcUnitGroupService;

    private HcUnitGroupItemsService hcUnitGroupItemsService;

    @Override
    public List<DtPackClassVo> findDtPackClass(String hospitalId) {
        List<DtPackClassVo> list = unitAppointRegMapper.findDtPackClass(hospitalId);
        if(list.size() == 0){
            list.add(new DtPackClassVo());
        }
        return list;
    }

    @Override
    public List<DtPackItemsVo> findDtPackItems(String hospitalId) {
        List<DtPackItemsVo> list = unitAppointRegMapper.findDtPackItems(hospitalId);
        if(list.size() == 0){
            list.add(new DtPackItemsVo());
        }
        return list;
    }

    @Override
    public List<DtSetsVo> findDtSets(String hospitalId) {
        List<DtSetsVo> list = unitAppointRegMapper.findDtSets(hospitalId);
        if(list.size() == 0){
            list.add(new DtSetsVo());
        }
        return list;
    }

    @Override
    public List<DtUnitTypeVo> findDtUnitType(String hospitalId) {
        List<DtUnitTypeVo> list = unitAppointRegMapper.findDtUnitType(hospitalId);
        if(list.size() == 0){
            list.add(new DtUnitTypeVo());
        }
        return list;
    }

    @Override
    public List<DtParentUnitVo> findDtParentUnit(String hospitalId) {
        List<DtParentUnitVo> list = unitAppointRegMapper.findDtParentUnit(hospitalId);
        if(list.size() == 0){
            list.add(new DtParentUnitVo());
        }
        return list;
    }

    @Override
    public List<DtUnitGroupItemsVo2> findDtUnitGroupItems2(String hospitalId, String unitId, String unitVisitId) {
        List<DtUnitGroupItemsVo2> list = unitAppointRegMapper.findDtUnitGroupItems2(hospitalId, unitId, unitVisitId);
        if(list.size() == 0){
            list.add(new DtUnitGroupItemsVo2());
        }
        return list;
    }

    @Override
    public Integer findPatCount(String hospitalId, String unitId, String visitId) {
        QueryWrapper<HcPersonVisitInfo> queryWrapper = new QueryWrapper();
        queryWrapper.eq("HOSPITAL_ID", hospitalId);
        queryWrapper.eq("UNIT_ID", unitId);
        queryWrapper.eq("UNIT_VISIT_ID", visitId);
        long count = hcPersonVisitInfoService.count(queryWrapper);
        return Integer.parseInt(count+"");
    }

    @Override
    public String findNewUnitId() {
        return unitAppointRegMapper.findNewUnitId();
    }

    @Override
    public Integer findMaxVisitId(String hospitalId, String unitId) {
        return unitAppointRegMapper.findMaxVisitId(hospitalId, unitId);
    }

    @Override
    public Integer findFinishedSign(String hospitalId, String unitId, String visitId) {
        return unitAppointRegMapper.findFinishedSign(hospitalId, unitId, visitId);
    }

    @Override
    public List<SetPacksVo> findSetPacks(String hospitalId, String setCode) {
        List<SetPacksVo> list = unitAppointRegMapper.findSetPacks(hospitalId, setCode);
        if(list.size() == 0){
            list.add(new SetPacksVo());
        }
        return list;
    }

    @Override
    @Transactional
    /**
     * 保存按钮
     */
    public void saveHcUnitGroupList(SaveHcUnitGroupListVo saveHcUnitGroupListVo) {

        updateHcUnitInfo(saveHcUnitGroupListVo.getUpdateHcUnitInfo());//更新单位信息
        updateHcUnitVisitInfo(saveHcUnitGroupListVo.getUpdateHcUnitVisitInfo());//更新单位预约信息

        //保存分组信息，组合信息(先删除，在新增)
        List<SaveHcUnitGroupVo> saveHcUnitGroupList = saveHcUnitGroupListVo.getSaveHcUnitGroupList();
        if(saveHcUnitGroupList!=null && saveHcUnitGroupList.size()>0){
            //删除
            for (SaveHcUnitGroupVo saveHcUnitGroupVo : saveHcUnitGroupList) {
                if(saveHcUnitGroupVo.getStat().equals("delete")){
                    //删除分组
                    deleteHcUnitGroup(saveHcUnitGroupVo.getHcUnitGroup());
                    //删除组合
                    deleteHcUnitGroupItems(saveHcUnitGroupVo.getHcUnitGroupItems());
                }
                if(saveHcUnitGroupVo.getStat().equals("add")){
                    addHcUnitGroup(saveHcUnitGroupVo.getHcUnitGroup());//分组
                    addHcUnitGroupItems(saveHcUnitGroupVo.getHcUnitGroupItems());//组合
                }
            }
            //新增
//            for (SaveHcUnitGroupVo saveHcUnitGroupVo : saveHcUnitGroupList) {
//                if(saveHcUnitGroupVo.getStat().equals("add")){
//                    addHcUnitGroup(saveHcUnitGroupVo.getHcUnitGroup());//分组
//                    addHcUnitGroupItems(saveHcUnitGroupVo.getHcUnitGroupItems());//组合
//                }
//            }
        }
    }

    @Override
    @Transactional
    /**
     * 新增单位预约
     */
    public void saveHcUnitVisitGroupList(SaveHcUnitVisitGroupListVo saveHcUnitVisitGroupListVo) {

        //更新单位信息
        updateHcUnitInfo(saveHcUnitVisitGroupListVo.getUpdateHcUnitInfo());

        //新增预约
        List<SaveHcUnitVisitGroupVo> saveHcUnitVisitGroupList = saveHcUnitVisitGroupListVo.getSaveHcUnitVisitGroupList();
        for(SaveHcUnitVisitGroupVo saveHcUnitVisitGroupVo : saveHcUnitVisitGroupList){
            List<HcUnitInfo> hcUnitInfos = saveHcUnitVisitGroupVo.getHcUnitInfo();
            List<HcUnitVisitInfo> hcUnitVisitInfos = saveHcUnitVisitGroupVo.getHcUnitVisitInfo();
            List<HcUnitGroup> hcUnitGroups = saveHcUnitVisitGroupVo.getHcUnitGroup();
            List<HcUnitGroupItems> hcUnitGroupItems = saveHcUnitVisitGroupVo.getHcUnitGroupItems();
            switch (saveHcUnitVisitGroupVo.getStat()){
                case "add":
                    //新单位
                    if(hcUnitInfos!=null && hcUnitInfos.size()>0){
                        hcUnitInfoService.save(hcUnitInfos.get(0));
                    }
                    //新增单位预约
                    hcUnitVisitInfoService.save(hcUnitVisitInfos.get(0));
                    //新增分组
                    if(hcUnitGroups!=null && hcUnitGroups.size()>0){
                        hcUnitGroupService.saveBatch(hcUnitGroups);
                    }
                    //新增组合
                    hcUnitGroupItemsService.saveBatch(hcUnitGroupItems);
                    break;
                case "delete":
                    //删除分组
                    deleteHcUnitGroup(hcUnitGroups);
                    //删除组合
                    deleteHcUnitGroupItems(hcUnitGroupItems);
                    //删除单位预约信息
                    deleteHcUnitVisitInfos(hcUnitVisitInfos);
                    //首次预约时删除单位信息
                    if(hcUnitVisitInfos.get(0).getUnitVisitId().equals("1")){
                        deleteHcUnitInfos(hcUnitInfos);
                    }
                    break;
            }

        }
    }

    @Override
    @Transactional
    public void deleteHcUnitVisitGroupList(SaveHcUnitVisitGroupListVo saveHcUnitVisitGroupListVo) {
        List<SaveHcUnitVisitGroupVo> saveHcUnitVisitGroupList = saveHcUnitVisitGroupListVo.getSaveHcUnitVisitGroupList();
        for(SaveHcUnitVisitGroupVo saveHcUnitVisitGroupVo : saveHcUnitVisitGroupList){

            //删除分组
            List<HcUnitGroup> hcUnitGroups = saveHcUnitVisitGroupVo.getHcUnitGroup();
            deleteHcUnitGroup(hcUnitGroups);
            //删除组合
            List<HcUnitGroupItems> hcUnitGroupItems = saveHcUnitVisitGroupVo.getHcUnitGroupItems();
            deleteHcUnitGroupItems(hcUnitGroupItems);
            //删除单位预约信息
            List<HcUnitVisitInfo> hcUnitVisitInfos = saveHcUnitVisitGroupVo.getHcUnitVisitInfo();
            deleteHcUnitVisitInfos(hcUnitVisitInfos);
            //首次预约时删除单位信息
            List<HcUnitInfo> hcUnitInfos = saveHcUnitVisitGroupVo.getHcUnitInfo();
            if(hcUnitVisitInfos.get(0).getUnitVisitId() == 1){
                deleteHcUnitInfos(hcUnitInfos);
            }
        }
    }

    private void updateHcUnitInfo(List<UpdateHcUnitInfo> updateHcUnitInfos){
        if(updateHcUnitInfos!=null && updateHcUnitInfos.size()>0){
            for(UpdateHcUnitInfo updateHcUnitInfo : updateHcUnitInfos){
                String hospitalId = updateHcUnitInfo.getHospitalId();
                String unitId = updateHcUnitInfo.getUnitId();
                String values = updateHcUnitInfo.getValues();
                UpdateWrapper<HcUnitInfo> updateWrapper = new UpdateWrapper<>();
                updateWrapper.setSql(values).eq("hospital_id", hospitalId).eq("unit_id", unitId);
                hcUnitInfoService.update(updateWrapper);
            }
        }
    }

    private void updateHcUnitVisitInfo(List<UpdateHcUnitVisitInfo> updateHcUnitVisitInfos){
        if(updateHcUnitVisitInfos!=null && updateHcUnitVisitInfos.size()>0){
            for(UpdateHcUnitVisitInfo updateHcUnitVisitInfo : updateHcUnitVisitInfos){
                String hospitalId = updateHcUnitVisitInfo.getHospitalId();
                String unitId = updateHcUnitVisitInfo.getUnitId();
                String unitVisitId = updateHcUnitVisitInfo.getUnitVisitId();
                String values = updateHcUnitVisitInfo.getValues();
                UpdateWrapper<HcUnitVisitInfo> updateWrapper = new UpdateWrapper<>();
                updateWrapper.setSql(values).eq("HOSPITAL_ID", hospitalId).eq("UNIT_ID", unitId).eq("UNIT_VISIT_ID", unitVisitId);
                hcUnitVisitInfoService.update(updateWrapper);
            }
        }
    }

    private void addHcUnitGroup(List<HcUnitGroup> hcUnitGroups){
        if(hcUnitGroups!=null && hcUnitGroups.size()>0){
            hcUnitGroupService.saveBatch(hcUnitGroups);
        }
    }

    private void addHcUnitGroupItems(List<HcUnitGroupItems> hcUnitGroupItems){
        if(hcUnitGroupItems !=null && hcUnitGroupItems.size()>0){
            hcUnitGroupItemsService.saveBatch(hcUnitGroupItems);
        }
    }

    private void deleteHcUnitGroup(List<HcUnitGroup> hcUnitGroups){
        if(hcUnitGroups!=null && hcUnitGroups.size()>0){
            for (HcUnitGroup hcUnitGroup : hcUnitGroups){
                QueryWrapper<HcUnitGroup> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("HOSPITAL_ID", hcUnitGroup.getHospitalId())
                        .eq("UNIT_ID", hcUnitGroup.getUnitId())
                        .eq("UNIT_VISIT_ID", hcUnitGroup.getUnitVisitId());
                hcUnitGroupService.remove(queryWrapper);
            }
        }
    }

    private void deleteHcUnitGroupItems(List<HcUnitGroupItems> hcUnitGroupItems){
        if(hcUnitGroupItems!=null && hcUnitGroupItems.size()>0){
            for (HcUnitGroupItems hcUnitGroupItem : hcUnitGroupItems){
                QueryWrapper<HcUnitGroupItems> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("HOSPITAL_ID", hcUnitGroupItem.getHospitalId()).
                        eq("UNIT_ID", hcUnitGroupItem.getUnitId()).
                        eq("UNIT_VISIT_ID", hcUnitGroupItem.getUnitVisitId());
                hcUnitGroupItemsService.remove(queryWrapper);
            }
        }
    }

    private void deleteHcUnitInfos(List<HcUnitInfo> hcUnitInfos) {
        if(hcUnitInfos!=null && hcUnitInfos.size()>0){
            for(HcUnitInfo hcUnitInfo : hcUnitInfos){
                QueryWrapper<HcUnitInfo> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("HOSPITAL_ID", hcUnitInfo.getHospitalId())
                        .eq("UNIT_ID", hcUnitInfo.getUnitId());
                hcUnitInfoService.remove(queryWrapper);
            }
        }
    }

    private void deleteHcUnitVisitInfos(List<HcUnitVisitInfo> hcUnitVisitInfos) {
        if(hcUnitVisitInfos!=null && hcUnitVisitInfos.size()>0){
            for (HcUnitVisitInfo hcUnitVisitInfo : hcUnitVisitInfos){
                QueryWrapper<HcUnitVisitInfo> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("HOSPITAL_ID", hcUnitVisitInfo.getHospitalId())
                        .eq("UNIT_ID", hcUnitVisitInfo.getUnitId())
                        .eq("UNIT_VISIT_ID", hcUnitVisitInfo.getUnitVisitId());
                hcUnitVisitInfoService.remove(queryWrapper);
            }
        }
    }

}
