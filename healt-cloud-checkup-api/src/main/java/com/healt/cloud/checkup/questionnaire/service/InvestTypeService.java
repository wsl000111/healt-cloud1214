package com.healt.cloud.checkup.questionnaire.service;

import com.healt.cloud.checkup.entity.HcInvestType;
import com.healt.cloud.checkup.questionnaire.vo.SaveInvestTypeListVo;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-13 9:53
 */
public interface InvestTypeService {

    public List<HcInvestType> findInvestType(String hospitalId);

    public void saveInvestType(SaveInvestTypeListVo saveInvestTypeList);

    public List<HcInvestType> findInvestTypeWeb(String hospitalId);
}
