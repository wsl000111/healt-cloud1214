package com.healt.cloud.checkup.service.ws.his.companyArchive;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-09-01 9:37
 * @description: TODO
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "result", propOrder = {
        "code",
        "desc",
        "examCompanyID"
})
@XmlRootElement
@Data
public class CompanyResult implements Serializable {
    @XmlElement(name = "Code", required = true)
    protected String code;
    @XmlElement(name = "Desc")
    protected String desc;
    @XmlElement(name = "ExamCompanyID")
    protected String examCompanyID;
}
