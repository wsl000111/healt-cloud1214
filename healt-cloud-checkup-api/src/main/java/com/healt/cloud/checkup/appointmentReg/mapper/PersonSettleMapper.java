package com.healt.cloud.checkup.appointmentReg.mapper;

import com.healt.cloud.checkup.vo.settlement.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author linklee
 * @create 2022-04-09 15:24
 */
@Mapper
public interface PersonSettleMapper {

    List<SettleItemListVo> findSettleItemList(@Param("hospitalId") String hospitalId, @Param("personId") String personId, @Param("personVisitId") Integer personVisitId);

    List<SettlePayListVo> findSettlePayList();

    List<PersonVisitAndInfoVo> findPersonVisitAndInfo(@Param("hospitalId") String hospitalId, @Param("personId") String personId);

    String findMoneyInCard(@Param("hospitalId") String hospitalId,@Param("cardNo") String cardNo);

    List<HospitalDictVo> findHospitalDict(@Param("hospitalId") String hospitalId);

    void updateMoneyInCard(@Param("hospitalId") String hospitalId,@Param("cardNo") String cardNo,@Param("paymentMoney") String paymentMoney);

    void updateNextChargeNo(@Param("hospitalId") String hospitalId);

    void updateBillIndicator(@Param("hospitalId") String hospitalId,@Param("personId") String personId,@Param("personVisitId") Integer personVisitId);

    String getMemberTransNo(@Param("hospitalId") String hospitalId);

    void saveHcMemberTrans(@Param("hospitalId") String hospitalId,@Param("cardNo") String cardNo,@Param("transNo") String transNo,@Param("transType") String transType,
                           @Param("pay") String pay,@Param("money") BigDecimal money,@Param("userId") String userId,@Param("note") String note);

    List<SbYyVo> findSbYy(@Param("hospitalId") String hospitalId, @Param("unitId") String unitId, @Param("unitVisitId") Integer unitVisitId, @Param("schemeCode") String schemeCode);
}
