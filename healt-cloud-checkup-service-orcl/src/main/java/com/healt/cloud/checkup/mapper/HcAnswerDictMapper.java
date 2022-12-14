package com.healt.cloud.checkup.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.healt.cloud.checkup.entity.HcAnswerDict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 问卷信息答案维护 Mapper 接口
 * </p>
 *
 * @author linklee
 * @since 2022-06-14
 */
@Mapper
public interface HcAnswerDictMapper extends BaseMapper<HcAnswerDict> {

}
