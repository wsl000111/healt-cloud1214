package com.healt.cloud.checkup.mapper.appointmentReg;

import com.healt.cloud.checkup.queryReport.vo.PersonListVo;
import com.healt.cloud.checkup.queryReport.vo.StrWherePageVo;
import com.healt.cloud.checkup.queryReport.vo.SumItemsVo;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author linklee
 * @create 2022-05-26 13:51
 */
@Mapper
public interface QueueStatMapper {

    List<PersonListVo> findPersonListTotal(StrWherePageVo strWherePageVo);

    List<PersonListVo> findPersonList(StrWherePageVo strWherePageVo);

    List<SumItemsVo> findSumItemsTotal(StrWherePageVo strWherePageVo);

    List<SumItemsVo> findSumItems(StrWherePageVo strWherePageVo);

    String findSumCharges(StrWherePageVo strWherePageVo);

    String findSumChargesNew(StrWherePageVo strWherePageVo);
}
