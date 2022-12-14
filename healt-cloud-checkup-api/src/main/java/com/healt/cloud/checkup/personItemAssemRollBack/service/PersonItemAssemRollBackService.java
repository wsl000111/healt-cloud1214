package com.healt.cloud.checkup.personItemAssemRollBack.service;

/**
 * @author GuYue
 * @date 2022-07-13 11:06
 * @description: TODO
 */
public interface PersonItemAssemRollBackService {
    void itemAssemRollback(String hospitalId, String personId, String personVisitId, String deptId);
}
