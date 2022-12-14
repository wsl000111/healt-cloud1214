package com.healt.cloud.checkup.service.tcp.vo.lab;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-07-19 14:08
 */
@Data
public class LabStatusResponseVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "患者 ID")
    private String PID_2;
    @ApiModelProperty(value = "患者姓名")
    private String PID_5;
    @ApiModelProperty(value = "出生日期")
    private String PID_7;
    @ApiModelProperty(value = "性别编码")
    private String PID_8;

    @ApiModelProperty(value = "患者类型")
    private String PV1_2;
    @ApiModelProperty(value = "科室编码")
    private String PV1_3_1;
    @ApiModelProperty(value = "患者就诊次数")
    private String PV1_19;
    @ApiModelProperty(value = "院区编码")
    private String PV1_39;
    @ApiModelProperty(value = "就诊时间")
    private String PV1_44;

    @ApiModelProperty(value = "医嘱控制码")
    private String ORC_1;
    @ApiModelProperty(value = "开单者申请单号")
    private String ORC_2;
    @ApiModelProperty(value = "操作时间")
    private String ORC_9;
    @ApiModelProperty(value = "操作人")
    private String ORC_19;
    @ApiModelProperty(value = "医嘱类型")
    private String ORC_29;
    @ApiModelProperty(value = "执行科室^^科室编号")
    private String ORC_32;

    @ApiModelProperty(value = "序号")
    private String OBR_1;
    @ApiModelProperty(value = "检验项目代码^项目名称")
    private String OBR_4;
    @ApiModelProperty(value = "结果状态")
    private String OBR_25;

    @ApiModelProperty(value = "序号")
    private String SPM_1;
    @ApiModelProperty(value = "样本编码")
    private String SPM_4;

    @ApiModelProperty(value = "试管条码")
    private String SAC_3;
    @ApiModelProperty(value = "试管颜色")
    private String SAC_8;

    @ApiModelProperty(value = "是否立即计费")
    private String BLG_1_1;

    private static final char CARRIAGE_RETURN = 13;
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        //PID||201532012|652101198612221332^^^^01||马志明^^^MA ZHI MING||19861222000000|1|||&华容文化路 179 号^华容^岳阳^湖南|||||^^2|||652101198612221332|||^汉族^1
        str.append("PID||"+ PID_2 +"|||"+ PID_5 +"||"+ PID_7 +"|"+ PID_8 +"||||||||||||||")
                .append(CARRIAGE_RETURN)
        //PV1||1|1007^^^||||0831||||||0||||||1||||||||||||||||||||H0002|||||20220105100100||||||
                .append("PV1||"+ PV1_2 +"|"+ PV1_3_1 +"^^^||||||||||||||||"+ PV1_19 +"||||||||||||||||||||"+ PV1_39 +"|||||"+ PV1_44 +"||||||")
                .append(CARRIAGE_RETURN)
        //ORC|SC|02C201708-2400445^^84704|||||||20170824162118||||||||||0383^陈新宽||||||||||C|||医学检验科^^2301
                .append("ORC|"+ ORC_1 +"|"+ ORC_2 +"|||||||"+ ORC_9 +"||||||||||"+ ORC_19 +"||||||||||"+ ORC_29 +"|||"+ ORC_32)
                .append(CARRIAGE_RETURN)
        //OBR|1|||GCP002^GCP 血常规|||||||||||||||||||||30||||||||||||||NoPass
                .append("OBR|"+ OBR_1 +"|||"+ OBR_4 +"|||||||||||||||||||||"+ OBR_25 +"|||||||||||||||||||||||||")
                .append(CARRIAGE_RETURN)
        //SPM|1|||1^全血
                .append("SPM|"+ SPM_1 +"|||"+ SPM_4)
                .append(CARRIAGE_RETURN)
        //SAC|||117082411172|||||0
                .append("SAC|||"+ SAC_3 +"|||||"+ SAC_8)
                .append(CARRIAGE_RETURN)
        //BLG|I
                .append("BLG|"+ BLG_1_1);
        return str.toString();
    }
}
