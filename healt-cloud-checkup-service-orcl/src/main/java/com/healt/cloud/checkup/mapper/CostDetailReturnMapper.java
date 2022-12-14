package com.healt.cloud.checkup.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.healt.cloud.checkup.entity.CostDetailReturn;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 体检传HIS收费临时表 Mapper 接口
 * </p>
 *
 * @author GuYue
 * @since 2022-08-01
 */
@Mapper
public interface CostDetailReturnMapper extends BaseMapper<CostDetailReturn> {

}
