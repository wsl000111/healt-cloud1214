package com.healt.cloud.checkup.service.ws.his.costDetailBilling;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author linklee
 * @create 2022-07-06 14:45
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chargeItem", propOrder = {
        "orderId",
        "applyNo",
        "clinicType",
        "feeItemClass",
        "clinicItemId",
        "clinicItemName",
        "itemType",
        "feeItemId",
        "feeItemName",
        "drugSpec",
        "pharmacyFactoryName",
        "num",
        "unit",
        "unitPrice",
        "unitCoeff",
        "totalPrice",
        "charges",
        "classOnRcpt",
        "clinicPropertyClass",
        "applyDoctorCode",
        "applyDoctorName",
        "applyOrgCode",
        "applyOrgName",
        "currentOrgCode",
        "currentOrgName",
        "currentWardCode",
        "currentWardName",
        "execOrgCode",
        "execOrgName",
        "chargeDate",
        "enterDate",
        "operator"
})
public class CostDetailBillingChargeItem {

    @XmlElement(name = "OrderId")
    protected String orderId;
    @XmlElement(name = "ApplyNo")
    protected String applyNo;
    @XmlElement(name = "ClinicType")
    protected String clinicType;
    @XmlElement(name = "FeeItemClass")
    protected String feeItemClass;
    @XmlElement(name = "ClinicItemId")
    protected String clinicItemId;
    @XmlElement(name = "ClinicItemName")
    protected String clinicItemName;
    @XmlElement(name = "ItemType")
    protected String itemType;
    @XmlElement(name = "FeeItemId")
    protected String feeItemId;
    @XmlElement(name = "FeeItemName")
    protected String feeItemName;
    @XmlElement(name = "DrugSpec")
    protected String drugSpec;
    @XmlElement(name = "PharmacyFactoryName")
    protected String pharmacyFactoryName;
    @XmlElement(name = "Num")
    protected String num;
    @XmlElement(name = "Unit")
    protected String unit;
    @XmlElement(name = "UnitPrice")
    protected String unitPrice;
    @XmlElement(name = "UnitCoeff")
    protected String unitCoeff;
    @XmlElement(name = "TotalPrice")
    protected String totalPrice;
    @XmlElement(name = "Charges")
    protected String charges;
    @XmlElement(name = "ClassOnRcpt")
    protected String classOnRcpt;
    @XmlElement(name = "ClinicPropertyClass")
    protected String clinicPropertyClass;
    @XmlElement(name = "ApplyDoctorCode")
    protected String applyDoctorCode;
    @XmlElement(name = "ApplyDoctorName")
    protected String applyDoctorName;
    @XmlElement(name = "ApplyOrgCode")
    protected String applyOrgCode;
    @XmlElement(name = "ApplyOrgName")
    protected String applyOrgName;
    @XmlElement(name = "CurrentOrgCode")
    protected String currentOrgCode;
    @XmlElement(name = "CurrentOrgName")
    protected String currentOrgName;
    @XmlElement(name = "CurrentWardCode")
    protected String currentWardCode;
    @XmlElement(name = "CurrentWardName")
    protected String currentWardName;
    @XmlElement(name = "ExecOrgCode")
    protected String execOrgCode;
    @XmlElement(name = "ExecOrgName")
    protected String execOrgName;
    @XmlElement(name = "ChargeDate")
    protected String chargeDate;
    @XmlElement(name = "EnterDate")
    protected String enterDate;
    @XmlElement(name = "Operator")
    protected String operator;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getClinicType() {
        return clinicType;
    }

    public void setClinicType(String clinicType) {
        this.clinicType = clinicType;
    }

    public String getFeeItemClass() {
        return feeItemClass;
    }

    public void setFeeItemClass(String feeItemClass) {
        this.feeItemClass = feeItemClass;
    }

    public String getClinicItemId() {
        return clinicItemId;
    }

    public void setClinicItemId(String clinicItemId) {
        this.clinicItemId = clinicItemId;
    }

    public String getClinicItemName() {
        return clinicItemName;
    }

