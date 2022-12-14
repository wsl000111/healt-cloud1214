package com.healt.cloud.checkup.frmDivDocDepart.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.*;
import com.healt.cloud.checkup.frmDivDocDepart.vo.*;
import com.healt.cloud.checkup.service.*;
import com.healt.cloud.checkup.service.pubComm.PubCommService;
import com.healt.cloud.checkup.vo.ReturnData;
import com.healt.cloud.checkup.frmDivDocDepart.mapper.DivDocDepartMapper;
import com.healt.cloud.checkup.frmDivDocDepart.service.DivDocDepartServer;
import com.healt.cloud.common.pages.PageResult;
import com.healt.cloud.common.utils.DruidUtils;
import com.healt.cloud.resultex.exception.CommonException;
import lombok.AllArgsConstructor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author GuYue
 * @date 2022-05-22 21:34
 * @description: TODO
 */
@Service
@AllArgsConstructor
public class DivDocDepartServerImpl implements DivDocDepartServer {

    private DivDocDepartMapper divDocDepartMapper;

    private HcPersonAppregItemsService hcPersonAppregItemsService;

    private HcDeptResultItemsService hcDeptResultItemsService;

    private HcDeptResultDictService hcDeptResultDictService;

    private InterfaceSourceService interfaceSourceService;

    private HcPersonVisitInfoService hcPersonVisitInfoService;

    private VLabTestMasterService vLabTestMasterService;

    private HcResultDictService hcResultDictService;

    private VHcItemPackDictService vHcItemPackDictService;

    private PubCommService pubCommService;

    private VExamMasterService vExamMasterService;

    private VExamReportService vExamReportService;

    private HcExamMasterService hcExamMasterService;

    private HcExamReportService hcExamReportService;

    @Override
    public List<ValidateRightVo> validateRight(String hospitalId, String userId) {
        List<ValidateRightVo> dt = divDocDepartMapper.validateRight(hospitalId, userId);
        if(dt == null || dt.size() == 0){
            dt = new ArrayList<>();
            dt.add(new ValidateRightVo());
        }
        return dt;
    }

    @Override
    @Transactional
    public String saveDivDocDepart(SaveDivDocDepartVo saveDivDocDeprtVo) {
        String hospitalId = saveDivDocDeprtVo.getHospitalId();// 机构编号
        String personId = saveDivDocDeprtVo.getPersonId();// 人员编号
        String personVisitId = saveDivDocDeprtVo.getPersonVisitId();//  体检次数
        String resultStatus = saveDivDocDeprtVo.getResultStatus();
        List<HcPersonAppregItemsVo> hcPersonAppregItemsList = saveDivDocDeprtVo.getUpdateHcPersonAppregItems();
        List<SaveHcDeptResultDict> saveHcDeptResultDictList = saveDivDocDeprtVo.getSaveHcDeptResultDict();
        List<SaveHcDeptResultItems> saveHcDeptResultItemsList = saveDivDocDeprtVo.getSaveHcDeptResultItems();
        List<SaveHcResultDict> saveHcResultDictList = saveDivDocDeprtVo.getSaveHcResultDict();
        //更改体检项目状态
        String err = "";
        for(HcPersonAppregItemsVo hcPersonAppregItems : hcPersonAppregItemsList){//更新hc_person_appreg_items有变化更新 空不更新
            //HOSPITAL_ID, PERSON_ID, PERSON_VISIT_ID, ITEM_PACK_CODE, ITEM_NO
            String values = hcPersonAppregItems.getValues();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            values += " ,finished_date = to_date('"+sdf.format(new Date())+"','yyyy-mm-dd hh24:mi:ss')";
            divDocDepartMapper.updateHcPersonAppregItems(values, hcPersonAppregItems.getHospitalId(), hcPersonAppregItems.getPersonId(), hcPersonAppregItems.getPersonVisitId(), hcPersonAppregItems.getItemPackCode());
//            if("完成".equals(hcPersonAppregItems.getFinishedSign()) || "拒检".equals(hcPersonAppregItems.getFinishedSign())){
//                continue;
//            }
//            UpdateWrapper<HcPersonAppregItems> hcPersonAppregItemsUpdateWrapper = new UpdateWrapper<>();
//            hcPersonAppregItemsUpdateWrapper.set("finished_sign", "完成")
//                    .set("finished_date", new Date())
//                    .set("doctor_id", hcPersonAppregItems.getDoctorId())
//                    .set("doctor_name", hcPersonAppregItems.getDoctorName())
//                    .set("editer_id", hcPersonAppregItems.getEditerId())
//                    .set("editer_name", hcPersonAppregItems.getEditerName());
//            hcPersonAppregItemsUpdateWrapper.eq("hospital_id", hcPersonAppregItems.getHospitalId())
//                    .eq("person_id", hcPersonAppregItems.getPersonId())
//                    .eq("visit_Id", hcPersonAppregItems.getPersonVisitId())
//                    .eq("ITEM_PACK_CODE", hcPersonAppregItems.getItemPackCode());
//            if(!hcPersonAppregItemsService.update(hcPersonAppregItemsUpdateWrapper)){
//                err += "更新体检号：" + hcPersonAppregItems.getPersonId() +
//                        "第" + hcPersonAppregItems.getPersonVisitId() + "次" +
//                        "组合" + hcPersonAppregItems.getItemPackCode() + "完成状态失败, ";
//            }
        }
        //保存项目结果
        for(SaveHcResultDict saveHcResultDict : saveHcResultDictList){
            switch (saveHcResultDict.getStat()){
                case "add":
                    for(HcResultDict dr : saveHcResultDict.getHcResultDict()){
                        QueryWrapper<HcResultDict> hcResultDictQueryWrapper = new QueryWrapper<>();
                        hcResultDictQueryWrapper.eq("HOSPITAL_ID", hospitalId)
                                .eq("PERSON_ID", personId)
                                .eq("PERSON_VISIT_ID", personVisitId)
                                .eq("ITEM_ASSEM_CODE", dr.getItemAssemCode())
                                .eq("DEPT_ID", dr.getDeptId())
                                .eq("HC_ITEM_CODE", dr.getHcItemCode());
                        List<HcResultDict> dthcresult = hcResultDictService.list(hcResultDictQueryWrapper);
                        if(dthcresult.size() > 0){ //如果存在，更新
                            UpdateWrapper<HcResultDict> hcResultDictUpdateWrapper = new UpdateWrapper<>();
                            hcResultDictUpdateWrapper.eq("HOSPITAL_ID", hospitalId)
                                    .eq("PERSON_ID", personId)
                                    .eq("PERSON_VISIT_ID", personVisitId)
                                    .eq("ITEM_ASSEM_CODE", dr.getItemAssemCode())
                                    .eq("DEPT_ID", dr.getDeptId())
                                    .eq("HC_ITEM_CODE", dr.getHcItemCode());
                            if(!hcResultDictService.update(dr, hcResultDictUpdateWrapper)){
                                err += "更新体检结果组合：" + dr.getItemAssemCode()+ "项目" + dr.getHcItemCode() + "|" + dr.getHcItemName() + "失败; ";
                            }
                        }else{ //  写入体检结果表中
                            if(!hcResultDictService.save(dr)){
                                err +=  "插入体检结果组合：" + dr.getItemAssemCode()+ "项目" + dr.getHcItemCode() + "|" + dr.getHcItemName() + "失败; ";
                            }
                        }
                    }
                break;
                case "update":
                    for(HcResultDict dr : saveHcResultDict.getHcResultDict()){
                        UpdateWrapper<HcResultDict> hcResultDictUpdateWrapper = new UpdateWrapper<>();
                        hcResultDictUpdateWrapper.eq("HOSPITAL_ID", hospitalId)
                                .eq("PERSON_ID", personId)
                                .eq("PERSON_VISIT_ID", personVisitId)
                                .eq("ITEM_ASSEM_CODE", dr.getItemAssemCode())
                                .eq("DEPT_ID", dr.getDeptId())
                                .eq("HC_ITEM_CODE", dr.getHcItemCode());
                        if(!hcResultDictService.update(dr, hcResultDictUpdateWrapper)){
                            err += "更新体检结果组合：" + dr.getItemAssemCode()+ "项目" + dr.getHcItemCode() + "|" + dr.getHcItemName() + "失败; ";
                        }
                    }
                    break;
            }
        }
        //保存分科体检主记录
        for(SaveHcDeptResultDict saveHcDeptResultDict : saveHcDeptResultDictList){
            for(HcDeptResultDict hcDeptResultDict : saveHcDeptResultDict.getHcDeptResultDict()){
                QueryWrapper<HcDeptResultDict> hcDeptResultDictQueryWrapper = new QueryWrapper<>();
                hcDeptResultDictQueryWrapper.eq("hospital_id", hcDeptResultDict.getHospitalId())
                        .eq("person_id", hcDeptResultDict.getPersonId())
                        .eq("person_visit_id", hcDeptResultDict.getPersonVisitId())
                        .eq("dept_id", hcDeptResultDict.getDeptId());
                long ds = hcDeptResultDictService.count(hcDeptResultDictQueryWrapper);
                if(ds > 0){
                    UpdateWrapper<HcDeptResultDict> hcDeptResultDictUpdateWrapper = new UpdateWrapper<>();
                    hcDeptResultDictUpdateWrapper.eq("hospital_id", hcDeptResultDict.getHospitalId())
                            .eq("person_id", hcDeptResultDict.getPersonId())
                            .eq("person_visit_id", hcDeptResultDict.getPersonVisitId())
                            .eq("dept_id", hcDeptResultDict.getDeptId());
                    if(!hcDeptResultDictService.update(hcDeptResultDict, hcDeptResultDictUpdateWrapper)){
                        err += "插入分科结果:" + hcDeptResultDict.getDeptName() + "更新分科体检主记录失败！ ";
                    }
                }else{
                    if(!hcDeptResultDictService.save(hcDeptResultDict)){
                        err += "插入分科结果:" + hcDeptResultDict.getDeptName() + "保存分科体检主记录失败！ ";
                    }
                }
            }
        }
        //保存分科体检明细记录
        for(SaveHcDeptResultItems saveHcDeptResultItems : saveHcDeptResultItemsList){
            if(StringUtils.isEmpty(saveHcDeptResultItems.getStat())){
                continue;
            }
            switch (saveHcDeptResultItems.getStat()){
                case "add":
                    for(HcDeptResultItems hcDeptResultItems : saveHcDeptResultItems.getHcDeptResultItems()){
                        QueryWrapper<HcDeptResultItems> hcDeptResultItemsQueryWrapper = new QueryWrapper<>();
                        hcDeptResultItemsQueryWrapper.eq("hospital_id", hcDeptResultItems.getHospitalId())
                                .eq("person_id", hcDeptResultItems.getPersonId())
                                .eq("person_visit_id", hcDeptResultItems.getPersonVisitId())
                                .eq("dept_id", hcDeptResultItems.getDeptId())
                                .eq("CONTENT_CLASS", hcDeptResultItems.getContentClass())
                                .eq("CONTENT", hcDeptResultItems.getContent());
                        long ds = hcDeptResultItemsService.count(hcDeptResultItemsQueryWrapper);
                        if(ds > 0){
                            UpdateWrapper<HcDeptResultItems> hcDeptResultItemsUpdateWrapper = new UpdateWrapper<>();
                            hcDeptResultItemsUpdateWrapper.eq("hospital_id", hcDeptResultItems.getHospitalId())
                                    .eq("person_id", hcDeptResultItems.getPersonId())
                                    .eq("person_visit_id", hcDeptResultItems.getPersonVisitId())
                                    .eq("dept_id", hcDeptResultItems.getDeptId())
                                    .eq("CONTENT_CLASS", hcDeptResultItems.getContentClass())
                                    .eq("CONTENT", hcDeptResultItems.getContent());
                            hcDeptResultItemsService.update(hcDeptResultItems, hcDeptResultItemsUpdateWrapper);
                        }else{
                            hcDeptResultItemsService.save(hcDeptResultItems);
                        }
                    }
                    break;
                case "delete":
                    for(HcDeptResultItems hcDeptResultItems : saveHcDeptResultItems.getHcDeptResultItems()){
                        //HOSPITAL_ID, PERSON_ID, PERSON_VISIT_ID, DEPT_ID, CONTENT_CLASS, CONTENT
                        LambdaQueryWrapper<HcDeptResultItems> queryWrapper = new LambdaQueryWrapper<>();
                        queryWrapper.eq(HcDeptResultItems::getHospitalId, hcDeptResultItems.getHospitalId());
                        queryWrapper.eq(HcDeptResultItems::getPersonId, hcDeptResultItems.getPersonId());
                        queryWrapper.eq(HcDeptResultItems::getPersonVisitId, hcDeptResultItems.getPersonVisitId());
                        queryWrapper.eq(HcDeptResultItems::getDeptId, hcDeptResultItems.getDeptId());
                        queryWrapper.eq(HcDeptResultItems::getContentClass, hcDeptResultItems.getContentClass());
                        queryWrapper.eq(HcDeptResultItems::getContent, hcDeptResultItems.getContent());
                        hcDeptResultItemsService.remove(queryWrapper);
                    }
                    break;
                case "update":
                    for (HcDeptResultItems hcDeptResultItems : saveHcDeptResultItems.getHcDeptResultItems()){
                        LambdaUpdateWrapper<HcDeptResultItems> updateWrapper = new LambdaUpdateWrapper<>();
                        updateWrapper.eq(HcDeptResultItems::getHospitalId, hcDeptResultItems.getHospitalId());
                        updateWrapper.eq(HcDeptResultItems::getPersonId, hcDeptResultItems.getPersonId());
                        updateWrapper.eq(HcDeptResultItems::getPersonVisitId, hcDeptResultItems.getPersonVisitId());
                        updateWrapper.eq(HcDeptResultItems::getDeptId, hcDeptResultItems.getDeptId());
                        updateWrapper.eq(HcDeptResultItems::getContentClass, hcDeptResultItems.getContentClass());
                        updateWrapper.eq(HcDeptResultItems::getContent, hcDeptResultItems.getContent());
                        hcDeptResultItemsService.update(hcDeptResultItems, updateWrapper);
                    }
                    break;
            }
        }
        //更新体检状态
        QueryWrapper<HcPersonVisitInfo> hcPersonVisitInfoQueryWrapper = new QueryWrapper<>();
        hcPersonVisitInfoQueryWrapper.eq("hospital_id", hospitalId);
        hcPersonVisitInfoQueryWrapper.eq("person_id", personId);
        hcPersonVisitInfoQueryWrapper.eq("person_visit_id", personVisitId);
        List<HcPersonVisitInfo> hcPersonVisitInfoList = hcPersonVisitInfoService.list(hcPersonVisitInfoQueryWrapper);
        if(hcPersonVisitInfoList==null || hcPersonVisitInfoList.size() == 0){
            throw new CommonException(500, "未找到本次体检信息！"+ personId+"|"+ personVisitId);
        }
        //int res_status = Integer.parseInt(hcPersonVisitInfoList.get(0).getResultStatus());
        if(Integer.parseInt(resultStatus) < 2){
            if(!divDocDepartMapper.updatePersonVisitInfoDepart(personId, personVisitId)){
                err += "更新体检状态:" + personId + "更新体检结果状态时出错！";
            }
        }
        return err;
    }

