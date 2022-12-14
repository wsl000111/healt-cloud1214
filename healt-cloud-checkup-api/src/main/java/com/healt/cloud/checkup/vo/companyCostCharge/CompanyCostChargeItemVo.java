package com.healt.cloud.checkup.vo.companyCostCharge;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-09-02 11:06
 * @description: TODO
 */
@Data
public class CompanyCostChargeItemVo implements Serializable {

    private String orderId;

    private String clinicType;

    private String feeItemClass;

    private String clinicItemId;

    private String num;

    private String unit;

    private String unitPrice;

    private String receivablePrice;

    private String discountsPrice;

    private String realPrice;

    private String operatorId;

    private String desc;
}
