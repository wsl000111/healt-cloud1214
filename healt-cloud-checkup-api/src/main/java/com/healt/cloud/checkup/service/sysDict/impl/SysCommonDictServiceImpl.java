package com.healt.cloud.checkup.service.sysDict.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.CheckUpAppliction;
import com.healt.cloud.checkup.entity.CommonDict;
import com.healt.cloud.checkup.mapper.CommonMapper;
import com.healt.cloud.checkup.service.CommonDictService;
import com.healt.cloud.checkup.service.sysDict.SysCommonDictService;
import com.healt.cloud.checkup.vo.sys.common.*;
import com.healt.cloud.common.http.HttpStatus;
import com.healt.cloud.common.utils.CommonUtils;
import com.healt.cloud.common.utils.ReflectionUtils;
import com.healt.cloud.resultex.exception.CommonException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-05 14:17
 * @description: TODO
 */
@Service
@AllArgsConstructor
public class SysCommonDictServiceImpl implements SysCommonDictService {

    private CommonMapper commonMapper;

    private CommonDictService commonDictService;

    @Override
    public List<DtTableVoResult> findDtTable(DtTableVo dtTableVo) {
        dtTableVo.setDictUser(dtTableVo.getDictUser().toUpperCase());
        List<DtTableVoResult> list = commonMapper.findDtTable(dtTableVo);
        return list;
    }

    @Override
    public List<DictColumnsVoResult> findDictColumns(DictColumnsVo dictColumnsVo) {
        List<DictColumnsVoResult> list = commonMapper.findDictColumns(dictColumnsVo);
        return list;
    }

    @Override
    public Object loadDtDict(DtDictVo dtDictVo){
        //tableName驼峰规则转换
        StringBuilder serviceName = new StringBuilder(CommonUtils.underline2Camel(dtDictVo.getTableName()));
        serviceName.append("ServiceImpl");
        Object serviceBean = CheckUpAppliction.checkUpApplicationContext.getBean(serviceName.toString());
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("hospital_id", dtDictVo.getHospitalCode());
        Object result = null;
        try{
            result = ReflectionUtils.invoke(serviceBean, "list", new Object[]{queryWrapper});
        }catch (Exception e){
            throw new CommonException();
        }
        return result;
    }

    public List<IndexColumnsVo> findIndexColumns(String tableName){
        return commonMapper.findIndexColumns(tableName);
    }

    @Override
    @Transactional
    public void saveCommonTable(SaveCommonTableVo saveCommonTableVo){

        String entityName = CommonUtils.underline2Camel(saveCommonTableVo.getCommonTableName());
        String entityClass = CommonUtils.firstUpper(entityName);
        List<String> columsList = new ArrayList<>();
        for(CommonTableColumnsVo commonTableColumnsVo : saveCommonTableVo.getCommonTableColumns()){
            columsList.add(CommonUtils.underline2Camel(commonTableColumnsVo.getTableColumns()));
        }
        List<String> underColumsList = new ArrayList<>();
        for(CommonTableColumnsVo commonTableColumnsVo : saveCommonTableVo.getCommonTableColumns()){
            underColumsList.add(commonTableColumnsVo.getTableColumns());
        }

        //获取service实例
        Object serviceBean = CheckUpAppliction.checkUpApplicationContext.getBean(entityName+"ServiceImpl");

        List<CommonTableColumnsDataVo> commonTableColumnsDataVoList = saveCommonTableVo.getCommonTableColumnsData();
        try{
            for(CommonTableColumnsDataVo commonTableColumnsDataVo : commonTableColumnsDataVoList){
                String[] columnsDataArray = commonTableColumnsDataVo.getTableColumnsData().split("\\^");
                Object entityBean = Class.forName("com.healt.cloud.checkup.entity."+entityClass).newInstance();
                for(int i=0 ; i<columsList.size() ; i++){
                    ReflectionUtils.invoke(entityBean, "set"+CommonUtils.firstUpper(columsList.get(i)), columnsDataArray[i]);
                }
                //查询主键集合
                List<IndexColumnsVo>  indexColumnsVoList = this.findIndexColumns(saveCommonTableVo.getCommonTableName());
                switch (commonTableColumnsDataVo.getStat()){
                    case "add":
                        ReflectionUtils.invoke(serviceBean, "save", entityBean);
                        break;
                    case "delete":
                        QueryWrapper queryWrapper = new QueryWrapper();
                        for(IndexColumnsVo indexColumnsVo : indexColumnsVoList){
                            for(int j=0; j<underColumsList.size(); j++){
                                if(indexColumnsVo.getIndexColumnName().equals(underColumsList.get(j))){
                                    queryWrapper.eq(indexColumnsVo.getIndexColumnName(), columnsDataArray[j]);
                                    break;
                                }
                            }
                        }
                        ReflectionUtils.invoke(serviceBean, "remove", queryWrapper);
                        break;
                    case "update":
                        UpdateWrapper updateWrapper = new UpdateWrapper();
                        for(IndexColumnsVo indexColumnsVo : indexColumnsVoList){
                            for(int j=0; j<underColumsList.size(); j++){
                                if(indexColumnsVo.getIndexColumnName().equals(underColumsList.get(j))){
                                    updateWrapper.eq(indexColumnsVo.getIndexColumnName(), columnsDataArray[j]);
                                    break;
                                }
                            }
                        }
                        Object[] params = new Object[]{entityBean, updateWrapper};
                        ReflectionUtils.invoke(serviceBean, "update", params);
                        break;
                }
            }
        } catch (Exception e) {
            CommonException ce = new CommonException();
            if(e instanceof InvocationTargetException){
                ce.setCode(500);
                ce.setMsg(e.getCause().getMessage());
                System.out.println(e.getCause().getMessage());
            }else{
                ce.setCode(HttpStatus.INTERNAL_SERVER_ERROR.getStatus());
                ce.setMsg(e.getMessage());
            }
            throw ce;
        }
    }

    @Override
    public List<CommonDictVoResult> findPublicDict(String dictType) {
        QueryWrapper<CommonDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dict_type", dictType);
        queryWrapper.eq("use_flag", "1");
        queryWrapper.orderByAsc("sort_no");
        List<CommonDict> list = commonDictService.list(queryWrapper);
        List<CommonDictVoResult> voList = new ArrayList<>();
        if(list.size() == 0){
            voList.add(new CommonDictVoResult());
        }else{
            for(CommonDict commonDict : list){
                CommonDictVoResult commonDictVoResult = new CommonDictVoResult();
                commonDictVoResult.setInputCode(commonDict.getInputCode());
                commonDictVoResult.setName(commonDict.getName());
                voList.add(commonDictVoResult);
            }
        }
        return voList;
    }

    @Override
    public List<CommonDictVoResult1> findPublicDict1(String dictType) {
        QueryWrapper<CommonDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dict_type", dictType);
        queryWrapper.eq("use_flag", "1");
        queryWrapper.orderByAsc("sort_no");
        List<CommonDict> list = commonDictService.list(queryWrapper);
        List<CommonDictVoResult1> voList = new ArrayList<>();
        if(list.size() == 0){
            voList.add(new CommonDictVoResult1());
        }else{
            for(CommonDict commonDict : list){
                CommonDictVoResult1 commonDictVoResult = new CommonDictVoResult1();
                commonDictVoResult.setCode(commonDict.getCode());
                commonDictVoResult.setInputCode(commonDict.getInputCode());
                commonDictVoResult.setName(commonDict.getName());
                voList.add(commonDictVoResult);
            }
        }
        return voList;
    }
}
