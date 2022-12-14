package com.healt.cloud.checkup.service.settlement;

import com.healt.cloud.checkup.entity.HcDiscountScheme;
import com.healt.cloud.checkup.entity.HcDiscountSchemeDetail;
import com.healt.cloud.checkup.vo.settlement.DtItemPackVo;
import com.healt.cloud.checkup.vo.settlement.vo.SaveHcDiscountSchemeVo;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-05 14:25
 */
public interface DiscountSchemeService {

    public List<DtItemPackVo> findDtItemPack(String hospitalId);

    public List<HcDiscountScheme> findDiscountScheme();

    public List<HcDiscountSchemeDetail> findDiscountSchemeDetail();

    public String findSysdate();

    public void deleteDiscountSchemeAndDetail(String hospitalId, String schemeCode);

    public void saveDiscountSchemeAndDetail(SaveHcDiscountSchemeVo saveHcDiscountScheme);

    public void deleteDiscountSchemeDetail(String itemAssemCode, String schemeCode);

}
