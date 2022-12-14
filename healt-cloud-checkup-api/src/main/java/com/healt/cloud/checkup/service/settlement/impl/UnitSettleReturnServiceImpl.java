package com.healt.cloud.checkup.service.settlement.impl;

import com.healt.cloud.checkup.entity.HcSettleMaster;
import com.healt.cloud.checkup.mapper.appointmentReg.UnitSettleReturnMapper;
import com.healt.cloud.checkup.service.settlement.UnitSettleReturnService;
import com.healt.cloud.checkup.vo.settlement.DtxmHZVo;
import com.healt.cloud.checkup.vo.settlement.DtxmmxVo;
import com.healt.cloud.checkup.vo.settlement.UnitSettleReturnItemListVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-07 9:42
 */
@Service
@AllArgsConstructor
public class UnitSettleReturnServiceImpl implements UnitSettleReturnService {

    private UnitSettleReturnMapper unitSettleReturnMapper;

    @Override
    public List<UnitSettleReturnItemListVo> findUnitSettleReturnItemList(String hospitalId, String rcptNo) {
        List<UnitSettleReturnItemListVo> list = unitSettleReturnMapper.findUnitSettleReturnItemList(hospitalId,rcptNo);
        if (list.size() == 0) {
            list.add(new UnitSettleReturnItemListVo());
        }
        return list;
    }

    @Override
    public List<HcSettleMaster> findHcSettleMaster(String hospitalId, String rcptNo) {
        List<HcSettleMaster> list = unitSettleReturnMapper.findHcSettleMaster(hospitalId,rcptNo);
        if (list.size() == 0) {
            list.add(new HcSettleMaster());
        }
        return list;
    }

    @Override
    public List<DtxmmxVo> findDtxmmx(String hospitalId, String rcptNo) {
        List<DtxmmxVo> list = unitSettleReturnMapper.findDtxmmx(hospitalId,rcptNo);
        if (list.size() == 0) {
            list.add(new DtxmmxVo());
        }
        return list;
    }

    @Override
    public List<DtxmHZVo> findDtxmHZ(String hospitalId, String rcptNo) {
        List<DtxmHZVo> list = unitSettleReturnMapper.findDtxmHZ(hospitalId,rcptNo);
        if (list.size() == 0) {
            list.add(new DtxmHZVo());
        }
        return list;
    }
}
