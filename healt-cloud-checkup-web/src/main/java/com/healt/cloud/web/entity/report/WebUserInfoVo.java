package com.healt.cloud.web.entity.report;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author 田恒宇
 * @since 2022-09-22
 */
@Data
public class WebUserInfoVo implements Serializable {

    private String  id;

    private String userName;

    private String idNo;

    private String phoneNo;

    private String personId;

    private String wxNo;

    private Date insertDate;

    private String relationShip;

    private String  code;

    private String  openId;

    private String bindId;

}
