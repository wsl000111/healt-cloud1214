package com.healt.cloud.checkup.service.sysDict.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.DepartClass;
import com.healt.cloud.checkup.entity.DepartDict;
import com.healt.cloud.checkup.entity.VDepartDict;
import com.healt.cloud.checkup.entity.VInterfaceSource;
import com.healt.cloud.checkup.mapper.SysDictMapper;
import com.healt.cloud.checkup.service.DepartClassService;
import com.healt.cloud.checkup.service.DepartDictService;
import com.healt.cloud.checkup.service.VDepartDictService;
import com.healt.cloud.checkup.service.VInterfaceSourceService;
import com.healt.cloud.checkup.service.sysDict.DepartService;
import com.healt.cloud.checkup.vo.HospitalVo;
import com.healt.cloud.checkup.vo.sys.depart.DepartDictVo;
import com.healt.cloud.checkup.vo.sys.depart.SaveDepartDictListVo;
import com.healt.cloud.checkup.vo.sys.depart.VHisDeptDictVo;
import com.healt.cloud.checkup.service.ws.WebServiceClient;
import com.healt.cloud.common.utils.PropertiesUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-05 14:17
 * @description: TODO
 */
@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    private VInterfaceSourceService vInterfaceSourceService;
    @Autowired
    private DepartClassService departClassService;
    @Autowired
    private DepartDictService departDictService;
    @Autowired
    private VDepartDictService vDepartDictService;
    @Autowired
    private SysDictMapper sysDictMapper;

    @Autowired
    private WebServiceClient client;

    private String isHis = PropertiesUtils.ISHIS;

    private String areaCode = PropertiesUtils.AREACODE;

    private String medInstCode = PropertiesUtils.MEDINSTCODE;

    @Override
    public List<VInterfaceSource> findDtInoerfaceSource(HospitalVo hospitalVo) {
        QueryWrapper<VInterfaceSource> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hospital_id", hospitalVo.getHospitalCode());
        List<VInterfaceSource> list = vInterfaceSourceService.list(queryWrapper);
        if (list.size() == 0) {
            list.add(new VInterfaceSource());
        }
        return list;
    }

    @Override
    public List<DepartClass> findDtDepartClass(HospitalVo hospitalVo) {
        QueryWrapper<DepartClass> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("HOSPITAL_ID", hospitalVo.getHospitalCode());
        queryWrapper.orderByAsc("CLASS_ID");
        List<DepartClass> list = departClassService.list(queryWrapper);
        if (list.size() == 0) {
            list.add(new DepartClass());
        }
        return list;
    }

    @Override
    public List<DepartDict> findDtDepart(HospitalVo hospitalVo) {
        QueryWrapper<DepartDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("HOSPITAL_ID", hospitalVo.getHospitalCode());
        queryWrapper.orderByAsc("SORT_NO");
        List<DepartDict> list = departDictService.list(queryWrapper);
        if (list.size() == 0) {
            list.add(new DepartDict());
        }
        return list;
    }

    @Override
    public List<VDepartDict> findVDtDepart(HospitalVo hospitalVo) {
        QueryWrapper<VDepartDict> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(hospitalVo.getHospitalCode())){
            queryWrapper.eq("HOSPITAL_ID", hospitalVo.getHospitalCode());
        }
        queryWrapper.orderByAsc("SORT_NO");
        List<VDepartDict> list = vDepartDictService.list(queryWrapper);
        if (list.size() == 0) {
            list.add(new VDepartDict());
        }
        return list;
    }

    @Override
    public List<VHisDeptDictVo> findDtHisDepart(HospitalVo hospitalVo) {
        List<VHisDeptDictVo> list;
        list = client.mdmOrganizationQuery(areaCode, medInstCode, "findDtHisDepart");
//        if("Y".equals(isHis)){
//        }else{
//            list = sysDictMapper.findDtHisDepart(hospitalVo);
//        }
        if (list.size() == 0) {
            list.add(new VHisDeptDictVo());
        }
        return list;
    }

    @Override
    public List<VHisDeptDictVo> findDeptList(String hospitalCode) {
//        List<VHisDeptDict> list = sysDictMapper.findDeptList(hospitalCode);
//        if (list.size() == 0) {
//            list.add(new VHisDeptDict());
//        }
//        return list;
        HospitalVo hospitalVo = new HospitalVo();
        hospitalVo.setHospitalCode(hospitalCode);
        return this.findDtHisDepart(hospitalVo);
    }

    @Override
    @Transactional
    public void saveDepartDict(SaveDepartDictListVo saveDepartDictListVo){
       for(DepartDictVo departDictVo : saveDepartDictListVo.getDepartDictList()){
            switch (departDictVo.getStat()){
                case "delete" :
                    for(DepartDict departDict : departDictVo.getDepartDict()){
                        QueryWrapper<DepartDict> queryWrapper = new QueryWrapper<DepartDict>(departDict);
                        departDictService.remove(queryWrapper);
                    }
                    break;
                case "add":
                    departDictService.saveBatch(departDictVo.getDepartDict());
                    break;
                case "update":
                    for(DepartDict departDict : departDictVo.getDepartDict()){
                        UpdateWrapper<DepartDict> updateWrapper= new UpdateWrapper<DepartDict>(departDict);
                        departDictService.update(departDict, updateWrapper);
                    }
                    break;
            }
       }
    }

}
