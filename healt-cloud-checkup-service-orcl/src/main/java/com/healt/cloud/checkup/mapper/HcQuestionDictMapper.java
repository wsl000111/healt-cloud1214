package com.healt.cloud.checkup.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.healt.cloud.checkup.entity.HcQuestionDict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 健康问卷信息维护 Mapper 接口
 * </p>
 *
 * @author linklee
 * @since 2022-06-10
 */
@Mapper
public interface HcQuestionDictMapper extends BaseMapper<HcQuestionDict> {

}
