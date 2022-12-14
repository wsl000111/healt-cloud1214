package com.healt.cloud.checkup.appointmentReg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.appointmentReg.service.PersionInfoService;
import com.healt.cloud.checkup.appointmentReg.vo.beforeSignIn.*;
import com.healt.cloud.checkup.entity.HcPersonAppregItems;
import com.healt.cloud.checkup.entity.HcPersonInfo;
import com.healt.cloud.checkup.service.HcPersonInfoService;
import com.healt.cloud.checkup.service.pubComm.PubCommService;
import com.healt.cloud.checkup.appointmentReg.mapper.BeforeSignInMapper;
import com.healt.cloud.checkup.appointmentReg.service.BeforeSignInService;
import com.healt.cloud.checkup.entity.HcPersonVisitInfo;
import com.healt.cloud.checkup.service.HcPersonAppregItemsService;
import com.healt.cloud.checkup.service.HcPersonVisitInfoService;
import com.healt.cloud.checkup.service.ws.WebServiceClient;
import com.healt.cloud.checkup.service.ws.his.CreateArchiveResponse;
import com.healt.cloud.checkup.vo.appointmentReg.beforSign.PersonAndVisitVo;
import com.healt.cloud.checkup.vo.appointmentReg.beforSign.PersonByWherePageVo;
import com.healt.cloud.checkup.vo.appointmentReg.personAppointReg.PersonItemsVo;
import com.healt.cloud.checkup.vo.appointmentReg.unitPersons.DtUnitVo;
import com.healt.cloud.common.pages.PageResult;
import com.healt.cloud.common.utils.PropertiesUtils;
import com.healt.cloud.resultex.exception.CommonException;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author linklee
 * @create 2022-04-15 15:42
 */
@Service
@AllArgsConstructor
public class BeforeSignInServiceImpl implements BeforeSignInService {

    private static final String areaCode = PropertiesUtils.AREACODE;

    private static final String medInstCode = PropertiesUtils.MEDINSTCODE;

    private BeforeSignInMapper beforeSignInMapper;

    private PubCommService pubCommService;

    private HcPersonAppregItemsService hcPersonAppregItemsService;

    private HcPersonVisitInfoService hcPersonVisitInfoService;

    private WebServiceClient client;

    private HcPersonInfoService hcPersonInfoService;

    private PersionInfoService persionInfoService;

    @Override
    public List<DtUnitVo> findDtUnit(String hospitalId) {
        List<DtUnitVo> list = beforeSignInMapper.findDtUnit(hospitalId);
        if (list.size() == 0) {
            list.add(new DtUnitVo());
        }
        return list;
    }

    @Override
    public PageResult selectPersonAndVisit(PersonByWherePageVo personByWherePageVo) {
        int pageNum = personByWherePageVo.getPageNum();
        if(pageNum<1){
            pageNum = 1;
        }
        int pageSize = personByWherePageVo.getPageSize();
        String strWhere = "";
        if(StringUtils.isNotEmpty(personByWherePageVo.getHospitalCode())){
            strWhere += " and a.hospital_id = '" + personByWherePageVo.getHospitalCode()+"'";
        }
        if(!"1".equals(personByWherePageVo.getSywbdgl())){
            strWhere += " and (a.before_sign = '0' or a.before_sign is null) ";
        }
        if ("0".equals(personByWherePageVo.getBeforeSign())){
            if(StringUtils.isNotEmpty(personByWherePageVo.getStartDate())&&!"*".equals(personByWherePageVo.getStartDate())){
                strWhere = " and a.appoints_date >= to_date('"+personByWherePageVo.getStartDate()+" 00:00:00','yyyy-mm-dd hh24:mi:ss')";
            }
            if(StringUtils.isNotEmpty(personByWherePageVo.getEndDate())&&!"*".equals(personByWherePageVo.getEndDate())){
                strWhere += " and a.appoints_date <= to_date('"+personByWherePageVo.getEndDate()+" 23:59:59','yyyy-mm-dd  hh24:mi:ss')";
            }
        }else{
            if(StringUtils.isNotEmpty(personByWherePageVo.getStartDate())&&!"*".equals(personByWherePageVo.getStartDate())){
                strWhere = " and a.before_date >= to_date('" + personByWherePageVo.getStartDate() + " 00:00:00','yyyy-mm-dd hh24:mi:ss')";
            }
            if(StringUtils.isNotEmpty(personByWherePageVo.getEndDate())&&!"*".equals(personByWherePageVo.getEndDate())){
                strWhere += " and a.before_date <= to_date('" + personByWherePageVo.getEndDate() + " 23:59:59','yyyy-mm-dd hh24:mi:ss')";
            }
        }
        if(StringUtils.isNotEmpty(personByWherePageVo.getUnitId())){
            strWhere += " and a.unit_id = '" + personByWherePageVo.getUnitId()+"'";
        }
        if(StringUtils.isNotEmpty(personByWherePageVo.getUnitVisitId())){
            strWhere += " and a.unit_visit_id = " + personByWherePageVo.getUnitVisitId();
        }
        if(StringUtils.isNotEmpty(personByWherePageVo.getPersonId())){
            strWhere += " and a.person_id = '" + personByWherePageVo.getPersonId()+"'";
        }
//        if(StringUtils.isNotEmpty(personByWherePageVo.getPersonVisitId())){
//            strWhere += " and a.person_visit_id = '" + personByWherePageVo.getPersonVisitId()+"'";
//        }
        List<PersonAndVisitVo> list = beforeSignInMapper.selectPersonAndVisit(pageNum, pageSize, strWhere);
        if (list.size() == 0) {
            list.add(new PersonAndVisitVo());
        }
        long totalSize = this.selectPersonAndVisitTotal(strWhere);
        long totalPages = totalSize%pageSize == 0 ? totalSize/pageSize : totalSize/pageSize+1;
        PageResult pageResult = new PageResult(pageNum, pageSize, totalSize, totalPages, list);
        return pageResult;
    }

