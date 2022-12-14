package com.healt.cloud.checkup.vo.companyCostCharge;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-09-02 11:04
 * @description: TODO
 */
@Data
public class CompanyCostChargeStateVoList implements Serializable {
    private List<CompanyCostChargeStateVo> companyCostChargeStateVoList;
}
