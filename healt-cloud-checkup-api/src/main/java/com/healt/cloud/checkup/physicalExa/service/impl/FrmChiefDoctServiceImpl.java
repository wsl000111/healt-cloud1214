package com.healt.cloud.checkup.physicalExa.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.*;
import com.healt.cloud.checkup.appointmentReg.service.UnitAppointRegService;
import com.healt.cloud.checkup.physicalExa.vo.frmChiefDoct.*;
import com.healt.cloud.checkup.service.HcAppendResultService;
import com.healt.cloud.checkup.service.HcDeptResultItemsService;
import com.healt.cloud.checkup.service.HcDiagnosisRecordService;
import com.healt.cloud.checkup.service.HcPersonVisitInfoService;
import com.healt.cloud.checkup.physicalExa.mapper.FrmChiefDoctMapper;
import com.healt.cloud.checkup.physicalExa.service.FrmChiefDoctService;
import com.healt.cloud.common.pages.PageResult;
import com.healt.cloud.resultex.exception.CommonException;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author GuYue
 * @date 2022-05-26 0:16
 * @description: TODO
 */
@Service
@AllArgsConstructor
public class FrmChiefDoctServiceImpl implements FrmChiefDoctService {

    private FrmChiefDoctMapper frmChiefDoctMapper;

    private HcAppendResultService hcAppendResultService;

    private HcDiagnosisRecordService hcDiagnosisRecordService;

    private HcDeptResultItemsService hcDeptResultItemsService;

    private HcPersonVisitInfoService hcPersonVisitInfoService;

    private UnitAppointRegService unitAppointRegService;

    @Override
    public String firstDocoter(String hospitalCode, String personId, String visitId) {
        String doctorName = frmChiefDoctMapper.firstDocoter(hospitalCode, personId, visitId);
        return doctorName==null?"":doctorName;
    }

    @Override
    @Transactional
    public String autoFinishedSign(String hospitalCode, String personId, String visitId) {
        frmChiefDoctMapper.autoFinishedSign(hospitalCode, personId, visitId);
        return "";
    }

    @Override
    public List<Map<String, String>> getItemPackName(String hospitalCode, String personId, String visitId) {
        List<Map<String, String>> list;
        list = frmChiefDoctMapper.getItemPackName(hospitalCode, personId, visitId);
        if(list == null || list.size() == 0){
            list = new ArrayList<>();
        }
        return list;
    }

