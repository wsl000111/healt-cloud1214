package com.healt.cloud.checkup.service.business.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.healt.cloud.checkup.entity.HcItemDict;
import com.healt.cloud.checkup.entity.VHcItemDict;
import com.healt.cloud.checkup.service.HcItemDictService;
import com.healt.cloud.checkup.service.VHcItemDictService;
import com.healt.cloud.checkup.service.business.ItemDictService;
import com.healt.cloud.checkup.vo.busniess.item.SaveHcItemDictListVo;
import com.healt.cloud.checkup.vo.busniess.item.SaveHcItemDictVo;
import com.healt.cloud.checkup.mapper.BusinessMapper;
import com.healt.cloud.checkup.vo.busniess.item.HcItemDictVo;
import com.healt.cloud.common.pages.PageResult;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * @author GuYue
 * @date 2022-03-11 9:55
 * @description: TODO
 */
@Service
@AllArgsConstructor
public class ItemDictServiceImpl implements ItemDictService {

    private HcItemDictService hcItemDictService;

    private VHcItemDictService vHcItemDictService;

    private BusinessMapper businessMapper;

    @Override
    public PageResult findHcItemDictPage(HcItemDictVo hcItemDictVo) {
        QueryWrapper<HcItemDict> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(hcItemDictVo.getInputCode())&&!"*".equals(hcItemDictVo.getInputCode())){
            queryWrapper.like("input_code", hcItemDictVo.getInputCode());
        }
        if(StringUtils.isNotEmpty(hcItemDictVo.getDeptId())){
            queryWrapper.eq("hospital_id", hcItemDictVo.getHospitalId());
            queryWrapper.eq("hc_dept_code", hcItemDictVo.getDeptId());
            queryWrapper.orderByAsc("sort_no");
            IPage<HcItemDict> page = new Page<>();
            page.setSize(hcItemDictVo.getPageSize());
            page.setCurrent(hcItemDictVo.getPageNum());
            page = hcItemDictService.page(page, queryWrapper);
            if(page.getRecords().size() == 0){
                List<HcItemDict> list = new ArrayList<>();
                list.add(new HcItemDict());
                page.setRecords(list);
            }
            return new PageResult<HcItemDict>(page.getCurrent(),page.getSize(),page.getTotal(), page.getPages(), page.getRecords());
        }else if(StringUtils.isNotEmpty(hcItemDictVo.getDeptClass())){
            if(StringUtils.isEmpty(hcItemDictVo.getInputCode())){
                hcItemDictVo.setInputCode(null);
            }
            int total = businessMapper.countItemDictByClass(hcItemDictVo);
            int pages = total%hcItemDictVo.getPageSize() == 0 ? total / hcItemDictVo.getPageSize() : total / hcItemDictVo.getPageSize() + 1;
            List<HcItemDict> list = businessMapper.findPageItemsByClass(hcItemDictVo);
            if(list.size() == 0){
                list.add(new HcItemDict());
            }
            return new PageResult<HcItemDict>(hcItemDictVo.getPageNum(),hcItemDictVo.getPageSize(), total, pages, list);
        }else{
            queryWrapper.eq("hospital_id", hcItemDictVo.getHospitalId());
            queryWrapper.orderByAsc("sort_no");
            IPage<HcItemDict> page = new Page<>();
            page.setSize(hcItemDictVo.getPageSize());
            page.setCurrent(hcItemDictVo.getPageNum());
            page = hcItemDictService.page(page, queryWrapper);
            if(page.getRecords().size() == 0){
                page.getRecords().add(new HcItemDict());
            }
            return new PageResult<HcItemDict>(page.getCurrent(),page.getSize(),page.getTotal(), page.getPages(), page.getRecords());
        }
    }

    @Override
    public void saveHcItemDictList(SaveHcItemDictListVo saveHcItemDictListVo) {
        for(SaveHcItemDictVo saveHcItemDictVo : saveHcItemDictListVo.getSaveHcItemDictList()){
            switch (saveHcItemDictVo.getStat()){
                case "delete" :
                    for(HcItemDict hcItemDict : saveHcItemDictVo.getHcItemDict()){
                        QueryWrapper<HcItemDict> queryWrapper = new QueryWrapper<>();
                        queryWrapper.eq("hospital_id", hcItemDict.getHospitalId());
                        queryWrapper.eq("item_code", hcItemDict.getItemCode());
                        hcItemDictService.remove(queryWrapper);
                    }
                    break;
                case "add":
                    hcItemDictService.saveBatch(saveHcItemDictVo.getHcItemDict());
                    break;
                case "update":
                    for(HcItemDict hcItemDict : saveHcItemDictVo.getHcItemDict()){
                        UpdateWrapper<HcItemDict> updateWrapper= new UpdateWrapper<>();
                        updateWrapper.eq("hospital_id", hcItemDict.getHospitalId());
                        updateWrapper.eq("item_code", hcItemDict.getItemCode());
                        hcItemDictService.update(hcItemDict, updateWrapper);
                    }
                    break;
            }
        }
    }

    @Override
    public List<HcItemDict> findHcItemDict(HcItemDictVo hcItemDictVo) {

        QueryWrapper<HcItemDict> queryWrapper = new QueryWrapper<>();
        List<HcItemDict> list = null;
        if(StringUtils.isNotEmpty(hcItemDictVo.getDeptId())){
            queryWrapper.eq("hospital_id", hcItemDictVo.getHospitalId());
            queryWrapper.eq("hc_dept_code", hcItemDictVo.getDeptId());
            queryWrapper.orderByAsc("sort_no");
            list = hcItemDictService.list(queryWrapper);
        }else if(StringUtils.isNotEmpty(hcItemDictVo.getDeptClass())){
            list = businessMapper.findItemsByClass(hcItemDictVo);
        }else{
            queryWrapper.eq("hospital_id", hcItemDictVo.getHospitalId());
            queryWrapper.orderByAsc("sort_no");
            list = hcItemDictService.list(queryWrapper);
        }
        if(list.size() == 0){
            list.add(new HcItemDict());
        }
        return list;
    }

    @Override
    public List<? extends Serializable> findVHcItemDict(HcItemDictVo hcItemDictVo) {
        QueryWrapper<HcItemDict> queryWrapper = new QueryWrapper<>();
        List<HcItemDict> list = null;
        if(StringUtils.isNotEmpty(hcItemDictVo.getDeptId())){
            QueryWrapper<VHcItemDict> queryWrapper1 = new QueryWrapper<>();
            queryWrapper.eq("hospital_id", hcItemDictVo.getHospitalId());
            queryWrapper.eq("hc_dept_code", hcItemDictVo.getDeptId());
            queryWrapper.orderByAsc("sort_no");
            List<VHcItemDict> listV = vHcItemDictService.list(queryWrapper1);
            return listV;
        }else if(StringUtils.isNotEmpty(hcItemDictVo.getDeptClass())){
            list = businessMapper.findItemsByClass(hcItemDictVo);
        }else{
            queryWrapper.eq("hospital_id", hcItemDictVo.getHospitalId());
            queryWrapper.orderByAsc("sort_no");
            list = hcItemDictService.list(queryWrapper);
        }
        if(list.size() == 0){
            list.add(new HcItemDict());
        }
        return list;
    }

}
