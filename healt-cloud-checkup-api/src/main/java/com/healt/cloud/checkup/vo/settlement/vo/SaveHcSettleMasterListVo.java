package com.healt.cloud.checkup.vo.settlement.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-04-10 13:44
 */
@Data
public class SaveHcSettleMasterListVo implements Serializable{

    private static final long serialVersionUID=1L;

    private List<SaveHcSettleMasterVo> saveHcSettleMasterList;
}
