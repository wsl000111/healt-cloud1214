package com.healt.cloud.checkup.mapper;

import com.healt.cloud.checkup.vo.busniess.clinicPrice.HcPersonPriceVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-07-14 17:20
 * @description: TODO
 */
@Mapper
public interface MyHcPackVsPriceMapper {
    List<HcPersonPriceVo> findHcPersonPriceByUnit(String hospitalId, String unitId, String unitVisitId);

    List<HcPersonPriceVo> findHcPersonPriceByPerson(String hospitalId, String personId, String personVisitId);

    List<HcPersonPriceVo> findHcPersonPriceByUnitPerson(@Param("hospitalId") String hospitalId,
                                                        @Param("unitId") String unitId,
                                                        @Param("unitVisitId")String unitVisitId,
                                                        @Param("personIdStrWhe")String personIdStrWhe);
}