    @Override
    @Transactional
    public String saveChiefDoctFirst(SaveChiefDoctFirstVo saveChiefDoctFirstVo) {
        //主检附加结果表hc_append_result
        List<SaveHcAppendResult> saveHcAppendResults = saveChiefDoctFirstVo.getSaveHcAppendResult();
        String lsSuggest = null;
        for(SaveHcAppendResult saveHcAppendResult : saveHcAppendResults){
            for(HcAppendResult result : saveHcAppendResult.getHcAppendResult()){
                lsSuggest = result.getContent();
                QueryWrapper<HcAppendResult> hcAppendResultQueryWrapper = new QueryWrapper<>();
                hcAppendResultQueryWrapper.eq("hospital_id", saveChiefDoctFirstVo.getHospitalId());
                hcAppendResultQueryWrapper.eq("person_id", saveChiefDoctFirstVo.getPersonId());
                hcAppendResultQueryWrapper.eq("person_visit_id", saveChiefDoctFirstVo.getPersonVisitId());
                if(StringUtils.isNotEmpty(lsSuggest)){
                    // 保存主检附加结果
                    long tcount = 0;
                    tcount = hcAppendResultService.count(hcAppendResultQueryWrapper);
                    if(tcount>0){
                        UpdateWrapper<HcAppendResult> hcAppendResultUpdateWrapper = new UpdateWrapper<>();
                        hcAppendResultUpdateWrapper.set("content", lsSuggest)
                                .eq("hospital_id", saveChiefDoctFirstVo.getHospitalId())
                                .eq("person_id", saveChiefDoctFirstVo.getPersonId())
                                .eq("person_visit_id", saveChiefDoctFirstVo.getPersonVisitId());
                        hcAppendResultService.update(hcAppendResultUpdateWrapper);
                    }else{
                        hcAppendResultService.save(result);
                    }
                }else{
                    hcAppendResultService.remove(hcAppendResultQueryWrapper);
                }
            }
        }
        //设置初步审核标志
        UpdateWrapper<HcPersonVisitInfo> hcPersonVisitInfoUpdateWrapper = new UpdateWrapper<>();
        hcPersonVisitInfoUpdateWrapper.set("result_status", saveChiefDoctFirstVo.getResultStatus())
                .set("first_docoter", saveChiefDoctFirstVo.getFirstDocoter())
                .set("first_date", new Date())
                .set("first_name", saveChiefDoctFirstVo.getFirstName())
                .eq("hospital_id", saveChiefDoctFirstVo.getHospitalId())
                .eq("person_id", saveChiefDoctFirstVo.getPersonId())
                .eq("person_visit_id", saveChiefDoctFirstVo.getPersonVisitId());
        hcPersonVisitInfoService.update(hcPersonVisitInfoUpdateWrapper);

        //体检诊断记录
        List<SaveHcDiagnosisRecord> saveHcDiagnosisRecords = saveChiefDoctFirstVo.getSaveHcDiagnosisRecord();
        if(saveHcDiagnosisRecords!=null && saveHcDiagnosisRecords.size()>0){
            for(SaveHcDiagnosisRecord saveHcDiagnosisRecord : saveHcDiagnosisRecords){

                List<HcDiagnosisRecord> hcDiagnosisRecords = saveHcDiagnosisRecord.getHcDiagnosisRecord();
                if("del".equals(saveHcDiagnosisRecord.getStat())){
                    QueryWrapper<HcDiagnosisRecord> queryWrapper = new QueryWrapper<>();
                    queryWrapper.eq("HOSPITAL_ID", hcDiagnosisRecords.get(0).getHospitalId())
                    .eq("PERSON_ID", hcDiagnosisRecords.get(0).getPersonId())
                    .eq("PERSON_VISIT_ID", hcDiagnosisRecords.get(0).getPersonVisitId());
                    hcDiagnosisRecordService.remove(queryWrapper);
                }else{
                    QueryWrapper<HcDiagnosisRecord> queryWrapper = new QueryWrapper<>();
                    queryWrapper.eq("HOSPITAL_ID", hcDiagnosisRecords.get(0).getHospitalId())
                            .eq("PERSON_ID", hcDiagnosisRecords.get(0).getPersonId())
                            .eq("PERSON_VISIT_ID", hcDiagnosisRecords.get(0).getPersonVisitId());
                    hcDiagnosisRecordService.remove(queryWrapper);
                    for(HcDiagnosisRecord hcDiagnosisRecord : hcDiagnosisRecords){
                        hcDiagnosisRecordService.save(hcDiagnosisRecord);
                    }
                }
                //查询是否存在记录 表 HC_DIAGNOSIS_RECORD体检诊断记录
//                for(HcDiagnosisRecord hcDiagnosisRecord : saveHcDiagnosisRecord.getHcDiagnosisRecord()){
                    //主键 hospital_id,person_id,person_visit_id,rec_class,rec_content
//                    QueryWrapper<HcDiagnosisRecord> queryWrapper = new QueryWrapper<>();
//                    queryWrapper.eq("HOSPITAL_ID", hcDiagnosisRecord.getHospitalId())
//                            .eq("PERSON_ID", hcDiagnosisRecord.getPersonId())
//                            .eq("PERSON_VISIT_ID", hcDiagnosisRecord.getPersonVisitId())
//                            .eq("rec_content", hcDiagnosisRecord.getRecContent())
//                            .eq("rec_class", hcDiagnosisRecord.getSortNo());
//                    if("delete".equals(saveHcDiagnosisRecord.getStat())){//如果是删除标记
//                        hcDiagnosisRecordService.remove(queryWrapper);
//                        continue;
//                    }
//                    List<HcDiagnosisRecord> list = hcDiagnosisRecordService.list(queryWrapper);
//                    if(list!=null && list.size()>0){//修改
//                        UpdateWrapper<HcDiagnosisRecord> updateWrapper = new UpdateWrapper<>();
//                        queryWrapper.eq("HOSPITAL_ID", hcDiagnosisRecord.getHospitalId())
//                                .eq("PERSON_ID", hcDiagnosisRecord.getPersonId())
//                                .eq("PERSON_VISIT_ID", hcDiagnosisRecord.getPersonVisitId())
//                                .eq("rec_content", hcDiagnosisRecord.getRecContent())
//                                .eq("rec_class", hcDiagnosisRecord.getSortNo());
//                        hcDiagnosisRecordService.update(hcDiagnosisRecord, updateWrapper);
//                    }else{//新增
//                        hcDiagnosisRecordService.save(hcDiagnosisRecord);
//                    }
//                }
            }
        }
        return "";
    }

