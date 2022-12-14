package com.healt.cloud.checkup.queryReport.service;

import com.healt.cloud.checkup.queryReport.vo.PersonQueryDictVo;
import com.healt.cloud.common.pages.PageResult;

/**
 * @author linklee
 * @create 2022-05-26 10:26
 */
public interface PersonQueryService {

    public PageResult findPersonQuery(PersonQueryDictVo personQueryDictVo);
}
