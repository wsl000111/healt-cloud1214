package com.healt.cloud.checkup.service.tcp.vo.lab;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-07-19 16:20
 */
@Data
public class LabReportQueryRspVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "查询消息名称")
    private String QPD_1;
    @ApiModelProperty(value = "查询标记")
    private String QPD_2;
    @ApiModelProperty(value = "患者类别")
    private String QPD_3_1;
    @ApiModelProperty(value = "患者ID")
    private String QPD_3_2;
    @ApiModelProperty(value = "就诊次数")
    private String QPD_3_3;
    @ApiModelProperty(value = "开始时间")
    private String QPD_3_4;
    @ApiModelProperty(value = "结束时间")
    private String QPD_3_5;

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
    @ApiModelProperty(value = "开单者申请单号")
    private String ORC_2;
    @ApiModelProperty(value = "医嘱控制码原因")
    private String ORC_16;
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
    @ApiModelProperty(value = "标本采集时间")
    private String OBR_7;
    @ApiModelProperty(value = "标本条码")
    private String OBR_11;
    @ApiModelProperty(value = "标本接收时间")
    private String OBR_14;
    @ApiModelProperty(value = "样本代码&样本名称")
    private String OBR_15_1;
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
    @ApiModelProperty(value = "父项目代码^项目名称")
    private String OBR_50;

    @ApiModelProperty(value = "OBX集合")
    private List<OBX> obxList;

    private static final char CARRIAGE_RETURN = 13;
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        //QPD|Z08^检验报告查询|Z0801|1^1008533000^2^20220101235249^20220121235249
        str.append("QPD|"+ QPD_1 +"|"+ QPD_2 +"|"+QPD_3_1+"^"+QPD_3_2+"^"+QPD_3_3+"^"+QPD_3_4+"^"+QPD_3_5)
                .append(CARRIAGE_RETURN)
                //PID||201532012|652101198612221332^^^^01||马志明^^^MA ZHI MING||19861222000000|1|||&华容文化路 179 号^华容^岳阳^湖南|||||^^2|||652101198612221332|||^汉族^1
                .append("PID||"+ PID_2 +"|||"+ PID_5 +"||"+ PID_7 +"|"+ PID_8 +"|||")
                .append(CARRIAGE_RETURN)
                //PV1||1|1007^^^||||0831||||||0||||||1||||||||||||||||||||H0002|||||20220105100100||||||
                .append("PV1||"+ PV1_2 +"|"+ PV1_3_1 +"^^^||||"+ PV1_7 +"||||||||||||"+ PV1_19 +"||||||||||||||||||||"+ PV1_39 +"|||||"+ PV1_44 +"||||||")
                .append(CARRIAGE_RETURN)
                //ORC|SN|02D2022122500156^^||||||||||||||||sr23^DGHY-E1|||||||||||C|||检验科^^210305
                .append("ORC|"+ ORC_1 +"|"+ ORC_2 +"||||||||||||||"+ ORC_16 +"|||||||||||||"+ ORC_29 +"|||"+ORC_32)
                .append(CARRIAGE_RETURN)
                //OBR|1||02D2022022500156|9022^ 血 常 规 |||20220224142937||||Spem123sd9344| 标 本 无 污 染 | 检 查 意 见|20220224150115|1&血|||||||20220224150200||LAB|F|||||||||101751\T\蒋婧婧|101751\T\蒋婧婧||||||||||||^血常规检验报告^^无|||
                .append("OBR|"+ OBR_1 +"||"+ OBR_3 +"|"+ OBR_4 +"|||"+ OBR_7 +"||||"+ OBR_11 +"|||"+ OBR_14 +"|"+ OBR_15_1 +"|||||||"+ OBR_22 +"||"+ OBR_24 +"|"+ OBR_25 +"|||||||||"+ OBR_34_1 +"|"+ OBR_35_1 +"||||||||||||^"+ OBR_47_2 +"^^|||"+ OBR_50);

        for (int i = 0; i < obxList.size(); i++) {
            //OBX|2|CWE|0101011^嗜酸性粒细胞比率||10.7^WBC|10\S\CCU/ml|3.5-9.5|↑||||||20220224151646||101751\S\蒋婧婧|N||||||||
            OBX obxi = obxList.get(i);
            str.append(obxi.toString());
            if (i != obxList.size()-1) {
                str.append(CARRIAGE_RETURN);
            }
        }
        return str.toString();
    }
}