    @Override
    public PageResult<PersonAndVisitVo> selectPersonAndVisitPrintNullNoPage(PersonByWherePageVo personByWherePageVo){
        List<PersonAndVisitVo> list = beforeSignInMapper.selectPersonAndVisitPrintNullNoPage(personByWherePageVo.getStartDate(), personByWherePageVo.getEndDate());
        if (list.size() == 0) {
            list.add(new PersonAndVisitVo());
        }
        PageResult pageResult = new PageResult(1, list.size(), list.size(), 1, list);
        return pageResult;
    }

    @Override
    public List<PersonItemsVo> selectPersonItemsNew(String hospitalId, String personId, Integer personVisitId) {
        List<PersonItemsVo> list = beforeSignInMapper.selectPersonItemsNew(hospitalId,personId,personVisitId);
        if (list.size() == 0) {
            list.add(new PersonItemsVo());
        }
        return list;
    }

    @Override
    public PageResult selectPersonAndVisitPrintNotNullNoPage(PersonByWherePageVo personByWherePageVo) {
        List<PersonAndVisitVo> list = beforeSignInMapper.selectPersonAndVisitPrintNotNullNoPage(personByWherePageVo.getStartDate(), personByWherePageVo.getEndDate());
        if (list.size() == 0) {
            list.add(new PersonAndVisitVo());
        }
        PageResult pageResult = new PageResult(1, list.size(), list.size(), 1, list);
        return pageResult;
    }

    @Override
    public PageResult selectPersonAndVisitPrintNUll(PersonByWherePageVo personByWherePageVo) {
        int pageNum = personByWherePageVo.getPageNum();
        if(pageNum<1){
            pageNum = 1;
        }
        int pageSize = personByWherePageVo.getPageSize();

        List<PersonAndVisitVo> list = beforeSignInMapper.selectPersonAndVisitPrintNull(pageNum, pageSize, personByWherePageVo.getStartDate(), personByWherePageVo.getEndDate());
        if (list.size() == 0) {
            list.add(new PersonAndVisitVo());
        }
        long totalSize = beforeSignInMapper.selectPersonAndVisitPrintNullTotal(personByWherePageVo.getStartDate(), personByWherePageVo.getEndDate());
        long totalPages = totalSize%pageSize == 0 ? totalSize/pageSize : totalSize/pageSize+1;
        PageResult pageResult = new PageResult(pageNum, pageSize, totalSize, totalPages, list);
        return pageResult;
    }

