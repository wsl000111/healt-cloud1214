package com.healt.cloud.checkup.service.business.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.healt.cloud.checkup.entity.*;
import com.healt.cloud.checkup.service.*;
import com.healt.cloud.checkup.vo.HospitalVo;
import com.healt.cloud.checkup.vo.busniess.itemPack.*;
import com.healt.cloud.checkup.mapper.BusinessMapper;
import com.healt.cloud.checkup.service.business.ItemDictPackService;
import com.healt.cloud.common.pages.PageResult;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author GuYue
 * @date 2022-03-11 9:55
 * @description: TODO
 */
@Service
@AllArgsConstructor
public class ItemDictPackServiceImpl implements ItemDictPackService {

    private HcItemPackDictService hcItemPackDictService;

    private VExamClassDictService vExamClassDictService;

    private VExamSubclassDictService vExamSubclassDictService;

    private VItemPackClassDictService vItemPackClassDictService;

    private VPackGuidegroupDictService vPackGuidegroupDictService;

    private VTestTubeDictService vTestTubeDictService;

    private VPackSpecimanDictService vPackSpecimanDictService;

    private VCostclassDictService vCostclassDictService;

    private VResultHandleDictService vResultHandleDictService;

    private VInterfaceSourceService vInterfaceSourceService;

    private HcPackVsItemDictService hcPackVsItemDictService;

    private HcPackVsClinicService hcPackVsClinicService;

    private BusinessMapper businessMapper;

    @Override
    public List<HcItemPackDict> findDtItemPack(HcItemPackDictVo hcItemPackDictVo) {
        QueryWrapper<HcItemPackDict> queryWrapper = new QueryWrapper<>();
        List<HcItemPackDict> list = new ArrayList<>();
        if(StringUtils.isNotEmpty(hcItemPackDictVo.getDeptId())){
            queryWrapper.eq("hospital_id", hcItemPackDictVo.getHospitalId());
            queryWrapper.eq("hc_dept_code", hcItemPackDictVo.getDeptId());
            queryWrapper.orderByAsc("sort_no");
            list = hcItemPackDictService.list(queryWrapper);

        }else if(StringUtils.isNotEmpty(hcItemPackDictVo.getDeptClass())){
            list = businessMapper.findItemPackByClass(hcItemPackDictVo);
        }else{
            queryWrapper.eq("hospital_id", hcItemPackDictVo.getHospitalId());
            queryWrapper.orderByAsc("sort_no");
            list = hcItemPackDictService.list(queryWrapper);
        }
        if(list.size() == 0){
            list.add(new HcItemPackDict());
        }
        return list;
    }

    @Override
    public PageResult<HcItemPackDict> findDtItemPackPage(HcItemPackDictVo hcItemPackDictVo) {
        QueryWrapper<HcItemPackDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hospital_id", hcItemPackDictVo.getHospitalId());
        queryWrapper.orderByAsc("sort_no");
        String columnName = hcItemPackDictVo.getColumnName();
        String columnValue = hcItemPackDictVo.getColumnValue();

        IPage<HcItemPackDict> page = new Page<>();
        page.setCurrent(hcItemPackDictVo.getPageNum());
        page.setSize(hcItemPackDictVo.getPageSize());
        PageResult<HcItemPackDict> result;
        if(StringUtils.isNotEmpty(hcItemPackDictVo.getDeptId())){
            if(StringUtils.isNotEmpty(columnName)&&StringUtils.isNotEmpty(columnValue)){
                columnName = columnName.substring(columnName.indexOf(".")+1);
                queryWrapper.like(columnName, columnValue);
            }
            queryWrapper.eq("hc_dept_code", hcItemPackDictVo.getDeptId());
            page = hcItemPackDictService.page(page, queryWrapper);
            if(page.getRecords().size() == 0){
                List<HcItemPackDict> li = new ArrayList<>();
                li.add(new HcItemPackDict());
                page.setRecords(li);
            }
            result = new PageResult<HcItemPackDict>(page.getCurrent(), page.getSize(), page.getTotal(), page.getPages(), page.getRecords());
        }else if(StringUtils.isNotEmpty(hcItemPackDictVo.getDeptClass())){
            if(StringUtils.isEmpty(columnName)||StringUtils.isEmpty(columnValue)){
                hcItemPackDictVo.setColumnName(null);
                hcItemPackDictVo.setColumnValue(null);
            }
            List<HcItemPackDict> list = businessMapper.findItemPackByClassPage(hcItemPackDictVo);
            if(list == null || list.size() == 0){
                list.add(new HcItemPackDict());
            }
            int totalSize = businessMapper.findItemPackByClassTotal(hcItemPackDictVo);
            int totalPages = totalSize%hcItemPackDictVo.getPageSize() == 0 ? totalSize / hcItemPackDictVo.getPageSize() : totalSize / hcItemPackDictVo.getPageSize() + 1;
            result = new PageResult<HcItemPackDict>(hcItemPackDictVo.getPageNum(), hcItemPackDictVo.getPageSize(), totalSize, totalPages, list);
        }else{
            if(StringUtils.isNotEmpty(columnName)&&StringUtils.isNotEmpty(columnValue)){
                columnName = columnName.substring(columnName.indexOf(".")+1);
                queryWrapper.like(columnName, columnValue);
            }
            page = hcItemPackDictService.page(page, queryWrapper);
            if(page.getRecords().size() == 0){
                List<HcItemPackDict> li = new ArrayList<>();
                li.add(new HcItemPackDict());
                page.setRecords(li);
            }
            result = new PageResult<HcItemPackDict>(page.getCurrent(), page.getSize(), page.getTotal(), page.getPages(), page.getRecords());
        }
        return result;
    }

