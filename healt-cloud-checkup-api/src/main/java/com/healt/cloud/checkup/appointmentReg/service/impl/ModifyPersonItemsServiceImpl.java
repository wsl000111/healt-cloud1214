package com.healt.cloud.checkup.appointmentReg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.appointmentReg.mapper.BeforeSignInMapper;
import com.healt.cloud.checkup.entity.HcPersonAppregItems;
import com.healt.cloud.checkup.entity.VHcItemPackDict;
import com.healt.cloud.checkup.service.pubComm.PubCommService;
import com.healt.cloud.checkup.appointmentReg.mapper.ModifyPersonItemsMapper;
import com.healt.cloud.checkup.appointmentReg.mapper.PersonAppointRegMapper;
import com.healt.cloud.checkup.appointmentReg.service.ModifyPersonItemsService;
import com.healt.cloud.checkup.mapper.pubComm.PubCommMapper;
import com.healt.cloud.checkup.service.HcPersonAppregItemsService;
import com.healt.cloud.checkup.service.VHcItemPackDictService;
import com.healt.cloud.checkup.vo.appointmentReg.modifyPersonItems.*;
import com.healt.cloud.checkup.vo.appointmentReg.personAppointReg.PersonItemsVo;
import com.healt.cloud.checkup.vo.appointmentReg.personAppointReg.UnitVisitInfoVo;
import com.healt.cloud.resultex.exception.CommonException;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author linklee
 * @create 2022-04-15 14:39
 */
@Service
@AllArgsConstructor
public class ModifyPersonItemsServiceImpl implements ModifyPersonItemsService {

    private HcPersonAppregItemsService hcPersonAppregItemsService;

    private ModifyPersonItemsMapper modifyPersonItemsMapper;

    private PersonAppointRegMapper personAppointRegMapper;

    private PubCommMapper pubCommMapper;

    private PubCommService pubCommService;

    private VHcItemPackDictService vHcItemPackDictService;

    private BeforeSignInMapper beforeSignInMapper;


    @Override
    public List<ModifySelectedItemsVo> findModifySelectedItems(String hospitalId, String personId, Integer personVisitId) {
        List<ModifySelectedItemsVo> list = modifyPersonItemsMapper.findModifySelectedItems(hospitalId,personId,personVisitId);
        if (list.size() == 0) {
            list.add(new ModifySelectedItemsVo());
        }
        return list;
    }

    @Override
    public List<SelectedPackSetVo> findSelectedPackSetVo(String hospitalId, String personId, Integer personVisitId) {
        List<SelectedPackSetVo> list = modifyPersonItemsMapper.findSelectedPackSetVo(hospitalId,personId,personVisitId);
        if (list.size() == 0) {
            list.add(new SelectedPackSetVo());
        }
        return list;
    }

    @Override
    public List<PublicDictVo> findPublicDict(String dictType) {
        List<PublicDictVo> list = modifyPersonItemsMapper.findPublicDict(dictType);
        if (list.size() == 0) {
            list.add(new PublicDictVo());
        }
        return list;
    }

    @Override
    public List<UnitPersonsVo> findUnitPersons(String hospitalId, String unitId) {
        List<UnitVisitInfoVo> list = personAppointRegMapper.findUnitVisitInfo(hospitalId,unitId);
        if(list.size() == 0){
            throw new CommonException(20001,"此单位还没有预约！");
        } else {
            UnitVisitInfoVo unitVisitInfoVo = list.get(0);
            if (unitVisitInfoVo.getFinishedSign().equals("1")) {
                throw new CommonException(20002,"此单位已体检完成！");
            }else {
                return modifyPersonItemsMapper.findUnitPersons(hospitalId,unitId,unitVisitInfoVo.getUnitVisitId());
            }
        }
    }

