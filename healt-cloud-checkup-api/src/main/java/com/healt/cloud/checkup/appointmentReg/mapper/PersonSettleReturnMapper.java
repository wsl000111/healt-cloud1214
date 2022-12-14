package com.healt.cloud.checkup.appointmentReg.mapper;

import com.healt.cloud.checkup.entity.HcSettleMaster;
import com.healt.cloud.checkup.vo.settlement.SettleReturnItemListVo;
import com.healt.cloud.checkup.vo.settlement.SettleReturnPayListVo;
import com.healt.cloud.checkup.vo.settlement.SettleReturnPersonInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author linklee
 * @create 2022-04-18 16:03
 */
@Mapper
public interface PersonSettleReturnMapper {

    List<SettleReturnItemListVo> findSettleReturnItemList(@Param("hospitalId") String hospitalId, @Param("rcptNo") String rcptNo);

    List<SettleReturnPayListVo> findSettleReturnPayList(@Param("hospitalId") String hospitalId, @Param("rcptNo") String rcptNo);

    List<HcSettleMaster> findHcSettleMaster(@Param("hospitalId") String hospitalId, @Param("rcptNo") String rcptNo);

    List<SettleReturnPersonInfoVo> findSettleReturnPersonInfo(@Param("hospitalId") String hospitalId, @Param("personId") String personId, @Param("personVisitId") Integer personVisitId);

    void updateHcSettleMaster(@Param("returnReptNo") String returnReptNo,@Param("hospitalId") String hospitalId,@Param("rcptNo") String rcptNo);

    void updateHcSettleDetail(@Param("returnReptNo") String returnReptNo,@Param("hospitalId") String hospitalId,@Param("rcptNo") String rcptNo);

    void updatePersonAppregItems(@Param("hospitalId") String hospitalId,@Param("personId") String personId,@Param("personVisitId") Integer personVisitId,
                                 @Param("itemPackCode") String itemPackCode,@Param("itemNo") Integer itemNo);

    void updateNextChargeNoTwo(@Param("hospitalId") String hospitalId);

    List<SettleReturnItemListVo> findSettleReturnItemListNew(@Param("hospitalId") String hospitalId,@Param("rcptNo") String rcptNo);
}
