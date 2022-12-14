package com.healt.cloud.checkup.encrypt.service;

import com.healt.cloud.checkup.entity.HealtEncryptDict;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-06-07 17:45
 * @description: TODO
 */
public interface MyEncryptDictSerivce {

    List<HealtEncryptDict> getEncryptDict(String hospitalId, String applicationCode);
}
