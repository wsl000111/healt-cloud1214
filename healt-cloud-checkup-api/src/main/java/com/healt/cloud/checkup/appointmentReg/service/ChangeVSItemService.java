package com.healt.cloud.checkup.appointmentReg.service;

import com.healt.cloud.checkup.vo.appointmentReg.changeVSItem.ChangeVSItemVo;
import com.healt.cloud.checkup.vo.appointmentReg.changeVSItem.SaveHcChangeVsItemListVo;
import com.healt.cloud.common.pages.PageResult;

/**
 * @author linklee
 * @create 2022-05-13 10:51
 */
public interface ChangeVSItemService {

    public PageResult findDtChangeVSItem(ChangeVSItemVo changeVSItemVo);

    public void saveHcChangeVsItemList(SaveHcChangeVsItemListVo saveHcChangeVsItemList);
}
