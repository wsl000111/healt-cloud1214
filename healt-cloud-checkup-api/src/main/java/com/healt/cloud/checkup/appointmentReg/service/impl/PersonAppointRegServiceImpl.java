package com.healt.cloud.checkup.appointmentReg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.healt.cloud.checkup.entity.*;
import com.healt.cloud.checkup.appointmentReg.service.PersionInfoService;
import com.healt.cloud.checkup.appointmentReg.vo.mobile.PersonAppointVo;
import com.healt.cloud.checkup.appointmentReg.vo.mobile.SavePersonAppointVo;
import com.healt.cloud.checkup.service.*;
import com.healt.cloud.checkup.vo.appointmentReg.personAppointReg.*;
import com.healt.cloud.checkup.appointmentReg.mapper.PersonAppointRegMapper;
import com.healt.cloud.checkup.service.ws.WebServiceClient;
import com.healt.cloud.checkup.service.ws.his.CreateArchiveResponse;
import com.healt.cloud.checkup.appointmentReg.service.PersonAppointRegService;
import com.healt.cloud.checkup.vo.appointmentReg.personAppointReg.vo.SaveHcPersonVisitInfoListVo;
import com.healt.cloud.checkup.vo.appointmentReg.personAppointReg.vo.SaveHcPersonVisitInfoVo;
import com.healt.cloud.common.pages.PageResult;
import com.healt.cloud.common.utils.PropertiesUtils;
import com.healt.cloud.resultex.exception.CommonException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author linklee
 * @create 2022-03-29 17:42
 */
@Service
public class PersonAppointRegServiceImpl implements PersonAppointRegService{

    private String isHis = PropertiesUtils.ISHIS;

    private String areaCode = PropertiesUtils.AREACODE;

    private String medInstCode = PropertiesUtils.MEDINSTCODE;

    @Autowired
    private PersonAppointRegMapper personAppointRegMapper;

    @Autowired
    private HcPersonVisitInfoService hcPersonVisitInfoService;

    @Autowired
    private HcPersonAppregItemsService hcPersonAppregItemsService;

//    @Autowired
//    private HcPersonVisitInfoMapper hcPersonVisitInfoMapper;

    @Autowired
    private ItemPackClassDictService itemPackClassDictService;

    @Autowired
    private HcPackSetDictService hcPackSetDictService;

    @Autowired
    private HcItemPackDictService hcItemPackDictService;

    @Autowired
    private PersionInfoService persionInfoService;

    @Autowired
    private WebServiceClient client;

    @Autowired
    private HcPersonInfoService hcPersonInfoService;


    @Override
    public List<PackSetDictVo> findPackSetDict(String hospitalId) {
        List<PackSetDictVo> list = personAppointRegMapper.findPackSetDict(hospitalId);
        if(list.size() == 0){
            list.add(new PackSetDictVo());
        }
        return list;
    }

    @Override
    public List<PackItemDictVo> findPackItemDict(String hospitalId) {
        List<PackItemDictVo> list = personAppointRegMapper.findPackItemDict(hospitalId);
        if(list.size() == 0){
            list.add(new PackItemDictVo());
        }
        return list;
    }

    @Override
    public List<SetItemListVo> findSetItemList(String hospitalId, String setCode) {
        List<SetItemListVo> list = personAppointRegMapper.findSetItemList(hospitalId,setCode);
        if(list.size() == 0){
            list.add(new SetItemListVo());
        }
        return list;
    }

    @Override
    public List<SelectedItemsVo> findSelectedItems(String hospitalId, String personId, Integer personVisitId) {
        List<SelectedItemsVo> list = personAppointRegMapper.findSelectedItems(hospitalId,personId,personVisitId);
        if(list.size() == 0){
            list.add(new SelectedItemsVo());
        }
        return list;
    }

    @Override
    public List<UnitListVo> findUnitList(String hospitalId) {
        List<UnitListVo> list = personAppointRegMapper.findUnitList(hospitalId);
        if(list.size() == 0){
            list.add(new UnitListVo());
        }
        return list;
    }

