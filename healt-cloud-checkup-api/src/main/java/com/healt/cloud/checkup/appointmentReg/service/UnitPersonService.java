package com.healt.cloud.checkup.appointmentReg.service;

import com.healt.cloud.checkup.entity.*;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-04-07 14:59
 * @description: TODO
 */
public interface UnitPersonService {

    List<VHcClassDict> findDtClassType(String hospitalId);

    List<VCountryDict> findDtCountry(String hospitalId);

    List<VAreaDict> findDtArea(String hospitalId);

    List<VNationDict> findDtNation(String hospitalId);

    List<VOccupationDict> findDtJob(String hospitalId);

    List<VMaritalStatusDict> findDtMaritalStatus(String hospitalId);

    List<VCostclassDict> findDtChargeType(String hospitalId);

    List<VIdentityDict> findDtIdentity(String hospitalId);
}
