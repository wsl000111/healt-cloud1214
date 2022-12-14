package com.healt.cloud.checkup.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.healt.cloud.checkup.entity.HcDeptResultItems;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 体检分科结果明细记录 Mapper 接口
 * </p>
 *
 * @author GuYue
 * @since 2022-05-23
 */
@Mapper
public interface HcDeptResultItemsMapper extends BaseMapper<HcDeptResultItems> {

}