    @Override
    @Transactional
    public String saveChiefDoctFinal(SaveChiefDoctFinalVo saveChiefDoctFinalVo) {
        String hospitalId = saveChiefDoctFinalVo.getHospitalId();
        String personId = saveChiefDoctFinalVo.getPersonId();
        String personVisitId = saveChiefDoctFinalVo.getPersonVisitId();

        this.autoFinishedSign(hospitalId, personId, personVisitId);

        String resultStatus = saveChiefDoctFinalVo.getResultStatus();
        List<SaveHcAppendResult> saveHcAppendResults = saveChiefDoctFinalVo.getSaveHcAppendResult();
        for(SaveHcAppendResult saveHcAppendResult : saveHcAppendResults){
            List<HcAppendResult> hcAppendResults = saveHcAppendResult.getHcAppendResult();
            for(HcAppendResult result : hcAppendResults){
                String suggest = result.getContent();
                if(StringUtils.isNotEmpty(suggest)){
                    QueryWrapper<HcAppendResult> hcAppendResultQueryWrapper = new QueryWrapper<>();
                    hcAppendResultQueryWrapper.eq("hospital_id", hospitalId)
                            .eq("person_id", personId)
                            .eq("person_visit_id", personVisitId);
                    long count = hcAppendResultService.count(hcAppendResultQueryWrapper);
                    if(count > 0){
                        UpdateWrapper<HcAppendResult> hcAppendResultUpdateWrapper = new UpdateWrapper<>();
                        hcAppendResultUpdateWrapper.set("content", result.getContent())
                                .eq("hospital_id", hospitalId)
                                .eq("person_id", personId)
                                .eq("person_visit_id", personVisitId);
                        hcAppendResultService.update(hcAppendResultUpdateWrapper);
                    }else {
                        hcAppendResultService.save(result);
                    }
                }else {
                    QueryWrapper<HcAppendResult> hcAppendResultQueryWrapper = new QueryWrapper<>();
                    hcAppendResultQueryWrapper.eq("hospital_id", hospitalId)
                            .eq("person_id", personId)
                            .eq("person_visit_id", personVisitId);
                    hcAppendResultService.remove(hcAppendResultQueryWrapper);
                }
            }
        }

        List<SaveHcDiagnosisRecord> saveHcDiagnosisRecords = saveChiefDoctFinalVo.getSaveHcDiagnosisRecord();
        if(saveHcDiagnosisRecords!=null && saveHcDiagnosisRecords.size()>0){
            for(SaveHcDiagnosisRecord saveHcDiagnosisRecord : saveHcDiagnosisRecords){
//                switch (saveHcDiagnosisRecord.getStat()){
//                    case "add":
//                        hcDiagnosisRecordService.saveBatch();
//                        break;
//                    case "update":
//                        for(HcDiagnosisRecord hcDiagnosisRecord : saveHcDiagnosisRecord.getHcDiagnosisRecord()){
//                            hcDiagnosisRecordService.saveOrUpdate(hcDiagnosisRecord);
//                        }
//                        break;
//                    case "delete":
//                        for(HcDiagnosisRecord hcDiagnosisRecord : saveHcDiagnosisRecord.getHcDiagnosisRecord()){
//                            QueryWrapper<HcDiagnosisRecord> queryWrapper = new QueryWrapper<>();
//                            queryWrapper.eq("HOSPITAL_ID", hcDiagnosisRecord.getHospitalId())
//                                    .eq("PERSON_ID", hcDiagnosisRecord.getPersonId())
//                                    .eq("PERSON_VISIT_ID", hcDiagnosisRecord.getPersonVisitId())
//                                    .eq("SORT_NO", hcDiagnosisRecord.getSortNo());
//                            hcDiagnosisRecordService.remove(queryWrapper);
//                        }
//                        break;
//                }

                List<HcDiagnosisRecord> hcDiagnosisRecords = saveHcDiagnosisRecord.getHcDiagnosisRecord();
                if("del".equals(saveHcDiagnosisRecord.getStat())){
                    QueryWrapper<HcDiagnosisRecord> queryWrapper = new QueryWrapper<>();
                    queryWrapper.eq("HOSPITAL_ID", hcDiagnosisRecords.get(0).getHospitalId())
                            .eq("PERSON_ID", hcDiagnosisRecords.get(0).getPersonId())
                            .eq("PERSON_VISIT_ID", hcDiagnosisRecords.get(0).getPersonVisitId());
                    hcDiagnosisRecordService.remove(queryWrapper);
                }else{
                    QueryWrapper<HcDiagnosisRecord> queryWrapper = new QueryWrapper<>();
                    queryWrapper.eq("HOSPITAL_ID", hcDiagnosisRecords.get(0).getHospitalId())
                            .eq("PERSON_ID", hcDiagnosisRecords.get(0).getPersonId())
                            .eq("PERSON_VISIT_ID", hcDiagnosisRecords.get(0).getPersonVisitId());
                    hcDiagnosisRecordService.remove(queryWrapper);
                    for(HcDiagnosisRecord hcDiagnosisRecord : hcDiagnosisRecords){
                        hcDiagnosisRecordService.save(hcDiagnosisRecord);
                    }
                }
//                for(HcDiagnosisRecord hcDiagnosisRecord : saveHcDiagnosisRecord.getHcDiagnosisRecord()){
//                    QueryWrapper<HcDiagnosisRecord> queryWrapper = new QueryWrapper<>();
//                    queryWrapper.eq("HOSPITAL_ID", hcDiagnosisRecord.getHospitalId())
//                            .eq("PERSON_ID", hcDiagnosisRecord.getPersonId())
//                            .eq("PERSON_VISIT_ID", hcDiagnosisRecord.getPersonVisitId())
//                            .eq("SORT_NO", hcDiagnosisRecord.getSortNo());
//                    if("delete".equals(saveHcDiagnosisRecord.getStat())){//如果是删除标记
//                        hcDiagnosisRecordService.remove(queryWrapper);
//                        continue;
//                    }
//                    List<HcDiagnosisRecord> list = hcDiagnosisRecordService.list(queryWrapper);
//                    if(list!=null && list.size()>0){//修改
//                        UpdateWrapper<HcDiagnosisRecord> updateWrapper = new UpdateWrapper<>();
//                        updateWrapper.eq("HOSPITAL_ID", hcDiagnosisRecord.getHospitalId())
//                                .eq("PERSON_ID", hcDiagnosisRecord.getPersonId())
//                                .eq("PERSON_VISIT_ID", hcDiagnosisRecord.getPersonVisitId())
//                                .eq("SORT_NO", hcDiagnosisRecord.getSortNo());
//                        hcDiagnosisRecordService.update(hcDiagnosisRecord, updateWrapper);
//                    }else{//新增
//                        hcDiagnosisRecordService.save(hcDiagnosisRecord);
//                    }
//                }
            }
        }

        //设置最终审核标志
        UpdateWrapper<HcPersonVisitInfo> hcPersonVisitInfoUpdateWrapper = new UpdateWrapper<>();
        hcPersonVisitInfoUpdateWrapper.set("result_status", "9")
                .set("FINAL_DOCOTER", saveChiefDoctFinalVo.getFinalDocoter())
                .set("FINAL_DATE", new Date())
                .set("FINAL_NAME", saveChiefDoctFinalVo.getFinalName())
                .eq("hospital_id", hospitalId)
                .eq("person_id", personId)
                .eq("person_visit_id", personVisitId);
        hcPersonVisitInfoService.update(hcPersonVisitInfoUpdateWrapper);
        return "";
    }

