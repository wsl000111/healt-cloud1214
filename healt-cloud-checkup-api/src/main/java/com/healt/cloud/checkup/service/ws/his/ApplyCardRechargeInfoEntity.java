package com.healt.cloud.checkup.service.ws.his;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "RechargeInfo")
@XmlType()
public class ApplyCardRechargeInfoEntity {
    /**
     * 交易金额
     */
    @XmlElement(name = "Amount")
    private String investAmount;

    /**
     * 支付方式
     */
    @XmlElement(name = "PayMode")
    private String payModeCode;
    /**
     * 交易请求时间
     */
    @XmlElement(name = "ReqTime")
    private String reqTime;
    /**
     * 终端号
     */
    @XmlElement(name = "TerminalNo")
    private String terminalNo;
    /**
     * 备注
     */
    @XmlElement(name = "Descn")
    private String descn;
}
