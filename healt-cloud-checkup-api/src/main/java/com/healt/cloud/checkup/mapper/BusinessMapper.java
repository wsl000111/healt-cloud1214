package com.healt.cloud.checkup.mapper;

import com.healt.cloud.checkup.entity.HcItemDict;
import com.healt.cloud.checkup.entity.HcItemPackDict;
import com.healt.cloud.checkup.vo.busniess.item.HcItemDictVo;
import com.healt.cloud.checkup.vo.busniess.itemExtern.ItemPackLabVo;
import com.healt.cloud.checkup.vo.busniess.itemPack.HcItemPackDictVo;
import com.healt.cloud.checkup.vo.busniess.itemPack.HcPackVsItemDictVo;
import com.healt.cloud.checkup.vo.busniess.itemPack.HcPackVsItemDictVoResult;
import com.healt.cloud.checkup.vo.busniess.packClinic.VClinicItemsVo;
import com.healt.cloud.checkup.vo.busniess.packSet.HcSetVsPackDictVo;
import com.healt.cloud.checkup.vo.busniess.packSet.PackSetNewVo;
import com.healt.cloud.checkup.vo.busniess.packSet.VHcItemPackDictVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-08 16:49
 * @description: TODO
 */
@Mapper
public interface BusinessMapper {

    List<HcItemDict> findItemsByClass(HcItemDictVo hcItemDictVo);

    List<HcItemDict> findPageItemsByClass(HcItemDictVo hcItemDictVo);

    int countItemDictByClass(HcItemDictVo hcItemDictVo);

    List<HcItemPackDict> findItemPackByClass(HcItemPackDictVo hcItemPackDictVo);

    List<HcPackVsItemDictVoResult> findtDtPackVsItem(HcPackVsItemDictVo hcPackVsItemDictVo);

    List<VClinicItemsVo> findDtClinicItems(@Param("itemClass") String itemClass);

    List<HcSetVsPackDictVo> findDtSetVsPack(@Param("hospitalId") String hospitalId, @Param("setCode") String setCode);

    List<VHcItemPackDictVo> findDtItemPackDict(String hospitalId);

    List<ItemPackLabVo> findDtItemPackLab(@Param("hospitalId") String hospitalId);

    List<HcItemPackDict> findItemPackByClassPage(HcItemPackDictVo hcItemPackDictVo);

    int findItemPackByClassTotal(HcItemPackDictVo hcItemPackDictVo);

    List<PackSetNewVo> findPackSetNew();
}

