package com.healt.cloud.checkup.questionnaire.service;

import com.healt.cloud.checkup.entity.HcInvestResult;
import com.healt.cloud.checkup.questionnaire.vo.SaveInvestResultListVo;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-13 14:33
 */
public interface InvestResultService {

    public List<HcInvestResult> findInvestResult(String hospitalId, String investCode);

    public void saveInvestResult(SaveInvestResultListVo saveInvestResultList);
}
