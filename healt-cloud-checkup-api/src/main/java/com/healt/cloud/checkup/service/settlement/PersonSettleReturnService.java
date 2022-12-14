package com.healt.cloud.checkup.service.settlement;

import com.healt.cloud.checkup.entity.HcSettleMaster;
import com.healt.cloud.checkup.vo.settlement.SettleReturnItemListVo;
import com.healt.cloud.checkup.vo.settlement.SettleReturnPayListVo;
import com.healt.cloud.checkup.vo.settlement.SettleReturnPersonInfoVo;
import com.healt.cloud.checkup.vo.settlement.vo.SaveHcReturnSettleListVo;

import java.util.List;

/**
 * @author linklee
 * @create 2022-04-18 16:01
 */
public interface PersonSettleReturnService {

    public List<SettleReturnItemListVo> findSettleReturnItemList(String hospitalId, String rcptNo);

    public List<SettleReturnPayListVo> findSettleReturnPayList(String hospitalId, String rcptNo);

    public List<HcSettleMaster> findHcSettleMaster(String hospitalId, String rcptNo);

    public List<SettleReturnPersonInfoVo> findSettleReturnPersonInfo(String hospitalId, String personId, Integer personVisitId);

    public void saveHcReturnSettleList(SaveHcReturnSettleListVo saveHcReturnSettleList);

    public List<SettleReturnItemListVo> findSettleReturnItemListNew(String hospitalId, String rcptNo);
}
