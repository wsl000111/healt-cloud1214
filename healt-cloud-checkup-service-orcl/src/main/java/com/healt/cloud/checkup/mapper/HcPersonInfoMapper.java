package com.healt.cloud.checkup.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.healt.cloud.checkup.entity.HcPersonInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 人员信息表 Mapper 接口
 * </p>
 *
 * @author GuYue
 * @since 2022-07-13
 */
@Mapper
public interface HcPersonInfoMapper extends BaseMapper<HcPersonInfo> {

}
