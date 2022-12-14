package com.healt.cloud.checkup.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.healt.cloud.checkup.entity.HcQueueNo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 本表记录体检人员报到的顺序号，唯一对应一个体检人员。 Mapper 接口
 * </p>
 *
 * @author linklee
 * @since 2022-06-18
 */
@Mapper
public interface HcQueueNoMapper extends BaseMapper<HcQueueNo> {

}
