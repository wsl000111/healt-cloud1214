package com.healt.cloud.checkup.vo.busniess.costDetail;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-07-14 12:56
 * @description: TODO
 */
@Data
public class SaveCostDetailBillingListVo implements Serializable {

    private List<SaveCostDetailBillingVo> saveCostDetailBilling;

}
