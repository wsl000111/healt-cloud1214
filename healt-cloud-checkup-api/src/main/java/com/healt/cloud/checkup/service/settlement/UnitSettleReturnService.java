package com.healt.cloud.checkup.service.settlement;

import com.healt.cloud.checkup.entity.HcSettleMaster;
import com.healt.cloud.checkup.vo.settlement.DtxmHZVo;
import com.healt.cloud.checkup.vo.settlement.DtxmmxVo;
import com.healt.cloud.checkup.vo.settlement.UnitSettleReturnItemListVo;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-07 9:42
 */
public interface UnitSettleReturnService {

    public List<UnitSettleReturnItemListVo> findUnitSettleReturnItemList(String hospitalId, String rcptNo);

    public List<HcSettleMaster> findHcSettleMaster(String hospitalId, String rcptNo);

    public List<DtxmmxVo> findDtxmmx(String hospitalId, String rcptNo);

    public List<DtxmHZVo> findDtxmHZ(String hospitalId, String rcptNo);
}
