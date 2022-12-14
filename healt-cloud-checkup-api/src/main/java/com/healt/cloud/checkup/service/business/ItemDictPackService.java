package com.healt.cloud.checkup.service.business;

import com.healt.cloud.checkup.entity.*;
import com.healt.cloud.checkup.vo.HospitalVo;
import com.healt.cloud.checkup.vo.busniess.itemPack.*;
import com.healt.cloud.common.pages.PageResult;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-11 9:55
 * @description: TODO
 */
public interface ItemDictPackService {

    List<HcItemPackDict> findDtItemPack(HcItemPackDictVo hcItemPackDictVo);

    List<HcPackVsItemDictVoResult> findtDtPackVsItem(HcPackVsItemDictVo hcPackVsItemDictVo);

    List<VExamClassDict> findDtExamClassDict(HospitalVo hospitalVo);

    List<VExamSubclassDict> findDtExamSubClassDict(HospitalVo hospitalVo);

    List<VItemPackClassDict> findDtPackClass(HospitalVo hospitalVo);

    List<VPackGuidegroupDict> findDtGuideGroup(HospitalVo hospitalVo);

    List<VTestTubeDict> findDtTestTube(HospitalVo hospitalVo);

    List<VPackSpecimanDict> findDtSpecimanName(HospitalVo hospitalVo);

    List<VCostclassDict> findDtCostClassDict(HospitalVo hospitalVo);

    List<VResultHandleDict> findDtResultHandle(HospitalVo hospitalVo);

    List<VInterfaceSource> findDtInterfaceSource(HospitalVo hospitalVo);

    void saveHcItemPackDict(SaveHcItemPackDictListVo saveHcItemPackDictListVo);

    void savePackVsItemDict(SavePackVsItemDictVo savePackVsItemDictVo);

    PageResult<HcItemPackDict> findDtItemPackPage(HcItemPackDictVo hcItemPackDictVo);

    List<HcItemPackDict> findItemPackDict(String hospitalId, String itemPackCode);
}
