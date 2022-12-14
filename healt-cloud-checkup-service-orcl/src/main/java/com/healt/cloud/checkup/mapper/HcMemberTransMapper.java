package com.healt.cloud.checkup.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.healt.cloud.checkup.entity.HcMemberTrans;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 会员卡交易记录 Mapper 接口
 * </p>
 *
 * @author linklee
 * @since 2022-04-26
 */
@Mapper
public interface HcMemberTransMapper extends BaseMapper<HcMemberTrans> {

}