    public void setClinicItemName(String clinicItemName) {
        this.clinicItemName = clinicItemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getFeeItemId() {
        return feeItemId;
    }

    public void setFeeItemId(String feeItemId) {
        this.feeItemId = feeItemId;
    }

    public String getFeeItemName() {
        return feeItemName;
    }

    public void setFeeItemName(String feeItemName) {
        this.feeItemName = feeItemName;
    }

    public String getDrugSpec() {
        return drugSpec;
    }

    public void setDrugSpec(String drugSpec) {
        this.drugSpec = drugSpec;
    }

    public String getPharmacyFactoryName() {
        return pharmacyFactoryName;
    }

    public void setPharmacyFactoryName(String pharmacyFactoryName) {
        this.pharmacyFactoryName = pharmacyFactoryName;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getUnitCoeff() {
        return unitCoeff;
    }

    public void setUnitCoeff(String unitCoeff) {
        this.unitCoeff = unitCoeff;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCharges() {
        return charges;
    }

    public void setCharges(String charges) {
        this.charges = charges;
    }

    public String getClassOnRcpt() {
        return classOnRcpt;
    }

    public void setClassOnRcpt(String classOnRcpt) {
        this.classOnRcpt = classOnRcpt;
    }

    public String getClinicPropertyClass() {
        return clinicPropertyClass;
    }

    public void setClinicPropertyClass(String clinicPropertyClass) {
        this.clinicPropertyClass = clinicPropertyClass;
    }

    public String getApplyDoctorCode() {
        return applyDoctorCode;
    }

    public void setApplyDoctorCode(String applyDoctorCode) {
        this.applyDoctorCode = applyDoctorCode;
    }

    public String getApplyDoctorName() {
        return applyDoctorName;
    }

    public void setApplyDoctorName(String applyDoctorName) {
        this.applyDoctorName = applyDoctorName;
    }

    public String getApplyOrgCode() {
        return applyOrgCode;
    }

    public void setApplyOrgCode(String applyOrgCode) {
        this.applyOrgCode = applyOrgCode;
    }

    public String getApplyOrgName() {
        return applyOrgName;
    }

    public void setApplyOrgName(String applyOrgName) {
        this.applyOrgName = applyOrgName;
    }

    public String getCurrentOrgCode() {
        return currentOrgCode;
    }

    public void setCurrentOrgCode(String currentOrgCode) {
        this.currentOrgCode = currentOrgCode;
    }

    public String getCurrentOrgName() {
        return currentOrgName;
    }

    public void setCurrentOrgName(String currentOrgName) {
        this.currentOrgName = currentOrgName;
    }

    public String getCurrentWardCode() {
        return currentWardCode;
    }

    public void setCurrentWardCode(String currentWardCode) {
        this.currentWardCode = currentWardCode;
    }

    public String getCurrentWardName() {
        return currentWardName;
    }

    public void setCurrentWardName(String currentWardName) {
        this.currentWardName = currentWardName;
    }

    public String getExecOrgCode() {
        return execOrgCode;
    }

    public void setExecOrgCode(String execOrgCode) {
        this.execOrgCode = execOrgCode;
    }

    public String getExecOrgName() {
        return execOrgName;
    }

    public void setExecOrgName(String execOrgName) {
        this.execOrgName = execOrgName;
    }

    public String getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(String chargeDate) {
        this.chargeDate = chargeDate;
    }

    public String getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(String enterDate) {
        this.enterDate = enterDate;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "ChargeItem{" +
                "orderId='" + orderId + '\'' +
                ", applyNo='" + applyNo + '\'' +
                ", clinicType='" + clinicType + '\'' +
                ", feeItemClass='" + feeItemClass + '\'' +
                ", clinicItemId='" + clinicItemId + '\'' +
                ", clinicItemName='" + clinicItemName + '\'' +
                ", itemType='" + itemType + '\'' +
                ", feeItemId='" + feeItemId + '\'' +
                ", feeItemName='" + feeItemName + '\'' +
                ", drugSpec='" + drugSpec + '\'' +
                ", pharmacyFactoryName='" + pharmacyFactoryName + '\'' +
                ", num='" + num + '\'' +
                ", unit='" + unit + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", unitCoeff='" + unitCoeff + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                ", charges='" + charges + '\'' +
                ", classOnRcpt='" + classOnRcpt + '\'' +
                ", clinicPropertyClass='" + clinicPropertyClass + '\'' +
                ", applyDoctorCode='" + applyDoctorCode + '\'' +
                ", applyDoctorName='" + applyDoctorName + '\'' +
                ", applyOrgCode='" + applyOrgCode + '\'' +
                ", applyOrgName='" + applyOrgName + '\'' +
                ", currentOrgCode='" + currentOrgCode + '\'' +
                ", currentOrgName='" + currentOrgName + '\'' +
                ", currentWardCode='" + currentWardCode + '\'' +
                ", currentWardName='" + currentWardName + '\'' +
                ", execOrgCode='" + execOrgCode + '\'' +
                ", execOrgName='" + execOrgName + '\'' +
                ", chargeDate='" + chargeDate + '\'' +
                ", enterDate='" + enterDate + '\'' +
                ", operator='" + operator + '\'' +
                '}';
    }
}
