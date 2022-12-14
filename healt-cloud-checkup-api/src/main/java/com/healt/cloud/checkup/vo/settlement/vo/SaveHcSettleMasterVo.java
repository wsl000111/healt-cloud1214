package com.healt.cloud.checkup.vo.settlement.vo;

import com.healt.cloud.checkup.entity.HcSettleMaster;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-04-10 13:45
 */
@Data
public class SaveHcSettleMasterVo implements Serializable{

    private static final long serialVersionUID=1L;

    private String stat;

    private List<HcSettleMaster> hcSettleMaster;
}
