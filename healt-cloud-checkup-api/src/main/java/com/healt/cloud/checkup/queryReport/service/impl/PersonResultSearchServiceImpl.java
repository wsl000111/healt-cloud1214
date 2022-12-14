package com.healt.cloud.checkup.queryReport.service.impl;

import com.healt.cloud.checkup.mapper.appointmentReg.PersonResultSearchMapper;
import com.healt.cloud.checkup.queryReport.service.PersonResultSearchService;
import com.healt.cloud.checkup.queryReport.vo.PersonInfoVo;
import com.healt.cloud.checkup.queryReport.vo.PersonItemsCostVo;
import com.healt.cloud.checkup.queryReport.vo.PersonItemsVo;
import com.healt.cloud.checkup.queryReport.vo.ResultDictVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author linklee
 * @create 2022-05-27 9:19
 */
@Service
@AllArgsConstructor
public class PersonResultSearchServiceImpl implements PersonResultSearchService {

    private PersonResultSearchMapper personResultSearchMapper;

    @Override
    public List findPersonVisitCount(String hospitalId, String personId) {
        String max = personResultSearchMapper.findPersonVisitCount(hospitalId,personId);
        if (max == null) {
            max = "";
        }
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("max",max);
        list.add(map);
        return list;
    }

    @Override
    public List<PersonInfoVo> findPersonInfo(String hospitalId, String personId, String personVisitId) {
        List<PersonInfoVo> list = personResultSearchMapper.findPersonInfo(hospitalId,personId,personVisitId);
        if (list.size() == 0) {
            list.add(new PersonInfoVo());
        }
        return list;
    }

    @Override
    public List<ResultDictVo> findLabHcResultDict(String hospitalId, String personId, String personVisitId) {
        List<ResultDictVo> list = personResultSearchMapper.findLabHcResultDict(hospitalId,personId,personVisitId);
        if (list.size() == 0) {
            list.add(new ResultDictVo());
        }
        return list;
    }

    @Override
    public List<ResultDictVo> findReportHcResultDict(String hospitalId, String personId, String personVisitId) {
        List<ResultDictVo> list = personResultSearchMapper.findReportHcResultDict(hospitalId,personId,personVisitId);
        if (list.size() == 0) {
            list.add(new ResultDictVo());
        }
        return list;
    }

    @Override
    public List<PersonItemsVo> findPersonItems(String hospitalId, String personId, String personVisitId) {
        List<PersonItemsVo> list = personResultSearchMapper.findPersonItems(hospitalId,personId,personVisitId);
        if (list.size() == 0) {
            list.add(new PersonItemsVo());
        }
        return list;
    }

    @Override
    public List<PersonItemsCostVo> findPersonItemsCost(String hospitalId, String personId, String personVisitId) {
        List<PersonItemsCostVo> list = personResultSearchMapper.findPersonItemsCost(hospitalId,personId,personVisitId);
        if (list.size() == 0) {
            list.add(new PersonItemsCostVo());
        }
        return list;
    }
}
