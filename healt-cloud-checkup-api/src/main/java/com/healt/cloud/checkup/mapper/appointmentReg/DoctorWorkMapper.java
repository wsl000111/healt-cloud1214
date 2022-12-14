package com.healt.cloud.checkup.mapper.appointmentReg;

import com.healt.cloud.checkup.queryReport.vo.DoctorItemVo;
import com.healt.cloud.checkup.queryReport.vo.EditerItemVo;
import com.healt.cloud.checkup.queryReport.vo.FinalDocoterVo;
import com.healt.cloud.checkup.queryReport.vo.ItemPackVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-29 13:14
 */
@Mapper
public interface DoctorWorkMapper {

    List<DoctorItemVo> findDoctorItem(@Param("beginDate") String beginDate, @Param("endDate") String endDate);

    List<EditerItemVo> findEditerItem(@Param("beginDate") String beginDate, @Param("endDate") String endDate);

    List<FinalDocoterVo> findFinalDocoter(@Param("beginDate") String beginDate, @Param("endDate") String endDate);

    List<ItemPackVo> findItemPack(@Param("beginDate") String beginDate, @Param("endDate") String endDate);
}
