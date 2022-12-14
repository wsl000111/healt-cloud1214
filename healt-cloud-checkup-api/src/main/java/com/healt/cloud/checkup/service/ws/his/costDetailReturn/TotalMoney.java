package com.healt.cloud.checkup.service.ws.his.costDetailReturn;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author linklee
 * @create 2022-07-06 15:58
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "totalMoney", propOrder = {
        "totalRefundMoney"
})
public class TotalMoney {

    @XmlElement(name = "TotalRefundMoney")
    protected String totalRefundMoney;

    public String getTotalRefundMoney() {
        return totalRefundMoney;
    }

    public void setTotalRefundMoney(String totalRefundMoney) {
        this.totalRefundMoney = totalRefundMoney;
    }

    @Override
    public String toString() {
        return "TotalMoney{" +
                "totalRefundMoney='" + totalRefundMoney + '\'' +
                '}';
    }
}
