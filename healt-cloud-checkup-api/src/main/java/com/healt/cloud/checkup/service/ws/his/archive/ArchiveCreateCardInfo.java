package com.healt.cloud.checkup.service.ws.his.archive;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author GuYue
 * @date 2022-07-04 17:48
 * @description: TODO
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cardInfo", propOrder = {
    "identityType",
    "identityNum",
    "validTime",
    "expireTime",
    "trackData"
})
public class ArchiveCreateCardInfo {
//    IdentityType 卡类型 String 是 参考码表 PIX0001
//    IdentityNum 卡号 String 否
//    ValidTime 发卡日期 String 否 当卡为医保卡时存入，格式：YYYYMMDDHHMMSS
//    ExpireTime 卡终止日期 String 否 当卡 为医保卡 时存入， 格式YYYYMMDDHHMMSS
//    TrackData 磁道信息 String 是 卡磁道格式：1.当卡为医保卡（居民/职工/社保）时存入，由“卡号|社会保障号码”组成
//    格式参考：JSG030475162|320721198912155621
//    身份证: 身份证号|出生日期
//    格式参考：320721196609084817|19660908
//    居民健康卡磁道格式：
//    卡号|办卡日期
//    格式参考：320706194910190034|20130502
    @XmlElement(name = "IdentityType")
    private String identityType;
    @XmlElement(name = "IdentityNum")
    private String identityNum;
    @XmlElement(name = "ValidTime")
    private String validTime;
    @XmlElement(name = "ExpireTime")
    private String expireTime;
    @XmlElement(name = "TrackData")
    private String trackData;

}
