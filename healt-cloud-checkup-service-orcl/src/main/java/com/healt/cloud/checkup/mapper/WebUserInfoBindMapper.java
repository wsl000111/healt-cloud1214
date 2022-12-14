package com.healt.cloud.checkup.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.healt.cloud.checkup.entity.WebUserInfoBind;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 体检人绑定关系表 Mapper 接口
 * </p>
 *
 * @author GuYue
 * @since 2022-10-16
 */
@Mapper
public interface WebUserInfoBindMapper extends BaseMapper<WebUserInfoBind> {

}
