package com.healt.cloud.checkup.mapper;

import com.healt.cloud.checkup.vo.HospitalVo;
import com.healt.cloud.checkup.vo.sys.common.*;
import com.healt.cloud.checkup.vo.sys.depart.VHisDeptDictVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-08 16:49
 * @description: TODO
 */
@Mapper
public interface CommonMapper {

    List<DtTableVoResult> findDtTable(DtTableVo dtTableVo);

    List<DictColumnsVoResult> findDictColumns(DictColumnsVo dictColumnsVo);

    List<IndexColumnsVo> findIndexColumns(String tableName);

    List<VHisDeptDictVo> findDtHisDepart(HospitalVo hospitalVo);
}

