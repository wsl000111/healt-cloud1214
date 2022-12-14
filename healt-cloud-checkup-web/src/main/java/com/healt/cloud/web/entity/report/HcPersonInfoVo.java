package com.healt.cloud.web.entity.report;



import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class HcPersonInfoVo implements Serializable {
    private String hospitalId;

    private String personId;

    private String name;

    private String unitId;

    private String sex;

    private String unitName;

    private String idNo;

    private Date barthday;

    private String inputCode;

    private String maritalStatus;

    private String country;

    private String area;

    private String pwd;

    private String nation;

    private String address;

    private String postcode;

    private String phoneNumber;

    private String mobile;

    private String email;

    private String source;

    private String job;

    private String examClass;

    private String personLevel;

    private String department;

    private String chargeType;

    private String personCharge;

    private String identity;

    private Date buildDate;

    private String userId;

    private String userName;

    private String note;

    private String salt;

    private String patientId;

    private String code;

}