    @Override
    public PageResult<FrmGetPersonVoRsp> findPerson(FrmGetPersonVo frmGetPersonVo) {
        PageResult<FrmGetPersonVoRsp> result;
        List<FrmGetPersonVoRsp> list = divDocDepartMapper.findPerson(frmGetPersonVo);
        if(list.size()==0){
            list.add(new FrmGetPersonVoRsp());
        }
        int totalSize = divDocDepartMapper.findPersonCount(frmGetPersonVo);
        int totalPages = totalSize%frmGetPersonVo.getPageSize() == 0 ? totalSize / frmGetPersonVo.getPageSize() : totalSize / frmGetPersonVo.getPageSize() + 1;
        result = new PageResult(frmGetPersonVo.getPageNum(), frmGetPersonVo.getPageSize(), totalSize, totalPages, list);
        return result;
    }

    @Override
    public PageResult<FrmGetUnitPersonVoRsp> findUnitPerson(FrmGetUnitPersonVo frmGetUnitPersonVo) {
        PageResult<FrmGetUnitPersonVoRsp> result;
        List<FrmGetUnitPersonVoRsp> list = divDocDepartMapper.findUnitPerson(frmGetUnitPersonVo);
        if(list.size()==0){
            list.add(new FrmGetUnitPersonVoRsp());
        }
        int totalSize = divDocDepartMapper.findUnitPersonCount(frmGetUnitPersonVo);
        int totalPages = totalSize%frmGetUnitPersonVo.getPageSize() == 0 ? totalSize / frmGetUnitPersonVo.getPageSize() : totalSize / frmGetUnitPersonVo.getPageSize() + 1;
        result = new PageResult(frmGetUnitPersonVo.getPageNum(), frmGetUnitPersonVo.getPageSize(), totalSize, totalPages, list);
        return result;
    }

    @Override
    public List<FrmGetPersonVoRsp> findGetPersonHistory(String hospitalId, String personId, String deptId) {
        List<FrmGetPersonVoRsp> list = divDocDepartMapper.findGetPersonHistory(hospitalId, personId, deptId);
        if(list.size()==0){
            list.add(new FrmGetPersonVoRsp());
        }
        return list;
    }

    @Override
    public String findWorkInfo(String deptId, String value1, String value2) {
        return divDocDepartMapper.findWorkInfo(deptId, value1, value2)+"";
    }

    @Override
    public List<FrmPackVsItems> findPackVsItems(String hospitalId, String itemPackCode) {
        List<FrmPackVsItems> list = divDocDepartMapper.findPackVsItems(hospitalId, itemPackCode);
        if(list.size()==0){
            list.add(new FrmPackVsItems());
        }
        return list;
    }

    private List<FrmPackVsItems> findPackVsItems1(String hospitalId, String itemPackCode) {
        List<FrmPackVsItems> list = divDocDepartMapper.findPackVsItems(hospitalId, itemPackCode);
        return list;
    }

    @Override
    public List<FrmPackItems> findPackItems(String hospitalId) {
        List<FrmPackItems> list = divDocDepartMapper.findPackItems(hospitalId);
        if(list.size()==0){
            list.add(new FrmPackItems());
        }
        return list;
    }

    @Override
    public List<FrmItemVsExternal> findItemVsExternal(String hospitalId, String itemCode) {
        List<FrmItemVsExternal> list = divDocDepartMapper.findItemVsExternal(hospitalId, itemCode);
        if(list.size()==0){
            list.add(new FrmItemVsExternal());
        }
        return list;
    }

    @Override
    public List<FrmLabResultVo> findLabResult(String testNoList) {
        List<FrmLabResultVo> list = divDocDepartMapper.findLabResult(testNoList);
        if(list.size()==0){
            list.add(new FrmLabResultVo());
        }
        return list;
    }

    private List<FrmLabResultVo> findLabResultOut(String hospitalId, Connection conn, String testNoList) {
        QueryRunner queryRunner = new QueryRunner();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT LAB_RESULT.REPORT_ITEM_NAME, LAB_RESULT.REPORT_ITEM_CODE,LAB_RESULT.RESULT, LAB_RESULT.UNITS,LAB_RESULT.ABNORMAL_INDICATOR,")
                .append("LAB_RESULT.INSTRUMENT_ID,LAB_RESULT.RESULT_DATE_TIME,LAB_RESULT.PRINT_CONTEXT,LAB_RESULT.TEST_NO FROM HCLAB_RESULT LAB_RESULT, hclab_test_master LAB_TEST_MASTER")
                .append("WHERE LAB_RESULT.TEST_NO = LAB_TEST_MASTER.TEST_NO and ")
                .append("LAB_RESULT.TEST_NO in ( ")
                .append(testNoList)
                .append(") AND LAB_TEST_MASTER.RESULT_STATUS = '4'");
        List<FrmLabResultVo> list = null;
        try {
            list = queryRunner.query(conn, sql.toString(), new BeanListHandler<FrmLabResultVo>(FrmLabResultVo.class));
        }catch (Exception e){
            throw new CommonException(500,"外部接口调用错误！");
        }
        if(list.size()==0){
            list.add(new FrmLabResultVo());
        }
        return list;
    }

    private List<FrmLabResultVo> findLabResultOut1(String hospitalId, String testNoList) {
        List<FrmLabResultVo> list = divDocDepartMapper.findLabResultOut1(testNoList);
        return list;
    }

    private List<FrmLabResultVo> findLabResultOut1(String hospitalId, Connection conn, String testNoList) {
        QueryRunner queryRunner = new QueryRunner();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT LAB_RESULT.REPORT_ITEM_NAME, LAB_RESULT.REPORT_ITEM_CODE,LAB_RESULT.RESULT, LAB_RESULT.UNITS,LAB_RESULT.ABNORMAL_INDICATOR,")
                .append("LAB_RESULT.INSTRUMENT_ID,LAB_RESULT.RESULT_DATE_TIME,LAB_RESULT.PRINT_CONTEXT,LAB_RESULT.TEST_NO FROM HCLAB_RESULT LAB_RESULT, hclab_test_master LAB_TEST_MASTER ")
                .append("WHERE LAB_RESULT.TEST_NO = LAB_TEST_MASTER.TEST_NO and ")
                .append("LAB_RESULT.TEST_NO in ( ")
                .append(testNoList)
                .append(") AND LAB_TEST_MASTER.RESULT_STATUS = '4'");
        List<FrmLabResultVo> list = null;
        try {
            list = queryRunner.query(conn, sql.toString(), new BeanListHandler<FrmLabResultVo>(FrmLabResultVo.class));
        }catch (Exception e){
            throw new CommonException(500,"外部接口调用错误！");
        }
        return list;
    }

    @Override
    public List<FrmLabResultVo> findLabResultOut(String hospitalId, String sourceId, String testNoList) {
        QueryWrapper<InterfaceSource> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hospital_id", hospitalId);
        queryWrapper.eq("source_id", sourceId);
        InterfaceSource interfaceSource = interfaceSourceService.getOne(queryWrapper);
        String serviceName = interfaceSource.getServiceName();
        String userName = interfaceSource.getUserName();
        String password = interfaceSource.getPassword();
        Connection conn = DruidUtils.getConnection(serviceName, userName, password);
        QueryRunner queryRunner = new QueryRunner();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT LAB_RESULT.REPORT_ITEM_NAME, LAB_RESULT.REPORT_ITEM_CODE,LAB_RESULT.RESULT, LAB_RESULT.UNITS,LAB_RESULT.ABNORMAL_INDICATOR,")
                .append("LAB_RESULT.INSTRUMENT_ID,LAB_RESULT.RESULT_DATE_TIME,LAB_RESULT.PRINT_CONTEXT,LAB_RESULT.TEST_NO FROM LAB_RESULT, LAB_TEST_MASTER ")
                .append("WHERE LAB_RESULT.TEST_NO = LAB_TEST_MASTER.TEST_NO and ")
                .append("LAB_RESULT.TEST_NO in ( ")
                .append(testNoList)
                .append(") AND LAB_TEST_MASTER.RESULT_STATUS = '4'");
        List<FrmLabResultVo> list = null;
        try {
            list = queryRunner.query(conn, sql.toString(), new BeanListHandler<FrmLabResultVo>(FrmLabResultVo.class));

        }catch (Exception e){
            throw new CommonException(500,"外部接口调用错误！");
        }
        if(list.size()==0){
            list.add(new FrmLabResultVo());
        }
        return list;
    }

    @Override
    public List<InterfaceSource> getHisConnStr(String hospitalId) {
        QueryWrapper<InterfaceSource> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hospital_id", hospitalId);
        return interfaceSourceService.list(queryWrapper);
    }

    @Override
    public List<HcDeptResultItems> findHcDeptResultItems(String hospitalId, String personId, String personVisitId, String deptId, String packCode, String relation) {
        QueryWrapper<HcDeptResultItems> hcDeptResultItemsQueryRunner = new QueryWrapper();
        hcDeptResultItemsQueryRunner.eq("hospital_id", hospitalId)
                .eq("person_id", personId)
                .eq("person_visit_id", personVisitId)
                .eq("dept_id", deptId);
        if(relation.equals("0")){
            hcDeptResultItemsQueryRunner.eq("ITEM_ASSEM_CODE", packCode);
        }
        if(relation.equals("*")){
            hcDeptResultItemsQueryRunner.ne("ITEM_ASSEM_CODE", packCode);
        }
        List<HcDeptResultItems> hcDeptResultItems = hcDeptResultItemsService.list(hcDeptResultItemsQueryRunner);
        return hcDeptResultItems;
    }

