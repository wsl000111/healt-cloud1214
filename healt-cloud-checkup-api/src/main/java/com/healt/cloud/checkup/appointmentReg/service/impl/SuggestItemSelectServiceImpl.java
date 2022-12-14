package com.healt.cloud.checkup.appointmentReg.service.impl;

import com.healt.cloud.checkup.appointmentReg.mapper.SuggestItemSelectMapper;
import com.healt.cloud.checkup.appointmentReg.service.SuggestItemSelectService;
import com.healt.cloud.checkup.appointmentReg.vo.suggestItemSelect.SuggestDepartDictVo;
import com.healt.cloud.checkup.appointmentReg.vo.suggestItemSelect.SuggestDictVo;
import com.healt.cloud.checkup.appointmentReg.vo.suggestItemSelect.SuggestVDepartDictVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-05-31 15:52
 * @description: TODO
 */
@Service
@AllArgsConstructor
public class SuggestItemSelectServiceImpl implements SuggestItemSelectService {

    private SuggestItemSelectMapper suggestItemSelectMapper;

    @Override
    public List<SuggestDepartDictVo> loadDepartDict() {
        List<SuggestDepartDictVo> list = suggestItemSelectMapper.loadDepartDict();
        if(list.size() == 0){
            list.add(new SuggestDepartDictVo());
        }
        return list;
    }

    @Override
    public List<SuggestVDepartDictVo> loadVDepartDict(String hospitalId) {
        List<SuggestVDepartDictVo> list = suggestItemSelectMapper.loadVDepartDict(hospitalId);
        if(list.size() == 0){
            list.add(new SuggestVDepartDictVo());
        }
        return list;
    }

    @Override
    public List<SuggestDictVo> loadSuggestDict(String hospitalId, String deptId) {
        List<SuggestDictVo> list = suggestItemSelectMapper.loadSuggestDict(hospitalId, deptId);
        if(list.size() == 0){
            list.add(new SuggestDictVo());
        }
        return list;
    }
}
