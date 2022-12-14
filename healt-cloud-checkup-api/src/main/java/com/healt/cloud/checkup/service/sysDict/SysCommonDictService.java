package com.healt.cloud.checkup.service.sysDict;

import com.healt.cloud.checkup.vo.sys.common.*;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-05 14:17
 * @description: TODO
 */
public interface SysCommonDictService {

    List<DtTableVoResult> findDtTable(DtTableVo dtTableVo);

    List<DictColumnsVoResult> findDictColumns(DictColumnsVo dictColumnsVo);

    Object loadDtDict(DtDictVo tableName);

    void saveCommonTable(SaveCommonTableVo saveCommonTableVo);

    List<CommonDictVoResult> findPublicDict(String dictType);

    List<CommonDictVoResult1> findPublicDict1(String dictType);
}