    @Override
    public List<HcDeptResultDict> findHcDeptResult(String hospitalId, String personId, String personVisitId, String deptId) {
        QueryWrapper<HcDeptResultDict> hcDeptResultDictQueryWrapper = new QueryWrapper<>();
        hcDeptResultDictQueryWrapper.eq("hospital_id", hospitalId)
                .eq("person_id", personId)
                .eq("person_visit_id", personVisitId);
        if(!"*".equals(deptId)){
            hcDeptResultDictQueryWrapper.eq("dept_id", deptId);
        }
        List<HcDeptResultDict> list = hcDeptResultDictService.list(hcDeptResultDictQueryWrapper);
        if(list.size() == 0){
            list.add(new HcDeptResultDict());
        }
        return list;
    }

    @Override
    public List<HcDeptResultItems> findDeptResultItems(String hospitalId, String personId, String personVisitId, String deptId) {
        QueryWrapper<HcDeptResultItems> hcDeptResultItemsQueryRunner = new QueryWrapper();
        hcDeptResultItemsQueryRunner.eq("hospital_id", hospitalId)
                .eq("person_id", personId)
                .eq("person_visit_id", "*".equals(personVisitId)?"":personVisitId)
                .eq("dept_id", deptId);
        List<HcDeptResultItems> list = hcDeptResultItemsService.list(hcDeptResultItemsQueryRunner);
        if(list.size() == 0){
            list.add(new HcDeptResultItems());
        }
        return list;
    }

    @Override
    public int countHcPersonAppregItems(String personId, String personVisitId, String finishedSign) {
        return divDocDepartMapper.countHcPersonAppregItems(personId, personVisitId, finishedSign);
    }

    @Override
    public List<DeptNameListVo> findDeptNameList(String hospitalId, String deptId) {
        List<DeptNameListVo> list = divDocDepartMapper.findDeptNameList(hospitalId, deptId);
        if(list.size() == 0){
            list.add(new DeptNameListVo());
        }
        return list;
    }

    @Override
    public List<ResultStatusListVo> findResultStatusList(String personId, String personVisitId) {
        List<ResultStatusListVo> list = divDocDepartMapper.findResultStatusList(personId, personVisitId);
        if(list.get(0) == null){
            list.clear();
            list.add(new ResultStatusListVo());
        }
        return list;
    }

    @Override
    public List<FrmGetHcAppregItem> findHcAppregItem(String hospitalId, String personId, String personVisitId, String packCode) {
        List<FrmGetHcAppregItem> list = divDocDepartMapper.findHcAppregItem(hospitalId, personId, personVisitId, packCode);
        if(list.size() == 0){
            list.add(new FrmGetHcAppregItem());
        }
        return list;
    }

    private List<FrmGetHcAppregItem> findHcAppregItem1(String hospitalId, String personId, String personVisitId, String packCode) {
        List<FrmGetHcAppregItem> list = divDocDepartMapper.findHcAppregItem(hospitalId, personId, personVisitId, packCode);
        return list;
    }

    @Override
    public List<InitDeptVo> initDept(String userName) {
        List<InitDeptVo> list = divDocDepartMapper.initDept(userName);
        if(list.size() == 0){
            list.add(new InitDeptVo());
        }
        return list;
    }

    @Override
    public List<InitDoctorVo> initDoctor(String hospitalId, String deptId) {
        List<InitDoctorVo> list = divDocDepartMapper.initDoctor(hospitalId, deptId);
        if(list.size() == 0){
            list.add(new InitDoctorVo());
        }
        return list;
    }

    @Override
    public List<FrmSetDivSourceVoRes> setDivSource(String hospitalId, String deptId, String personId, String visitId) {
        List<FrmSetDivSourceVoRes> list = divDocDepartMapper.setDivSource(hospitalId, deptId, personId, visitId);
        if(list.size() == 0){
            list.add(new FrmSetDivSourceVoRes());
        }
        return list;
    }

    @Override
    public String findResultStatus(String hospitalId, String personId, String visitId) {
        String resultStatus = divDocDepartMapper.findResultStatus(hospitalId, personId, visitId);
        return resultStatus==null? "" : resultStatus;
    }

    @Override
    public Date findBeforeDate(String hospitalId, String personId, String visitId) {
        return divDocDepartMapper.findBeforeDate(hospitalId, personId, visitId);
    }

    @Override
    public int findItemsCount(String hospitalId, String personId, String visitId, String deptCode) {
        int itemsCount = divDocDepartMapper.findItemsCount(hospitalId, personId, visitId, deptCode);
        return itemsCount;
    }

    @Override
    public List<HcPersonVisitInfo> findHcPersonVisitInfo(String hospitalId, String personId, String visitId) {
        UpdateWrapper<HcPersonVisitInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("hospital_id", hospitalId)
                .eq("person_id", personId)
                .eq("person_visit_id", visitId);
        List<HcPersonVisitInfo> list = hcPersonVisitInfoService.list(updateWrapper);
        if(list.size() == 0){
            list.add(new HcPersonVisitInfo());
        }
        return list;
    }

    @Override
    public List<HcPersonInfo> findHcPersonInfo(String hospitalId, String personId) {
        List<HcPersonInfo> list  = divDocDepartMapper.findHcPersonInfo(hospitalId, personId);
        if(list.size() == 0){
            HcPersonInfo hcPersonInfo = new HcPersonInfo();
            hcPersonInfo.setIsaway("");
            list.add(hcPersonInfo);
        }
        return list;
    }

    @Override
    public String findClassName(String hospitalId, String deptId) {
        String className = divDocDepartMapper.findClassName(hospitalId, deptId);
        return className==null ? "" : className;
    }

    @Override
    public int findCountApply(String hospitalId, String deptId, String personId, String visitId) {
        return divDocDepartMapper.findCountApply(hospitalId, deptId, personId, visitId);
    }

    @Override
    public int findCountSettle(String hospitalId, String personId, String visitId, String deptCode) {
        return divDocDepartMapper.findCountSettle(hospitalId, personId, visitId, deptCode);
    }

    @Override
    public List<SetPersonInfoVo> findSetPersonInfo(String hospitalId, String personId, String visitId) {
        return divDocDepartMapper.findSetPersonInfo(hospitalId, personId, visitId);
    }

    @Override
    public List<HcDeptResultDict> findDeptResult(String personId, String visitId, String deptId) {
        QueryWrapper<HcDeptResultDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("person_id", personId)
                .eq("person_visit_id", visitId)
                .eq("dept_id", deptId);
        List<HcDeptResultDict> list = hcDeptResultDictService.list(queryWrapper);
        if(list.size() == 0){
            list.add(new HcDeptResultDict());
        }
        return list;
    }

    @Override
    public List<GetHcResultVo> findHcResult(String hospitalId, String personId, String visitId, String packCode, String deptId) {
        if("*".equals(deptId)||StringUtils.isEmpty(deptId)){
            deptId = "*";
        }
        List<GetHcResultVo> list = divDocDepartMapper.findHcResult(hospitalId, personId, visitId, packCode, deptId);
        if(list.size() == 0){
            list.add(new GetHcResultVo());
        }
        return list;
    }

    @Override
    public List<HcAppregItemsVo> findHcAppregItems(String hospitalId, String personId, String visitId, String deptClass) {
        List<HcAppregItemsVo> list = divDocDepartMapper.findHcAppregItems(hospitalId, personId, visitId, deptClass);
        if(list.size() == 0){
            list.add(new HcAppregItemsVo());
        }
        return list;
    }

    @Override
    public List<VLabTestMaster> findVLabTestMaster(String testNo) {
        QueryWrapper<VLabTestMaster> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("test_no", testNo);
        List<VLabTestMaster> list = vLabTestMasterService.list(queryWrapper);
        if(list.size() == 0){
            list.add(new VLabTestMaster());
        }
        return list;
    }

    @Override
    public String findResultHandle(String hospitalId, String itemPackCode) {
        String resultHandle = divDocDepartMapper.findResultHandle(hospitalId, itemPackCode);
        return resultHandle == null ? "" : resultHandle;
    }

    public List<VHcItemPackDict> findVHcItemPackDict(String hospitalId, String itemPackCode){
        QueryWrapper<VHcItemPackDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hospital_id", hospitalId).eq("item_pack_code", itemPackCode);
        return vHcItemPackDictService.list(queryWrapper);
    }

    @Override
    public String findUpdateConclusion(String hospitalId, String hcDeptCode) {
        String conclusion = divDocDepartMapper.findUpdateConclusion(hospitalId, hcDeptCode);
        return conclusion == null ? "" : conclusion;
    }

