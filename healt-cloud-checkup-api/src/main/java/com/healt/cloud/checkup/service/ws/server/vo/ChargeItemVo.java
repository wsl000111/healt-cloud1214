package com.healt.cloud.checkup.service.ws.server.vo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-09-19 13:32
 * @description: TODO
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chargeItem", propOrder = {
        "orderId",
        "feeStatus",
        "rekNo",
        "rekId",
        "operator",
        "operateTime"
})
@Data
public class ChargeItemVo implements Serializable {

    @XmlElement(name = "OrderId")
    private String orderId; // 医嘱 ID String 是 体检系统中费用唯一 ID
    @XmlElement(name = "FeeStatus")
    private String feeStatus; //收费状态 String 是 码表:BSS0002，0=未收、1=已收、2=已退、3=红冲
    @XmlElement(name = "RekNo")
    private String rekNo; //结算序号 String 是
    @XmlElement(name = "RekId")
    private String rekId; //结算标识 String 是
    @XmlElement(name = "Operator")
    private String operator;
    @XmlElement(name = "OperateTime")
    private String operateTime;

}
