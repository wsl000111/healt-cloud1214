package com.healt.cloud.checkup.appointmentReg.mapper;

import com.healt.cloud.checkup.entity.HcChangeVsItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-16 14:38
 */
@Mapper
public interface ChangeItemMapper {

    List<HcChangeVsItem> findChangeVsItem(@Param("hospitalId") String hospitalId, @Param("itemCode") String itemCode);
}
