
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>outpOrderInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="outpOrderInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OrderId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OrderCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SortNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="ApplyTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="OrderName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ExecOrgCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ExecOrgName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DispenseWinId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="WindowName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsUrgent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ApplyDoctorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ApplyDoctorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ApplyOrgCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ApplyOrgName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CancelDoctorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CancelDoctorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CancelTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="DeleteFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RefPrice" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="OrderType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PrescrType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TemplateType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ChargeFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DebtFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TisaType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Agents" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="TemplateForm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MedicMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CreateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="DayAgents" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="FormAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FormUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TisaMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OutpOrderItemList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="OutpOrderItem" type="{http://wegohis.com}outpOrderItem" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "outpOrderInfo", propOrder = {
    "orderId",
    "orderCode",
    "sortNo",
    "applyTime",
    "orderName",
    "execOrgCode",
    "execOrgName",
    "dispenseWinId",
    "windowName",
    "isUrgent",
    "applyDoctorCode",
    "applyDoctorName",
    "applyOrgCode",
    "applyOrgName",
    "cancelDoctorCode",
    "cancelDoctorName",
    "cancelTime",
    "deleteFlag",
    "refPrice",
    "orderType",
    "prescrType",
    "templateType",
    "chargeFlag",
    "debtFlag",
    "tisaType",
    "agents",
    "templateForm",
    "medicMethod",
    "createTime",
    "dayAgents",
    "formAmount",
    "formUnit",
    "tisaMethod",
    "outpOrderItemList"
})
public class OutpOrderInfo {

