package com.healt.cloud.checkup.service.tcp.vo.exam;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-07-20 16:16
 */
@Data
public class ExamReportReleaseVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "患者ID")
    private String PID_2;
    @ApiModelProperty(value = "患者姓名")
    private String PID_5;
    @ApiModelProperty(value = "出生日期")
    private String PID_7;
    @ApiModelProperty(value = "性别")
    private String PID_8;

    @ApiModelProperty(value = "患者类别")
    private String PV1_2;
    @ApiModelProperty(value = "科室")
    private String PV1_3_1;
    @ApiModelProperty(value = "就诊医生")
    private String PV1_7;
    @ApiModelProperty(value = "就诊次数")
    private String PV1_19;
    @ApiModelProperty(value = "院区编码")
    private String PV1_39;
    @ApiModelProperty(value = "就诊时间")
    private String PV1_44;

    @ApiModelProperty(value = "医嘱控制码")
    private String ORC_1;
    @ApiModelProperty(value = "医技申请单号^^医嘱号")
    private String ORC_2;
    @ApiModelProperty(value = "医嘱类型")
    private String ORC_29;
    @ApiModelProperty(value = "执行科室^^科室编码")
    private String ORC_32;

    @ApiModelProperty(value = "序号")
    private String OBR_1;
    @ApiModelProperty(value = "报告单号")
    private String OBR_3;
    @ApiModelProperty(value = "诊疗项目代码^诊疗项目名称")
    private String OBR_4;
    @ApiModelProperty(value = "报告时间")
    private String OBR_22;
    @ApiModelProperty(value = "诊断服务类别")
    private String OBR_24;
    @ApiModelProperty(value = "报告状态")
    private String OBR_25;
    @ApiModelProperty(value = "报告医生")
    private String OBR_34_1;
    @ApiModelProperty(value = "审核医生")
    private String OBR_35_1;
    @ApiModelProperty(value = "报告单名称")
    private String OBR_47_2;

    @ApiModelProperty(value = "OBX集合")
    private List<ExamOBX> obxList;

    private static final char CARRIAGE_RETURN = 13;
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        //PID||201532012|652101198612221332^^^^01||马志明^^^MA ZHI MING||19861222000000|1|||&华容文化路 179 号^华容^岳阳^湖南|||||^^2|||652101198612221332|||^汉族^1
        str.append("PID||"+ PID_2 +"|||"+ PID_5 +"||"+ PID_7 +"|"+ PID_8 +"||||||||||||||")
                .append(CARRIAGE_RETURN)
                //PV1||1|101022101||||123123||||||0||||||2||||||||||||||||||||H0002|||||20220126094730
                .append("PV1||"+ PV1_2 +"|"+ PV1_3_1 +"^^^||||"+ PV1_7 +"||||||||||||"+ PV1_19 +"||||||||||||||||||||"+ PV1_39 +"|||||"+ PV1_44)
                .append(CARRIAGE_RETURN)
                //ORC|SN|02D2022022500156||||||||||||||||131612250063^USF|||||||||||D|||妇产科 B 超室^^210305
                .append("ORC|"+ ORC_1 +"|"+ ORC_2 +"|||||||||||||||||||||||||||"+ ORC_29 +"|||"+ORC_32)
                .append(CARRIAGE_RETURN)
                //OBR|1||02D2022022500156|02760^ 妇 彩 - 子 宫 、 附 件||||||||||||||||||20220225110350||RAD|F|||||||||101751&蒋婧婧|101751&蒋婧婧||||||||||||^二维彩超报告单两幅图
                .append("OBR|"+ OBR_1 +"||"+ OBR_3 +"|"+ OBR_4 +"||||||||||||||||||"+ OBR_22 +"||"+ OBR_24 +"|"+ OBR_25 +"|||||||||"+ OBR_34_1 +"|"+ OBR_35_1 +"||||||||||||^"+ OBR_47_2);

        for (int i = 0; i < obxList.size(); i++) {
            ExamOBX obxi = obxList.get(i);
            str.append(obxi.toString());
            if (i != obxList.size()-1) {
                str.append(CARRIAGE_RETURN);
            }
        }
        return str.toString();
    }
}