    @Override
    public PageResult selectPersonAndVisitPrintNotNull(PersonByWherePageVo personByWherePageVo) {
        int pageNum = personByWherePageVo.getPageNum();
        if(pageNum<1){
            pageNum = 1;
        }
        int pageSize = personByWherePageVo.getPageSize();

        List<PersonAndVisitVo> list = beforeSignInMapper.selectPersonAndVisitPrintNotNull(pageNum, pageSize, personByWherePageVo.getStartDate(), personByWherePageVo.getEndDate());
        if (list.size() == 0) {
            list.add(new PersonAndVisitVo());
        }
        long totalSize = beforeSignInMapper.selectPersonAndVisitPrintNotNullTotal(personByWherePageVo.getStartDate(), personByWherePageVo.getEndDate());
        long totalPages = totalSize%pageSize == 0 ? totalSize/pageSize : totalSize/pageSize+1;
        PageResult pageResult = new PageResult(pageNum, pageSize, totalSize, totalPages, list);
        return pageResult;
    }

    private long selectPersonAndVisitTotal(String strWhere){
        long totalSize = beforeSignInMapper.selectPersonAndVisitTotal(strWhere);
        return totalSize;
    }

    @Override
    public List<PersonItemsVo> selectPersonItems(String hospitalId, String personId, Integer personVisitId) {
        List<PersonItemsVo> list = beforeSignInMapper.selectPersonItems(hospitalId,personId,personVisitId);
        if (list.size() == 0) {
            list.add(new PersonItemsVo());
        }
        return list;
    }

    @Override
    public void updateSubmitApplyNo(String applyNo,String itemPackCode, String hospitalId, String personId, Integer personVisitId, Integer itemNo) {
        beforeSignInMapper.updateSubmitApplyNo(applyNo,itemPackCode,hospitalId,personId,personVisitId,itemNo);
    }

    @Override
    public void updatePersonVisitInfo(String beforeId, String beforeName, String hospitalId, String personId, Integer personVisitId) {
        beforeSignInMapper.updatePersonVisitInfo(beforeId,beforeName,hospitalId,personId,personVisitId);
    }

    @Override
    public List<String> selectFinishedItemPackName(String hospitalId, String personId, Integer personVisitId) {
        List<String> list = beforeSignInMapper.selectFinishedItemPackName(hospitalId,personId,personVisitId);
        return list;
    }

    @Override
    public void updateBeforeSign(String hospitalId, String personId, Integer personVisitId) {
        //查询所有体检项目
        LambdaQueryWrapper<HcPersonAppregItems> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(HcPersonAppregItems::getPersonId, personId);
        queryWrapper.eq(HcPersonAppregItems::getPersonVisitId, personVisitId);
        List<HcPersonAppregItems> list = hcPersonAppregItemsService.list(queryWrapper);
        //判断项目是否已经有完成的
        list.stream().filter(hcPersonAppregItems -> hcPersonAppregItems.getFinishedSign().equals("完成")).collect(Collectors.toList());
        for(HcPersonAppregItems item : list){
            //查询项目体检类别
        }

        //beforeSignInMapper.updateBeforeSign(hospitalId,personId,personVisitId);
    }

