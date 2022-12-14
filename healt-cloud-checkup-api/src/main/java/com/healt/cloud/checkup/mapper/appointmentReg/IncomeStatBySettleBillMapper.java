package com.healt.cloud.checkup.mapper.appointmentReg;

import com.healt.cloud.checkup.queryReport.vo.SettleBillDictVo;
import com.healt.cloud.checkup.queryReport.vo.SettleBillVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author linklee
 * @create 2022-06-02 16:49
 */
@Mapper
public interface IncomeStatBySettleBillMapper {

    List<SettleBillVo> findSettleBill(SettleBillDictVo settleBillDictVo);
}
