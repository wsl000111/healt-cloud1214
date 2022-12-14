package com.healt.cloud.web.entity.user;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class WebUserInfo implements Serializable {
    private String id;

    private String userName;

    private String idNo;

    private String phoneNo;

    private String personId;

    private String wxNo;

    private Date insertDate;

    private String relationShip;
}