    @Override
    public String beforeSignIn(SaveBeforeSignInListVo saveBeforeSignInListVo) {

        List<UpdateHcPersonVistInfoVo> updateHcPersonVistInfoVos = saveBeforeSignInListVo.getUpdateHcPersonVistInfo();
        String errPersonList = "";
        for(UpdateHcPersonVistInfoVo updateHcPersonVistInfoVo : updateHcPersonVistInfoVos){
            //判断是否建档
            QueryWrapper<HcPersonInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("person_id", updateHcPersonVistInfoVo.getPersonId());
            queryWrapper.eq("hospital_id", updateHcPersonVistInfoVo.getHospitalId());
            HcPersonInfo hcPersonInfo = hcPersonInfoService.getOne(queryWrapper);
            //如果平台id为null说明还没有和平台id绑定
            if(StringUtils.isEmpty(hcPersonInfo.getPatientId())){
                String result = client.findPersonInfoWS(medInstCode, areaCode, hcPersonInfo.getIdNo(), hcPersonInfo.getName(), "savePersonVisitInfo");
                String patientId = "";
                if(!"0".equals(result)){//平台已经建档
                    patientId = result;
                }else{//平台没有建档，建档获取personId
                    CreateArchiveResponse createArchiveResponse = persionInfoService.archiveCreate(hcPersonInfo, "saveHcPersonVisitInfoList");
                    patientId = createArchiveResponse.getPatientInfo().getPatientId();
                }
                hcPersonInfo.setPatientId(patientId);
                UpdateWrapper<HcPersonInfo> hcPersonInfoUpdateWrapper = new UpdateWrapper<>();
                hcPersonInfoUpdateWrapper.set("patient_id", patientId);
                hcPersonInfoUpdateWrapper.eq("hospital_id", hcPersonInfo.getHospitalId());
                hcPersonInfoUpdateWrapper.eq("person_id", hcPersonInfo.getPersonId());
                hcPersonInfoService.update(hcPersonInfoUpdateWrapper);

                LambdaUpdateWrapper<HcPersonVisitInfo> hcPersonVisitInfoUpdateWrapper1 = new LambdaUpdateWrapper<>();
                hcPersonVisitInfoUpdateWrapper1.set(HcPersonVisitInfo::getPatientId, hcPersonInfo.getPatientId());
                hcPersonVisitInfoUpdateWrapper1.eq(HcPersonVisitInfo::getPersonId, hcPersonInfo.getPersonId());
                hcPersonVisitInfoService.update(hcPersonVisitInfoUpdateWrapper1);
            }


            //List<UpdateHcPersonAppregItemsVo> updateHcPersonAppregItems = updateHcPersonVistInfoVo.getUpdateHcPersonAppregItems();
            //查询人员所有预约项目
            List<PersonItemsVo> personItemsVos = this.selectPersonItems(updateHcPersonVistInfoVo.getHospitalId(),
                    updateHcPersonVistInfoVo.getPersonId(), Integer.parseInt(updateHcPersonVistInfoVo.getPersonVisitId()));

            //循环体检人的所有组合项目生成申请号
            for(PersonItemsVo updateHcPersonAppregItemsVo : personItemsVos){
                //判断申请号，如果为空生成
                String applyNo = updateHcPersonAppregItemsVo.getApplyNo();
                if(StringUtils.isNotEmpty(applyNo)){
                    continue;
                }
                String applySendto = updateHcPersonAppregItemsVo.getApplySendto();
                if (StringUtils.isEmpty(applySendto)||"0000".equals(applySendto)){
                    continue;//不需要发往
                }
                String itemPackCode = updateHcPersonAppregItemsVo.getItemPackCode();
                //取类别判断
                String itemClass = updateHcPersonAppregItemsVo.getApplyClass();
                if ("检查".equals(itemClass)){
                    applyNo = pubCommService.findExamNoForItem(updateHcPersonVistInfoVo.getHospitalId(), itemPackCode);
                    if("非诊疗项目".equals(applyNo)){
                        continue;
                    }
                    if(StringUtils.isEmpty(applyNo)){
                        throw new CommonException(500, "取检查申请号失败！"+itemPackCode);
                    }
                    updateHcPersonAppregItemsVo.setApplyNo(applyNo);
                }
                if ("检验".equals(itemClass)){
                    //因为不是直接写到数据库，能采到一管血的项目不能从数据库中提取
                    applyNo = pubCommService.findTestNoForItem(personItemsVos, updateHcPersonVistInfoVo.getHospitalId(), itemPackCode);
                    if("非诊疗项目".equals(applyNo)){
                        continue;
                    }
                    if(StringUtils.isEmpty(applyNo)){
                        throw new CommonException(500, "取检验申请号失败！"+itemPackCode);
                    }
                    updateHcPersonAppregItemsVo.setApplyNo(applyNo);
                }
            }
            //发送申请220705000105

            List<Connection> connList = new ArrayList<>();
//            try {
//                //手动提交事务
//                for (Connection conn : connList) {
//                    conn.setAutoCommit(false);
//                }
//            } catch (SQLException sqlException){
//                throw new CommonException(500, "获取数据源失败！");
//            }
            String personId = updateHcPersonVistInfoVo.getPersonId();
            String visitId = updateHcPersonVistInfoVo.getPersonVisitId();
            String sendExamApply = pubCommService.sendExamApply(connList, personItemsVos, updateHcPersonVistInfoVo.getUserName());
            if(sendExamApply.length()>0){
//                try {
//                    for (Connection conn : connList) {
//                        conn.rollback();
//                    }
//                }catch (SQLException sqlException){
//                    throw new CommonException(500, personId+"检查申请回滚失败！");
//                }
                errPersonList += "id:"+personId + ",err:"+ sendExamApply + ",name:" +updateHcPersonVistInfoVo.getName() + "\\r\\n";
                continue;
            }
            String sendLabApply = pubCommService.sendLabApply(connList, personItemsVos, updateHcPersonVistInfoVo.getUserName());
            if(sendLabApply.length()>0){
                try {
                    for (Connection conn : connList) {
                        conn.rollback();
                    }
                }catch (SQLException sqlException){
                    throw new CommonException(500, personId+"检验申请回滚失败！");
                }
                errPersonList += "id:"+personId + ",err:"+ sendLabApply + ",name:" +updateHcPersonVistInfoVo.getName() + "\\r\\n";
                continue;
            }
            //更新项目发送标志语句
            List<PersonItemsVo> updatePersonItemsVos = personItemsVos.stream().filter(personItemsVo -> personItemsVo.getSubmitApply() == "1").collect(Collectors.toList());
            boolean success = true;
            for(PersonItemsVo personItemsVo : updatePersonItemsVos){
                String itemPackCode = personItemsVo.getItemPackCode();
                String applyNo = personItemsVo.getApplyNo();
                int itemNo = personItemsVo.getItemNo();
                UpdateWrapper<HcPersonAppregItems> updateWrapper = new UpdateWrapper<>();
                updateWrapper
                        .set("apply_no", applyNo)
                        .set("submit_apply", "1");
                updateWrapper.eq("item_pack_code", itemPackCode);
                updateWrapper.eq("person_id", personId);
                updateWrapper.eq("person_visit_id", visitId);
                updateWrapper.eq("hospital_id", personItemsVo.getHospitalId());
                updateWrapper.eq("item_no", personItemsVo.getItemNo());


                if(!hcPersonAppregItemsService.update(updateWrapper)){
                    success = false;
                    errPersonList += "更新" + personId + "项目：" + itemPackCode + "申请标志失败！" + "\\r\\n";
                    break;
                }
            }
            if(success){
                //修改个人体检预约状态
                UpdateWrapper<HcPersonVisitInfo> hcPersonVisitInfoUpdateWrapper = new UpdateWrapper<>();
                hcPersonVisitInfoUpdateWrapper
                        .set("before_date", new Date())
                        .set("before_sign", "1")
                        .set("before_id", updateHcPersonVistInfoVo.getUserName())
                        .set("before_name", updateHcPersonVistInfoVo.getUserRealName());
                hcPersonVisitInfoUpdateWrapper.eq("person_id", updateHcPersonVistInfoVo.getPersonId());
                hcPersonVisitInfoUpdateWrapper.eq("person_visit_id", updateHcPersonVistInfoVo.getPersonVisitId());
                hcPersonVisitInfoUpdateWrapper.eq("hospital_id", updateHcPersonVistInfoVo.getHospitalId());
                if(!hcPersonVisitInfoService.update(hcPersonVisitInfoUpdateWrapper)){
                    errPersonList += "更新" + personId + "签到表失败！" + "\\r\\n";
                }
            }else{
                errPersonList += personId+":"+updateHcPersonVistInfoVo.getName() + "签到失败！" + "\\r\\n";
            }
//            if (fail){
//                try {
//                    for (Connection conn : connList) {
//                        conn.rollback();
//                    }
//                }catch (SQLException sqlException){
//                    throw new CommonException(500, personId+"签到回滚失败！");
//                }
//            }else {
//                try {
//                    for (Connection conn : connList) {
//                        conn.commit();
//                    }
//                }catch (SQLException sqlException){
//                    throw new CommonException(500, personId+"签到提交失败！");
//                }
//            }
        }
        if(errPersonList.length()>0){
            throw new CommonException(10005, errPersonList);
        }
        return "";
    }

