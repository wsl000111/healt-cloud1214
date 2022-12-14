package com.healt.cloud.checkup.printReport.service.impl;

import com.healt.cloud.checkup.queryReport.service.DiagnosisStatUnitService;
import com.healt.cloud.checkup.queryReport.vo.AbnormalResultsVo;
import com.healt.cloud.checkup.printReport.mapper.UnitReportMapper;
import com.healt.cloud.checkup.printReport.service.UnitReportService;
import com.healt.cloud.checkup.printReport.vo.AbnormalResultsTwoVo;
import com.healt.cloud.checkup.printReport.vo.UnitQueryReportDictVo;
import com.healt.cloud.checkup.printReport.vo.UnitQueryReportVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author linklee
 * @create 2022-06-02 8:47
 */
@Service
@AllArgsConstructor
public class UnitReportServiceImpl implements UnitReportService {

    private UnitReportMapper unitReportMapper;

    private DiagnosisStatUnitService diagnosisStatUnitService;

    @Override
    public List<UnitQueryReportVo> findUnitQueryReport(UnitQueryReportDictVo unitQueryReportDictVo) {
        List<UnitQueryReportVo> list = unitReportMapper.findUnitQueryReport(unitQueryReportDictVo);
        if (list.size() == 0) {
            list.add(new UnitQueryReportVo());
        }
        return list;
    }

    @Override
    public List findUnitReport(String hospitalId, String unitId, String unitVisitId, String department, String personLeve) {
        if("*".equals(department)||"".equals(department)||null==department){
            department = null;
        }
        if("*".equals(personLeve)||"".equals(personLeve)||null==personLeve){
            personLeve = null;
        }
        List<UnitQueryReportVo> list1 = unitReportMapper.findUnitInfo(unitId,unitVisitId);
        if (list1.size() == 0) {
            list1.add(new UnitQueryReportVo());
        }
        List list2 = diagnosisStatUnitService.findTotalCount(hospitalId, unitId, unitVisitId, department, personLeve);
        List list3 = diagnosisStatUnitService.findManCount(hospitalId, unitId, unitVisitId, department, personLeve);
        List list4 = diagnosisStatUnitService.findWomanCount(hospitalId,unitId,unitVisitId, department, personLeve);
        List list5 = diagnosisStatUnitService.findBeforeSignTotalCount(hospitalId,unitId,unitVisitId, department, personLeve);
        List list6 = diagnosisStatUnitService.findBeforeSignManCount(hospitalId,unitId,unitVisitId, department, personLeve);
        List list7 = diagnosisStatUnitService.findBeforeSignWomanCount(hospitalId,unitId,unitVisitId, department, personLeve);

        List list8 = findCountByAge(hospitalId,unitId,unitVisitId,"","20","男", department, personLeve);
        List list9 = findCountByAge(hospitalId,unitId,unitVisitId,"","20","女", department, personLeve);
        List list10 = findCountByAgeTotal(hospitalId,unitId,unitVisitId,"","20", department, personLeve);
        List list11 = findCountByAge(hospitalId,unitId,unitVisitId,"20","30","男", department, personLeve);
        List list12 = findCountByAge(hospitalId,unitId,unitVisitId,"20","30","女", department, personLeve);
        List list13 = findCountByAgeTotal(hospitalId,unitId,unitVisitId,"20","30", department, personLeve);
        List list14 = findCountByAge(hospitalId,unitId,unitVisitId,"30","40","男", department, personLeve);
        List list15 = findCountByAge(hospitalId,unitId,unitVisitId,"30","40","女", department, personLeve);
        List list16 = findCountByAgeTotal(hospitalId,unitId,unitVisitId,"30","40", department, personLeve);
        List list17 = findCountByAge(hospitalId,unitId,unitVisitId,"40","50","男", department, personLeve);
        List list18 = findCountByAge(hospitalId,unitId,unitVisitId,"40","50","女", department, personLeve);
        List list19 = findCountByAgeTotal(hospitalId,unitId,unitVisitId,"40","50", department, personLeve);
        List list20 = findCountByAge(hospitalId,unitId,unitVisitId,"50","60","男", department, personLeve);
        List list21 = findCountByAge(hospitalId,unitId,unitVisitId,"50","60","女", department, personLeve);
        List list22 = findCountByAgeTotal(hospitalId,unitId,unitVisitId,"50","60", department, personLeve);
        List list23 = findCountByAge(hospitalId,unitId,unitVisitId,"60","","男", department, personLeve);
        List list24 = findCountByAge(hospitalId,unitId,unitVisitId,"60","","女", department, personLeve);
        List list25 = findCountByAgeTotal(hospitalId,unitId,unitVisitId,"60","", department, personLeve);

        List<AbnormalResultsVo> list26 = unitReportMapper.findAbnormalResults11(hospitalId, unitId, unitVisitId, department, personLeve);
        if (list26.size() == 0) {
            list26.add(new AbnormalResultsVo());
        }
        List<AbnormalResultsTwoVo> list27 = unitReportMapper.findAbnormalResults21(hospitalId, unitId, unitVisitId, department, personLeve);
        if (list27.size() == 0) {
            list27.add(new AbnormalResultsTwoVo());
        }

        List<Map<String, Object>> list = new ArrayList();
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
        Map map7 = new HashMap();
        map7.put("list7",list7);
        list.add(map7);
        Map map8 = new HashMap();
        map8.put("list8",list8);
        list.add(map8);
        Map map9 = new HashMap();
        map9.put("list9",list9);
        list.add(map9);
        Map map10 = new HashMap();
        map10.put("list10",list10);
        list.add(map10);
        Map map11 = new HashMap();
        map11.put("list11",list11);
        list.add(map11);
        Map map12 = new HashMap();
        map12.put("list12",list12);
        list.add(map12);
        Map map13 = new HashMap();
        map13.put("list13",list13);
        list.add(map13);
        Map map14 = new HashMap();
        map14.put("list14",list14);
        list.add(map14);
        Map map15 = new HashMap();
        map15.put("list15",list15);
        list.add(map15);
        Map map16 = new HashMap();
        map16.put("list16",list16);
        list.add(map16);
        Map map17 = new HashMap();
        map17.put("list17",list17);
        list.add(map17);
        Map map18 = new HashMap();
        map18.put("list18",list18);
        list.add(map18);
        Map map19 = new HashMap();
        map19.put("list19",list19);
        list.add(map19);
        Map map20 = new HashMap();
        map20.put("list20",list20);
        list.add(map20);
        Map map21 = new HashMap();
        map21.put("list21",list21);
        list.add(map21);
        Map map22 = new HashMap();
        map22.put("list22",list22);
        list.add(map22);
        Map map23 = new HashMap();
        map23.put("list23",list23);
        list.add(map23);
        Map map24 = new HashMap();
        map24.put("list24",list24);
        list.add(map24);
        Map map25 = new HashMap();
        map25.put("list25",list25);
        list.add(map25);
        Map map26 = new HashMap();
        map26.put("list26",list26);
        list.add(map26);
        Map map27 = new HashMap();
        map27.put("list27",list27);
        list.add(map27);

        Map noteMap1 = new HashMap();
        String str1 = "list1: 单位体检信息 " +
                "list2: 登记总人数 " +
                "list3: 登记男人数 " +
                "list4: 登记女人数 " +
                "list5: 参检总人数 " +
                "list6: 参检男人数 ";
        noteMap1.put("notes",str1);
        list.add(noteMap1);
        Map noteMap2 = new HashMap();
        String str2 = "list7: 参检女人数 " +
                "list8: 20岁以下男人数 " +
                "list9: 20岁以下女人数 " +
                "list10: 20岁以下总人数 " +
                "list11: 20-30岁男人数 " +
                "list12: 20-30岁女人数 ";
        noteMap2.put("notes",str2);
        list.add(noteMap2);
        Map noteMap3 = new HashMap();
        String str3 = "list13: 20-30岁总人数 " +
                "list14: 30-40岁男人数 " +
                "list15: 30-40岁女人数 " +
                "list16: 30-40岁总人数 " +
                "list17: 40-50岁男人数 " +
                "list18: 40-50岁女人数 ";
        noteMap3.put("notes",str3);
        list.add(noteMap3);
        Map noteMap4 = new HashMap();
        String str4 = "list19: 40-50岁总人数 " +
                "list20: 50-60岁男人数 " +
                "list21: 50-60岁女人数 " +
                "list22: 50-60岁总人数 " +
                "list23: 60岁及以上男人数 " +
                "list24: 60岁及以上女人数 ";
        noteMap4.put("notes",str4);
        list.add(noteMap4);
        Map noteMap5 = new HashMap();
        String str5 = "list25: 60岁及以上总人数 " +
                "list26: 体检异常结果检出统计1 " +
                "list27: 体检异常结果检出统计2 ";
        noteMap5.put("notes",str5);
        list.add(noteMap5);
        return list;
    }

