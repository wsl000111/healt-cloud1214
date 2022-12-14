
package com.healt.cloud.checkup.service.ws.his;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bedDictVO complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="bedDictVO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BedId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BedCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BedName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BedTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SortNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AreaCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MedInstCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="WardCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AuthorizedCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AuthorizedName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RoomCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sexFlagCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SexFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RoomTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsEnable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bedDictVO", propOrder = {
    "bedId",
    "bedCode",
    "bedName",
    "bedTypeCode",
    "sortNo",
    "areaCode",
    "medInstCode",
    "wardCode",
    "authorizedCode",
    "authorizedName",
    "roomCode",
    "sexFlagCode",
    "sexFlag",
    "roomTypeCode",
    "isEnable"
})
public class BedDictVO {

    @XmlElement(name = "BedId")
    protected String bedId;
    @XmlElement(name = "BedCode")
    protected String bedCode;
    @XmlElement(name = "BedName")
    protected String bedName;
    @XmlElement(name = "BedTypeCode")
    protected String bedTypeCode;
    @XmlElement(name = "SortNo")
    protected String sortNo;
    @XmlElement(name = "AreaCode")
    protected String areaCode;
    @XmlElement(name = "MedInstCode")
    protected String medInstCode;
    @XmlElement(name = "WardCode")
    protected String wardCode;
    @XmlElement(name = "AuthorizedCode")
    protected String authorizedCode;
    @XmlElement(name = "AuthorizedName")
    protected String authorizedName;
    @XmlElement(name = "RoomCode")
    protected String roomCode;
    protected String sexFlagCode;
    @XmlElement(name = "SexFlag")
    protected String sexFlag;
    @XmlElement(name = "RoomTypeCode")
    protected String roomTypeCode;
    @XmlElement(name = "IsEnable")
    protected String isEnable;

    /**
     * 获取bedId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBedId() {
        return bedId;
    }

    /**
     * 设置bedId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBedId(String value) {
        this.bedId = value;
    }

    /**
     * 获取bedCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBedCode() {
        return bedCode;
    }

    /**
     * 设置bedCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBedCode(String value) {
        this.bedCode = value;
    }

    /**
     * 获取bedName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBedName() {
        return bedName;
    }

    /**
     * 设置bedName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBedName(String value) {
        this.bedName = value;
    }

    /**
     * 获取bedTypeCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBedTypeCode() {
        return bedTypeCode;
    }

    /**
     * 设置bedTypeCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBedTypeCode(String value) {
        this.bedTypeCode = value;
    }

    /**
     * 获取sortNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSortNo() {
        return sortNo;
    }

    /**
     * 设置sortNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSortNo(String value) {
        this.sortNo = value;
    }

    /**
     * 获取areaCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 设置areaCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaCode(String value) {
        this.areaCode = value;
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
     * 获取wardCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWardCode() {
        return wardCode;
    }

    /**
     * 设置wardCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWardCode(String value) {
        this.wardCode = value;
    }

    /**
     * 获取authorizedCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizedCode() {
        return authorizedCode;
    }

    /**
     * 设置authorizedCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizedCode(String value) {
        this.authorizedCode = value;
    }

    /**
     * 获取authorizedName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizedName() {
        return authorizedName;
    }

    /**
     * 设置authorizedName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizedName(String value) {
        this.authorizedName = value;
    }

    /**
     * 获取roomCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomCode() {
        return roomCode;
    }

    /**
     * 设置roomCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomCode(String value) {
        this.roomCode = value;
    }

    /**
     * 获取sexFlagCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSexFlagCode() {
        return sexFlagCode;
    }

    /**
     * 设置sexFlagCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSexFlagCode(String value) {
        this.sexFlagCode = value;
    }

    /**
     * 获取sexFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSexFlag() {
        return sexFlag;
    }

    /**
     * 设置sexFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSexFlag(String value) {
        this.sexFlag = value;
    }

    /**
     * 获取roomTypeCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomTypeCode() {
        return roomTypeCode;
    }

    /**
     * 设置roomTypeCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomTypeCode(String value) {
        this.roomTypeCode = value;
    }

    /**
     * 获取isEnable属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsEnable() {
        return isEnable;
    }

    /**
     * 设置isEnable属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsEnable(String value) {
        this.isEnable = value;
    }

}
