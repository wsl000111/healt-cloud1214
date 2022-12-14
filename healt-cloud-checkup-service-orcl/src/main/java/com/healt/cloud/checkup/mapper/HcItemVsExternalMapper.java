package com.healt.cloud.checkup.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.healt.cloud.checkup.entity.HcItemVsExternal;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 项目与检验项目结果对照 Mapper 接口
 * </p>
 *
 * @author GuYue
 * @since 2022-03-18
 */
@Mapper
public interface HcItemVsExternalMapper extends BaseMapper<HcItemVsExternal> {

}