    @Override
    public List<HcItemPackDict> findItemPackDict(String hospitalId, String itemPackCode) {
        QueryWrapper<HcItemPackDict> wrapper = new QueryWrapper<>();
        wrapper.eq("HOSPITAL_ID",hospitalId);
        wrapper.eq("ITEM_PACK_CODE",itemPackCode);
        List<HcItemPackDict> list = hcItemPackDictService.list(wrapper);
        if (list.size() == 0) {
            list.add(new HcItemPackDict());
        }
        return list;
    }

    @Override
    public List<HcPackVsItemDictVoResult> findtDtPackVsItem(HcPackVsItemDictVo hcPackVsItemDictVo) {
        List<HcPackVsItemDictVoResult> list = businessMapper.findtDtPackVsItem(hcPackVsItemDictVo);
        if(list.size() == 0){
            list.add(new HcPackVsItemDictVoResult());
        }
        return list;
    }

    @Override
    public List<VExamClassDict> findDtExamClassDict(HospitalVo hospitalVo) {
        QueryWrapper<VExamClassDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("serial_no");
        if(StringUtils.isNotEmpty(hospitalVo.getHospitalCode())){
            queryWrapper.eq("hospital_id", hospitalVo.getHospitalCode());
        }
        List<VExamClassDict> list = vExamClassDictService.list(queryWrapper);
        if(list.size() == 0){
            list.add(new VExamClassDict());
        }
        return list;
    }

    @Override
    public List<VExamSubclassDict> findDtExamSubClassDict(HospitalVo hospitalVo) {
        QueryWrapper<VExamSubclassDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("serial_no");
        if(StringUtils.isNotEmpty(hospitalVo.getHospitalCode())){
            queryWrapper.eq("hospital_id", hospitalVo.getHospitalCode());
        }
        List<VExamSubclassDict> list = vExamSubclassDictService.list(queryWrapper);
        if(list.size() == 0){
            list.add(new VExamSubclassDict());
        }
        return list;
    }

    @Override
    public List<VItemPackClassDict> findDtPackClass(HospitalVo hospitalVo) {
        QueryWrapper<VItemPackClassDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort_no");
        if(StringUtils.isNotEmpty(hospitalVo.getHospitalCode())){
            queryWrapper.eq("hospital_id", hospitalVo.getHospitalCode());
        }
        List<VItemPackClassDict> list = vItemPackClassDictService.list(queryWrapper);
        if(list.size() == 0){
            list.add(new VItemPackClassDict());
        }
        return list;
    }

    @Override
    public List<VPackGuidegroupDict> findDtGuideGroup(HospitalVo hospitalVo) {
        QueryWrapper<VPackGuidegroupDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort_no");
        if(StringUtils.isNotEmpty(hospitalVo.getHospitalCode())){
            queryWrapper.eq("hospital_id", hospitalVo.getHospitalCode());
        }
        List<VPackGuidegroupDict> list = vPackGuidegroupDictService.list(queryWrapper);
        if(list.size() == 0){
            list.add(new VPackGuidegroupDict());
        }
        return list;
    }

    @Override
    public List<VTestTubeDict> findDtTestTube(HospitalVo hospitalVo) {
        QueryWrapper<VTestTubeDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort_no");
        if(StringUtils.isNotEmpty(hospitalVo.getHospitalCode())){
            queryWrapper.eq("hospital_id", hospitalVo.getHospitalCode());
        }
        List<VTestTubeDict> list = vTestTubeDictService.list(queryWrapper);
        if(list.size() == 0){
            list.add(new VTestTubeDict());
        }
        return list;
    }

    @Override
    public List<VPackSpecimanDict> findDtSpecimanName(HospitalVo hospitalVo) {
        QueryWrapper<VPackSpecimanDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort_no");
        if(StringUtils.isNotEmpty(hospitalVo.getHospitalCode())){
            queryWrapper.eq("hospital_id", hospitalVo.getHospitalCode());
        }
        List<VPackSpecimanDict> list = vPackSpecimanDictService.list(queryWrapper);
        if(list.size() == 0){
            list.add(new VPackSpecimanDict());
        }
        return list;
    }

    @Override
    public List<VCostclassDict> findDtCostClassDict(HospitalVo hospitalVo) {
        QueryWrapper<VCostclassDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort_no");
        if(StringUtils.isNotEmpty(hospitalVo.getHospitalCode())){
            queryWrapper.eq("hospital_id", hospitalVo.getHospitalCode());
        }
        List<VCostclassDict> list = vCostclassDictService.list(queryWrapper);
        if(list.size() == 0){
            list.add(new VCostclassDict());
        }
        return list;
    }

