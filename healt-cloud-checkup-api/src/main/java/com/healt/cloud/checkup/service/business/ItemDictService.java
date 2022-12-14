package com.healt.cloud.checkup.service.business;

import com.healt.cloud.checkup.entity.HcItemDict;
import com.healt.cloud.checkup.vo.busniess.item.HcItemDictVo;
import com.healt.cloud.checkup.vo.busniess.item.SaveHcItemDictListVo;
import com.healt.cloud.common.pages.PageResult;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-11 9:55
 * @description: TODO
 */
public interface ItemDictService {

    List<HcItemDict> findHcItemDict(HcItemDictVo hcItemDictVo);

    List<? extends Serializable> findVHcItemDict(HcItemDictVo hcItemDictVo);

    PageResult findHcItemDictPage(HcItemDictVo hcItemDictVo);

    void saveHcItemDictList(SaveHcItemDictListVo saveHcItemDictListVo);
}
