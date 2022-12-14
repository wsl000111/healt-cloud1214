package com.healt.cloud.checkup.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.healt.cloud.checkup.entity.WebSetVsUnit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 公众号套餐与单位对照表 Mapper 接口
 * </p>
 *
 * @author GuYue
 * @since 2022-10-23
 */
@Mapper
public interface WebSetVsUnitMapper extends BaseMapper<WebSetVsUnit> {

}