    @Override
    public List<VResultHandleDict> findDtResultHandle(HospitalVo hospitalVo) {
        QueryWrapper<VResultHandleDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort_no");
        if(StringUtils.isNotEmpty(hospitalVo.getHospitalCode())){
            queryWrapper.eq("hospital_id", hospitalVo.getHospitalCode());
        }
        List<VResultHandleDict> list = vResultHandleDictService.list(queryWrapper);
        if(list.size() == 0){
            list.add(new VResultHandleDict());
        }
        return list;
    }

    @Override
    public List<VInterfaceSource> findDtInterfaceSource(HospitalVo hospitalVo) {
        QueryWrapper<VInterfaceSource> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(hospitalVo.getHospitalCode())){
            queryWrapper.eq("hospital_id", hospitalVo.getHospitalCode());
        }
        List<VInterfaceSource> list = vInterfaceSourceService.list(queryWrapper);
        if(list.size() == 0){
            list.add(new VInterfaceSource());
        }
        return list;
    }

    @Override
    public void saveHcItemPackDict(SaveHcItemPackDictListVo saveHcItemPackDictList) {
        for(SaveHcItemPackDicVo saveHcItemPackDicVo : saveHcItemPackDictList.getSaveHcItemPackDictList()){
            switch (saveHcItemPackDicVo.getStat()){
                case "delete" :
                    for(HcItemPackDict hcItemPackDict : saveHcItemPackDicVo.getHcItemPackDict()){
                        QueryWrapper<HcPackVsItemDict> hcPackVsItemDictWrapper = new QueryWrapper<>();
                        hcPackVsItemDictWrapper.eq("hospital_id", hcItemPackDict.getHospitalId());
                        hcPackVsItemDictWrapper.eq("item_pack_code", hcItemPackDict.getItemPackCode());
                        hcPackVsItemDictService.remove(hcPackVsItemDictWrapper);
                        QueryWrapper<HcPackVsClinic> hcPackVsClinicWrapper = new QueryWrapper<>();
                        hcPackVsClinicWrapper.eq("hospital_id", hcItemPackDict.getHospitalId());
                        hcPackVsClinicWrapper.eq("item_pack_code", hcItemPackDict.getItemPackCode());
                        hcPackVsClinicService.remove(hcPackVsClinicWrapper);
                        QueryWrapper<HcItemPackDict> hcItemPackDictWrapper = new QueryWrapper<>();
                        hcItemPackDictWrapper.eq("hospital_id", hcItemPackDict.getHospitalId());
                        hcItemPackDictWrapper.eq("item_pack_code", hcItemPackDict.getItemPackCode());
                        hcItemPackDictService.remove(hcItemPackDictWrapper);
                    }
                    break;
                case "add":
                    hcItemPackDictService.saveBatch(saveHcItemPackDicVo.getHcItemPackDict());
                    break;
                case "update":
                    for(HcItemPackDict hcItemPackDict : saveHcItemPackDicVo.getHcItemPackDict()){
                        UpdateWrapper<HcItemPackDict> updateWrapper= new UpdateWrapper<>();
                        updateWrapper.eq("hospital_id", hcItemPackDict.getHospitalId());
                        updateWrapper.eq("item_pack_code", hcItemPackDict.getItemPackCode());
                        hcItemPackDictService.update(hcItemPackDict, updateWrapper);
                    }
                    break;
            }
        }
    }

    @Override
    public void savePackVsItemDict(SavePackVsItemDictVo savePackVsItemDictVo) {
        switch (savePackVsItemDictVo.getStat()){
            case "delete" :
                for(HcPackVsItemDict hcPackVsItemDict : savePackVsItemDictVo.getHcPackVsItemDict()){
                    QueryWrapper<HcPackVsItemDict> queryWrapper = new QueryWrapper<>();
                    queryWrapper.eq("hospital_id", hcPackVsItemDict.getHospitalId());
                    queryWrapper.eq("item_pack_code", hcPackVsItemDict.getItemPackCode());
                    queryWrapper.eq("ITEM_CODE", hcPackVsItemDict.getItemCode());
                    hcPackVsItemDictService.remove(queryWrapper);
                    UpdateWrapper<HcPackVsItemDict> updateWrapper = new UpdateWrapper<>();
                    updateWrapper.set("ITEM_NO", hcPackVsItemDict.getItemNo()-1);
                    updateWrapper.gt("ITEM_NO", hcPackVsItemDict.getItemNo()); //gt 大于
                    updateWrapper.eq("HOSPITAL_ID", hcPackVsItemDict.getHospitalId());
                    updateWrapper.eq("ITEM_PACK_CODE", hcPackVsItemDict.getItemPackCode());
                    hcPackVsItemDictService.update(updateWrapper);
                }
                break;
            case "add":
                hcPackVsItemDictService.saveBatch(savePackVsItemDictVo.getHcPackVsItemDict());
                break;
        }
    }

}