    @Override
    public List<UnitGroupVo> findUnitGroup(String hospitalId, String unitId) {
        List<UnitVisitInfoVo> list = personAppointRegMapper.findUnitVisitInfo(hospitalId,unitId);
        if(list.size() == 0){
            throw new CommonException(20001,"此单位还没有预约！");
        } else {
            UnitVisitInfoVo unitVisitInfoVo = list.get(0);
            if (unitVisitInfoVo.getFinishedSign().equals("1")) {
                throw new CommonException(20002,"此单位已体检完成！");
            } else {
                return personAppointRegMapper.findUnitGroup(hospitalId,unitId,unitVisitInfoVo.getUnitVisitId());
            }
        }
    }

//    @Override
//    public List<PersonInfoVo> finishedSignFlag(String hospitalId, String personId) {
//        //取体检次数信息
//        List<PersonVisitInfoVo> list = personAppointRegMapper.finishedSignInfo(hospitalId,personId);
//        //创建空的个人基本信息集合
//        List<PersonInfoVo> listInfo = new LinkedList<>();
//        //根据hospital_id和person_id，得到PersonVisitInfo
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.eq("hospital_id",hospitalId);
//        wrapper.eq("person_id",personId);
//        HcPersonVisitInfo pvInfo = hcPersonVisitInfoMapper.selectOne(wrapper);
//        //个人访问次数
//        Integer pvId =pvInfo.getPersonVisitId();
//
//        // 判断体检次数信息是否为空
//        if(list.size() == 0){
//            //为空则将PersonVisitId置为1
//            pvInfo.setPersonVisitId(1);
//            hcPersonVisitInfoMapper.update(pvInfo,wrapper);
//            //返回个人基本信息
//            listInfo = personAppointRegMapper.findPersonInfo(hospitalId,personId);
//            return listInfo;
//        }else {//非空,取出list里面值
//            PersonVisitInfoVo personVisitInfoVo = list.get(0);
//
//            //当finished_sign标志为0
//            if (personVisitInfoVo.getFinishedSign().equals("0")) {
//                //personAppointRegMapper.finishedSignFlag(hospitalId,personId,personVisitInfoVo.getPersonVisitId());
//                //更改finished_sign标志为1，person_visit_id加1
//                pvInfo.setFinishedSign("1");
//                pvInfo.setPersonVisitId(pvId+1);
//                hcPersonVisitInfoMapper.update(pvInfo,wrapper);
//                throw new CommonException(20003,"此人最后一次体检未完成,已改为完成！");
//            } else {//当finished_sign标志为1，则person_visit_id加1
//                pvInfo.setPersonVisitId(pvId+1);
//                hcPersonVisitInfoMapper.update(pvInfo,wrapper);
//                throw new CommonException(20004,"此人最后一次体检已完成！");
//            }
//            //返回空值
//            //listInfo.add(new PersonInfoVo());
//            //return listInfo;
//        }
//    }

    @Override
    public List<PersonVisitInfoVo> findPersonVisitInfo(String hospitalId, String personId) {
        List<PersonVisitInfoVo> list = personAppointRegMapper.findPersonVisitInfo(hospitalId,personId);
        if(list.size() == 0){
            list.add(new PersonVisitInfoVo());
        }
        return list;
    }

    @Override
    public List<PersonInfoVo> findPersonInfo(String hospitalId, String personId) {
        List<PersonInfoVo> list = personAppointRegMapper.findPersonInfo(hospitalId,personId);
        if(list.size() == 0){
            list.add(new PersonInfoVo());
        }
        return list;
    }

    @Override
    public void updateFinishedSign(String hospitalId, String personId, Integer personVisitId) {
        personAppointRegMapper.updateFinishedSign(hospitalId,personId,personVisitId);
    }

    @Override
    public List<UnitGroupListVo> findItemsByGroup(String hospitalId, String groupCode, String unitId, Integer unitVisitId) {
        List<UnitGroupListVo> list = personAppointRegMapper.findUnitGroupList(hospitalId,groupCode,unitId,unitVisitId);
        if(list.size() == 0){
            list.add(new UnitGroupListVo());
        }
        return list;
    }
    @Autowired
    private HcUnitInfoService hcUnitInfoService;

