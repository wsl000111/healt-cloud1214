package com.healt.cloud.checkup.service.tcp.vo.lab;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-07-20 11:23
 */
@Data
public class LabCriticalValueVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "患者 ID")
    private String PID_2;
    @ApiModelProperty(value = "患者姓名")
    private String PID_5;
    @ApiModelProperty(value = "出生日期")
    private String PID_7;
    @ApiModelProperty(value = "性别")
    private String PID_8;

    @ApiModelProperty(value = "患者类型")
    private String PV1_2;
    @ApiModelProperty(value = "科室编码")
    private String PV1_3_1;
    @ApiModelProperty(value = "就诊医生")
    private String PV1_7;
    @ApiModelProperty(value = "患者就诊次数")
    private String PV1_19;
    @ApiModelProperty(value = "院区编码")
    private String PV1_39;
    @ApiModelProperty(value = "就诊时间")
    private String PV1_44;

    @ApiModelProperty(value = "医嘱控制码")
    private String ORC_1;
    @ApiModelProperty(value = "医技申请单号^^医嘱号")
    private String ORC_2;
    @ApiModelProperty(value = "危急值标识")
    private String ORC_16;
    @ApiModelProperty(value = "操作人")
    private String ORC_19;
    @ApiModelProperty(value = "医嘱类型")
    private String ORC_29;
    @ApiModelProperty(value = "执行科室^^科室编号")
    private String ORC_32;

    @ApiModelProperty(value = "序号")
    private String OBR_1;
    @ApiModelProperty(value = "报告单号")
    private String OBR_2;
    @ApiModelProperty(value = "项目代码^项目名称")
    private String OBR_4;
    @ApiModelProperty(value = "确认人")
    private String OBR_34_1;

    @ApiModelProperty(value = "序号")
    private String NET_1;
    @ApiModelProperty(value = "处理内容")
    private String NET_3;
    @ApiModelProperty(value = "处理医生")
    private String NET_4_1;
    @ApiModelProperty(value = "处理科室")
    private String NET_4_2;
    @ApiModelProperty(value = "处理时间")
    private String NET_6;

    private static final char CARRIAGE_RETURN = 13;
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        //PID||201532012|652101198612221332^^^^01||马志明^^^MA ZHI MING||19861222000000|1|||&华容文化路 179 号^华容^岳阳^湖南|||||^^2|||652101198612221332|||^汉族^1
        str.append("PID||"+ PID_2 +"|||"+ PID_5 +"||"+ PID_7 +"|"+ PID_8 +"||||||||||||||")
                .append(CARRIAGE_RETURN)
                //PV1||1|101022101||||123123||||||0||||||2||||||||||||||||||||H0002|||||20220126094730
                .append("PV1||"+ PV1_2 +"|"+ PV1_3_1 +"^^^||||"+ PV1_7 +"||||||||||||"+ PV1_19 +"||||||||||||||||||||"+ PV1_39 +"|||||"+ PV1_44 +"||||||")
                .append(CARRIAGE_RETURN)
                //ORC|OK||02D2021041700600||||||20210418101714|||||||CR^危急值|||09152^金媛||||||||||D|||急诊 CT 室^^230506
                .append("ORC|"+ ORC_1 +"|"+ ORC_2 +"||||||||||||||"+ ORC_16 +"|||"+ ORC_19 +"||||||||||"+ ORC_29 +"|||"+ ORC_32)
                .append(CARRIAGE_RETURN)
                //OBR|1|1550088||6LTC0001^上腹 CT 平扫||||||||||||||||||||||||||||||1947&李娅|唐兆伦&1712
                .append("OBR|"+ OBR_1 +"|"+ OBR_2 +"||"+ OBR_4 +"||||||||||||||||||||||||||||||"+ OBR_34_1 +"||||||||||||||||")
                .append(CARRIAGE_RETURN)
                //NTE|1||汇报医生|1234&张医生^13123&外科||20220301184119
                .append("NET|"+ NET_1 +"||"+ NET_3 +"|"+ NET_4_1 +"^"+ NET_4_2 +"||"+ NET_6);
        return str.toString();
    }
}
