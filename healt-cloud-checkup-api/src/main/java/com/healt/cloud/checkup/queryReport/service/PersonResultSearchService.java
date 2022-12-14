package com.healt.cloud.checkup.queryReport.service;

import com.healt.cloud.checkup.queryReport.vo.PersonInfoVo;
import com.healt.cloud.checkup.queryReport.vo.PersonItemsCostVo;
import com.healt.cloud.checkup.queryReport.vo.PersonItemsVo;
import com.healt.cloud.checkup.queryReport.vo.ResultDictVo;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-27 9:18
 */
public interface PersonResultSearchService {

    public List findPersonVisitCount(String hospitalId, String personId);

    public List<PersonInfoVo> findPersonInfo(String hospitalId, String personId, String personVisitId);

    public List<ResultDictVo> findLabHcResultDict(String hospitalId, String personId, String personVisitId);

    public List<ResultDictVo> findReportHcResultDict(String hospitalId, String personId, String personVisitId);

    public List<PersonItemsVo> findPersonItems(String hospitalId, String personId, String personVisitId);

    public List<PersonItemsCostVo> findPersonItemsCost(String hospitalId, String personId, String personVisitId);
}
