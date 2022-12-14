package com.healt.cloud.checkup.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.healt.cloud.checkup.entity.CostChargeStateDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * HIS计费返回的收费状态主表 Mapper 接口
 * </p>
 *
 * @author GuYue
 * @since 2022-08-11
 */
@Mapper
public interface CostChargeStateDetailMapper extends BaseMapper<CostChargeStateDetail> {

}