    @XmlElement(name = "OrderId")
    protected String orderId;
    @XmlElement(name = "OrderCode")
    protected String orderCode;
    @XmlElement(name = "SortNo")
    protected Long sortNo;
    @XmlElement(name = "ApplyTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar applyTime;
    @XmlElement(name = "OrderName")
    protected String orderName;
    @XmlElement(name = "ExecOrgCode")
    protected String execOrgCode;
    @XmlElement(name = "ExecOrgName")
    protected String execOrgName;
    @XmlElement(name = "DispenseWinId")
    protected String dispenseWinId;
    @XmlElement(name = "WindowName")
    protected String windowName;
    @XmlElement(name = "IsUrgent")
    protected String isUrgent;
    @XmlElement(name = "ApplyDoctorCode")
    protected String applyDoctorCode;
    @XmlElement(name = "ApplyDoctorName")
    protected String applyDoctorName;
    @XmlElement(name = "ApplyOrgCode")
    protected String applyOrgCode;
    @XmlElement(name = "ApplyOrgName")
    protected String applyOrgName;
    @XmlElement(name = "CancelDoctorCode")
    protected String cancelDoctorCode;
    @XmlElement(name = "CancelDoctorName")
    protected String cancelDoctorName;
    @XmlElement(name = "CancelTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar cancelTime;
    @XmlElement(name = "DeleteFlag")
    protected String deleteFlag;
    @XmlElement(name = "RefPrice")
    protected Long refPrice;
    @XmlElement(name = "OrderType")
    protected String orderType;
    @XmlElement(name = "PrescrType")
    protected String prescrType;
    @XmlElement(name = "TemplateType")
    protected String templateType;
    @XmlElement(name = "ChargeFlag")
    protected String chargeFlag;
    @XmlElement(name = "DebtFlag")
    protected String debtFlag;
    @XmlElement(name = "TisaType")
    protected String tisaType;
    @XmlElement(name = "Agents")
    protected Long agents;
    @XmlElement(name = "TemplateForm")
    protected String templateForm;
    @XmlElement(name = "MedicMethod")
    protected String medicMethod;
    @XmlElement(name = "CreateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createTime;
    @XmlElement(name = "DayAgents")
    protected Long dayAgents;
    @XmlElement(name = "FormAmount")
    protected String formAmount;
    @XmlElement(name = "FormUnit")
    protected String formUnit;
    @XmlElement(name = "TisaMethod")
    protected String tisaMethod;
    @XmlElement(name = "OutpOrderItemList")
    protected OutpOrderItemList outpOrderItemList;

    /**
     * 获取orderId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置orderId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderId(String value) {
        this.orderId = value;
    }

    /**
     * 获取orderCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * 设置orderCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderCode(String value) {
        this.orderCode = value;
    }

    /**
     * 获取sortNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSortNo() {
        return sortNo;
    }

    /**
     * 设置sortNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSortNo(Long value) {
        this.sortNo = value;
    }

    /**
     * 获取applyTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getApplyTime() {
        return applyTime;
    }

    /**
     * 设置applyTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setApplyTime(XMLGregorianCalendar value) {
        this.applyTime = value;
    }

    /**
     * 获取orderName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderName() {
        return orderName;
    }

    /**
     * 设置orderName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderName(String value) {
        this.orderName = value;
    }

    /**
     * 获取execOrgCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExecOrgCode() {
        return execOrgCode;
    }

    /**
     * 设置execOrgCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExecOrgCode(String value) {
        this.execOrgCode = value;
    }

    /**
     * 获取execOrgName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExecOrgName() {
        return execOrgName;
    }

    /**
     * 设置execOrgName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExecOrgName(String value) {
        this.execOrgName = value;
    }

    /**
     * 获取dispenseWinId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDispenseWinId() {
        return dispenseWinId;
    }

    /**
     * 设置dispenseWinId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDispenseWinId(String value) {
        this.dispenseWinId = value;
    }

    /**
     * 获取windowName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWindowName() {
        return windowName;
    }

    /**
     * 设置windowName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWindowName(String value) {
        this.windowName = value;
    }

    /**
     * 获取isUrgent属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsUrgent() {
        return isUrgent;
    }

    /**
     * 设置isUrgent属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsUrgent(String value) {
        this.isUrgent = value;
    }

    /**
     * 获取applyDoctorCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyDoctorCode() {
        return applyDoctorCode;
    }

    /**
     * 设置applyDoctorCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyDoctorCode(String value) {
        this.applyDoctorCode = value;
    }

    /**
     * 获取applyDoctorName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyDoctorName() {
        return applyDoctorName;
    }

    /**
     * 设置applyDoctorName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyDoctorName(String value) {
        this.applyDoctorName = value;
    }

    /**
     * 获取applyOrgCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyOrgCode() {
        return applyOrgCode;
    }

    /**
     * 设置applyOrgCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyOrgCode(String value) {
        this.applyOrgCode = value;
    }

    /**
     * 获取applyOrgName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyOrgName() {
        return applyOrgName;
    }

    /**
     * 设置applyOrgName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyOrgName(String value) {
        this.applyOrgName = value;
    }

    /**
     * 获取cancelDoctorCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCancelDoctorCode() {
        return cancelDoctorCode;
    }

    /**
     * 设置cancelDoctorCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCancelDoctorCode(String value) {
        this.cancelDoctorCode = value;
    }

    /**
     * 获取cancelDoctorName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCancelDoctorName() {
        return cancelDoctorName;
    }

    /**
     * 设置cancelDoctorName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCancelDoctorName(String value) {
        this.cancelDoctorName = value;
    }

    /**
     * 获取cancelTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCancelTime() {
        return cancelTime;
    }

    /**
     * 设置cancelTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCancelTime(XMLGregorianCalendar value) {
        this.cancelTime = value;
    }

    /**
     * 获取deleteFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置deleteFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeleteFlag(String value) {
        this.deleteFlag = value;
    }

    /**
     * 获取refPrice属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRefPrice() {
        return refPrice;
    }

    /**
     * 设置refPrice属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRefPrice(Long value) {
        this.refPrice = value;
    }

    /**
     * 获取orderType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * 设置orderType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderType(String value) {
        this.orderType = value;
    }

    /**
     * 获取prescrType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrescrType() {
        return prescrType;
    }

    /**
     * 设置prescrType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrescrType(String value) {
        this.prescrType = value;
    }

    /**
     * 获取templateType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplateType() {
        return templateType;
    }

    /**
     * 设置templateType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplateType(String value) {
        this.templateType = value;
    }

    /**
     * 获取chargeFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChargeFlag() {
        return chargeFlag;
    }

    /**
     * 设置chargeFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChargeFlag(String value) {
        this.chargeFlag = value;
    }

    /**
     * 获取debtFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDebtFlag() {
        return debtFlag;
    }

    /**
     * 设置debtFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDebtFlag(String value) {
        this.debtFlag = value;
    }

    /**
     * 获取tisaType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTisaType() {
        return tisaType;
    }

    /**
     * 设置tisaType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTisaType(String value) {
        this.tisaType = value;
    }

    /**
     * 获取agents属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAgents() {
        return agents;
    }

    /**
     * 设置agents属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAgents(Long value) {
        this.agents = value;
    }

    /**
     * 获取templateForm属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplateForm() {
        return templateForm;
    }

    /**
     * 设置templateForm属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplateForm(String value) {
        this.templateForm = value;
    }

    /**
     * 获取medicMethod属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedicMethod() {
        return medicMethod;
    }

    /**
     * 设置medicMethod属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedicMethod(String value) {
        this.medicMethod = value;
    }

    /**
     * 获取createTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreateTime() {
        return createTime;
    }

    /**
     * 设置createTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreateTime(XMLGregorianCalendar value) {
        this.createTime = value;
    }

    /**
     * 获取dayAgents属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDayAgents() {
        return dayAgents;
    }

    /**
     * 设置dayAgents属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDayAgents(Long value) {
        this.dayAgents = value;
    }

    /**
     * 获取formAmount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormAmount() {
        return formAmount;
    }

    /**
     * 设置formAmount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormAmount(String value) {
        this.formAmount = value;
    }

    /**
     * 获取formUnit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormUnit() {
        return formUnit;
    }

    /**
     * 设置formUnit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormUnit(String value) {
        this.formUnit = value;
    }

    /**
     * 获取tisaMethod属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTisaMethod() {
        return tisaMethod;
    }

    /**
     * 设置tisaMethod属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTisaMethod(String value) {
        this.tisaMethod = value;
    }

    /**
     * 获取outpOrderItemList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OutpOrderItemList }
     *     
     */
    public OutpOrderItemList getOutpOrderItemList() {
        return outpOrderItemList;
    }

    /**
     * 设置outpOrderItemList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OutpOrderItemList }
     *     
     */
    public void setOutpOrderItemList(OutpOrderItemList value) {
        this.outpOrderItemList = value;
    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="OutpOrderItem" type="{http://wegohis.com}outpOrderItem" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "outpOrderItem"
    })
    public static class OutpOrderItemList {

        @XmlElement(name = "OutpOrderItem")
        protected List<OutpOrderItem> outpOrderItem;

        /**
         * Gets the value of the outpOrderItem property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the outpOrderItem property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOutpOrderItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OutpOrderItem }
         * 
         * 
         */
        public List<OutpOrderItem> getOutpOrderItem() {
            if (outpOrderItem == null) {
                outpOrderItem = new ArrayList<OutpOrderItem>();
            }
            return this.outpOrderItem;
        }

    }

}