    @Override
    @Transactional
    public void savePersonVisitInfo(SaveHcPersonVisitInfoListVo saveHcPersonVisitInfoList) {
        for (SaveHcPersonVisitInfoVo saveHcPersonVisitInfoVo : saveHcPersonVisitInfoList.getHcPersonVisitInfoVo()) {
            switch (saveHcPersonVisitInfoVo.getStat()) {
                case "delete" :
                    for (HcPersonVisitInfo hcPersonVisitInfo : saveHcPersonVisitInfoVo.getHcPersonVisitInfo()) {
                        QueryWrapper<HcPersonVisitInfo> queryWrapper = new QueryWrapper<HcPersonVisitInfo>(hcPersonVisitInfo);
                        hcPersonVisitInfoService.remove(queryWrapper);
                    }
                    for (HcPersonAppregItems hcPersonAppregItems : saveHcPersonVisitInfoVo.getHcPersonAppregItems()) {
                        QueryWrapper<HcPersonAppregItems> queryWrapper = new QueryWrapper<HcPersonAppregItems>(hcPersonAppregItems);
                        hcPersonAppregItemsService.remove(queryWrapper);
                    }
                    break;
                case "add":
                    //查询HIS是否建档, 没建档进行建档，然后绑定patientId
                    for(HcPersonVisitInfo hcPersonVisitInfo : saveHcPersonVisitInfoVo.getHcPersonVisitInfo()){
                        QueryWrapper<HcPersonInfo> queryWrapper = new QueryWrapper<>();
                        queryWrapper.eq("person_id", hcPersonVisitInfo.getPersonId());
                        queryWrapper.eq("hospital_id", hcPersonVisitInfo.getHospitalId());
                        HcPersonInfo hcPersonInfo = hcPersonInfoService.getOne(queryWrapper);
                        //如果平台id为null说明还没有和平台id绑定
                        String patientId = hcPersonInfo.getPatientId();
                        if(StringUtils.isEmpty(patientId)){
                            String result = client.findPersonInfoWS(medInstCode, areaCode, hcPersonInfo.getIdNo(), hcPersonInfo.getName(), "savePersonVisitInfo");
                            if(!"0".equals(result)){//已经建档
                                patientId = result;
                            }else{//建档获取personId
                                CreateArchiveResponse createArchiveResponse = persionInfoService.archiveCreate(hcPersonInfo, "saveHcPersonVisitInfoList");
                                patientId = createArchiveResponse.getPatientInfo().getPatientId();
                            }
                            hcPersonInfo.setPatientId(patientId);
                            UpdateWrapper<HcPersonInfo> updateWrapper = new UpdateWrapper<>();
                            updateWrapper.set("patient_id", patientId);
                            updateWrapper.eq("hospital_id", hcPersonInfo.getHospitalId());
                            updateWrapper.eq("person_id", hcPersonInfo.getPersonId());
                            hcPersonInfoService.update(updateWrapper);
                        }
                        if(StringUtils.isEmpty(hcPersonVisitInfo.getUnitName())){
                            LambdaQueryWrapper<HcUnitInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                            if(StringUtils.isNotEmpty(hcPersonVisitInfo.getUnitId())){
                                lambdaQueryWrapper.eq(HcUnitInfo::getUnitId, hcPersonVisitInfo.getUnitId());
                                List<HcUnitInfo> list = hcUnitInfoService.list(lambdaQueryWrapper);
                                if(list.size()>0){
                                    hcPersonVisitInfo.setUnitName(list.get(0).getUnitName());
                                }
                            }
                        }
                        hcPersonVisitInfo.setPatientId(patientId);
                    }
                    for(HcPersonAppregItems hcPersonAppregItems : saveHcPersonVisitInfoVo.getHcPersonAppregItems()){
                        //生成唯一order_id
                        String orderId = personAppointRegMapper.selectOrderId().toString();
                        hcPersonAppregItems.setOrderId(orderId);
                    }
                    hcPersonVisitInfoService.saveBatch(saveHcPersonVisitInfoVo.getHcPersonVisitInfo());
                    hcPersonAppregItemsService.saveBatch(saveHcPersonVisitInfoVo.getHcPersonAppregItems());
                    break;
                case "update":
                    if (saveHcPersonVisitInfoVo.getHcPersonVisitInfo().size() != 0) {
                        for (HcPersonVisitInfo hcPersonVisitInfo : saveHcPersonVisitInfoVo.getHcPersonVisitInfo()) {
                            UpdateWrapper<HcPersonVisitInfo> updateWrapper = new UpdateWrapper<HcPersonVisitInfo>(hcPersonVisitInfo);
                            hcPersonVisitInfoService.update(hcPersonVisitInfo,updateWrapper);
                        }
                        for (HcPersonAppregItems hcPersonAppregItems : saveHcPersonVisitInfoVo.getHcPersonAppregItems()) {
                            UpdateWrapper<HcPersonAppregItems> updateWrapper = new UpdateWrapper<HcPersonAppregItems>(hcPersonAppregItems);
                            hcPersonAppregItemsService.update(hcPersonAppregItems,updateWrapper);
                        }
                    }
                    break;
            }
        }

    }

