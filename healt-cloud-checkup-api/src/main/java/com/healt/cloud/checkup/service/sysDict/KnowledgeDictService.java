package com.healt.cloud.checkup.service.sysDict;

import com.healt.cloud.checkup.entity.HcDiseaseDict;
import com.healt.cloud.checkup.entity.HcKnowledgeDict;
import com.healt.cloud.checkup.vo.sys.knowledge.*;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-21 12:42
 * @description: TODO
 */
public interface KnowledgeDictService {
    List<HcKnowledgeDict> findKnowledgeList(HcKnowledgeDictVo hcKnowledgeDictVo);

    List<HcDiseaseDict> findDiseaseList(String hospitalId);

    List<ItemsDepartListVo> findItemsDepartList();

    void saveHcKnowledgeDictListVo(SaveHcKnowledgeDictListVo saveHcKnowledgeDictListVo);

    List<HcKnowledgeDictVoRsp> findKnowledgeDict(HcKnowledgeDictVoReq hcResultDict);
}