    @Override
    public PageResult<ChiefPersonVisitInfoVo> searchChiefDoct(SearchChiefDoctVo searchChiefDoctVo) {
        String strWhere = "";
        if(StringUtils.isEmpty(searchChiefDoctVo.getPersonId())){
            String tresultStatus = searchChiefDoctVo.getTresult_status();
            String tbegindate = "to_date('"+searchChiefDoctVo.getTbegindate()+"','yyyy-mm-dd hh24:mi:ss')";
            String tenddate = "to_date('"+searchChiefDoctVo.getTenddate()+"','yyyy-mm-dd hh24:mi:ss')";
            String resultStatus  = searchChiefDoctVo.getResultStatus();
            String printFlay = searchChiefDoctVo.getPrintFlag();
            if(StringUtils.isNotEmpty(searchChiefDoctVo.getHospitalId())||searchChiefDoctVo.getHospitalId()!="*"){
                strWhere += " and a.hospital_id = "+searchChiefDoctVo.getHospitalId();
            }
            if("0".equals(tresultStatus)){
                strWhere += " and b.appoints_date >= " + tbegindate; //预约时间
                strWhere += " and b.appoints_date <= " + tenddate;
            }else if ("1".equals(tresultStatus)){
                strWhere += " and b.before_date >= " + tbegindate; //报到时间
                strWhere += " and b.before_date <= " + tenddate;
            }else if("2".equals(tresultStatus)) {
                strWhere += " and b.first_date >= " + tbegindate; //检完时间
                strWhere += " and b.first_date <= " + tenddate;
            }else if("3".equals(tresultStatus)){
                strWhere += " and b.final_date >= " + tbegindate; //终检时间
                strWhere += " and b.final_date <= " + tenddate;
            }
            if(StringUtils.isNotEmpty(resultStatus)){
                strWhere += " and b.result_status = '"+resultStatus+"'";
            }
            if("未打印".equals(printFlay)){
                strWhere += " and print_date is null";
            }else if("已打印".equals(printFlay)){
                strWhere += " and print_date is not null";
            }
            List<ChiefPersonVisitInfoVo> list = frmChiefDoctMapper.searchChiefDoct(strWhere, searchChiefDoctVo.getPageNum(), searchChiefDoctVo.getPageSize());
            if(list.size() == 0){
                list.clear();
                list.add(new ChiefPersonVisitInfoVo());
            }
            int total = frmChiefDoctMapper.searchChiefDoctCount(strWhere);
            int pages = total%searchChiefDoctVo.getPageSize() == 0 ? total / searchChiefDoctVo.getPageSize() : total / searchChiefDoctVo.getPageSize() + 1;

            PageResult<ChiefPersonVisitInfoVo> pageResult = new PageResult<>(searchChiefDoctVo.getPageNum(), searchChiefDoctVo.getPageSize(), total, pages, list);
            return pageResult;
        }else{
            strWhere += " and b.person_id ='" + searchChiefDoctVo.getPersonId()+"'";
            strWhere += " and b.person_visit_id ='" + searchChiefDoctVo.getVisitId()+"'";
            List<ChiefPersonVisitInfoVo> list = frmChiefDoctMapper.searchChiefDoct(strWhere, searchChiefDoctVo.getPageNum(), searchChiefDoctVo.getPageSize());
            if(list.size() == 0){
                list.clear();
                list.add(new ChiefPersonVisitInfoVo());
            }
            int total = frmChiefDoctMapper.searchChiefDoctCount(strWhere);
            int pages = total%searchChiefDoctVo.getPageSize() == 0 ? total / searchChiefDoctVo.getPageSize() : total / searchChiefDoctVo.getPageSize() + 1;

            PageResult<ChiefPersonVisitInfoVo> pageResult = new PageResult<>(searchChiefDoctVo.getPageNum(), searchChiefDoctVo.getPageSize(), total, pages, list);
            return pageResult;
        }

    }

