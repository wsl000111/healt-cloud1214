package com.healt.cloud.checkup.encrypt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.healt.cloud.checkup.entity.HealtEncryptDict;
import com.healt.cloud.checkup.encrypt.service.MyEncryptDictSerivce;
import com.healt.cloud.checkup.service.HealtEncryptDictService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-06-07 17:45
 * @description: TODO
 */
@Service
@AllArgsConstructor
public class MyEncryptDictSerivceImpl implements MyEncryptDictSerivce {

    private HealtEncryptDictService healtEncryptDictService;

    @Override
    public List<HealtEncryptDict> getEncryptDict(String hospitalId, String applicationCode) {
        QueryWrapper<HealtEncryptDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hospital_id", hospitalId)
                .eq("application_code", applicationCode);
        List<HealtEncryptDict> list = healtEncryptDictService.list(queryWrapper);
        if (list.size() == 0){
            list.add(new HealtEncryptDict());
        }
        return list;
    }
}
