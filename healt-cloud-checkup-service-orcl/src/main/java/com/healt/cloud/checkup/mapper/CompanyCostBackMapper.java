package com.healt.cloud.checkup.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.healt.cloud.checkup.entity.CompanyCostBack;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 体检单位传HIS收费临时表 Mapper 接口
 * </p>
 *
 * @author GuYue
 * @since 2022-09-02
 */
@Mapper
public interface CompanyCostBackMapper extends BaseMapper<CompanyCostBack> {

}