    @Override
    public List findUnitDepartment(String unitId, String unitVisitId) {
        List<String> stringList = unitReportMapper.findUnitDepartment(unitId, unitVisitId);
        List<Map<String, String>> mapList = new ArrayList<>();
        for(String str : stringList){
            Map<String, String> map = new HashMap<>();
            map.put("DEPARTMENT", str);
            mapList.add(map);
        }
        return mapList;
    }

    @Override
    public List findUnitLevel(String unitId, String unitVisitId) {
        List<String> stringList = unitReportMapper.findUnitLevel(unitId, unitVisitId);
        List<Map<String, String>> mapList = new ArrayList<>();
        for(String str : stringList){
            Map<String, String> map = new HashMap<>();
            map.put("PERSON_LEVEL", str);
            mapList.add(map);
        }
        return mapList;
    }

    public List findCountByAge(String hospitalId, String unitId, String unitVisitId,
                               String age1, String age2, String sex) {
        String count = unitReportMapper.findCountByAge(hospitalId,unitId,unitVisitId,age1,age2,sex);
        if (count == null) {
            count = "";
        }
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("count(*)",count);
        list.add(map);
        return list;
    }

    public List findCountByAge(String hospitalId, String unitId, String unitVisitId,
                               String age1, String age2, String sex, String department, String personLeve) {
        String count = unitReportMapper.findCountByAge1(hospitalId,unitId,unitVisitId,age1,age2,sex,department,personLeve);
        if (count == null) {
            count = "";
        }
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("count(*)",count);
        list.add(map);
        return list;
    }

    public List findCountByAgeTotal(String hospitalId, String unitId, String unitVisitId,
                               String age1, String age2) {
        String count = unitReportMapper.findCountByAgeTotal(hospitalId,unitId,unitVisitId,age1,age2);
        if (count == null) {
            count = "";
        }
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("count(*)",count);
        list.add(map);
        return list;
    }

    public List findCountByAgeTotal(String hospitalId, String unitId, String unitVisitId,
                                    String age1, String age2, String department, String personLeve) {
        String count = unitReportMapper.findCountByAgeTotal1(hospitalId,unitId,unitVisitId,age1,age2,department,personLeve);
        if (count == null) {
            count = "";
        }
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("count(*)",count);
        list.add(map);
        return list;
    }

}
