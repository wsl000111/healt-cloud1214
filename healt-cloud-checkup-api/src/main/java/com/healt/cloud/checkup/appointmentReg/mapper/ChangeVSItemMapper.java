package com.healt.cloud.checkup.appointmentReg.mapper;

import com.healt.cloud.checkup.entity.HcChangeVsItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-13 10:55
 */
@Mapper
public interface ChangeVSItemMapper {

    List<HcChangeVsItem> findDtChangeVSItem(@Param("hospitalId") String hospitalId);

}
