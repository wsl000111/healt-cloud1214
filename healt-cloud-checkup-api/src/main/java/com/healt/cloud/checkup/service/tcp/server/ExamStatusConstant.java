package com.healt.cloud.checkup.service.tcp.server;

/**
 * @author GuYue
 * @date 2022-07-19 17:00
 * @description: TODO
 */
public class ExamStatusConstant {
    public static String EXAM_APPOINT = "20"; //检查预约
    public static String EXAM_CANCEL = "7"; //取消预约
    public static String EXAM_SIGN = "25"; //检查签到
//30 检查登记 到检，在检查系统登记，准备做检查
//31 取消登记
//40 检查开始
//50 图像到达
//60 初步报告 不单独发送状态变更，只发送初步报告（文字报告之前发）
//70 审核发布 不单独发送状态变更，只发送审核报告
//80 取消报告
}
