package com.healt.cloud.checkup.service.business.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.healt.cloud.checkup.entity.HcItemVsExternal;
import com.healt.cloud.checkup.service.business.ItemVsExernService;
import com.healt.cloud.checkup.vo.busniess.itemExtern.ItemPackLabVo;
import com.healt.cloud.checkup.vo.busniess.itemExtern.SaveHcItemVsExternalListVo;
import com.healt.cloud.checkup.mapper.BusinessMapper;
import com.healt.cloud.checkup.service.HcItemVsExternalService;
import com.healt.cloud.checkup.vo.busniess.itemExtern.SaveHcItemVsExternalVo;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-18 9:33
 * @description: TODO
 */
@Service
@AllArgsConstructor
public class ItemVsExernServiceImpl implements ItemVsExernService {

    private HcItemVsExternalService hcItemVsExternalService;

    private BusinessMapper businessMapper;

    @Override
    public List<HcItemVsExternal> findDtItemVsExtern(String hospitalId, String itemCode) {
        QueryWrapper<HcItemVsExternal> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(itemCode)){
            queryWrapper.eq("HC_ITEM_CODE", itemCode);
        }
        queryWrapper.eq("HOSPITAL_ID", hospitalId);
        queryWrapper.orderByAsc("ITEM_NO");
        List<HcItemVsExternal> list = hcItemVsExternalService.list(queryWrapper);
        if(list.size() == 0){
            list.add(new HcItemVsExternal());
        }
        return list;
    }

    @Override
    public List<ItemPackLabVo> findDtItemPackLab(String hospitalId) {
        List<ItemPackLabVo> list = businessMapper.findDtItemPackLab(hospitalId);
        if(list.size() == 0){
            list.add(new ItemPackLabVo());
        }
        return list;
    }

    @Override
    public void saveHcItemVsExternalListVo(SaveHcItemVsExternalListVo saveHcItemVsExternalListVo) {
        List<SaveHcItemVsExternalVo> saveHcItemVsExternalList = saveHcItemVsExternalListVo.getSaveHcItemVsExternalList();
        for(SaveHcItemVsExternalVo saveHcItemVsExternalVo : saveHcItemVsExternalList){
            switch (saveHcItemVsExternalVo.getStat()){
                case "add":
                    hcItemVsExternalService.saveBatch(saveHcItemVsExternalVo.getHcItemVsExternal());
                    break;
                case "delete":
                    for(HcItemVsExternal hcItemVsExternal : saveHcItemVsExternalVo.getHcItemVsExternal()){
                        LambdaQueryWrapper<HcItemVsExternal> queryWrapper = new LambdaQueryWrapper<>();
                        queryWrapper.eq(HcItemVsExternal::getHcItemCode, hcItemVsExternal.getHcItemCode());
                        queryWrapper.eq(HcItemVsExternal::getExtCode, hcItemVsExternal.getExtCode());
                        hcItemVsExternalService.remove(queryWrapper);
                    }
                    break;
                case "update":
                    for (HcItemVsExternal hcItemVsExternal : saveHcItemVsExternalVo.getHcItemVsExternal()){
                        LambdaUpdateWrapper<HcItemVsExternal> updateWrapper = new LambdaUpdateWrapper<>();
                        updateWrapper.eq(HcItemVsExternal::getHcItemCode, hcItemVsExternal.getHcItemCode());
                        //updateWrapper.eq(HcItemVsExternal::getExtCode, hcItemVsExternal.getExtCode());
                        hcItemVsExternalService.update(hcItemVsExternal, updateWrapper);
                    }
                    break;
            }
        }
    }
}
