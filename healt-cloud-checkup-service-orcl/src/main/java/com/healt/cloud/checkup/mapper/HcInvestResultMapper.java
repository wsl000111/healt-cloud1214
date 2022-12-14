package com.healt.cloud.checkup.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.healt.cloud.checkup.entity.HcInvestResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 体检人员问卷结果表 Mapper 接口
 * </p>
 *
 * @author linklee
 * @since 2022-06-13
 */
@Mapper
public interface HcInvestResultMapper extends BaseMapper<HcInvestResult> {

}
