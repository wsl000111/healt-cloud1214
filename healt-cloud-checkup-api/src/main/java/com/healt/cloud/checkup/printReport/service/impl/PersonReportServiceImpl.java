package com.healt.cloud.checkup.printReport.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.healt.cloud.checkup.entity.*;
import com.healt.cloud.checkup.printReport.vo.*;
import com.healt.cloud.checkup.printReport.vo.mobile.*;
import com.healt.cloud.checkup.queryReport.vo.ResultDictVo;
import com.healt.cloud.checkup.service.*;
import com.healt.cloud.checkup.mapper.appointmentReg.PersonResultSearchMapper;
import com.healt.cloud.checkup.printReport.mapper.PersonReportMapper;
import com.healt.cloud.checkup.printReport.service.PersonReportService;
import com.healt.cloud.common.pages.PageResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author linklee
 * @create 2022-06-01 8:56
 */
@Service
@AllArgsConstructor
public class PersonReportServiceImpl implements PersonReportService {

    private PersonReportMapper personReportMapper;

    private PersonResultSearchMapper personResultSearchMapper;

    private HcPersonInfoService hcPersonInfoService;

    private HcPersonVisitInfoService hcPersonVisitInfoService;

    @Override
    public PageResult findPrintPerson(PrintPersonDictVo printPersonDictVo) {
        List<PrintPersonVo> listTotal = personReportMapper.findPrintPersonTotal(printPersonDictVo);
        int totalSize = listTotal.size();

        List<PrintPersonVo> list = personReportMapper.findPrintPerson(printPersonDictVo);
        if (list.size() == 0) {
            list.add(new PrintPersonVo());
        }
        int totalPages = totalSize%printPersonDictVo.getPageSize() == 0 ? totalSize / printPersonDictVo.getPageSize() : totalSize / printPersonDictVo.getPageSize() + 1;
        PageResult result = new PageResult<PrintPersonVo>(printPersonDictVo.getPageNum(), printPersonDictVo.getPageSize(), totalSize, totalPages, list);
        return result;
    }

    @Override
    public List findPersonReport(String hospitalId, String personId, String personVisitId) {
        List<PersonBasicInfoVo> list1 = personReportMapper.findPersonBasicInfo(hospitalId,personId,personVisitId);
        if (list1.size() == 0) {
            list1.add(new PersonBasicInfoVo());
        }
        List<PersonResultItemsVo> list2 = personReportMapper.findPersonResultItems(hospitalId,personId,personVisitId);
        if (list2.size() == 0) {
            list2.add(new PersonResultItemsVo());
        }
        List<PersonAppendResultVo> list3 = personReportMapper.findPersonAppendResult(hospitalId,personId,personVisitId);
        if (list3.size() == 0) {
            list3.add(new PersonAppendResultVo());
        } else {
            for (int i = list3.size()-1; i >= 0 ; i--) {
                if (list3.get(i) == null || list3.get(i).equals("")) {
                    list3.remove(i);
                }
            }
            if (list3.size() == 0) {
                list3.add(new PersonAppendResultVo());
            }
        }
        List<ResultDictVo> list4 = personResultSearchMapper.findLabHcResultDict(hospitalId,personId,personVisitId);
        if (list4.size() == 0) {
            list4.add(new ResultDictVo());
        }
        List<ResultDictVo> list5 = personResultSearchMapper.findReportHcResultDict(hospitalId,personId,personVisitId);
        for(ResultDictVo vo : list5){
            if("null".equals(vo.getKeyName())){
                vo.setKeyName("");
            }
            if("null".equals(vo.getHcResult())){
                vo.setHcResult("");
            }
        }
        if (list5.size() == 0) {
            list5.add(new ResultDictVo());
        }
        List<PersonResultVo> list6 = personReportMapper.findPersonResult(hospitalId,personId,personVisitId);
        if (list6.size() == 0) {
            list6.add(new PersonResultVo());
        } else {
            for (int i = list6.size()-1; i >= 0 ; i--) {
                if (list6.get(i) == null || list6.get(i).equals("")) {
                    list6.remove(i);
                }
            }
            if (list6.size() == 0) {
                list6.add(new PersonResultVo());
            }
        }

        List list = new ArrayList();
        Map map1 = new HashMap();
        map1.put("list1",list1);
        list.add(map1);
        Map map2 = new HashMap();
        map2.put("list2",list2);
        list.add(map2);
        Map map3 = new HashMap();
        map3.put("list3",list3);
        list.add(map3);
        Map map4 = new HashMap();
        map4.put("list4",list4);
        list.add(map4);
        Map map5 = new HashMap();
        map5.put("list5",list5);
        list.add(map5);
        Map map6 = new HashMap();
        map6.put("list6",list6);
        list.add(map6);

        List noteList = new ArrayList<>();
        Map noteMap1 = new HashMap();
        noteMap1.put("list1:","体检人员基本信息");
        noteList.add(noteMap1);
        Map noteMap2 = new HashMap();
        noteMap2.put("list2:","体检人员体检汇总");
        noteList.add(noteMap2);
        Map noteMap3 = new HashMap();
        noteMap3.put("list3:","主检附加结果");
        noteList.add(noteMap3);
        Map noteMap4 = new HashMap();
        noteMap4.put("list4:","体检项目结果记录(检验)");
        noteList.add(noteMap4);
        Map noteMap5 = new HashMap();
        noteMap5.put("list5:","体检项目结果记录(报告)");
        noteList.add(noteMap5);
        Map noteMap6 = new HashMap();
        noteMap6.put("list6:","检查结论");
        noteList.add(noteMap6);

        list.add(noteList);
        return list;
    }