    @Override
    public List<ModifyPersonVisitInfoVo> findModifyPersonVisitInfoVo(String hospitalId, String personId) {
        List<ModifyPersonVisitInfoVo> list = modifyPersonItemsMapper.findModifyPersonVisitInfoVo(hospitalId,personId);
        if (list.size() > 0) {
            ModifyPersonVisitInfoVo infoVo = list.get(0);
            if (infoVo.getFinishedSign().equals("1")) {
                throw new CommonException(20001,"此人最后一次体检已完成，不能修改！");
            }
            if (infoVo.getResultStatus().equals("F")) {
                throw new CommonException(20002,"此人最后一次体检已最终审核，不能修改！");
            }
        } else {
            throw new CommonException(20003,"此人不存在或无预约信息！");
        }
        return list;
    }

    @Override
    public List<ModifyPersonVisitInfoVo> findModifyPersonVisitInfoVoTwo(String hospitalId, String personId, String personVisitId) {
        List<ModifyPersonVisitInfoVo> list = modifyPersonItemsMapper.findModifyPersonVisitInfoVoTwo(hospitalId,personId,personVisitId);
        if (list.size() > 0) {
            ModifyPersonVisitInfoVo infoVo = list.get(0);
            if (infoVo.getFinishedSign().equals("1")) {
                throw new CommonException(20001,"此人最后一次体检已完成，不能修改！");
            }
            if (infoVo.getResultStatus().equals("F")) {
                throw new CommonException(20002,"此人最后一次体检已最终审核，不能修改！");
            }
        } else {
            throw new CommonException(20003,"此人不存在或无预约信息！");
        }
        return list;
    }

    @Override
    public String findItemClass(String hospitalId, String itemPackCode) {
        String ItemClass = modifyPersonItemsMapper.findItemClass(hospitalId,itemPackCode);
        if (ItemClass == null) {
            ItemClass = "";
        }
        return ItemClass;
    }

    @Override
    public String findApplySendto(String itemPackCode) {
        String applySendto = modifyPersonItemsMapper.findApplySendto(itemPackCode);
        if (applySendto == null) {
            applySendto = "";
        }
        return applySendto;
    }

