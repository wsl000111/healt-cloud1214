package com.healt.cloud.checkup.mapper.appointmentReg;

import com.healt.cloud.checkup.queryReport.vo.MoneyTypeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-31 17:22
 */
@Mapper
public interface IncomStatByMoneyTypeMapper {

    List<MoneyTypeVo> findMoneyType(@Param("beginDate") String beginDate, @Param("endDate") String endDate);
}