    @Override
    public List<ChiemItemStatusVo> chiemItemStatus(String hospitalId, String personId, String visitId) {
        List<ChiemItemStatusVo> list = frmChiefDoctMapper.chiemItemStatus(hospitalId, personId, visitId);
        if(list.size() == 0){
            list.add(new ChiemItemStatusVo());
        }
        return list;
    }

    @Override
    public List<HcDeptResultDict> deptchiefaudit(String hospitalId, String personId, String visitId) {
        List<HcDeptResultDict> list = frmChiefDoctMapper.deptchiefaudit(hospitalId, personId, visitId);
        if(list.size() == 0){
            list.add(new HcDeptResultDict());
        }
        return list;
    }

    @Override
    public List<HcDiagnosisRecord> dtDiagnosis(String hospitalId, String personId, String visitId) {
        QueryWrapper<HcDiagnosisRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hospital_id",hospitalId)
                .eq("person_id",personId)
                .eq("person_visit_id",visitId);
        List<HcDiagnosisRecord> list = hcDiagnosisRecordService.list(queryWrapper);
        if(list.size() == 0){
            list.add(new HcDiagnosisRecord());
        }
        return list;
    }

    @Override
    public List<HcDeptResultItems> dtDeptResultItem(String hospitalId, String personId, String visitId) {
        QueryWrapper<HcDeptResultItems> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hospital_id",hospitalId)
                .eq("person_id",personId)
                .eq("person_visit_id",visitId);
        List<HcDeptResultItems> list = hcDeptResultItemsService.list(queryWrapper);
        if(list.size() == 0){
            list.add(new HcDeptResultItems());
        }
        return list;
    }

