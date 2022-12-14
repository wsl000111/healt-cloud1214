
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ssoUserInfoResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ssoUserInfoResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UserInfo" type="{http://wegohis.com}bcsUumUser" minOccurs="0"/&gt;
 *         &lt;element name="MediTeamList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="MediTeam" type="{http://wegohis.com}mediTeam" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="UserPrivilege" type="{http://wegohis.com}userPrivilege" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ssoUserInfoResponse", propOrder = {
    "userInfo",
    "mediTeamList",
    "userPrivilege"
})
public class SsoUserInfoResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "UserInfo")
    protected BcsUumUser userInfo;
    @XmlElement(name = "MediTeamList")
    protected MediTeamList mediTeamList;
    @XmlElement(name = "UserPrivilege")
    protected UserPrivilege userPrivilege;

    /**
     * 获取userInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BcsUumUser }
     *     
     */
    public BcsUumUser getUserInfo() {
        return userInfo;
    }

    /**
     * 设置userInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BcsUumUser }
     *     
     */
    public void setUserInfo(BcsUumUser value) {
        this.userInfo = value;
    }

    /**
     * 获取mediTeamList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link MediTeamList }
     *     
     */
    public MediTeamList getMediTeamList() {
        return mediTeamList;
    }

    /**
     * 设置mediTeamList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MediTeamList }
     *     
     */
    public void setMediTeamList(MediTeamList value) {
        this.mediTeamList = value;
    }

    /**
     * 获取userPrivilege属性的值。
     * 
     * @return
     *     possible object is
     *     {@link UserPrivilege }
     *     
     */
    public UserPrivilege getUserPrivilege() {
        return userPrivilege;
    }

    /**
     * 设置userPrivilege属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link UserPrivilege }
     *     
     */
    public void setUserPrivilege(UserPrivilege value) {
        this.userPrivilege = value;
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
     *         &lt;element name="MediTeam" type="{http://wegohis.com}mediTeam" maxOccurs="unbounded"/&gt;
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
        "mediTeam"
    })
    public static class MediTeamList {

        @XmlElement(name = "MediTeam", required = true)
        protected List<MediTeam> mediTeam;

        /**
         * Gets the value of the mediTeam property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mediTeam property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMediTeam().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link MediTeam }
         * 
         * 
         */
        public List<MediTeam> getMediTeam() {
            if (mediTeam == null) {
                mediTeam = new ArrayList<MediTeam>();
            }
            return this.mediTeam;
        }

    }

}