    @Override
    @Transactional
    public int importLabResult(String hospitalId, String applyNo, String personId, int personVisitId, String itemPackCode, String doctorName, String ext_sys_code) {
        String ls_item_pack_name; //项目组合名称
        String ls_pack_sort_no; //项目组合名称在科室中对应的排列序号
        String ls_Hc_dept_code, ls_Hc_dept_name;  //项目组合对应的科室代码和名
        String ls_result_handle; //项目组合代码处理阳性体征的方式
        String ls_unit_id;
        int unit_visit_id;
        Date sysdatetime; //系统时间
        List<FrmItemVsExternal> dt_item_vs_external;
        List<FrmLabResultVo> dtresultlab = this.findLabResultOut(hospitalId, ext_sys_code, applyNo);
        List<FrmGetHcAppregItem> dt_personal_items = this.findHcAppregItem(hospitalId, personId, personVisitId+"", itemPackCode);
        List<FrmGetHcAppregItem> drrows = dt_personal_items.stream().filter(frmGetHcAppregItem -> frmGetHcAppregItem.getPERSON_ID().equals(personId))
                .filter(frmGetHcAppregItem -> frmGetHcAppregItem.getPERSON_VISIT_ID().equals(personVisitId))
                .filter(frmGetHcAppregItem -> frmGetHcAppregItem.getITEM_PACK_CODE().equals(itemPackCode)).collect(Collectors.toList());
        if(drrows.size() < 1){
            throw new CommonException(500,"未查询到:" + itemPackCode + "的项目!");
        }
        ls_item_pack_name = drrows.get(0).getITEM_PACK_NAME();
        ls_Hc_dept_name = drrows.get(0).getITEM_PACK_NAME();
        ls_Hc_dept_code = drrows.get(0).getDEPT_CODE();
        ls_Hc_dept_name = drrows.get(0).getDEPT_NAME();
        ls_pack_sort_no = StringUtils.isEmpty(drrows.get(0).getITEM_NO()) ? "" : drrows.get(0).getITEM_NO();
        //=============获得项目组合代码处理阳性体征的方式
            /*
            1每条阳性一条记录
            2把所有阳性合并成一条，中间以、连接
            3把所有阳性合并成一条，中间以"\R\N"连接
            */
        String content_list = "";
        List<VHcItemPackDict> ds = this.findVHcItemPackDict(hospitalId, itemPackCode);
        if(ds!=null&&ds.size()>0){
            ls_result_handle = ds.get(0).getResultHandle();
            if(StringUtils.isEmpty(ls_result_handle)){
                ls_result_handle = "1";
            }else if(!("1".equals(ls_result_handle)||"2".equals(ls_result_handle)||"3".equals(ls_result_handle))){
                ls_result_handle = "1";
            }
        }else{
            throw new CommonException(500, "未查询到:" + itemPackCode + "的项目!");
        }
        //====获取单位代码和单位体检次数===
        QueryWrapper<HcPersonVisitInfo> hcPersonVisitInfoQueryWrapper = new QueryWrapper<>();
        hcPersonVisitInfoQueryWrapper.eq("hospital_id", hospitalId).eq("person_id", personId).eq("person_visit_id", personVisitId);
        List<HcPersonVisitInfo> personList = hcPersonVisitInfoService.list(hcPersonVisitInfoQueryWrapper);
        if (personList!=null&&personList.size()>0){
            ls_unit_id = personList.get(0).getUnitId();
            unit_visit_id = personList.get(0).getUnitVisitId();
        }else{
            throw new CommonException(500, "导入检验结果未找到本次体检单位");
        }
        sysdatetime = new Date();
        //=============== 开始判断检验项目组合对应的项目情况==============
        List<FrmPackVsItems> dtpackvsitem = this.findPackVsItems(hospitalId, itemPackCode);
        int item_count = 0; //项目组合对应的项目数量
        if(dtpackvsitem!=null && dtpackvsitem.size()>0){
            item_count = dtpackvsitem.size();
        }
        if(item_count == 0){
            throw new CommonException(500, "导入检验结果项目组合代码:" + itemPackCode + "没有对应项目");
        }
        int external_count = 0, item_order_no;
        String ls_item_code, ls_item_name, ls_ext_code, ls_show_type, ls_result_type;

        // 清除可能存在的结果
        QueryWrapper<HcResultDict> hcResultDictQueryWrapper = new QueryWrapper<>();
        hcResultDictQueryWrapper
                .eq("HOSPITAL_ID", hospitalId)
                .eq("person_id", personId)
                .eq("person_visit_id", personVisitId)
                .eq("item_assem_code", itemPackCode);
        hcResultDictService.remove(hcResultDictQueryWrapper);
        // 先删除当前的组合所有分科结果项目，重新插入
        QueryWrapper<HcDeptResultItems> hcDeptResultItemsQueryWrapper = new QueryWrapper<>();
        hcDeptResultItemsQueryWrapper
                .eq("HOSPITAL_ID", hospitalId)
                .eq("person_id", personId)
                .eq("person_visit_id", personVisitId)
                .eq("dept_id",ls_Hc_dept_code)
                .eq("item_assem_code", itemPackCode);
        hcDeptResultItemsService.remove(hcDeptResultItemsQueryWrapper);
        String report_item_code, report_item_name;  // 检验报告项目代码,检验报告项目名称
        String ls_result, ls_units, ls_print_context, ls_abnormal_indicator;   //检验结果，单位, 正常值范围,正常标志
        BigDecimal ldec_result;    //检验数字结果
        BigDecimal value, top_v, bottom_v;
        String ls_abnormal_dept_result = "";
        int dept_sort_no = 1;
        int result_cnt = 0;
        for(int step = 0; step < item_count; step++){
            ls_item_code = dtpackvsitem.get(step).getITEM_CODE();
            ls_item_name = dtpackvsitem.get(step).getITEM_NAME();
            item_order_no = Integer.parseInt(dtpackvsitem.get(step).getITEM_NO());
            ls_show_type = dtpackvsitem.get(step).getRESULT_TYPE();
            ls_result_type = dtpackvsitem.get(step).getRESULT_TYPE();
            dt_item_vs_external = this.findItemVsExternal(hospitalId, ls_item_code);
            external_count = 0;
            if(dt_item_vs_external == null || dt_item_vs_external.size() == 0){
                continue;
            }else{
                for(FrmItemVsExternal drext : dt_item_vs_external){
                    ls_ext_code = drext.getExt_code();
                    String finalLs_ext_code = ls_ext_code;
                    List<FrmLabResultVo> drs = dtresultlab.stream().filter(frmLabResultVo -> finalLs_ext_code.equals(frmLabResultVo.getREPORT_ITEM_CODE())).collect(Collectors.toList());
                    if(drs.size()>0){
                        value = new BigDecimal(0);
                        external_count = 1;
                        report_item_code = drs.get(0).getREPORT_ITEM_CODE();
                        report_item_name = drs.get(0).getREPORT_ITEM_NAME();
                        ls_result = drs.get(0).getRESULT();
                        ls_units = drs.get(0).getUNITS();
                        ls_print_context = drs.get(0).getPRINT_CONTEXT();
                        ls_abnormal_indicator = drs.get(0).getABNORMAL_INDICATOR();
                        // 转换结果，补充正常值
                        if ("NEG".equals(ls_result.toUpperCase()))
                        {
                            ls_result = "阴性";
                        }
                        if(StringUtils.isEmpty(ls_print_context)) {
                            //如果为空，则取 项目字典表中的字段
                            String ls_bottom_v = dtpackvsitem.get(step).getBOTTOM_LIMIT();
                            String ls_top_v = dtpackvsitem.get(step).getTOP_LIMIT();
                            if (StringUtils.isEmpty(ls_top_v) || StringUtils.isEmpty(ls_bottom_v)) {//无上下限
                                ls_print_context = dtpackvsitem.get(step).getNORMAL_VALUE();
                            } else {
                                if (isInteger(ls_result)) {
                                    value = new BigDecimal(ls_result);
                                    top_v = new BigDecimal(ls_top_v);
                                    bottom_v = new BigDecimal(ls_bottom_v);
                                    if (value.compareTo(bottom_v) == -1) {
                                        ls_abnormal_dept_result = "L";
                                    } else if (value.compareTo(top_v) == 1) {
                                        ls_abnormal_indicator = "H";
                                    } else {
                                        ls_abnormal_indicator = "N";
                                    }
                                    ls_print_context = ls_bottom_v + "-" + ls_top_v;
                                }
                                ls_units = dtpackvsitem.get(step).getUNIT();
                            }
                        }
                        String ls_dec_result = "null";
                        if(StringUtils.isNotEmpty(ls_result)){
                            //不理解这块的代码的作用是什么
//                                if (decimal.TryParse(ls_result, out value))
//                                {
//                                    ls_result = value.ToString();
//                                }
                        }
                        //  写入体检结果表中并收集异常结果
                        HcResultDict hcResultDict = new HcResultDict();
                        hcResultDict.setHospitalId(hospitalId).setPersonId(personId).setPersonVisitId(personVisitId).setDeptId(ls_Hc_dept_code)
                                .setDeptName(ls_Hc_dept_name).setItemAssemCode(itemPackCode).setItemAssemName(ls_item_pack_name).setHcItemCode(ls_item_code)
                                .setHcItemName(ls_item_name).setAssemSortNo(Integer.parseInt(ls_pack_sort_no)).setItemOrderNo(item_order_no);
                        //hcResultDict.setShowType(ls_show_type);
                        if("2".equals(ls_Hc_dept_code)){
                            hcResultDict.setShowType("检验");
                        }else{
                            hcResultDict.setShowType("报告");
                        }
                        if("null".equals(ls_result)){
                            ls_result = "";
                        }
                        hcResultDict.setResultType(ls_result_type).setKeyName(ls_result).setHcResult(ls_result).setResultDecimal(new BigDecimal(ls_dec_result))
                                .setUnit(ls_units).setPrintContext(ls_print_context).setAbnormalIndicator(ls_abnormal_indicator).setUnitId(ls_unit_id)
                                .setUnitVisitId(unit_visit_id).setHcResultDate(sysdatetime);
                        try{
                            hcResultDictService.save(hcResultDict);
                        }catch (Exception e){
                            throw new CommonException(500,  "插入体检结果组合：" + itemPackCode + "项目" + ls_item_code + "|" + ls_item_name + "失败");
                        }
                        //书写阳性体征
                        String restohandle = this.resultToHandle(ls_result);
                        if("1".equals(ls_result_handle)){
                            if("L".equals(ls_abnormal_indicator) || "H".equals(ls_abnormal_indicator)){
                                ls_abnormal_dept_result = "L".equals(ls_abnormal_indicator) ? ls_item_name + "偏低" : ls_item_name + "偏高";
                            }else if(!"0".equals(restohandle)){
                                ls_abnormal_dept_result = ls_item_name + restohandle;
                            }else if(ls_result.indexOf("阳性") >= 0 || ls_result.indexOf("+") >= 0){
                                ls_abnormal_dept_result = ls_item_name + ls_result;
                            }
                        }else{
                            if ("L".equals(ls_abnormal_indicator) || "H".equals(ls_abnormal_indicator)) {
                                if ("2".equals(ls_result_handle))//所有阳性合并成一条，中间以、连接
                                {
                                    if (StringUtils.isNotEmpty(ls_abnormal_dept_result)) ls_abnormal_dept_result += "、";
                                }
                                if ("3".equals(ls_result_handle))//所有阳性合并成一条，中间以"\r\n"连接
                                {
                                    if (StringUtils.isNotEmpty(ls_abnormal_dept_result)) ls_abnormal_dept_result += "\r\n";
                                }
                                ls_abnormal_dept_result += "L".equals(ls_abnormal_indicator) ? ls_item_name + "偏低" : ls_item_name + "偏高";
                            }
                            else if (!"0".equals(restohandle)){
                                if ("2".equals(ls_result_handle))//所有阳性合并成一条，中间以、连接
                                {
                                    if (StringUtils.isNotEmpty(ls_abnormal_dept_result)) ls_abnormal_dept_result += "、";
                                }
                                if ("3".equals(ls_result_handle))//所有阳性合并成一条，中间以"\r\n"连接
                                {
                                    if (StringUtils.isNotEmpty(ls_abnormal_dept_result)) ls_abnormal_dept_result += "\r\n";
                                }
                                ls_abnormal_dept_result += ls_item_name + restohandle;
                            }
                            else if (ls_result.indexOf("阳性") >= 0 || ls_result.indexOf("+") >= 0){
                                if ("2".equals(ls_result_handle))//所有阳性合并成一条，中间以、连接
                                {
                                    if (StringUtils.isNotEmpty(ls_abnormal_dept_result)) ls_abnormal_dept_result += "、";
                                }
                                if ("3".equals(ls_result_handle))//所有阳性合并成一条，中间以"\r\n"连接
                                {
                                    if (StringUtils.isNotEmpty(ls_abnormal_dept_result)) ls_abnormal_dept_result += "\r\n";
                                }
                                ls_abnormal_dept_result += ls_item_name + ls_result;
                            }
                        }
                        if("1".equals(ls_result_handle)&&StringUtils.isNotEmpty(ls_abnormal_dept_result)){//插入科室体检项目
                            try{
                                hcDeptResultItemsQueryWrapper.clear();
                                hcDeptResultItemsQueryWrapper.eq("result_cnt", result_cnt)
                                        .eq("person_id", personId)
                                        .eq("person_visit_id", personVisitId)
                                        .eq("dept_id", ls_Hc_dept_code)
                                        .eq("CONTENT", ls_abnormal_dept_result);
                                hcDeptResultItemsService.remove(hcDeptResultItemsQueryWrapper);
                            }catch (Exception e){
                                throw new CommonException(500,"删除科室" + ls_Hc_dept_code + "组合" + itemPackCode + "项目：" + ls_item_code + "内容" + ls_abnormal_dept_result + "失败");
                            }
                            try{
                                HcDeptResultItems hcDeptResultItems = new HcDeptResultItems();
                                hcDeptResultItems.setHospitalId(hospitalId).setPersonId(personId).setPersonVisitId(personVisitId).setDeptId(ls_Hc_dept_code).setDeptName(ls_Hc_dept_name)
                                        .setContentClass("1").setContent(ls_abnormal_dept_result).setDescription("").setSortNo(dept_sort_no).setItemAssemCode(itemPackCode)
                                        .setInDeptReport("0").setInChiefReport("0").setGuideContent("").setHcItemCode(ls_item_code);
                            }catch (Exception e){
                                throw new CommonException(500, "插入阳性体征：" + itemPackCode + "项目" + ls_item_code + "|" + ls_item_name + "内容：" + ls_abnormal_dept_result + "失败");
                            }
                            if(StringUtils.isEmpty(content_list)){
                                content_list = ls_abnormal_dept_result;
                            }else{
                                content_list += "\r\n"+ls_abnormal_dept_result;
                            }
                            dept_sort_no++;
                        }
                        result_cnt++;
                    }else {
                        continue;
                    }
                }
            }
        }
        if(result_cnt == 0){
            return 0;
        }
        UpdateWrapper<HcPersonAppregItems> hcPersonAppregItemsUpdateWrapper = new UpdateWrapper<>();
        hcPersonAppregItemsUpdateWrapper.set("finished_sign", "完成")
                .set("finished_date", new Date())
                .set("doctor_name", doctorName)
                .eq("hospital_id", hospitalId)
                .eq("person_id", personId)
                .eq("person_visit_id", personVisitId)
                .eq("ITEM_PACK_CODE", itemPackCode);

        try {
            hcPersonAppregItemsService.update(hcPersonAppregItemsUpdateWrapper);
        }catch (Exception e){
            throw new CommonException(500, "更新体检号：" + personId + "第" + doctorName + "次" + "组合" + itemPackCode + "完成状态失败");
        }
        return 1;
    }

