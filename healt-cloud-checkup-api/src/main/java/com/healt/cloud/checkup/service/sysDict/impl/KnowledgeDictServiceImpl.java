package com.healt.cloud.checkup.service.sysDict.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.HcDiseaseDict;
import com.healt.cloud.checkup.entity.HcKnowledgeDict;
import com.healt.cloud.checkup.mapper.SysDictMapper;
import com.healt.cloud.checkup.service.HcDiseaseDictService;
import com.healt.cloud.checkup.service.HcKnowledgeDictService;
import com.healt.cloud.checkup.service.sysDict.KnowledgeDictService;
import com.healt.cloud.checkup.vo.sys.knowledge.*;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-21 12:43
 * @description: TODO
 */
@Service
@AllArgsConstructor
public class KnowledgeDictServiceImpl implements KnowledgeDictService {

    private HcKnowledgeDictService hcKnowledgeDictService;

    private HcDiseaseDictService hcDiseaseDictService;

    private SysDictMapper sysDictMapper;

    @Override
    public List<HcKnowledgeDict> findKnowledgeList(HcKnowledgeDictVo hcKnowledgeDictVo) {
        QueryWrapper<HcKnowledgeDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hospital_id", hcKnowledgeDictVo.getHospitalCode());
        if(StringUtils.isNotEmpty(hcKnowledgeDictVo.getKnowledgeType())){
            if(!"全部".equals(hcKnowledgeDictVo.getKnowledgeType())){
                queryWrapper.eq("knowledge_type", hcKnowledgeDictVo.getKnowledgeType());
            }
        }else {
            queryWrapper.eq("item_code", hcKnowledgeDictVo.getItemCode());
        }
        if(StringUtils.isNotEmpty(hcKnowledgeDictVo.getDeptId())){
            queryWrapper.eq("dept_id", hcKnowledgeDictVo.getDeptId());
        }
        List<HcKnowledgeDict> list = hcKnowledgeDictService.list(queryWrapper);
        if(list.size() == 0){
            list.add(new HcKnowledgeDict());
        }
        return list;
    }

    @Override
    public List<HcDiseaseDict> findDiseaseList(String hospitalId) {
        QueryWrapper<HcDiseaseDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hospital_id", hospitalId);
        List<HcDiseaseDict> list = hcDiseaseDictService.list(queryWrapper);
        if(list.size() == 0){
            list.add(new HcDiseaseDict());
        }
        return list;
    }

    @Override
    public List<ItemsDepartListVo> findItemsDepartList() {
        List<ItemsDepartListVo> list = sysDictMapper.findItemsDepartList();
        if(list.size() == 0){
            list.add(new ItemsDepartListVo());
        }
        return list;
    }

    @Override
    public void saveHcKnowledgeDictListVo(SaveHcKnowledgeDictListVo saveHcKnowledgeDictListVo) {
        for(SaveHcKnowledgeDictVo saveHcKnowledgeDictVo : saveHcKnowledgeDictListVo.getSaveHcKnowledgeDictList()){
            switch (saveHcKnowledgeDictVo.getStat()){
                case "add":
                    hcKnowledgeDictService.saveBatch(saveHcKnowledgeDictVo.getHcKnowledgeDict());
                    break;
                case "delete":
                    for(HcKnowledgeDict hcKnowledgeDict : saveHcKnowledgeDictVo.getHcKnowledgeDict()){
                        QueryWrapper<HcKnowledgeDict> queryWrapper = new QueryWrapper<>();
                        queryWrapper.eq("HOSPITAL_ID", hcKnowledgeDict.getHospitalId());
                        queryWrapper.eq("KNOWLEDGE_CODE", hcKnowledgeDict.getKnowledgeCode());
                        hcKnowledgeDictService.remove(queryWrapper);
                    }
                    break;
                case "update":
                    for(HcKnowledgeDict hcKnowledgeDict : saveHcKnowledgeDictVo.getHcKnowledgeDict()){
                        UpdateWrapper<HcKnowledgeDict> updateWrapper = new UpdateWrapper<>();
                        updateWrapper.eq("HOSPITAL_ID", hcKnowledgeDict.getHospitalId());
                        updateWrapper.eq("KNOWLEDGE_CODE", hcKnowledgeDict.getKnowledgeCode());
                        hcKnowledgeDictService.update(hcKnowledgeDict, updateWrapper);
                    }
                    break;
            }
        }
    }

    @Override
    public List<HcKnowledgeDictVoRsp> findKnowledgeDict(HcKnowledgeDictVoReq hcKnowledgeDict) {
        String knowledgeType = StringUtils.isNotEmpty(hcKnowledgeDict.getKnowledgeType()) ? hcKnowledgeDict.getKnowledgeType(): null;
        String itemCode = StringUtils.isNotEmpty(hcKnowledgeDict.getItemCode()) ? hcKnowledgeDict.getItemCode(): null;
        String deptId = StringUtils.isNotEmpty(hcKnowledgeDict.getDeptId()) ? hcKnowledgeDict.getDeptId(): null;
        String diseaseCode = StringUtils.isNotEmpty(hcKnowledgeDict.getDiseaseCode()) ? hcKnowledgeDict.getDiseaseCode(): null;
        String inputCode = StringUtils.isNotEmpty(hcKnowledgeDict.getInputCode()) ? hcKnowledgeDict.getInputCode(): null;
        String itemNameFlag = StringUtils.isNotEmpty(hcKnowledgeDict.getItemNameFlag()) ? hcKnowledgeDict.getItemNameFlag(): null;
        String knowledgeName = StringUtils.isNotEmpty(hcKnowledgeDict.getKnowledgeName()) ? hcKnowledgeDict.getKnowledgeName(): null;
        List<HcKnowledgeDictVoRsp> list = sysDictMapper.findKnowledgeDict(hcKnowledgeDict.getHospitalId(), knowledgeType ,itemCode, deptId, diseaseCode, inputCode, itemNameFlag, knowledgeName);
        if(list.size() == 0){
            list.add(new HcKnowledgeDictVoRsp());
        }
        return list;
    }

}