    @Override
    public List<DtSuggestVo> dtSuggest(String hospitalId, String personId, String visitId) {
        List<DtSuggestVo> list = frmChiefDoctMapper.dtSuggest(hospitalId, personId, visitId);
        if(list.size() == 0){
            list.add(new DtSuggestVo());
        }
        return list;
    }

    @Override
    public String dtContent(String hospitalId, String personId, String visitId) {
        String content = frmChiefDoctMapper.dtContent(hospitalId, personId, visitId);
        return content==null ? "" : content;
    }

    @Override
    public PageResult<UnitPersonInfoVo> findUnitPersonInfo(SearchUnitPersonInfoVo searchUnitPersonInfoVo) {
        String hospitalId = searchUnitPersonInfoVo.getHospitalId();
        String unitId = searchUnitPersonInfoVo.getUnitId();
        String unitVisitId = searchUnitPersonInfoVo.getUnitVisitId();
        int pageSize = searchUnitPersonInfoVo.getPageSize();
        int pageNum = searchUnitPersonInfoVo.getPageNum();
        if(StringUtils.isEmpty(unitVisitId)){
            unitVisitId = unitAppointRegService.findMaxVisitId(hospitalId, unitId)+"";
            if(unitVisitId.equals("0")){
                throw new CommonException(500, "单位编码错误");
            }
        }
        List<UnitPersonInfoVo> list = frmChiefDoctMapper.selectUnitPersonInfo(hospitalId, unitId, Integer.parseInt(unitVisitId), pageSize, pageNum);
        int total = frmChiefDoctMapper.selectUnitPersonInfoTotal(hospitalId, unitId, Integer.parseInt(unitVisitId), pageSize, pageNum);
        int pages = total%pageSize == 0 ? total / pageSize : total / pageSize + 1;
        if(list.size() == 0){
            list.add(new UnitPersonInfoVo());
        }
        PageResult<UnitPersonInfoVo> pageResult = new PageResult(pageNum, pageSize, total, pages, list);
        return pageResult;
    }

    @Override
    public List<PersonHistoryInfoVo> getPersonHistory(String hospitalId, String perosnId) {
        List<PersonHistoryInfoVo> list = frmChiefDoctMapper.getPersonHistory(hospitalId, perosnId);
        if(list.size() == 0){
            list.add(new PersonHistoryInfoVo());
        }
        return list;
    }

    @Override
    public List<Map<String, String>> findGuideClass(String knowledgeType, String hospitalId) {
        List<Map<String, String>> list = frmChiefDoctMapper.findGuideClass(knowledgeType, hospitalId);
        if(list.size() == 0){
            Map<String, String> map = new HashMap<>();
            map.put("GUIDE_CLASS", "");
            list.add(map);
        }
        return list;
    }

    @Override
    public List<GuideInfoVo> findGuideInfo(String knowledgeType, String hospitalId) {
        List<GuideInfoVo> list = frmChiefDoctMapper.findGuideInfo(knowledgeType, hospitalId);
        if(list.size() == 0){
            list.add(new GuideInfoVo());
        }
        return list;
    }

}
