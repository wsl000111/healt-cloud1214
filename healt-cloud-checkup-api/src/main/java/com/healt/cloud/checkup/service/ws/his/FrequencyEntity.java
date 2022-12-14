
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>frequencyEntity complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="frequencyEntity"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FrequencyId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MedInstCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FrequencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FrequencyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="LatinName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Cycle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CycleUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CycleUnitName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Times" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RecordTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UseScope" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UseScopeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="WbCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "frequencyEntity", propOrder = {
    "frequencyId",
    "medInstCode",
    "frequencyCode",
    "frequencyName",
    "latinName",
    "cycle",
    "cycleUnit",
    "cycleUnitName",
    "times",
    "recordTime",
    "useScope",
    "useScopeName",
    "pyCode",
    "wbCode"
})
public class FrequencyEntity {

    @XmlElement(name = "FrequencyId")
    protected String frequencyId;
    @XmlElement(name = "MedInstCode")
    protected String medInstCode;
    @XmlElement(name = "FrequencyCode")
    protected String frequencyCode;
    @XmlElement(name = "FrequencyName")
    protected String frequencyName;
    @XmlElement(name = "LatinName")
    protected String latinName;
    @XmlElement(name = "Cycle")
    protected String cycle;
    @XmlElement(name = "CycleUnit")
    protected String cycleUnit;
    @XmlElement(name = "CycleUnitName")
    protected String cycleUnitName;
    @XmlElement(name = "Times")
    protected String times;
    @XmlElement(name = "RecordTime")
    protected String recordTime;
    @XmlElement(name = "UseScope")
    protected String useScope;
    @XmlElement(name = "UseScopeName")
    protected String useScopeName;
    @XmlElement(name = "PyCode")
    protected String pyCode;
    @XmlElement(name = "WbCode")
    protected String wbCode;

    /**
     * 获取frequencyId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrequencyId() {
        return frequencyId;
    }

    /**
     * 设置frequencyId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrequencyId(String value) {
        this.frequencyId = value;
    }

    /**
     * 获取medInstCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedInstCode() {
        return medInstCode;
    }

    /**
     * 设置medInstCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedInstCode(String value) {
        this.medInstCode = value;
    }

    /**
     * 获取frequencyCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrequencyCode() {
        return frequencyCode;
    }

    /**
     * 设置frequencyCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrequencyCode(String value) {
        this.frequencyCode = value;
    }

    /**
     * 获取frequencyName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrequencyName() {
        return frequencyName;
    }

    /**
     * 设置frequencyName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrequencyName(String value) {
        this.frequencyName = value;
    }

    /**
     * 获取latinName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLatinName() {
        return latinName;
    }

    /**
     * 设置latinName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLatinName(String value) {
        this.latinName = value;
    }

    /**
     * 获取cycle属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCycle() {
        return cycle;
    }

    /**
     * 设置cycle属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCycle(String value) {
        this.cycle = value;
    }

    /**
     * 获取cycleUnit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCycleUnit() {
        return cycleUnit;
    }

    /**
     * 设置cycleUnit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCycleUnit(String value) {
        this.cycleUnit = value;
    }

    /**
     * 获取cycleUnitName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCycleUnitName() {
        return cycleUnitName;
    }

    /**
     * 设置cycleUnitName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCycleUnitName(String value) {
        this.cycleUnitName = value;
    }

    /**
     * 获取times属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimes() {
        return times;
    }

    /**
     * 设置times属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimes(String value) {
        this.times = value;
    }

    /**
     * 获取recordTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecordTime() {
        return recordTime;
    }

    /**
     * 设置recordTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordTime(String value) {
        this.recordTime = value;
    }

    /**
     * 获取useScope属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUseScope() {
        return useScope;
    }

    /**
     * 设置useScope属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUseScope(String value) {
        this.useScope = value;
    }

    /**
     * 获取useScopeName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUseScopeName() {
        return useScopeName;
    }

    /**
     * 设置useScopeName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUseScopeName(String value) {
        this.useScopeName = value;
    }

    /**
     * 获取pyCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPyCode() {
        return pyCode;
    }

    /**
     * 设置pyCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPyCode(String value) {
        this.pyCode = value;
    }

    /**
     * 获取wbCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWbCode() {
        return wbCode;
    }

    /**
     * 设置wbCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWbCode(String value) {
        this.wbCode = value;
    }

}