    @Override
    //@Transactional
    public String cancelBeforeSign(CancelBeforeSignListVo cancelBeforeSignListVo) {
        List<CancelBeforeSignVo> list = cancelBeforeSignListVo.getCancelBeforeSignList();
        if(list.size()==0){
            return "请选择体检人";
        }
        //String msg = "已有完成项目不能取消报到！";
        String msg = "";
        String err = "";
        QueryWrapper<HcPersonAppregItems> queryWrapper = new QueryWrapper<>();
        UpdateWrapper<HcPersonVisitInfo> updateWrapper = new UpdateWrapper<>();
        for(CancelBeforeSignVo cancelBeforeSignVo : list){
            //判断是否已经签到
            LambdaQueryWrapper<HcPersonVisitInfo> hcPersonVisitInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
            hcPersonVisitInfoLambdaQueryWrapper.eq(HcPersonVisitInfo::getPersonId, cancelBeforeSignVo.getPersonId());
            hcPersonVisitInfoLambdaQueryWrapper.eq(HcPersonVisitInfo::getPersonVisitId, cancelBeforeSignVo.getVisitId());
            HcPersonVisitInfo hcPersonVisitInfo = hcPersonVisitInfoService.getOne(hcPersonVisitInfoLambdaQueryWrapper);
            //没有签到，删除预约信息
            if("0".equals(hcPersonVisitInfo.getBeforeSign())){
                //删除hcPersonAppregItems
                LambdaQueryWrapper<HcPersonAppregItems> hcPersonAppregItemsLambdaQueryWrapper = new LambdaQueryWrapper<>();
                hcPersonAppregItemsLambdaQueryWrapper.eq(HcPersonAppregItems::getPersonId, hcPersonVisitInfo.getPersonId());
                hcPersonAppregItemsLambdaQueryWrapper.eq(HcPersonAppregItems::getPersonVisitId, hcPersonVisitInfo.getPersonVisitId());
                hcPersonAppregItemsService.remove(hcPersonAppregItemsLambdaQueryWrapper);
                //删除hcPersonVisitInfo
                LambdaQueryWrapper<HcPersonVisitInfo> hcPersonVisitInfoLambdaQueryWrapper1 = new LambdaQueryWrapper<>();
                hcPersonVisitInfoLambdaQueryWrapper1.eq(HcPersonVisitInfo::getPersonId, hcPersonVisitInfo.getPersonId());
                hcPersonVisitInfoLambdaQueryWrapper1.eq(HcPersonVisitInfo::getPersonVisitId, hcPersonVisitInfo.getPersonVisitId());
                hcPersonVisitInfoService.remove(hcPersonVisitInfoLambdaQueryWrapper1);
                continue;
            }
            //已经签到
            //查询是否有已经完成的项目
            queryWrapper.clear();
            queryWrapper.eq("hospital_id", cancelBeforeSignVo.getHospitalId())
                    .eq("person_id", cancelBeforeSignVo.getPersonId())
                    .eq("person_visit_id", cancelBeforeSignVo.getVisitId())
                    .eq("finished_sign", "完成");
            long count = hcPersonAppregItemsService.count(queryWrapper);
            //有已经完成的项目，不能取消签到
            if(count > 0){
                err +=  cancelBeforeSignVo.getName() + "[" + cancelBeforeSignVo.getPersonId() + "]已有完成项目！, ";
                continue;
            }
            //判断是否已经收费，已经收费不能取消签到
            queryWrapper.clear();
            queryWrapper.eq("hospital_id", cancelBeforeSignVo.getHospitalId())
                    .eq("person_id", cancelBeforeSignVo.getPersonId())
                    .eq("person_visit_id", cancelBeforeSignVo.getVisitId())
                    .eq("BILL_INDICATOR", "1");
            count = hcPersonAppregItemsService.count(queryWrapper);
            if(count > 0){
                err +=  cancelBeforeSignVo.getName() + "[" + cancelBeforeSignVo.getPersonId() + "]已缴费！, ";
                continue;
            }
            updateWrapper.clear();
            updateWrapper.set("before_date" ,"")
                    .set("before_sign", "0")
                    .set("before_id", "")
                    .set("before_name", "")
                    .eq("hospital_id", cancelBeforeSignVo.getHospitalId())
                    .eq("person_id", cancelBeforeSignVo.getPersonId())
                    .eq("person_visit_id", cancelBeforeSignVo.getVisitId());
            //boolean suc = hcPersonVisitInfoService.update(updateWrapper);
            boolean suc = true;
            if(!suc){
                err += "更新" + cancelBeforeSignVo.getPersonId() + "签到表失败！,";
            }
            //查询所有推送项目，发送撤销申请

        }
        if(err.length() == 0){
            msg = "取消完成";
        }else{
            msg = err;
        }
        return msg;
    }

    @Override
    public List<XRGuidanceSheetVo> xRGuidanceSheet(String hospitalId, String personId, String personVisitId) {
        List<XRGuidanceSheetVo> list = beforeSignInMapper.xRGuidanceSheet(hospitalId, personId, personVisitId);
        if(list.size() == 0){
            list.add(new XRGuidanceSheetVo());
        }
        return list;
    }


}