    @Override
    public String saveModifyPersonItemList(SaveModifyPersonItemsListVo saveModifyPersonItemsListVo) {
        List<SaveModifyPersonItemsVo> saveModifyPersonItemList = saveModifyPersonItemsListVo.getSaveModifyPersonItemList();
        String hospitalId = saveModifyPersonItemsListVo.getHospitalId();
        String beforeSign = saveModifyPersonItemsListVo.getBeforeSign();
        String personId = saveModifyPersonItemsListVo.getPersonId();
        String personVisitId = saveModifyPersonItemsListVo.getPersonVisitId();
        String userName = saveModifyPersonItemsListVo.getUserName();

        //未签到
        if("0".equals(beforeSign)){
            for(SaveModifyPersonItemsVo saveModifyPersonItemsVo : saveModifyPersonItemList){
                switch (saveModifyPersonItemsVo.getStat()){
                    case "add"://如果存在，就修改，没有就新增
                        for(HcPersonAppregItems item : saveModifyPersonItemsVo.getHcPersonAppregItems()){
                            QueryWrapper<HcPersonAppregItems> queryWrapper = new QueryWrapper<>();
                            queryWrapper.eq("HOSPITAL_ID", item.getHospitalId())
                                    .eq("PERSON_ID", item.getPersonId())
                                    .eq("PERSON_VISIT_ID", item.getPersonVisitId())
                                    .eq("ITEM_PACK_CODE", item.getItemPackCode())
                                    .eq("ITEM_NO", item.getItemNo());
                            if(hcPersonAppregItemsService.getOne(queryWrapper)!=null){
                                UpdateWrapper<HcPersonAppregItems> updateWrapper = new UpdateWrapper<>();
                                updateWrapper.eq("HOSPITAL_ID", item.getHospitalId())
                                        .eq("PERSON_ID", item.getPersonId())
                                        .eq("PERSON_VISIT_ID", item.getPersonVisitId())
                                        .eq("ITEM_PACK_CODE", item.getItemPackCode())
                                        .eq("ITEM_NO", item.getItemNo());
                                hcPersonAppregItemsService.update(item, updateWrapper);
                            }else{
                                String orderId = personAppointRegMapper.selectOrderId().toString();
                                item.setOrderId(orderId);
                                hcPersonAppregItemsService.save(item);
                            }
                        }
                        break;
                    case "delete":
                        for(HcPersonAppregItems item : saveModifyPersonItemsVo.getHcPersonAppregItems()){
                            QueryWrapper<HcPersonAppregItems> queryWrapper = new QueryWrapper<>();
                            queryWrapper.eq("HOSPITAL_ID", item.getHospitalId())
                                    .eq("PERSON_ID", item.getPersonId())
                                    .eq("PERSON_VISIT_ID", item.getPersonVisitId())
                                    .eq("ITEM_PACK_CODE", item.getItemPackCode())
                                    .eq("ITEM_NO", item.getItemNo());
                            hcPersonAppregItemsService.remove(queryWrapper);
                        }
                        break;
                }
            }
        }
        //判断签到 如果已经签到需要修改或生成申请
        if("1".equals(beforeSign)){
            String applySendTo = "";
            String applyNo = "";

            String itemClass = "";
            String itemPackCode = "";
            String msg = null;
            for(SaveModifyPersonItemsVo saveModifyPersonItemsVo : saveModifyPersonItemList) {
                List<PersonItemsVo> dsItemList = new ArrayList<>();
                //判断申请号，如果为空生成
                for(HcPersonAppregItems item : saveModifyPersonItemsVo.getHcPersonAppregItems()){
                    PersonItemsVo personItemsVo = new PersonItemsVo();

                    applySendTo = null;
                    applyNo = item.getApplyNo();
                    if(StringUtils.isNotEmpty(applyNo)){
                        continue;
                    }
                    itemPackCode = item.getItemPackCode();
                    applySendTo = pubCommMapper.selectApplySendTo(itemPackCode);
                    if (StringUtils.isEmpty(applySendTo)||"0000".equals(applySendTo)){
                        continue;//不需要发往
                    }
                    //取类别判断
                    itemClass = this.findItemClass(hospitalId, itemPackCode);
                    personItemsVo.setApplyClass(itemClass);
                    BeanUtils.copyProperties(item, personItemsVo);
                    if("检查".equals(itemClass)){
                        applyNo = pubCommService.findExamNoForItem(hospitalId, itemPackCode);
                        if("非诊疗项目".equals(applyNo)){
                            continue;
                        }
                        if(StringUtils.isEmpty(applyNo)||applyNo.contains("msg")){
                            throw new CommonException(500, "取申请号失败！"+applyNo);
                        }
                        item.setApplyNo(applyNo);
                        personItemsVo.setApplyNo(applyNo);
                        dsItemList.add(personItemsVo);
                    }
                    if("检验".equals(itemClass)){
                        dsItemList.add(personItemsVo);
                        //因为不是直接写到数据库，能采到一管血的项目不能从数据库中提取
                        //因为传值的问题，需要补充信息
                        QueryWrapper<VHcItemPackDict> queryWrapper = new QueryWrapper<>();
                        queryWrapper.eq("hospital_id", hospitalId);
                        queryWrapper.eq("item_pack_code", itemPackCode);
                        VHcItemPackDict vHcItemPackDict = vHcItemPackDictService.getOne(queryWrapper);
                        if (vHcItemPackDict != null){
                            personItemsVo.setSpecimanName(vHcItemPackDict.getSpecimanName());
                            personItemsVo.setTestTubeCode(vHcItemPackDict.getTestTubeCode());
                            personItemsVo.setDrawBlood(vHcItemPackDict.getDrawBlood());
                            personItemsVo.setItemPackName(vHcItemPackDict.getItemPackName());
                        }
                        //List<PersonItemsVo> list = beforeSignInMapper.selectPersonItems(hospitalId,personId,Integer.parseInt(personVisitId));
                        //applyNo = pubCommService.findTestNoForItem(list, hospitalId, itemPackCode);
                        applyNo = pubCommService.findTestNoForItem(dsItemList, hospitalId, itemPackCode);
                        if(StringUtils.isEmpty(applyNo)||applyNo.contains("msg")){
                            throw new CommonException(500, "取申请号失败！"+applyNo);
                        }
                        item.setApplyNo(applyNo);
                        personItemsVo.setApplyNo(applyNo);

                    }
                }
                List<Connection> connList = new ArrayList<>();

                switch (saveModifyPersonItemsVo.getStat()) {
                    case "add"://如果存在，就修改，撤销原来的申请，发送新的申请，没有就新增，发送新的申请
                        for(HcPersonAppregItems item : saveModifyPersonItemsVo.getHcPersonAppregItems()){
                            QueryWrapper<HcPersonAppregItems> queryWrapper = new QueryWrapper<>();
                            queryWrapper.eq("HOSPITAL_ID", item.getHospitalId())
                                    .eq("PERSON_ID", item.getPersonId())
                                    .eq("PERSON_VISIT_ID", item.getPersonVisitId())
                                    .eq("ITEM_PACK_CODE", item.getItemPackCode())
                                    .eq("ITEM_NO", item.getItemNo());
                            if(hcPersonAppregItemsService.getOne(queryWrapper)!=null){
                                UpdateWrapper<HcPersonAppregItems> updateWrapper = new UpdateWrapper<>();
                                updateWrapper.eq("HOSPITAL_ID", item.getHospitalId())
                                        .eq("PERSON_ID", item.getPersonId())
                                        .eq("PERSON_VISIT_ID", item.getPersonVisitId())
                                        .eq("ITEM_PACK_CODE", item.getItemPackCode())
                                        .eq("ITEM_NO", item.getItemNo());
                                hcPersonAppregItemsService.update(item, updateWrapper);
                                //撤销旧申请
                                msg = pubCommService.deleteExamOrLabApply(connList, item, this.findItemClass(hospitalId, item.getItemPackCode()));
                            }else{
                                String orderId = personAppointRegMapper.selectOrderId().toString();
                                item.setOrderId(orderId);
                                hcPersonAppregItemsService.save(item);
                            }
                        }
                        //发送申请
                        String sendExamApply = pubCommService.sendExamApply(connList, dsItemList, userName);
                        if(sendExamApply.length()>0){
                            try {
                                for (Connection conn : connList) {
                                    conn.rollback();
                                }
                                throw new CommonException(500, "发送检查申请失败！"+sendExamApply);
                            }catch (SQLException sqlException){
                                throw new CommonException(500, personId+"检查申请回滚失败！");
                            }
                        }
                        sendExamApply = pubCommService.sendLabApply(connList, dsItemList, userName);
                        if(sendExamApply.length()>0){
                            try {
                                for (Connection conn : connList) {
                                    conn.rollback();
                                }
                                throw new CommonException(500, "发送检验申请失败！"+sendExamApply);
                            }catch (SQLException sqlException){
                                throw new CommonException(500, personId+"检查申请回滚失败！");
                            }
                        }
                        break;
                    case "delete":
                        for(HcPersonAppregItems item : saveModifyPersonItemsVo.getHcPersonAppregItems()){
                            QueryWrapper<HcPersonAppregItems> queryWrapper = new QueryWrapper<>();
                            queryWrapper.eq("HOSPITAL_ID", item.getHospitalId())
                                    .eq("PERSON_ID", item.getPersonId())
                                    .eq("PERSON_VISIT_ID", item.getPersonVisitId())
                                    .eq("ITEM_PACK_CODE", item.getItemPackCode())
                                    .eq("ITEM_NO", item.getItemNo());
                            hcPersonAppregItemsService.remove(queryWrapper);
                            msg = pubCommService.deleteExamOrLabApply(connList, item, this.findItemClass(hospitalId, item.getItemPackCode()));
                        }
                        break;
                }
//                try {
                    if(StringUtils.isNotEmpty(msg)&&msg.length()>0){
//                        for (Connection conn : connList) {
//                            conn.rollback();
//                        }
                    }else {
//                        for (Connection conn : connList) {
//                            conn.commit();
//                        }
                    }
//                }
//                catch (SQLException sqlException){
//                    throw new CommonException(500, personId+"签到提交失败！");
//                }
                break;
            }
        }
        return "";
    }
}
























