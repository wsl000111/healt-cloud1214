package com.healt.cloud.pdf.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class WebPersonOrderListVo implements Serializable {

    private String personId;

    private String idNo;

    private String name;

    private String sex;

    private Date barthday;

    private String phoneNumber;

    private String mobile;

    private Date appointsDate;

    private Integer personVisitId;

    private String unitId;

    private String unitName;

    private String finishedSign;

    private Date finishedDate;

    private String resultStatus;

    private String itemPackCode;

    private String itemPackName;

    private Integer itemNo;

    private BigDecimal costs;

    private BigDecimal charges;

    private String billIndicator;

    private String itemFinishedSign;

    private String orderId;

}
