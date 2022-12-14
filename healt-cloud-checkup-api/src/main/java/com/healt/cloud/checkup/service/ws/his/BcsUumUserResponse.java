
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>bcsUumUserResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="bcsUumUserResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UserInfoList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="UserInfo" type="{http://wegohis.com}bcsUumUser" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bcsUumUserResponse", propOrder = {
    "userInfoList"
})
public class BcsUumUserResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "UserInfoList")
    protected UserInfoList userInfoList;

    /**
     * 获取userInfoList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link UserInfoList }
     *     
     */
    public UserInfoList getUserInfoList() {
        return userInfoList;
    }

    /**
     * 设置userInfoList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link UserInfoList }
     *     
     */
    public void setUserInfoList(UserInfoList value) {
        this.userInfoList = value;
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
     *         &lt;element name="UserInfo" type="{http://wegohis.com}bcsUumUser" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "userInfo"
    })
    public static class UserInfoList {

        @XmlElement(name = "UserInfo")
        protected List<BcsUumUser> userInfo;

        /**
         * Gets the value of the userInfo property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the userInfo property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getUserInfo().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BcsUumUser }
         * 
         * 
         */
        public List<BcsUumUser> getUserInfo() {
            if (userInfo == null) {
                userInfo = new ArrayList<BcsUumUser>();
            }
            return this.userInfo;
        }

    }

}