    @Override
    @Transactional
    public String loadImportLabResult(LoadLabVo loadLabVo) {
        String hospitalId = loadLabVo.getHospitalId();
        String personId = loadLabVo.getPersonId();
        int visitid = loadLabVo.getPersonVisitId();
        int resStatus = loadLabVo.getResStatus();
        String  ls_conclusion;
        String  ls_finished_sign; //完成标志，结果状态
        String ls_apply_no;   //检验申请号
        int item_no;        // 检验项目序号
        String deptId = loadLabVo.getHcDeptCode();
        String ls_p_id, ls_p_dept_code, ls_p_dept_name;  //体检号，体检科室
        int li_p_visit_id;
        String item_pack_name, item_assem_code;
        String ls_total_not_finish = "";   // 保存结果尚未完成的检验项目
        String ls_total_commit = "";      // 保存成功导入的检验项目
        String ls_total_failure = "";         // 保存导入过程中失败的检验项目
        String ls_receive_server;
        int finish_cnt = 0;//完成的项目数量

        //某体检人的所有项目组合
        List<HcAppregItemsVo> dtHc_Appreg_Items = this.findHcAppregItems(hospitalId ,personId, visitid+"", "检验");
        // 开始处理每一个预约的项目组合(检验)
        //================================================================================
        int pcount = dtHc_Appreg_Items == null ? 0 : dtHc_Appreg_Items.size();
        if (pcount == 0){
            return "-1";
        }

        String test_Tube_Color;
        //对项目组合进行循环处理, 过滤FINISHED_SIGN=完成，RESULT_RECIEVED结果所在为空或”0000“,申请单号为空
        for(int i=0; i<pcount; i++){
            //for循环个人体检项目
            HcAppregItemsVo dr = dtHc_Appreg_Items.get(i);
            ls_finished_sign = dr.getFINISHED_SIGN();
            if("完成".equals(ls_finished_sign)){
                continue;
            }
            ls_receive_server = dr.getRESULT_RECIEVED();
            if(StringUtils.isEmpty(ls_receive_server)||"0000".equals(ls_receive_server)){
                continue;
            }
            String ls_apply_no_exist = dr.getAPPLY_NO();
            //如果申请单号为空，跳过
            if (StringUtils.isEmpty(ls_apply_no_exist)) {
                continue;
            }
            ls_p_id = dr.getPERSON_ID();
            li_p_visit_id = Integer.parseInt(dr.getPERSON_VISIT_ID());
            ls_p_dept_code = dr.getHC_DEPT_CODE();
            item_assem_code = dr.getITEM_PACK_CODE();
            item_pack_name = dr.getITEM_PACK_NAME();
            ls_apply_no = ls_apply_no_exist;
            ls_p_dept_name = dr.getDEPT_NAME();
            item_no = Integer.parseInt(dr.getITEM_NO());
            // 获得外部协作参数
            String errmsg = "";//returnData.getMessage();
//            String ext_sys_code = dr.getRESULT_RECIEVED();
            //判断是否存在数据库连接
//            List<Connection> drConns = pubCommService.getConnects(hospitalId, ext_sys_code);
//            if(drConns.size() == 0){
//                throw new CommonException(-1, "无法获得结果所在对应的事务。组合名称：" + item_pack_name);
//            }
//            List<FrmLabResultVo> dtLab_Result = this.findLabResultOut1(hospitalId, drConns.get(0), ls_apply_no);
            //根据申请单号查询检验项目结果
            List<FrmLabResultVo> dtLab_Result = this.findLabResultOut1(hospitalId, ls_apply_no);
            boolean import_ok = true;
            //项目组合对应的项目字典
            List<FrmPackVsItems> dtPackVsItem = this.findPackVsItems(hospitalId, item_assem_code);
            //查询科室体检项目结果
            List<GetHcResultVo> dtHc_Result_Item = this.findHcResult(hospitalId, personId, visitid+"", item_assem_code, deptId);
            //查询科室阳性体征
            List<HcDeptResultItems> dt_DeptResultItems1 = this.findHcDeptResultItems(hospitalId, personId,visitid+"", ls_p_dept_code, item_assem_code, "0");
            //更新某体检人的某个项目组合
            List<FrmGetHcAppregItem> dtHc_PersonAppreg_Items = this.findHcAppregItem1(hospitalId, personId, visitid+"", item_assem_code);
            String current_doctor_name;//  体检医生
            String ls_doctor = "", ls_notes_for_spcm = "";
            List<VLabTestMaster> list = null;
            try{
                //取检验医生、标注说明
                list = this.findVLabTestMaster(ls_apply_no);
            }catch (Exception e){
                //throw new CommonException(500, "取检验医生、标注说明" +e.getMessage());
                errmsg += "取检验医生、标注说明" +e.getMessage();
            }
            if(list!=null&&list.size()>0&&StringUtils.isNotEmpty(list.get(0).getTestNo())){
                ls_doctor = list.get(0).getVerifiedBy();
                ls_notes_for_spcm = list.get(0).getNotesForSpcm();
            }

            int ret = 0;
            ReturnData returnData;
            ls_conclusion = "";
            if(dtLab_Result==null||dtLab_Result.size()==0||dtHc_PersonAppreg_Items==null||dtHc_PersonAppreg_Items.size()==0){//////////
                //throw new CommonException(500,"无法获得检验结果或者检验项目：" + item_pack_name);
                errmsg += "无法获得检验结果或者检验项目：" + item_pack_name;
            }else{
                returnData = this.importLabResult1(hospitalId, ls_apply_no, personId, visitid, item_assem_code ,ls_doctor, dtPackVsItem, dtLab_Result,
                        dtHc_Result_Item, dt_DeptResultItems1, dtHc_PersonAppreg_Items);
                ret = returnData.getCode();
                ls_conclusion = returnData.getRef();
            }
            if(ret < 0){
                ls_total_failure += "\r\n - " + item_pack_name;
                import_ok = false;
            }else if(ret == 0){
                ls_total_not_finish += "\r\n - " + item_pack_name;
                import_ok = false;
            }
            if (!import_ok) {
                continue;//如果处理失败，跳过这条
            }
            finish_cnt++;//完成数量加1
            // 保存分科体检主记录
            //获取非当前组合项目的结果
            dt_DeptResultItems1 = this.findHcDeptResultItems(hospitalId, personId, visitid+"", ls_p_dept_code, item_assem_code, "1");
            if(dt_DeptResultItems1 == null){
                return "取检验科室" + ls_p_dept_code + "的结果项目失败！";
            }
            String ls_old_conclusion = "";
            for(HcDeptResultItems drrs : dt_DeptResultItems1){
                if(ls_conclusion.contains(drrs.getContent())){
                    continue;
                }
                if(StringUtils.isEmpty(ls_old_conclusion)){
                    ls_old_conclusion = drrs.getContent();
                }else{
                    ls_old_conclusion += "\r\n" + drrs.getContent();
                }
            }
            //TODO 0826处理问题
            if(StringUtils.isEmpty(ls_conclusion)){
                ls_conclusion = ls_old_conclusion;
            }else{
                if(StringUtils.isNotEmpty(ls_old_conclusion)){
                    ls_conclusion = ls_old_conclusion + "\r\n" + ls_conclusion;
                }
            }
            if(ls_conclusion.length() > 2000){
                ls_conclusion = ls_conclusion.substring(0, 2000);
            }else if(ls_conclusion.length() == 0){
                ls_conclusion = "未见异常";
            }
            //先删除之前的分科体检结果，再重新更新插入
            QueryWrapper<HcDeptResultDict> hcDeptResultDictQueryWrapper = new QueryWrapper<>();
            hcDeptResultDictQueryWrapper.eq("HOSPITAL_ID", hospitalId)
                    .eq("PERSON_ID", ls_p_id)
                    .eq("PERSON_VISIT_ID", li_p_visit_id)
                    .eq("DEPT_ID", ls_p_dept_code);
            hcDeptResultDictService.remove(hcDeptResultDictQueryWrapper);
//            if(!){
//                errmsg = "导入检验结果:" + item_pack_name + "删除之前分科体检主记录失败！" + ls_p_dept_code;
//            }
            HcDeptResultDict hcDeptResultDict = new HcDeptResultDict();
            hcDeptResultDict.setHospitalId(hospitalId)
                    .setPersonId(ls_p_id)
                    .setPersonVisitId(li_p_visit_id)
                    .setDeptId(ls_p_dept_code)
                    .setDeptName(ls_p_dept_name)
                    .setHcResultDate(new Date())
                    .setMedInDeptReport("1")
                    .setDoctorName(ls_doctor)
                    .setOperator(loadLabVo.getUserName())
                    .setOperatorName(loadLabVo.getUserRealName())
                    .setConclusionText(ls_conclusion);
            if(!hcDeptResultDictService.save(hcDeptResultDict)){
                errmsg = "导入检验结果:" + item_pack_name + "保存分科体检主记录失败！" + ls_p_dept_code;
            }
            if(loadLabVo.getResStatus() < 2){
                if(!divDocDepartMapper.updatePersonVisitInfo(ls_p_id, li_p_visit_id)){
                    errmsg = "导入检验结果:" + item_pack_name + "更新体检结果状态时出错！";
                }
            }
            if(StringUtils.isEmpty(errmsg)){
                ls_total_commit += "\r\n - " + item_pack_name;
            }else{
                throw new CommonException(500, "保存失败！" + errmsg);
            }
        }
        String op_message = "";
        if(StringUtils.isNotEmpty(ls_total_failure)){
            op_message += "导入失败的项目包括:" + ls_total_failure + "\r\n";
        }
        if (StringUtils.isNotEmpty(ls_total_not_finish)){
            op_message += "未完成的项目包括:" + ls_total_not_finish + "\r\n";
        }
        if (StringUtils.isNotEmpty(ls_total_commit)){
            op_message += "导入成功的项目包括:" + ls_total_commit + "\r\n";
        }
        return op_message;
    }

