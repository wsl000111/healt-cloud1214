package com.healt.cloud.checkup.service.business;

import com.healt.cloud.checkup.entity.HcPackVsClinic;
import com.healt.cloud.checkup.entity.VClinicItemClass;
import com.healt.cloud.checkup.vo.busniess.clinicPrice.ClinicItemPrice;
import com.healt.cloud.checkup.vo.busniess.packClinic.SaveHcPackVsClincListVo;
import com.healt.cloud.checkup.vo.busniess.packClinic.VClinicItemsVo;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-11 9:55
 * @description: 组合与诊疗对照Service
 */
public interface PackVsClinicService {

    List<VClinicItemClass> findDtClinicItemClass();

    List<VClinicItemsVo> findDtClinicItems(String itemClass);

    List<HcPackVsClinic> findDtPackVsClinic(String hospitalCode, String itemPackCode);

    void saveHcPackVsClincList(SaveHcPackVsClincListVo saveHcPackVsClincListVo);

    void reloadMdmClinicitemQuery(String itemClass);

    List<ClinicItemPrice> findClinicItemPrice(String itemClass, String itemCode, String findClinicItemPrice);

    void reloadMdmClinicpriceQuery(String itemClass, String itemCode);
}
