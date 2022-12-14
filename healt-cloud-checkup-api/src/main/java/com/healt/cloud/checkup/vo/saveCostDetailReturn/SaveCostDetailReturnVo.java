package com.healt.cloud.checkup.vo.saveCostDetailReturn;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-08-23 1:40
 * @description: TODO
 */
@Data
public class SaveCostDetailReturnVo implements Serializable {
    private List<SaveCostDetailReturn> saveCostDetailReturn;
}