    private ReturnData importLabResult1(String hospitalId, String ls_apply_no, String personId, int visitid, String itemPackCode, String ls_doctor,
                                        List<FrmPackVsItems> dtpackvsitem, List<FrmLabResultVo> dtLab_result,
                                        List<GetHcResultVo> dtHc_result_item, List<HcDeptResultItems> dt_deptResultItems1,
                                        List<FrmGetHcAppregItem> dtHc_personAppreg_items) {
        ReturnData returnData = new ReturnData();
        String ls_item_pack_name; //项目组合名称
        String ls_pack_sort_no; //项目组合名称在科室中对应的排列序号
        String ls_Hc_dept_code, ls_Hc_dept_name;  //项目组合对应的科室代码和名
        String ls_result_handle; //获得项目组合代码处理阳性体征的方法
        String ls_unit_id;
        int unit_visit_id;
        Date sysdatetime; //系统时间
        List<FrmItemVsExternal> dt_item_vs_external;
        List<FrmLabResultVo> dtresultlab = dtLab_result;
        List<FrmGetHcAppregItem> dt_personal_items = dtHc_personAppreg_items;
        List<FrmGetHcAppregItem> drrows = new ArrayList<>();
        for(FrmGetHcAppregItem frmGetHcAppregItem : dt_personal_items){
            if(frmGetHcAppregItem.getPERSON_ID().equals(personId)&&frmGetHcAppregItem.getPERSON_VISIT_ID().equals(visitid+"")&&frmGetHcAppregItem.getITEM_PACK_CODE().equals(itemPackCode)){
                drrows.add(frmGetHcAppregItem);
            }
        }
//        List<FrmGetHcAppregItem> drrows = dt_personal_items.stream().filter(frmGetHcAppregItem -> frmGetHcAppregItem.getPERSON_ID().equals(personId))
//                .filter(frmGetHcAppregItem -> frmGetHcAppregItem.getPERSON_VISIT_ID().equals(visitid))
//                .filter(frmGetHcAppregItem -> frmGetHcAppregItem.getITEM_PACK_CODE().equals(itemPackCode)).collect(Collectors.toList());
        if(drrows.size() < 1){
            returnData.setCode(-1);
            returnData.setMessage("未查询到:" + itemPackCode + "的项目!");
            return returnData;
        }
        ls_item_pack_name = drrows.get(0).getITEM_PACK_NAME();
        ls_Hc_dept_name = drrows.get(0).getDEPT_NAME();
        ls_Hc_dept_code = drrows.get(0).getDEPT_CODE();
        ls_Hc_dept_name = drrows.get(0).getDEPT_NAME();
        ls_pack_sort_no = StringUtils.isEmpty(drrows.get(0).getITEM_NO()) ? "" : drrows.get(0).getITEM_NO();
        String content_list = "";
        //=============获得项目组合代码处理阳性体征的方法
        /*
        1每条阳性一条记录
        2把所有阳性合并成一条，中间以、连接
        3把所有阳性合并成一条，中间以"\R\N"连接
        */
        List<VHcItemPackDict> ds = this.findVHcItemPackDict(hospitalId, itemPackCode);
        if(ds!=null&&ds.size()>0){
            ls_result_handle = ds.get(0).getResultHandle();
            if(StringUtils.isEmpty(ls_result_handle)){
                ls_result_handle = "1";
            }else if(!("1".equals(ls_result_handle)||"2".equals(ls_result_handle)||"3".equals(ls_result_handle))){
                ls_result_handle = "1";
            }
        }else{
            returnData.setCode(-1);
            returnData.setMessage("未查询到:" + itemPackCode + "的项目!");
            return returnData;
        }
        //====获取单位代码和单位体检次数===
        QueryWrapper<HcPersonVisitInfo> hcPersonVisitInfoQueryWrapper = new QueryWrapper<>();
        hcPersonVisitInfoQueryWrapper.eq("hospital_id", hospitalId).eq("person_id", personId).eq("person_visit_id", visitid);
        List<HcPersonVisitInfo> personList = hcPersonVisitInfoService.list(hcPersonVisitInfoQueryWrapper);
        if (personList!=null&&personList.size()>0){
            ls_unit_id = personList.get(0).getUnitId();
            unit_visit_id = personList.get(0).getUnitVisitId();
        }else{
            returnData.setCode(-1);
            returnData.setMessage("导入检验结果未找到本次体检单位");
            return returnData;
        }
        sysdatetime = new Date();
        //=============== 开始判断检验项目组合对应的项目情况==============
        //List<FrmPackVsItems> dtpackvsitem = this.findPackVsItems(hospitalId, itemPackCode);
        int item_count = 0; //项目组合对应的项目数量
        if(dtpackvsitem!=null && dtpackvsitem.size()>0){
            item_count = dtpackvsitem.size();
        }
        if(item_count == 0){
            returnData.setCode(-1);
            returnData.setMessage("导入检验结果项目组合代码:" + itemPackCode + "没有对应项目");
            return returnData;
        }
        int external_count = 0, item_order_no;
        String ls_item_code, ls_item_name, ls_ext_code, ls_show_type, ls_result_type;

        // 清除可能存在的结果
        QueryWrapper<HcResultDict> hcResultDictQueryWrapper = new QueryWrapper<>();
        hcResultDictQueryWrapper
                .eq("HOSPITAL_ID", hospitalId)
                .eq("person_id", personId)
                .eq("person_visit_id", visitid)
                .eq("item_assem_code", itemPackCode);
        hcResultDictService.remove(hcResultDictQueryWrapper);
        // 先删除当前的组合所有分科结果项目，重新插入
        QueryWrapper<HcDeptResultItems> hcDeptResultItemsQueryWrapper = new QueryWrapper<>();
        hcDeptResultItemsQueryWrapper
                .eq("HOSPITAL_ID", hospitalId)
                .eq("person_id", personId)
                .eq("person_visit_id", visitid)
                .eq("dept_id",ls_Hc_dept_code)
                .eq("item_assem_code", itemPackCode);
        hcDeptResultItemsService.remove(hcDeptResultItemsQueryWrapper);
        String report_item_code, report_item_name;  // 检验报告项目代码,检验报告项目名称
        String ls_result, ls_units, ls_print_context, ls_abnormal_indicator;   //检验结果，单位, 正常值范围,正常标志
        BigDecimal ldec_result;    //检验数字结果
        BigDecimal value, top_v, bottom_v;
        String ls_abnormal_dept_result = "";
        int dept_sort_no = 1;
        int result_cnt = 0;
        for(int step = 0; step < item_count; step++){
            ls_item_code = dtpackvsitem.get(step).getITEM_CODE();
            ls_item_name = dtpackvsitem.get(step).getITEM_NAME();
            item_order_no = Integer.parseInt(dtpackvsitem.get(step).getITEM_NO());
            ls_show_type = dtpackvsitem.get(step).getRESULT_TYPE();
            ls_result_type = dtpackvsitem.get(step).getRESULT_TYPE();
            dt_item_vs_external = this.findItemVsExternal(hospitalId, ls_item_code);
            external_count = 0;
            if(dt_item_vs_external == null || dt_item_vs_external.size() == 0){
                continue;
            }else{
                for(FrmItemVsExternal drext : dt_item_vs_external){
                    ls_ext_code = drext.getExt_code();
                    String finalLs_ext_code = ls_ext_code;
                    List<FrmLabResultVo> drs = dtresultlab.stream().filter(frmLabResultVo -> finalLs_ext_code.equals(frmLabResultVo.getREPORT_ITEM_CODE())).collect(Collectors.toList());
                    if(drs.size()>0){
                        value = new BigDecimal(0);
                        external_count = 1;
                        report_item_code = drs.get(0).getREPORT_ITEM_CODE();
                        report_item_name = drs.get(0).getREPORT_ITEM_NAME();
                        ls_result = drs.get(0).getRESULT();
                        ls_units = drs.get(0).getUNITS();
                        ls_print_context = drs.get(0).getPRINT_CONTEXT();
                        ls_abnormal_indicator = drs.get(0).getABNORMAL_INDICATOR();
                        // 转换结果，补充正常值
                        if ("NEG".equals(ls_result.toUpperCase()))
                        {
                            ls_result = "阴性";
                        }
                        if(StringUtils.isEmpty(ls_print_context)) {
                            //如果为空，则取 项目字典表中的字段
                            String ls_bottom_v = dtpackvsitem.get(step).getBOTTOM_LIMIT();
                            String ls_top_v = dtpackvsitem.get(step).getTOP_LIMIT();
                            if (StringUtils.isEmpty(ls_top_v) || StringUtils.isEmpty(ls_bottom_v)) {//无上下限
                                ls_print_context = dtpackvsitem.get(step).getNORMAL_VALUE();
                            } else {
                                if (isInteger(ls_result)) {
                                    value = new BigDecimal(ls_result);
                                    top_v = new BigDecimal(ls_top_v);
                                    bottom_v = new BigDecimal(ls_bottom_v);
                                    if (value.compareTo(bottom_v) == -1) {
                                        ls_abnormal_dept_result = "L";
                                    } else if (value.compareTo(top_v) == 1) {
                                        ls_abnormal_indicator = "H";
                                    } else {
                                        ls_abnormal_indicator = "N";
                                    }
                                    ls_print_context = ls_bottom_v + "-" + ls_top_v;
                                }
                                ls_units = dtpackvsitem.get(step).getUNIT();
                            }
                        }
                        String ls_dec_result = "null";
                        if(StringUtils.isNotEmpty(ls_result)){
                            //不理解这块的代码的作用是什么
//                                if (decimal.TryParse(ls_result, out value))
//                                {
//                                    ls_result = value.ToString();
//                                }
                        }
                        //  写入体检结果表中并收集异常结果
                        HcResultDict hcResultDict = new HcResultDict();
                        if("2".equals(ls_Hc_dept_code)){
                            ls_show_type = "检验";
                            ls_Hc_dept_name = "检验科";
                        }else{
                            ls_show_type = "报告";
                        }
                        if("null".equals(ls_result)){
                            ls_result = "";
                        }
                        hcResultDict.setHospitalId(hospitalId).setPersonId(personId).setPersonVisitId(visitid).setDeptId(ls_Hc_dept_code)
                                .setDeptName(ls_Hc_dept_name).setItemAssemCode(itemPackCode).setItemAssemName(ls_item_pack_name).setHcItemCode(ls_item_code)
                                .setHcItemName(ls_item_name).setAssemSortNo(Integer.parseInt(ls_pack_sort_no)).setItemOrderNo(item_order_no)
                                .setShowType(ls_show_type).setResultType(ls_result_type).setKeyName(ls_result).setHcResult(ls_result)
                                .setUnit(ls_units).setPrintContext(ls_print_context).setAbnormalIndicator(ls_abnormal_indicator).setUnitId(ls_unit_id)
                                .setUnitVisitId(unit_visit_id).setHcResultDate(sysdatetime);
                        if(!"null".equals(ls_dec_result)){
                            hcResultDict.setResultDecimal(new BigDecimal(ls_dec_result));
                        }
                        try{
                            hcResultDictService.save(hcResultDict);
                        }catch (Exception e){
                            returnData.setCode(-1);
                            returnData.setMessage("插入体检结果组合：" + itemPackCode + "项目" + ls_item_code + "|" + ls_item_name + "失败");
                            return returnData;
                        }
                        //书写阳性体征
                        String restohandle = this.resultToHandle(ls_result);
                        if("1".equals(ls_result_handle)){
                            if("L".equals(ls_abnormal_indicator) || "H".equals(ls_abnormal_indicator) || "↑".equals(ls_abnormal_indicator) || "↓".equals(ls_abnormal_indicator)){
                                ls_abnormal_dept_result = ("L".equals(ls_abnormal_indicator)||"↓".equals(ls_abnormal_indicator))? ls_item_name + "偏低" : ls_item_name + "偏高";
                            }else if(!"0".equals(restohandle)){
                                ls_abnormal_dept_result = ls_item_name + restohandle;
                            }else if(ls_result.indexOf("阳性") >= 0 || ls_result.indexOf("+") >= 0){
                                ls_abnormal_dept_result = ls_item_name + ls_result;
                            }
                        }else{
                            if ("L".equals(ls_abnormal_indicator) || "H".equals(ls_abnormal_indicator) || "↑".equals(ls_abnormal_indicator) || "↓".equals(ls_abnormal_indicator)) {
                                if ("2".equals(ls_result_handle))//所有阳性合并成一条，中间以、连接
                                {
                                    if (StringUtils.isNotEmpty(ls_abnormal_dept_result)) ls_abnormal_dept_result += "、";
                                }
                                if ("3".equals(ls_result_handle))//所有阳性合并成一条，中间以"\r\n"连接
                                {
                                    if (StringUtils.isNotEmpty(ls_abnormal_dept_result)) ls_abnormal_dept_result += "\r\n";
                                }
                                ls_abnormal_dept_result += ("L".equals(ls_abnormal_indicator)||"↓".equals(ls_abnormal_indicator)) ? ls_item_name + "偏低" : ls_item_name + "偏高";
                            }
                            else if (!"0".equals(restohandle)){
                                if ("2".equals(ls_result_handle))//所有阳性合并成一条，中间以、连接
                                {
                                    if (StringUtils.isNotEmpty(ls_abnormal_dept_result)) ls_abnormal_dept_result += "、";
                                }
                                if ("3".equals(ls_result_handle))//所有阳性合并成一条，中间以"\r\n"连接
                                {
                                    if (StringUtils.isNotEmpty(ls_abnormal_dept_result)) ls_abnormal_dept_result += "\r\n";
                                }
                                ls_abnormal_dept_result += ls_item_name + restohandle;
                            }
                            else if (ls_result.indexOf("阳性") >= 0 || ls_result.indexOf("+") >= 0){
                                if ("2".equals(ls_result_handle))//所有阳性合并成一条，中间以、连接
                                {
                                    if (StringUtils.isNotEmpty(ls_abnormal_dept_result)) ls_abnormal_dept_result += "、";
                                }
                                if ("3".equals(ls_result_handle))//所有阳性合并成一条，中间以"\r\n"连接
                                {
                                    if (StringUtils.isNotEmpty(ls_abnormal_dept_result)) ls_abnormal_dept_result += "\r\n";
                                }
                                ls_abnormal_dept_result += ls_item_name + ls_result;
                            }
                        }
                        if("1".equals(ls_result_handle)&&StringUtils.isNotEmpty(ls_abnormal_dept_result)){//插入科室体检项目
                            try{
                                hcDeptResultItemsQueryWrapper.clear();//HOSPITAL_ID, PERSON_ID, PERSON_VISIT_ID, DEPT_ID, CONTENT_CLASS, CONTENT
                                hcDeptResultItemsQueryWrapper//.eq("result_cnt", result_cnt)
                                        .eq("person_id", personId)
                                        .eq("person_visit_id", visitid)
                                        .eq("dept_id", ls_Hc_dept_code)
                                        .eq("CONTENT", ls_abnormal_dept_result);
                                hcDeptResultItemsService.remove(hcDeptResultItemsQueryWrapper);
                            }catch (Exception e){
                                returnData.setMessage("删除科室" + ls_Hc_dept_code + "组合" + itemPackCode + "项目：" + ls_item_code + "内容" + ls_abnormal_dept_result + "失败");
                                return returnData;
                            }
                            try{
                                HcDeptResultItems hcDeptResultItems = new HcDeptResultItems();
                                if("2".equals(ls_Hc_dept_code)){
                                    ls_Hc_dept_name = "检验科";
                                }
                                hcDeptResultItems.setHospitalId(hospitalId).setPersonId(personId).setPersonVisitId(visitid).setDeptId(ls_Hc_dept_code).setDeptName(ls_Hc_dept_name)
                                        .setContentClass("1").setContent(ls_abnormal_dept_result).setDescription("").setSortNo(dept_sort_no).setItemAssemCode(itemPackCode)
                                        .setInDeptReport("0").setInChiefReport("0").setGuideContent("").setHcItemCode(ls_item_code);
                                hcDeptResultItemsService.save(hcDeptResultItems);
                            }catch (Exception e){
                                returnData.setMessage("插入阳性体征：" + itemPackCode + "项目" + ls_item_code + "|" + ls_item_name + "内容：" + ls_abnormal_dept_result + "失败");
                            }
                            if(StringUtils.isEmpty(content_list)){
                                content_list = ls_abnormal_dept_result;
                            }else{
                                content_list += "\r\n"+ls_abnormal_dept_result;
                            }
                            ls_abnormal_dept_result = "";
                            dept_sort_no++;
                        }
                        result_cnt++;
                    }else {
                        continue;
                    }
                }
            }
        }
        if(result_cnt == 0){//项目没有结果
            returnData.setCode(0);
            return returnData;
        }
        UpdateWrapper<HcPersonAppregItems> hcPersonAppregItemsUpdateWrapper = new UpdateWrapper<>();
        hcPersonAppregItemsUpdateWrapper.eq("hospital_id", hospitalId)
                .eq("person_id", personId)
                .eq("person_visit_id", visitid)
                .eq("ITEM_PACK_CODE", itemPackCode);
        HcPersonAppregItems hcPersonAppregItems = new HcPersonAppregItems();
        hcPersonAppregItems.setFinishedSign("完成");
        hcPersonAppregItems.setFinishedDate(new Date());
        hcPersonAppregItems.setDoctorName(ls_doctor);
        try {
            hcPersonAppregItemsService.update(hcPersonAppregItems, hcPersonAppregItemsUpdateWrapper);
        }catch (Exception e){
            returnData.setMessage("更新体检号：" + personId + "第" + visitid + "次" + "组合" + itemPackCode + "完成状态失败");
            return returnData;
        }
        returnData.setCode(1);
        returnData.setRef(content_list);
        return returnData;
    }

