package com.healt.cloud.checkup.mapper.appointmentReg;

import com.healt.cloud.checkup.queryReport.vo.SettleMasterQueryDictVo;
import com.healt.cloud.checkup.queryReport.vo.SettleMasterQueryNewVo;
import com.healt.cloud.checkup.queryReport.vo.SettleMasterQueryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-31 10:39
 */
@Mapper
public interface SettleMasterQueryMapper {

    List<SettleMasterQueryVo> findSettleMasterQuery(SettleMasterQueryDictVo settleMasterQueryDictVo);

    List<SettleMasterQueryNewVo> findSettleMasterQueryNew(SettleMasterQueryDictVo settleMasterQueryDictVo);
}
