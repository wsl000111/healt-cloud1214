package com.healt.cloud.checkup.vo.settlement.vo;

import com.healt.cloud.checkup.entity.HcRcptPay;
import com.healt.cloud.checkup.entity.HcSettleDetail;
import com.healt.cloud.checkup.entity.HcSettleMaster;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-04-24 16:31
 */
@Data
public class SaveHcSettleVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String stat;

    private List<HcSettleMaster> hcSettleMaster;
    private List<HcSettleDetail> hcSettleDetail;
    private List<HcRcptPay> hcRcptPay;

}
