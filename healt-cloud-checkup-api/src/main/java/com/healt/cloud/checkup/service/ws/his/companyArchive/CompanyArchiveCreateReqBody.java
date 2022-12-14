package com.healt.cloud.checkup.service.ws.his.companyArchive;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-09-01 8:15
 * @description: TODO
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Body")
public class CompanyArchiveCreateReqBody implements Serializable {

    @XmlElement(name = "CompanyInfo")
    protected CompanyInfo companyInfo;

}
