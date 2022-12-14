package com.healt.cloud.checkup.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.healt.cloud.checkup.entity.HcPackVsPrice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 体检组合项目对照HIS价表项目 Mapper 接口
 * </p>
 *
 * @author GuYue
 * @since 2022-07-14
 */
@Mapper
public interface HcPackVsPriceMapper extends BaseMapper<HcPackVsPrice> {

}
