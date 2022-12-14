package com.healt.cloud.checkup.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.healt.cloud.checkup.entity.HcResultDict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 体检项目结果记录 Mapper 接口
 * </p>
 *
 * @author GuYue
 * @since 2022-05-23
 */
@Mapper
public interface HcResultDictMapper extends BaseMapper<HcResultDict> {

}