    @Override
    public void updatePrint(String hospitalId, String personId, String personVisitId, String userName, String userRealName) {

        personReportMapper.updatePrint(hospitalId,personId,personVisitId,userName,userRealName);
    }

    @Override
    public List<ReportListVo> loadPersonReportList(QueryReportListVo queryReportListVo) {
        String queryType = queryReportListVo.getQueryType();
        HcPersonInfo hcPersonInfo = new HcPersonInfo();
        if(queryType.equals("idNo")){//如果传入身份证号，需要根据身份证号查询patientId，patientVisitId
            String idNo = queryReportListVo.getQueryNo();
            QueryWrapper<HcPersonInfo> personInfoQueryWrapper = new QueryWrapper<>();
            personInfoQueryWrapper.eq("hospital_id", queryReportListVo.getHospitalId());
            personInfoQueryWrapper.eq("id_no", idNo);
            personInfoQueryWrapper.eq("Mobile", queryReportListVo.getPhone());
            hcPersonInfo = hcPersonInfoService.getOne(personInfoQueryWrapper);
        }else if(queryType.equals("patientId")){
            hcPersonInfo.setPersonId(queryReportListVo.getQueryNo());
        }
        QueryWrapper<HcPersonVisitInfo> hcPersonVisitInfoQueryWrapper = new QueryWrapper<>();
        hcPersonVisitInfoQueryWrapper.eq("PERSON_ID", hcPersonInfo.getPersonId());
        hcPersonVisitInfoQueryWrapper.eq("hospital_id", queryReportListVo.getHospitalId());
        hcPersonVisitInfoQueryWrapper.eq("RESULT_STATUS", "9");
        hcPersonVisitInfoQueryWrapper.isNotNull("final_docoter");
        List<HcPersonVisitInfo> list = hcPersonVisitInfoService.list(hcPersonVisitInfoQueryWrapper);
        List<ReportListVo> listVos = new ArrayList<>();
        for(HcPersonVisitInfo hcPersonVisitInfo : list){
            ReportListVo reportListVo = new ReportListVo();
            reportListVo.setPersonId(hcPersonVisitInfo.getPersonId());
            reportListVo.setPersonVisitId(hcPersonVisitInfo.getPersonVisitId());
            //reportListVo.setFinishedDate(hcPersonVisitInfo.getFinishedDate());
            reportListVo.setHospitalId(hcPersonVisitInfo.getHospitalId());
            reportListVo.setBeforeDate(hcPersonVisitInfo.getBeforeDate());
            //reportListVo.setUnitId(hcPersonVisitInfo.getUnitId());
            //reportListVo.setUnitVisitId(hcPersonVisitInfo.getUnitVisitId());
            listVos.add(reportListVo);
        }
        return listVos;
    }

