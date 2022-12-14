
package com.healt.cloud.checkup.service.ws.his;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>materialQueryResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="materialQueryResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://wegohis.com}soapBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MaterialList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Material" type="{http://wegohis.com}materialQueryVO" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "materialQueryResponse", propOrder = {
    "materialList"
})
public class MaterialQueryResponse
    extends SoapBaseResponse
{

    @XmlElement(name = "MaterialList")
    protected MaterialList materialList;

    /**
     * 获取materialList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link MaterialList }
     *     
     */
    public MaterialList getMaterialList() {
        return materialList;
    }

    /**
     * 设置materialList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MaterialList }
     *     
     */
    public void setMaterialList(MaterialList value) {
        this.materialList = value;
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
     *         &lt;element name="Material" type="{http://wegohis.com}materialQueryVO" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "material"
    })
    public static class MaterialList {

        @XmlElement(name = "Material")
        protected List<MaterialQueryVO> material;

        /**
         * Gets the value of the material property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the material property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMaterial().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link MaterialQueryVO }
         * 
         * 
         */
        public List<MaterialQueryVO> getMaterial() {
            if (material == null) {
                material = new ArrayList<MaterialQueryVO>();
            }
            return this.material;
        }

    }

}
