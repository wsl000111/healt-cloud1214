package com.healt.cloud.checkup.appointmentReg.service;

import com.healt.cloud.checkup.entity.HcChangeVsItem;
import com.healt.cloud.checkup.entity.HcChangeitemLog;
import com.healt.cloud.checkup.vo.appointmentReg.changeItem.SaveHcChargeItemListVo;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-16 14:34
 */
public interface ChangeItemService {

    public List<HcChangeitemLog> findChangeVsItemLog();

    public List<HcChangeVsItem> findChangeVsItem(String hospitalId, String itemCode);

    public void saveHcChargeItemList(SaveHcChargeItemListVo saveHcChargeItemList);
}
