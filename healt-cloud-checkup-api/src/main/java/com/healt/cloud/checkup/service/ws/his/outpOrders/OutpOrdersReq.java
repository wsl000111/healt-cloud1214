package com.healt.cloud.checkup.service.ws.his.outpOrders;

import lombok.Data;

/**
 * @author GuYue
 * @date 2022-07-23 22:37
 * @description: TODO
 */
@Data
public class OutpOrdersReq {

    //卡类型（采血系统可以配置，默认1＝自动识别，2＝卡号，3＝病历号，4＝发票号，9=双击病人姓名开窗模式）
    private String cardType;

    //卡号/病历号/发票号等
    private String cardNo;

    private String startDate;

    private String endDate;

    //显示已经确认的项目（1＝显示确认，其它表示不显示）
    private String showOrderConfirm;

    //执行科室（多个用逗号隔开，NULL关键字表示执行科室为空的情况）
    private String performedBy;

}
