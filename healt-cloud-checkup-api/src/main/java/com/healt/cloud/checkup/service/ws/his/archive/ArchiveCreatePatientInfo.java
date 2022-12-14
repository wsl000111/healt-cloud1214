package com.healt.cloud.checkup.service.ws.his.archive;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author GuYue
 * @date 2022-07-04 17:47
 * @description: TODO
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "patientInfo", propOrder = {
    "medInstCode",
    "areaCode",
    "patientName",
    "pyCode",
    "patientSex",
    "birthDate",
    "idCard",
    "phoneNo",
    "insuranceType",
    "childrenName",
    "relation",
    "occupationCode"
})
@Data
public class ArchiveCreatePatientInfo {
//    MedInstCode 医疗机构编码 String 是
//    AreaCode 院区编码 String 是
//    PatientName 姓名 String 是 儿童时填写监护人姓名
//    PyCode 姓名拼音 String 是 大写字母，不同的汉字拼音之间用空格分割
//    PatientSex 性别 String 是 GB2261-80 儿童时填写儿童性别
//    BirthDate 出生日期 String 是 格式 YYYYMMDDHHMMSS 儿童时填写儿童出生日期
//    IdCard 身份证号 String 是
//    PhoneNo 手机号 String 是
//    InsuranceType 费别类型 String 否 YB0005 如果不填，则默认为自费 注意：此项仅适用于浙江医院 情况
//    ChildrenName 儿童姓名 String 可选 儿童卡时填写
//    Relation 关系 可选 儿童卡时填写，RC033
//    OccupationCode 传染病患者职业编码 String 是 CV02.01.202
    @XmlElement(name = "MedInstCode")
    private String medInstCode;
    @XmlElement(name = "AreaCode")
    private String areaCode;
    @XmlElement(name = "PatientName")
    private String patientName;
    @XmlElement(name = "PyCode")
    private String pyCode;
    @XmlElement(name = "PatientSex")
    private String patientSex;
    @XmlElement(name = "BirthDate")
    private String birthDate;
    @XmlElement(name = "IdCard")
    private String idCard;
    @XmlElement(name = "PhoneNo")
    private String phoneNo;
    @XmlElement(name = "InsuranceType")
    private String insuranceType;
    @XmlElement(name = "ChildrenName")
    private String childrenName;
    @XmlElement(name = "Relation")
    private String relation;
    @XmlElement(name = "OccupationCode")
    private String occupationCode;

}
