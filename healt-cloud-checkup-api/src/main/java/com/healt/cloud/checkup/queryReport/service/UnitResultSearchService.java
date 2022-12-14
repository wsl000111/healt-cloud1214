package com.healt.cloud.checkup.queryReport.service;

import com.healt.cloud.checkup.queryReport.vo.PersonTztListDictVo;
import com.healt.cloud.checkup.queryReport.vo.UnitInfoVo;
import com.healt.cloud.common.pages.PageResult;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-26 16:21
 */
public interface UnitResultSearchService {

    public List<UnitInfoVo> findUnitInfo(String hospitalId, String unitId);

    public PageResult findPersonList(PersonTztListDictVo personTztListDictVo);
}
