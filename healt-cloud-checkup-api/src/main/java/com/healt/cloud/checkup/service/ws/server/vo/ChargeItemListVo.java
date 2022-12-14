package com.healt.cloud.checkup.service.ws.server.vo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-09-19 13:27
 * @description: TODO
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "chargeItemList")
public class ChargeItemListVo implements Serializable {

    @XmlElement(name = "ChargeItem")
    protected List<ChargeItemVo> chargeItem;

}