    private HcResultDictService hcResultDictService;

    private HcDiagnosisRecordService hcDiagnosisRecordService;

    private HcDeptResultDictService hcDeptResultDictService;

    @Override
    public HcReportVo loadPersonReportInfo(String hospitalId, String personId, String personVisitId) {
        HcReportVo hcReportVo = new HcReportVo();
        List<HcResultExpVo> exceptionList = new ArrayList<HcResultExpVo>();
        List<HcResultDictVo> hcResultDictVoList = new ArrayList<HcResultDictVo>();
        List<HcDiagnosisRecordVo> hcDiagnosisRecordVoList = new ArrayList<HcDiagnosisRecordVo>();
        hcReportVo.setExceptionList(exceptionList);
        hcReportVo.setHcResultDictVoList(hcResultDictVoList);
        hcReportVo.setHcDiagnosisRecordVoList(hcDiagnosisRecordVoList);

        //查询异常项组合名称
        List<String> expAssemNameList = personReportMapper.selectExpAssemNameList(hospitalId, personId, personVisitId);
        //拼装异常项明细记录
        for(String expAssemName : expAssemNameList) {
            HcResultExpVo hcResultExpVo = new HcResultExpVo();
            exceptionList.add(hcResultExpVo);
            hcResultExpVo.setItemAssemName(expAssemName);

            //List<HcResultDict> expList = personReportMapper.selectResultExp(hospitalId, personId, personVisitId, expAssemName);
            QueryWrapper<HcResultDict> hcResultDictQueryWrapper = new QueryWrapper<>();
            hcResultDictQueryWrapper.eq("HOSPITAL_ID", hospitalId);
            hcResultDictQueryWrapper.eq("PERSON_ID", personId);
            hcResultDictQueryWrapper.eq("PERSON_VISIT_ID", personVisitId);
            hcResultDictQueryWrapper.eq("ITEM_ASSEM_NAME",expAssemName);
            hcResultDictQueryWrapper.isNotNull("ABNORMAL_FLAG");
            hcResultDictQueryWrapper.gt("ABNORMAL_FLAG",0);
            hcResultDictQueryWrapper.orderByAsc("ASSEM_SORT_NO").orderByAsc("ITEM_ORDER_NO");
            List<HcResultDict> expList = hcResultDictService.list(hcResultDictQueryWrapper);
            List<HcResultDictVo> expVoList = new ArrayList<HcResultDictVo>();
            for(HcResultDict expItem : expList) {
                HcResultDictVo itemVo = new HcResultDictVo();
                itemVo.setHcItemName(expItem.getHcItemName());
                itemVo.setAbnormalIndicator(expItem.getAbnormalIndicator());
                itemVo.setPrintContext(expItem.getPrintContext());
                itemVo.setUnit(expItem.getUnit());
                //itemVo.setResultDecimal(expItem.getResultDecimal().toString());
                itemVo.setHcResult(expItem.getHcResult());
                expVoList.add(itemVo);
            }
            hcResultExpVo.setHcResultDictVoList(expVoList);
        }

        //拼装体检结论及建议
        //List<HcDiagnosisRecord> hcDiagnosisRecordList = hcDiagnosisRecordMapper.selectList(bean.getHospitalId(), bean.getPersonId(), bean.getPersonVisitId());
        QueryWrapper<HcDiagnosisRecord> hcDiagnosisRecordQueryWrapper = new QueryWrapper<>();
        hcDiagnosisRecordQueryWrapper.eq("HOSPITAL_ID", hospitalId)
                .eq("PERSON_ID", personId)
                .eq("PERSON_VISIT_ID", personVisitId)
                .orderByAsc("SORT_NO");
        List<HcDiagnosisRecord> hcDiagnosisRecordList = hcDiagnosisRecordService.list(hcDiagnosisRecordQueryWrapper);
        for (HcDiagnosisRecord item : hcDiagnosisRecordList) {
            HcDiagnosisRecordVo hcDiagnosisRecordVo = new HcDiagnosisRecordVo();
            hcDiagnosisRecordVo.setGuideContent(item.getGuideContent());
            hcDiagnosisRecordVo.setRecContent(item.getRecContent());
            hcDiagnosisRecordVoList.add(hcDiagnosisRecordVo);
        }

        //拼装报告详情
        //查询科室
        //List<String> deptList = hcResultDictMapper.selectDeptList(bean.getHospitalId(), bean.getPersonId(), bean.getPersonVisitId());
        List<String> deptList = personReportMapper.selectDeptList(hospitalId, personId, personVisitId);
        for(String deptName : deptList) {
            //拼装第一级科室分类
            HcResultDictVo deptVo = new HcResultDictVo();
            hcResultDictVoList.add(deptVo);
            deptVo.setDeptName(deptName);
            //科室小结
            //HcDeptResultDict hcDeptResultDict = hcDeptResultDictMapper.selectByCondition(bean.getHospitalId(), bean.getPersonId(), bean.getPersonVisitId(), deptName);
            QueryWrapper<HcDeptResultDict> hcDeptResultDictQueryWrapper = new QueryWrapper<>();
            hcDeptResultDictQueryWrapper.eq("HOSPITAL_ID", hospitalId)
                    .eq("PERSON_ID", personId)
                    .eq("PERSON_VISIT_ID", personVisitId)
                    .eq("DEPT_NAME", deptName);
            HcDeptResultDict hcDeptResultDict = hcDeptResultDictService.getOne(hcDeptResultDictQueryWrapper);
            if(hcDeptResultDict!=null){
                deptVo.setCondusionText(hcDeptResultDict.getConclusionText());
            }
            //拼装第二级组合分类
            //List<String> assemNameList = hcResultDictMapper.selectAssemNameList(bean.getHospitalId(), bean.getPersonId(), bean.getPersonVisitId(), deptName);
            List<String> assemNameList = personReportMapper.selectAssemNameList(hospitalId, personId, personVisitId, deptName);
            List<HcResultDictVo> assemVoList = new ArrayList<HcResultDictVo>();
            deptVo.setChildren(assemVoList);
            for(String assemName : assemNameList) {
                HcResultDictVo assemVo = new HcResultDictVo();
                assemVo.setItemAssemName(assemName);
                assemVoList.add(assemVo);
                //拼装第三级结果明细
                //List<HcResultDict> itemList = hcResultDictMapper.selectItemList(bean.getHospitalId(), bean.getPersonId(), bean.getPersonVisitId(), assemName);
                QueryWrapper<HcResultDict> hcResultDictQueryWrapper = new QueryWrapper<>();
                hcResultDictQueryWrapper.eq("HOSPITAL_ID", hospitalId)
                        .eq("PERSON_ID", personId)
                        .eq("PERSON_VISIT_ID", personVisitId)
                        .eq("ITEM_ASSEM_NAME", assemName)
                        .orderByAsc("ASSEM_SORT_NO")
                        .orderByAsc("ITEM_ORDER_NO");
                List<HcResultDict> itemList = hcResultDictService.list(hcResultDictQueryWrapper);
                List<HcResultDictVo> itemVoList = new ArrayList<HcResultDictVo>();
                for(HcResultDict item : itemList) {
                    HcResultDictVo itemVo = new HcResultDictVo();
                    itemVo.setHcItemCode(item.getHcItemCode());
                    itemVo.setHcItemName(item.getHcItemName());
                    itemVo.setAbnormalIndicator(item.getAbnormalIndicator());
                    itemVo.setPrintContext(item.getPrintContext());
                    itemVo.setUnit(item.getUnit());
                    //itemVo.setKeyName(item.getKeyName());
                    //itemVo.setResultDecimal(item.getResultDecimal().toString());
                    itemVo.setHcResult(item.getHcResult());
                    itemVo.setShowType(item.getShowType());
                    itemVoList.add(itemVo);
                }
                assemVo.setChildren(itemVoList);
            }
        }
        return hcReportVo;
    }
}
