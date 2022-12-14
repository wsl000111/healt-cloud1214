package com.healt.cloud.checkup.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.healt.cloud.checkup.entity.HcRoomVsAssem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 检查室与项目组合对照表 Mapper 接口
 * </p>
 *
 * @author linklee
 * @since 2022-06-18
 */
@Mapper
public interface HcRoomVsAssemMapper extends BaseMapper<HcRoomVsAssem> {

}
