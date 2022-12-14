package com.healt.cloud.checkup.service.settlement;

import com.healt.cloud.checkup.vo.settlement.*;
import com.healt.cloud.checkup.vo.settlement.vo.SaveHcSettleListVo;
import com.healt.cloud.checkup.vo.settlement.vo.SaveHcSettleMasterListVo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author linklee
 * @create 2022-04-09 13:58
 */
public interface PersonSettleService {

    public List<SettleItemListVo> findSettleItemList(String hospitalId, String personId, Integer personVisitId);

    public List<SettlePayListVo> findSettlePayList();

    public List<PersonVisitAndInfoVo> findPersonVisitAndInfo(String hospitalId, String personId);

    public BigDecimal findMoneyInCard(String hospitalId, String cardNo);

    public List<HospitalDictVo> findHospitalDict(String hospitalId);

    public void updateMoneyInCard(String hospitalId, String cardNo, BigDecimal paymentMoney);

    public void saveSettleMaster(SaveHcSettleMasterListVo saveHcSettleMasterListVo);

    public void updateNextChargeNo(String hospitalId);

    public void updateBillIndicator(String hospitalId, String personId, Integer personVisitId);

    public void saveHcSettleList(SaveHcSettleListVo saveHcSettleList);

    public List<SbYyVo> findSbYy(String hospitalId, String unitId, Integer unitVisitId, String schemeCode);
}
