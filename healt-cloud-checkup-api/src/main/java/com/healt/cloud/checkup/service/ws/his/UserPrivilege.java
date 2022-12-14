
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>userPrivilege complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="userPrivilege"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SysUri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HasContext" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RoleList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Role" type="{http://wegohis.com}userPrivilegeRole" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="FuncList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="SysFunc" type="{http://wegohis.com}userPrivilegeFunc" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AuthList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Auth" type="{http://wegohis.com}userPrivilegeSysCtlAuth" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "userPrivilege", propOrder = {
    "sysUri",
    "hasContext",
    "roleList",
    "funcList",
    "authList"
})
public class UserPrivilege {

    @XmlElement(name = "SysUri")
    protected String sysUri;
    @XmlElement(name = "HasContext", defaultValue = "0")
    protected String hasContext;
    @XmlElement(name = "RoleList")
    protected RoleList roleList;
    @XmlElement(name = "FuncList")
    protected FuncList funcList;
    @XmlElement(name = "AuthList")
    protected AuthList authList;

    /**
     * 获取sysUri属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSysUri() {
        return sysUri;
    }

    /**
     * 设置sysUri属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSysUri(String value) {
        this.sysUri = value;
    }

    /**
     * 获取hasContext属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHasContext() {
        return hasContext;
    }

    /**
     * 设置hasContext属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHasContext(String value) {
        this.hasContext = value;
    }

    /**
     * 获取roleList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link RoleList }
     *     
     */
    public RoleList getRoleList() {
        return roleList;
    }

    /**
     * 设置roleList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RoleList }
     *     
     */
    public void setRoleList(RoleList value) {
        this.roleList = value;
    }

    /**
     * 获取funcList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FuncList }
     *     
     */
    public FuncList getFuncList() {
        return funcList;
    }

    /**
     * 设置funcList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FuncList }
     *     
     */
    public void setFuncList(FuncList value) {
        this.funcList = value;
    }

    /**
     * 获取authList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AuthList }
     *     
     */
    public AuthList getAuthList() {
        return authList;
    }

    /**
     * 设置authList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AuthList }
     *     
     */
    public void setAuthList(AuthList value) {
        this.authList = value;
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
     *         &lt;element name="Auth" type="{http://wegohis.com}userPrivilegeSysCtlAuth" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "auth"
    })
    public static class AuthList {

        @XmlElement(name = "Auth")
        protected List<UserPrivilegeSysCtlAuth> auth;

        /**
         * Gets the value of the auth property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the auth property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAuth().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link UserPrivilegeSysCtlAuth }
         * 
         * 
         */
        public List<UserPrivilegeSysCtlAuth> getAuth() {
            if (auth == null) {
                auth = new ArrayList<UserPrivilegeSysCtlAuth>();
            }
            return this.auth;
        }

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
     *         &lt;element name="SysFunc" type="{http://wegohis.com}userPrivilegeFunc" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "sysFunc"
    })
    public static class FuncList {

        @XmlElement(name = "SysFunc")
        protected List<UserPrivilegeFunc> sysFunc;

        /**
         * Gets the value of the sysFunc property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the sysFunc property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSysFunc().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link UserPrivilegeFunc }
         * 
         * 
         */
        public List<UserPrivilegeFunc> getSysFunc() {
            if (sysFunc == null) {
                sysFunc = new ArrayList<UserPrivilegeFunc>();
            }
            return this.sysFunc;
        }

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
     *         &lt;element name="Role" type="{http://wegohis.com}userPrivilegeRole" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "role"
    })
    public static class RoleList {

        @XmlElement(name = "Role")
        protected List<UserPrivilegeRole> role;

        /**
         * Gets the value of the role property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the role property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRole().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link UserPrivilegeRole }
         * 
         * 
         */
        public List<UserPrivilegeRole> getRole() {
            if (role == null) {
                role = new ArrayList<UserPrivilegeRole>();
            }
            return this.role;
        }

    }

    @Override
    public String toString() {
        return "UserPrivilege{" +
                "sysUri='" + sysUri + '\'' +
                ", hasContext='" + hasContext + '\'' +
                ", roleList=" + roleList +
                ", funcList=" + funcList +
                ", authList=" + authList +
                '}';
    }
}
