package com.healt.cloud.checkup.appointmentReg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.healt.cloud.checkup.entity.HcChangeVsItem;
import com.healt.cloud.checkup.vo.appointmentReg.changeVSItem.SaveHcChangeVsItemListVo;
import com.healt.cloud.checkup.vo.appointmentReg.changeVSItem.SaveHcChangeVsItemVo;
import com.healt.cloud.checkup.appointmentReg.mapper.ChangeVSItemMapper;
import com.healt.cloud.checkup.appointmentReg.service.ChangeVSItemService;
import com.healt.cloud.checkup.service.HcChangeVsItemService;
import com.healt.cloud.checkup.vo.appointmentReg.changeVSItem.ChangeVSItemVo;
import com.healt.cloud.common.pages.PageResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linklee
 * @create 2022-05-13 10:54
 */
@Service
@AllArgsConstructor
public class ChangeVSItemServiceImpl implements ChangeVSItemService {

    private ChangeVSItemMapper changeVSItemMapper;

    private HcChangeVsItemService hcChangeVsItemService;

    @Override
    public PageResult findDtChangeVSItem(ChangeVSItemVo changeVSItemVo) {
        QueryWrapper<HcChangeVsItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hospital_id", changeVSItemVo.getHospitalCode());
        IPage<HcChangeVsItem> page = new Page<>();
        page.setSize(changeVSItemVo.getPageSize());
        page.setCurrent(changeVSItemVo.getPageNum());
        page = hcChangeVsItemService.page(page, queryWrapper);
        if(page.getRecords().size() == 0){
            List<HcChangeVsItem> list = new ArrayList<>();
            list.add(new HcChangeVsItem());
            return new PageResult(page.getCurrent(),page.getSize(),page.getTotal(), page.getPages(), list);
        } else {
            return new PageResult(page.getCurrent(),page.getSize(),page.getTotal(), page.getPages(), page.getRecords());
        }
    }

    @Override
    @Transactional
    public void saveHcChangeVsItemList(SaveHcChangeVsItemListVo saveHcChangeVsItemList) {
        for (SaveHcChangeVsItemVo saveHcChangeVsItemVo : saveHcChangeVsItemList.getSaveHcChangeVsItem()) {
            switch (saveHcChangeVsItemVo.getStat()) {
                case "delete" :
                    for (HcChangeVsItem hcChangeVsItem : saveHcChangeVsItemVo.getHcChangeVsItem()) {
                        QueryWrapper<HcChangeVsItem> queryWrapper = new QueryWrapper<>();
                        queryWrapper.eq("HOSPITAL_ID", hcChangeVsItem.getHospitalId());
                        queryWrapper.eq("ITEM_CODE", hcChangeVsItem.getItemCode());
                        queryWrapper.eq("ITEM_NO", hcChangeVsItem.getItemNo());
                        hcChangeVsItemService.remove(queryWrapper);
                    }
                    break;
                case "add" :
                    hcChangeVsItemService.saveBatch(saveHcChangeVsItemVo.getHcChangeVsItem());
                    break;
                case "update" :
                    for (HcChangeVsItem hcChangeVsItem : saveHcChangeVsItemVo.getHcChangeVsItem()) {
                        UpdateWrapper<HcChangeVsItem> updateWrapper = new UpdateWrapper<>();
                        updateWrapper.eq("HOSPITAL_ID", hcChangeVsItem.getHospitalId());
                        updateWrapper.eq("ITEM_CODE", hcChangeVsItem.getItemCode());
                        updateWrapper.eq("ITEM_NO", hcChangeVsItem.getItemNo());
                        hcChangeVsItemService.update(hcChangeVsItem,updateWrapper);
                    }
                    break;
            }
        }
    }
}
