package com.healt.cloud.checkup.service.business;

import com.healt.cloud.checkup.entity.CompanyCostBack;
import com.healt.cloud.checkup.vo.busniess.costDetail.CostDetailBillingDictVo;
import com.healt.cloud.checkup.vo.busniess.costDetail.SaveCostDetailBillingListVo;
import com.healt.cloud.checkup.entity.CostDetailBilling;
import com.healt.cloud.checkup.vo.companyCostCharge.CompanyCostChargeStateVoList;
import com.healt.cloud.checkup.vo.saveCostDetailReturn.SaveCostDetailReturnVo;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-07-14 12:41
 * @description: TODO
 */
public interface HcCostDetailBillingService {
    List<CostDetailBilling> findCostDetailBilling(String hospitalId, String personId, String personVisitId);

    void saveCostDetailBillingList(SaveCostDetailBillingListVo saveCostDetailBillingList);

    List<CostDetailBilling> findCostDetailBillingFilter(CostDetailBillingDictVo costDetailBillingDictVo);

    void saveCostDetailReturn(SaveCostDetailReturnVo saveCostDetailReturnVo);

    void cancelCostDetailBillingList(SaveCostDetailBillingListVo saveCostDetailBillingList);

    void companyCostBack(CompanyCostChargeStateVoList companyCostChargeStateVoList);

    /**
     * 查询单位收费状态
     * @param unitId
     * @param unitVisitId
     * @param canctype
     * @return
     */
    List<CompanyCostBack> findCompanyCostBacks(String unitId, String unitVisitId, String canctype);
}
