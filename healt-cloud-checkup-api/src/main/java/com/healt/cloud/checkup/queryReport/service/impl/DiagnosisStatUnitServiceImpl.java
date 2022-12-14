package com.healt.cloud.checkup.queryReport.service.impl;

import com.healt.cloud.checkup.mapper.appointmentReg.DiagnosisStatUnitMapper;
import com.healt.cloud.checkup.queryReport.service.DiagnosisStatUnitService;
import com.healt.cloud.checkup.queryReport.vo.AbnormalResultsDictVo;
import com.healt.cloud.checkup.queryReport.vo.AbnormalResultsVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author linklee
 * @create 2022-05-29 14:54
 */
@Service
@AllArgsConstructor
public class DiagnosisStatUnitServiceImpl implements DiagnosisStatUnitService {

    private DiagnosisStatUnitMapper diagnosisStatUnitMapper;

    @Override
    public List findTotalCount(String hospitalId, String unitId, String unitVisitId) {
        String count = diagnosisStatUnitMapper.findTotalCount(hospitalId,unitId,unitVisitId);
        if (count == null) {
            count = "";
        }
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("count(*)",count);
        list.add(map);
        return list;
    }

    @Override
    public List findTotalCount(String hospitalId, String unitId, String unitVisitId, String department, String personLeve) {
        if("*".equals(department)||"".equals(department)||null==department){
            department = null;
        }
        if("*".equals(personLeve)||"".equals(personLeve)||null==personLeve){
            personLeve = null;
        }
        String count = diagnosisStatUnitMapper.findTotalCount1(hospitalId,unitId,unitVisitId,department,personLeve);
        if (count == null) {
            count = "";
        }
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("count(*)",count);
        list.add(map);
        return list;
    }

    @Override
    public List findManCount(String hospitalId, String unitId, String unitVisitId, String department, String personLeve) {
        String count = diagnosisStatUnitMapper.findManCount1(hospitalId,unitId,unitVisitId, department, personLeve);
        if (count == null) {
            count = "";
        }
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("count(*)",count);
        list.add(map);
        return list;
    }

    @Override
    public List findManCount(String hospitalId, String unitId, String unitVisitId) {
        String count = diagnosisStatUnitMapper.findManCount(hospitalId,unitId,unitVisitId);
        if (count == null) {
            count = "";
        }
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("count(*)",count);
        list.add(map);
        return list;
    }

    @Override
    public List findWomanCount(String hospitalId, String unitId, String unitVisitId, String department, String personLeve) {
        String count = diagnosisStatUnitMapper.findWomanCount1(hospitalId,unitId,unitVisitId,department,personLeve);
        if (count == null) {
            count = "";
        }
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("count(*)",count);
        list.add(map);
        return list;
    }

    @Override
    public List findWomanCount(String hospitalId, String unitId, String unitVisitId) {
        String count = diagnosisStatUnitMapper.findWomanCount(hospitalId,unitId,unitVisitId);
        if (count == null) {
            count = "";
        }
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("count(*)",count);
        list.add(map);
        return list;
    }

    @Override
    public List findBeforeSignTotalCount(String hospitalId, String unitId, String unitVisitId, String department, String personLeve) {
        String count = diagnosisStatUnitMapper.findBeforeSignTotalCount1(hospitalId,unitId,unitVisitId,department,personLeve);
        if (count == null) {
            count = "";
        }
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("count(*)",count);
        list.add(map);
        return list;
    }

    @Override
    public List findBeforeSignTotalCount(String hospitalId, String unitId, String unitVisitId) {
        String count = diagnosisStatUnitMapper.findBeforeSignTotalCount(hospitalId,unitId,unitVisitId);
        if (count == null) {
            count = "";
        }
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("count(*)",count);
        list.add(map);
        return list;
    }

    @Override
    public List findBeforeSignManCount(String hospitalId, String unitId, String unitVisitId, String department, String personLeve) {
        String count = diagnosisStatUnitMapper.findBeforeSignManCount1(hospitalId,unitId,unitVisitId,department,personLeve);
        if (count == null) {
            count = "";
        }
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("count(*)",count);
        list.add(map);
        return list;
    }

    @Override
    public List findBeforeSignManCount(String hospitalId, String unitId, String unitVisitId) {
        String count = diagnosisStatUnitMapper.findBeforeSignManCount(hospitalId,unitId,unitVisitId);
        if (count == null) {
            count = "";
        }
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("count(*)",count);
        list.add(map);
        return list;
    }

    @Override
    public List findBeforeSignWomanCount(String hospitalId, String unitId, String unitVisitId, String department, String personLeve) {
        String count = diagnosisStatUnitMapper.findBeforeSignWomanCount1(hospitalId,unitId,unitVisitId,department,personLeve);
        if (count == null) {
            count = "";
        }
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("count(*)",count);
        list.add(map);
        return list;
    }

    @Override
    public List findBeforeSignWomanCount(String hospitalId, String unitId, String unitVisitId) {
        String count = diagnosisStatUnitMapper.findBeforeSignWomanCount(hospitalId,unitId,unitVisitId);
        if (count == null) {
            count = "";
        }
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("count(*)",count);
        list.add(map);
        return list;
    }

    @Override
    public List<AbnormalResultsVo> findAbnormalResults(AbnormalResultsDictVo abnormalResultsDictVo) {
        List<AbnormalResultsVo> list = diagnosisStatUnitMapper.findAbnormalResults(abnormalResultsDictVo);
        if (list.size() == 0) {
            list.add(new AbnormalResultsVo());
        }
        return list;
    }

}
