package com.healt.cloud.checkup.service.business;

import com.healt.cloud.checkup.entity.HcPackVsPrice;
import com.healt.cloud.checkup.vo.busniess.clinicPrice.HcPersonPriceVo;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-07-14 16:22
 * @description: TODO
 */
public interface MyHcPackVsPriceService {
    List<HcPackVsPrice> findPackVsPriceList(String itemPackCode, String hospitalId);

    void findAndSaveHcPackVsPrice(String hospitalId, String itemPackCode, String clinicItemCode, String clinicItemName);

    List<HcPersonPriceVo> findHcPersonPriceByUnit(String hospitalId, String unitId, String unitVisitId);

    List<HcPersonPriceVo> findHcPersonPriceByPerson(String hospitalId, String personId, String personVisitId);

    List<HcPersonPriceVo> findHcPersonPriceByUnitPerson(String hospitalId, String unitId, String unitVisitId, String personIdStr);
}
