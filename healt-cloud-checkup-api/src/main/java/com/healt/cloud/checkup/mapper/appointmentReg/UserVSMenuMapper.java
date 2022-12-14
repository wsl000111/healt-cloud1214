package com.healt.cloud.checkup.mapper.appointmentReg;

import com.healt.cloud.checkup.sysDict.vo.MenuListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-27 17:09
 */
@Mapper
public interface UserVSMenuMapper {

    List<MenuListVo> findAlreadyMenuList(@Param("hospitalId") String hospitalId, @Param("userId") String userId);

    List<MenuListVo> findUnallocatedMenuList(@Param("hospitalId") String hospitalId,@Param("userId") String userId);
}