    @Transactional
    @Override
    public String loadImportExamResult(LoadExamVo loadExamVo){
        String hospitalId = loadExamVo.getHospitalId();
        String personId = loadExamVo.getPersonId();
        String visitId = loadExamVo.getPersonVisitId()+"";
        String ls_finished_sign; //完成标志，结果状态
        String ls_apply_no;   //检验申请号
        int li_pack_sort_no,li_item_order_no;        // 检查项目序号
        String ls_p_id, ls_p_dept_code, ls_p_dept_name,ls_unit_id;  //体检号，体检科室
        int li_p_visit_id,unit_visit_id;
        String item_pack_name, item_pack_code,item_code,item_name;
        String ls_total_not_finish = "";   // 保存结果尚未完成的检验项目
        String ls_total_commit = "";      // 保存成功导入的检验项目
        String ls_total_failure = "";         // 保存导入过程中失败的检验项目
        String ls_receive_server;
        String impression, description, recommendation, exam_para;
        String ls_old_conclusion, ls_old_impression, ls_old_recommendation;
        //某体检人的所有项目组合
        List<HcAppregItemsVo> dtHc_Appreg_Items = this.findHcAppregItems(hospitalId, personId, visitId, "检查");
        //================================================================================
        // 开始处理每一个预约的项目组合(检验)
        //================================================================================
        int pcount = dtHc_Appreg_Items==null ? 0 : dtHc_Appreg_Items.size();
        if(pcount == 0){
            return "0";
        }
        //循环处理
        // 对于每一个预约的检验项目组合
        String test_Tube_Color;
        //对项目组合进行循环处理
        List<HcDeptResultItems> dt_DeptResultItems1 = null;
        String errMessage = "";
        for(int i=0; i<pcount; i++){
            HcAppregItemsVo dr = dtHc_Appreg_Items.get(i);
            ls_finished_sign = dr.getFINISHED_SIGN();
            if("完成".equals(ls_finished_sign)||"拒检".equals(ls_finished_sign) || "待检".equals(ls_finished_sign) || "补检".equals(ls_finished_sign)){
                continue;
            }
            ls_receive_server = dr.getRESULT_RECIEVED();
            if(StringUtils.isEmpty(ls_receive_server)||"0000".equals(ls_receive_server)){
                continue;
            }
            String ls_apply_no_exist = dr.getAPPLY_NO();
            //如果申请单号为空，跳过
            if(StringUtils.isEmpty(ls_apply_no_exist)){
                continue;
            }
            ls_p_id = dr.getPERSON_ID();
            li_p_visit_id = Integer.parseInt(dr.getPERSON_VISIT_ID());
            ls_p_dept_code = dr.getHC_DEPT_CODE();
            item_pack_code = dr.getITEM_PACK_CODE();
            item_pack_name = dr.getITEM_PACK_NAME();
            ls_apply_no = ls_apply_no_exist;
            ls_p_dept_name = dr.getDEPT_NAME();
            li_pack_sort_no = dr.getITEM_NO()==null?1:Integer.parseInt(dr.getITEM_NO());
            ls_unit_id = dr.getUNIT_ID();
            unit_visit_id = Integer.parseInt(dr.getUNIT_VISIT_ID());
            // 获得外部协作参数
            String ext_sys_code = dr.getRESULT_RECIEVED();
            //判断是否存在数据库连接
            if(StringUtils.isEmpty(item_pack_code)){
                errMessage += ";没有找到项目组合名称为：" + item_pack_name+"的对应项目！";
                continue;
            }
//            List<Connection> drConns = pubCommService.getConnects(hospitalId, ext_sys_code);
//            if(drConns==null || drConns.size() == 0){
//                errMessage += ";无法获得结果所在对应的事务。组合名称：" + item_pack_name;
//            }
//            Connection conn = drConns.get(0);
//            QueryRunner queryRunner = new QueryRunner();
//            StringBuilder sql = new StringBuilder();
            QueryWrapper<HcExamMaster> hcExamMasterQueryWrapper = new QueryWrapper<>();
            hcExamMasterQueryWrapper.eq("exam_no", ls_apply_no)
                    .in("result_status", "3", "4");
            int count = (int) hcExamMasterService.count(hcExamMasterQueryWrapper);
            //sql.append("select count(*) from HC_EXAM_MASTER where exam_no='" + ls_apply_no + "' and result_status in ('3','4')");
//            BigDecimal count = null;
//            try {
//                count = queryRunner.query(conn, sql.toString(), new ScalarHandler<BigDecimal>());
//            }catch (Exception e){
//                errMessage += ";查询EXAM_MASTER失败。单据：" + ls_apply_no;
//            }
            int exam_res_count = count;
//            if(count != null){
//                exam_res_count = count.intValue();
//            }
            if(exam_res_count == 0){
                ls_total_not_finish += "\r\n - " + item_pack_name;
                continue;
            }
            //sql.setLength(0);
            QueryWrapper<HcExamReport> hcExamReportQueryWrapper = new QueryWrapper<>();
            hcExamReportQueryWrapper.eq("exam_no", ls_apply_no);
            count = (int) hcExamReportService.count(hcExamReportQueryWrapper);
//            sql.append("select count(*) from EXAM_REPORT where exam_no='" + ls_apply_no + "'");
//            try {
//                count = queryRunner.query(conn, sql.toString(), new ScalarHandler<BigDecimal>());
//            }catch (Exception e){
//                throw new CommonException(-1, "查询EXAM_REPORT失败。单据：" + ls_apply_no+"");
//            }
            exam_res_count = count;
//            if(count!=null){
//                exam_res_count = count.intValue();
//            }
            if(exam_res_count == 0){
                ls_total_not_finish += "\r\n - " + item_pack_name;
                continue;
            }
            List<FrmPackVsItems> dtPackVsItem = this.findPackVsItems1(hospitalId, item_pack_code);
            if(dtPackVsItem == null || dtPackVsItem.size() == 0){
                errMessage += ";没有找到组合名称为"+ item_pack_name+"对应的项目!";
                continue;
            }
            item_code = dtPackVsItem.get(0).getITEM_CODE();
            item_name = dtPackVsItem.get(0).getITEM_NAME();
            li_item_order_no = Integer.parseInt(dtPackVsItem.get(0).getITEM_NO());

            description = ""; //检查所见
            impression = ""; //异常诊断
            recommendation = "";  //建议
            exam_para = "";      //检查参数

            //按检查申请号导入检查结果
            QueryWrapper<VExamReport> vExamReportQueryWrapper = new QueryWrapper<>();
            vExamReportQueryWrapper.eq("exam_no", ls_apply_no);
            List<VExamReport> ds = null;
            try{
                ds = vExamReportService.list(vExamReportQueryWrapper);
            }catch (Exception e){
                ls_total_failure += "\r\n - " + item_pack_name;
                continue;
            }
            // 保存分科体检主记录
            description = ds.get(0).getDescription();
            impression = ds.get(0).getImpression();
            recommendation = ds.get(0).getRecommendation();
            exam_para = ds.get(0).getExamPara();
            //取检查医生
            String ls_doctor="", ls_exam_class="";
            QueryWrapper<VExamMaster> vExamMasterQueryWrapper = new QueryWrapper<>();
            vExamMasterQueryWrapper.eq("exam_no", ls_apply_no);
            List<VExamMaster> ds1 = null;
            try{
                ds1 = vExamMasterService.list(vExamMasterQueryWrapper);
            }catch (Exception e){
                errMessage += ";取检查医生失败" + ls_apply_no + e.getMessage();
                continue;
            }
            if(ds1!=null&&ds1.size()>0){
                ls_doctor = ds1.get(0).getReporter();
                ls_exam_class = ds1.get(0).getExamClass();
            }
            //===开始处理科室小结===
            ls_old_conclusion = "";
            ls_old_recommendation = "";
            boolean isInsert = true;//是否插入
            List<HcDeptResultDict> dt_DeptResult = this.findHcDeptResult(hospitalId, personId, visitId, ls_p_dept_code);//获取科室结果
//            if(dt_DeptResult.get(0).getPersonId() == null){
//                errMessage += ";无法获得分科结果!"+ ls_p_dept_code;
//                continue;
//            }
            if(dt_DeptResult.size()>0&&StringUtils.isNotEmpty(dt_DeptResult.get(0).getPersonId())){
                ls_old_conclusion = dt_DeptResult.get(0).getConclusionText();
                ls_old_recommendation = dt_DeptResult.get(0).getSuggestText();
                isInsert = false;
            }
            if (StringUtils.isNotEmpty(ls_old_conclusion))
            {
                ls_old_conclusion = impression;
            }
            else
            {
                ls_old_conclusion += "\r\n"+impression;
            }

            //===开始处理科室建议===
            if (StringUtils.isNotEmpty(ls_old_recommendation))
            {
                ls_old_recommendation = recommendation;
            }
            else
            {
                ls_old_recommendation += "\r\n" + recommendation;
            }

            //OPERATOR_NAME应该使用ls_doctor这个检查报告人么，目前是赋值给医生姓名OPERATOR_NAME是保存操作员 ,CONCLUSION_TEXT,SUGGEST_TEXT   ,'"  + ls_old_conclusion + "','" + ls_old_recommendation + "'
            String fieldstr = "",valuestr="";
            HcDeptResultDict hcDeptResultDict = new HcDeptResultDict();
            if(isInsert){
                hcDeptResultDict.setHospitalId(hospitalId)
                        .setPersonId(personId)
                        .setPersonVisitId(Integer.parseInt(visitId))
                        .setDeptId(ls_p_dept_code)
                        .setDeptName(ls_p_dept_name)
                        .setHcResultDate(new Date())
                        .setMedInDeptReport("1")
                        .setDoctorName(ls_doctor)
                        .setOperator(loadExamVo.getUserName())
                        .setOperatorName(loadExamVo.getUserRealName())
                        .setChiefSumFlag("1");
                if(StringUtils.isNotEmpty(impression)){
                    hcDeptResultDict.setConclusionText(ls_old_conclusion);
                }
                if(StringUtils.isNotEmpty(recommendation)){
                    hcDeptResultDict.setSuggestText(ls_old_recommendation);
                }
                if(!hcDeptResultDictService.save(hcDeptResultDict)){
                    errMessage += ";导入检查结果:" + item_pack_name + "保存分科体检主记录失败！";
                }
            }else{
                UpdateWrapper<HcDeptResultDict> hcDeptResultDictUpdateWrapper = new UpdateWrapper<>();
                HcDeptResultDict hcDeptResultDictWhere = new HcDeptResultDict();

                hcDeptResultDictUpdateWrapper.eq("hospital_id", hospitalId);
                hcDeptResultDictUpdateWrapper.eq("person_id", personId);
                hcDeptResultDictUpdateWrapper.eq("person_visit_id", visitId);
                hcDeptResultDictUpdateWrapper.eq("dept_id", ls_p_dept_code);

//                hcDeptResultDictUpdateWrapper.set("HC_RESULT_DATE", new Date())
//                        .set("MED_IN_DEPT_REPORT", "1")
//                        .set("DOCTOR_NAME", ls_doctor)
//                        .set("OPERATOR", loadExamVo.getUserName())
//                        .set("OPERATOR_NAME", loadExamVo.getUserRealName())
//                        .set("CHIEF_SUM_FLAG", "1")
//                        .set(StringUtils.isNotEmpty(impression), "CONCLUSION_TEXT", ls_old_conclusion)
//                        .set(StringUtils.isNotEmpty(recommendation), "SUGGEST_TEXT", ls_old_recommendation);
                hcDeptResultDictWhere.setHcResultDate(new Date());
                hcDeptResultDictWhere.setMedInDeptReport("1");
                hcDeptResultDictWhere.setDeptName(ls_p_dept_name);
                hcDeptResultDictWhere.setOperator(loadExamVo.getUserName());
                hcDeptResultDictWhere.setOperatorName(loadExamVo.getUserRealName());
                hcDeptResultDictWhere.setChiefSumFlag("1");
                if(StringUtils.isNotEmpty(impression)){
                    hcDeptResultDictWhere.setConclusionText(ls_old_conclusion);
                }
                if(StringUtils.isNotEmpty(recommendation)){
                    hcDeptResultDictWhere.setSuggestText(ls_old_recommendation);
                }
                if(!hcDeptResultDictService.update(hcDeptResultDictWhere, hcDeptResultDictUpdateWrapper)){
                    errMessage += ";导入检查结果:" + item_pack_name + "保存分科体检主记录失败！";
                }
            }
            // 开始保存分科体检明细记录
            dt_DeptResultItems1 = this.findDeptResultItems(hospitalId, personId, visitId, ls_p_dept_code);
            String ls_result_handle = dr.getRESULT_HANDLE();
            if(StringUtils.isEmpty(ls_result_handle)){
                ls_result_handle = "1";
            }else if(!"1".equals(ls_result_handle) || !"2".equals(ls_result_handle) || !"3".equals(ls_result_handle) || !"4".equals(ls_result_handle)) {
                ls_result_handle = "1";
            }
            int dept_sort_no = dt_DeptResultItems1 == null ? 1 : dt_DeptResultItems1.size() + 1;
            List<HcDeptResultItems> dataRows;
            if(StringUtils.isNotEmpty(impression)){//处理诊断
                String[] line_impress = impression.split("/r/n");
                if("1".equals(ls_result_handle)){
                    line_impress = new String[1];
                    line_impress[0] = impression.trim();
                }
                for(int j=0; j<line_impress.length; j++){
                    if(dt_DeptResultItems1 !=null && dt_DeptResultItems1.size()>0){
                        int finalJ = j;
                        String[] finalLine_impress = line_impress;
                        dataRows = dt_DeptResultItems1.stream().filter(hcDeptResultItems -> finalLine_impress[finalJ].equals(hcDeptResultItems.getContent())).collect(Collectors.toList());
                        if(dataRows.size()>0){
                            continue;//如果结果内容相同，跳过
                        }
                        HcDeptResultItems hcDeptResultItems = new HcDeptResultItems();
                        //处理recommendation 体检建议 参数
                        if(StringUtils.isEmpty(recommendation)){
                            recommendation = "";
                        }
                        hcDeptResultItems.setHospitalId(hospitalId)
                                .setPersonId(personId)
                                .setPersonVisitId(Integer.parseInt(visitId))
                                .setDeptId(ls_p_dept_code)
                                .setDeptName(ls_p_dept_name)
                                .setContentClass("2")
                                .setContent(line_impress[j])
                                .setSortNo(dept_sort_no)
                                .setItemAssemCode(item_pack_code)
                                .setInDeptReport("0")
                                .setInChiefReport("0")
                                .setGuideContent(recommendation.trim())
                                .setHcItemCode(item_code);
                        if(!hcDeptResultItemsService.save(hcDeptResultItems)){
                            errMessage +=  "插入分科建议记录：组合" + item_pack_name +"内容"+ line_impress[j] + "失败; ";
                        }
                        dept_sort_no++;
                    }
                }
            }
            //=================开始汇总结果======
            String ls_conclusion = "";
            if(StringUtils.isNotEmpty(exam_para)){
                ls_conclusion += "【检查参数】" + "\r\n" + exam_para;
            }
            if(StringUtils.isNotEmpty(description)){
                if(StringUtils.isEmpty(ls_conclusion)){
                    ls_conclusion = "【检查所见】" + "\r\n" + description;
                }
                else{
                    ls_conclusion += "\r\n" + "【检查所见】" + "\r\n" + description;
                }
            }
            if(StringUtils.isNotEmpty(impression)){
                if (StringUtils.isEmpty(ls_conclusion)){
                    ls_conclusion = "【印 象】" + "\r\n" + impression;
                }
                else{
                    ls_conclusion += "\r\n" + "【印 象】" + "\r\n" + impression;
                }
            }
            // 清除可能存在的结果
            QueryWrapper<HcResultDict> hcResultDictQueryWrapper = new QueryWrapper<>();
            hcResultDictQueryWrapper.eq("HOSPITAL_ID",hospitalId)
                    .eq("person_id",personId)
                    .eq("person_visit_id",visitId)
                    .eq("item_assem_code", item_pack_code);
            if(!hcResultDictService.remove(hcResultDictQueryWrapper)){
//                errMessage += "删除检查组合" + item_pack_code + "结果失败; ";
            }
            //  写入体检结果表中并收集异常结果
            HcResultDict hcResultDict = new HcResultDict();
            String showType11 = "";
            if("2".equals(ls_p_dept_code)){
                showType11 = "检验";
            }else{
                showType11 = "报告";
            }
            if("null".equals(ls_conclusion)){
                ls_conclusion = "";
            }
            hcResultDict.setHospitalId(hospitalId)
                    .setPersonId(personId)
                    .setPersonVisitId(Integer.parseInt(visitId))
                    .setDeptId(ls_p_dept_code)
                    .setDeptName(ls_p_dept_name)
                    .setItemAssemCode(item_pack_code)
                    .setItemAssemName(item_pack_name)
                    .setHcItemCode(item_code)
                    .setHcItemName(item_name)
                    .setAssemSortNo(li_pack_sort_no)
                    .setItemOrderNo(li_item_order_no)
                    .setShowType(showType11)
                    .setResultType("字符")
                    .setKeyName(ls_conclusion)
                    .setHcResult(ls_conclusion)
                    .setUnitId(ls_unit_id)
                    .setUnitVisitId(unit_visit_id)
                    .setHcResultDate(new Date());
            if(!hcResultDictService.save(hcResultDict)){
               errMessage +=  "插入体检结果组合：" + item_pack_code + "项目" + item_code + "|" + item_name + "失败; ";
            }
            //完成组合项目
            UpdateWrapper<HcPersonAppregItems> hcPersonAppregItemsUpdateWrapper = new UpdateWrapper<>();
            hcPersonAppregItemsUpdateWrapper.set("finished_sign","完成")
                    .set("finished_date", new Date());
            if(StringUtils.isNotEmpty(ls_doctor)){
                hcPersonAppregItemsUpdateWrapper.set("doctor_name", ls_doctor);
            }
            hcPersonAppregItemsUpdateWrapper.eq("HOSPITAL_ID",hospitalId)
                    .eq("person_id",personId)
                    .eq("person_visit_id",visitId)
                    .eq("item_pack_code", item_pack_code);
            if(!hcPersonAppregItemsService.update(hcPersonAppregItemsUpdateWrapper)){
                errMessage += "更新体检号：" + personId + "第" + visitId + "次" + "组合" + item_pack_code + "完成状态失败; ";
            }
            if(loadExamVo.getResStatus()<2){
                if(!divDocDepartMapper.updatePersonVisitInfo(personId, Integer.parseInt(visitId))){
                    errMessage += "导入检验结果:" + item_pack_name + "更新体检结果状态时出错！";
                }
            }
        }
        if(StringUtils.isNotEmpty(errMessage)){
            return errMessage;
        }
        String op_message = "";
        if (StringUtils.isNotEmpty(ls_total_failure)){
            op_message += "导入失败的检查项目包括:" + ls_total_failure + "\r\n";
        }
        if (StringUtils.isNotEmpty(ls_total_not_finish)){
            op_message += "未完成的检查项目包括:" + ls_total_not_finish + "\r\n";
        }
        if (StringUtils.isNotEmpty(ls_total_commit)){
            op_message += "导入成功的检查项目包括:" + ls_total_commit + "\r\n";
        }
        return op_message;
    }