    @Override
    public void updateApplyNoPrint(String hospitalId, String applyNo) {
        personAppointRegMapper.updateApplyNoPrint(hospitalId,applyNo);
        //select a.PRINT_DATETIME,a.print_oper  from hcLAB_TEST_MASTER a where test_no = applyNo ;
        personAppointRegMapper.updatePrint(applyNo);
    }

    @Override
    public List<ItemPackClassDict> findItemPackClassList(String hospitalId) {
        QueryWrapper<ItemPackClassDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("HOSPITAL_ID", hospitalId)
                .orderByAsc("SORT_NO");
        return itemPackClassDictService.list(queryWrapper);
    }

    @Override
    public PageResult findPackSetDictPage(PersonAppointVo personAppointVo) {
        QueryWrapper<HcPackSetDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hospital_id", personAppointVo.getHospitalId());
        queryWrapper.eq("EFFECTIVE_FLAG", "1");
        queryWrapper.orderByAsc("ITEM_NO");
        IPage<HcPackSetDict> page = new Page<>();
        page.setSize(personAppointVo.getPageSize());
        page.setCurrent(personAppointVo.getPageNum());
        page = hcPackSetDictService.page(page, queryWrapper);
        return new PageResult(page.getCurrent(),page.getSize(),page.getTotal(), page.getPages(), page.getRecords());
    }

    @Override
    public PageResult loadPackItemListPage(PersonAppointVo personAppointVo) {
        QueryWrapper<HcItemPackDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hospital_id", personAppointVo.getHospitalId());
        queryWrapper.eq("pack_class", personAppointVo.getClassCode());
        queryWrapper.eq("EFFECTIVE_FLAG", "1");
        IPage<HcItemPackDict> page = new Page<>();
        page.setSize(personAppointVo.getPageSize());
        page.setCurrent(personAppointVo.getPageNum());
        page = hcItemPackDictService.page(page, queryWrapper);
        return new PageResult(page.getCurrent(),page.getSize(),page.getTotal(), page.getPages(), page.getRecords());
    }

    @Override
    public List<SetItemListVo> findSetItemListWeb(String hospitalId, String setCode) {
        List<SetItemListVo> list = personAppointRegMapper.findSetItemList(hospitalId,setCode);
        return list;
    }

    @Override
    public String savePersonAppoint(SavePersonAppointVo savePersonAppointVo) {
        HcPersonInfo hcPersonInfo = savePersonAppointVo.getHcPersonInfo();
        List<HcPersonAppregItems> hcPersonAppregItemsList = savePersonAppointVo.getHcPersonAppregItemsList();
        //校验体检人是否存在，存在查询最大体检次数，不存在，先建档
        //根据身份证号和电话查询体积人信息
        hcPersonInfo = persionInfoService.findPersonInfoWeb(hcPersonInfo);
        //查询最大体检号

        return null;
    }
}
