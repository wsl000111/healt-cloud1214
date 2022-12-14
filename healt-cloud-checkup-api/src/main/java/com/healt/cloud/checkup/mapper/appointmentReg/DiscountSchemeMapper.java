package com.healt.cloud.checkup.mapper.appointmentReg;

import com.healt.cloud.checkup.entity.HcDiscountScheme;
import com.healt.cloud.checkup.entity.HcDiscountSchemeDetail;
import com.healt.cloud.checkup.vo.settlement.DtItemPackVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-05 14:27
 */
@Mapper
public interface DiscountSchemeMapper {

    List<DtItemPackVo> findDtItemPack(@Param("hospitalId") String hospitalId);

    List<HcDiscountScheme> findDiscountScheme();

    List<HcDiscountSchemeDetail> findDiscountSchemeDetail();

    String findSysdate();
}