    @Override
    public List<LoadDeptDictVo> loadDeptDict(String hospitalId) {
        List<LoadDeptDictVo> list = divDocDepartMapper.loadDeptDict(hospitalId);
        if(list.size() == 0){
            list.add(new LoadDeptDictVo());
        }
        return list;
    }

    @Override
    public List<DeptDiseaseGroupVo> getDeptDiseaseGroup(String hospitalId, String deptId) {
        List<DeptDiseaseGroupVo> list = divDocDepartMapper.getDeptDiseaseGroup(hospitalId, deptId);
        if (list.size() == 0){
            list.add(new DeptDiseaseGroupVo());
        }
        return list;
    }

    @Override
    public List<HcDiseaseDict> getHcDiseaseDict(String hospitalId, String diseaseCode, String deptId) {
        List<HcDiseaseDict> list = divDocDepartMapper.getHcDiseaseDict(hospitalId, diseaseCode, deptId);
        if (list.size() == 0){
            list.add(new HcDiseaseDict());
        }
        return list;
    }

    private String resultToHandle(String result){
        boolean b_ret = false;
        switch (result)
        {
            case "Ⅰ°":
                break;
            case "Ⅱ°":
                break;
            case "Ⅲ°":
            case "Ⅳ°":
            case "Ⅴ°":
            case "Ⅵ°":
            case "Ⅶ°":
                b_ret = true;
                break;
            default:
                break;
        }
        if (b_ret)
        {
            return result;
        }
        else
        {
            return "0";
        }
    }

    private boolean isInteger(String str){
        try{
            Integer.parseInt(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

}
