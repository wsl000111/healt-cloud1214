package com.healt.cloud.checkup.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.healt.cloud.checkup.entity.HcDiseaseDict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 体检疾病诊断字典 Mapper 接口
 * </p>
 *
 * @author GuYue
 * @since 2022-05-30
 */
@Mapper
public interface HcDiseaseDictMapper extends BaseMapper<HcDiseaseDict> {

}
