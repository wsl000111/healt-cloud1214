package com.healt.cloud.checkup.mapper.appointmentReg;

import com.healt.cloud.checkup.entity.HcSettleMaster;
import com.healt.cloud.checkup.vo.settlement.DtxmHZVo;
import com.healt.cloud.checkup.vo.settlement.DtxmmxVo;
import com.healt.cloud.checkup.vo.settlement.UnitSettleReturnItemListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-07 9:44
 */
@Mapper
public interface UnitSettleReturnMapper {
    List<UnitSettleReturnItemListVo> findUnitSettleReturnItemList(@Param("hospitalId") String hospitalId,@Param("rcptNo") String rcptNo);

    List<HcSettleMaster> findHcSettleMaster(@Param("hospitalId") String hospitalId, @Param("rcptNo") String rcptNo);

    List<DtxmmxVo> findDtxmmx(@Param("hospitalId") String hospitalId,@Param("rcptNo") String rcptNo);

    List<DtxmHZVo> findDtxmHZ(@Param("hospitalId") String hospitalId,@Param("rcptNo") String rcptNo);
}
