package com.healt.cloud.checkup.queryReport.service;

import com.healt.cloud.checkup.queryReport.vo.StrWherePageVo;
import com.healt.cloud.common.pages.PageResult;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-26 15:30
 */
public interface StatNoauditAllService {

    public PageResult findPersonNotFinalList(StrWherePageVo strWherePageVo);

    public List findUnitCount(String unitId);
}
