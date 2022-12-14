package com.healt.cloud.checkup.service.settlement;

import com.healt.cloud.checkup.vo.settlement.*;
import com.healt.cloud.checkup.vo.settlement.vo.SaveHcSettleListVo;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-03 10:52
 */
public interface UnitSettleService {

    public List<UnitInfoVo> findUnitInfo(String hospitalId);

    public List<DiscountSchemeVo> findDiscountScheme();

    public List<HcUnitGroupVo> findDtUnitGroup(String hospitalId, String unitId, Integer unitVisitId);

    public List<DtxmmxVo> findDtxmmx(String hospitalId, String unitId, Integer unitVisitId);

    public List<DtxmHZVo> findDtxmHZ(String hospitalId, String unitId, Integer unitVisitId);

    public List<SbYyVo> findSbYy(String hospitalId, String unitId, Integer unitVisitId, String schemeCode);

    public void saveHcSettleList(SaveHcSettleListVo saveHcSettleList);

    List<DtxmmxVo> findDtxmmxPerson(String hospitalId, String unitId, Integer unitVisitId, String personIdStr);

    List<DtxmHZVo> findDtxmHZPerson(String hospitalId, String unitId, Integer unitVisitId, String personIdStr);
}
