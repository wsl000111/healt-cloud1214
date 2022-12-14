package com.healt.cloud.checkup.service.business;

import com.healt.cloud.checkup.entity.HcItemVsExternal;
import com.healt.cloud.checkup.vo.busniess.itemExtern.ItemPackLabVo;
import com.healt.cloud.checkup.vo.busniess.itemExtern.SaveHcItemVsExternalListVo;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-18 9:33
 * @description: TODO
 */
public interface ItemVsExernService {
    List<HcItemVsExternal> findDtItemVsExtern(String hospitalId, String itemCode);

    List<ItemPackLabVo> findDtItemPackLab(String hospitalId);

    void saveHcItemVsExternalListVo(SaveHcItemVsExternalListVo saveHcItemVsExternalListVo);
}
