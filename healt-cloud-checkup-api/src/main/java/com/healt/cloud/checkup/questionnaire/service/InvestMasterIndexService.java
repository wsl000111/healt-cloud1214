package com.healt.cloud.checkup.questionnaire.service;

import com.healt.cloud.checkup.entity.HcInvestMasterIndex;
import com.healt.cloud.checkup.questionnaire.vo.SaveInvestMasterIndexListVo;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-13 13:44
 */
public interface InvestMasterIndexService {

    public List<HcInvestMasterIndex> findInvestMasterIndex(String hospitalId);

    public void saveInvestMasterIndexWeb(SaveInvestMasterIndexListVo saveInvestMasterIndexList);
}
