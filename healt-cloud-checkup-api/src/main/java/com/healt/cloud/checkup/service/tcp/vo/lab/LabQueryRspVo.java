package com.healt.cloud.checkup.service.tcp.vo.lab;

import com.healt.cloud.checkup.service.tcp.vo.pathology.PathologyQueryRspVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-07-19 8:48
 */
@Data
public class LabQueryRspVo implements Serializable {

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
    @ApiModelProperty(value = "执行科室")
    private String QPD_3_4;
    @ApiModelProperty(value = "开始时间")
    private String QPD_3_5;
    @ApiModelProperty(value = "结束时间")
    private String QPD_3_6;

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
    @ApiModelProperty(value = "申请时间")
    private String ORC_9;
    @ApiModelProperty(value = "申请医生")
    private String ORC_12;
    @ApiModelProperty(value = "申请科室^^科室编码")
    private String ORC_21;
    @ApiModelProperty(value = "医嘱类型")
    private String ORC_29;
    @ApiModelProperty(value = "执行科室^^科室编码")
    private String ORC_32;

    private List<OBR> obrList;
    @Data
    public static class OBR implements Serializable{
        @ApiModelProperty(value = "序号")
        private String OBR_1;
        @ApiModelProperty(value = "检验项目")
        private String OBR_4;
        @ApiModelProperty(value = "紧急标志")
        private String OBR_5;
        @ApiModelProperty(value = "样本代码&样本名称")
        private String OBR_15_1;
        @ApiModelProperty(value = "项目金额")
        private String OBR_19;
    }

    private List<DG1> dg1List;
    @Data
    public static class DG1 implements Serializable{
        @ApiModelProperty(value = "序号")
        private String DG1_1;
        @ApiModelProperty(value = "临床诊断")
        private String DG1_3;
        @ApiModelProperty(value = "诊断类型")
        private String DG1_6;
    }

    private static final char CARRIAGE_RETURN = 13;
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        //QPD|Z04^查询检查申请信息|Z0401|2^1006188174^1^3120^20211200000000^20211228000000
        str.append("QPD|"+ QPD_1 +"|"+ QPD_2 +"|"+QPD_3_1+"^"+QPD_3_2+"^"+QPD_3_3+"^"+QPD_3_4+"^"+QPD_3_5+"^"+QPD_3_6)
                .append(CARRIAGE_RETURN)
        //PID||201532012|652101198612221332^^^^01||马志明^^^MA ZHI MING||19861222000000|1|||&华容文化路 179 号
                .append("PID||"+ PID_2 +"|||"+ PID_5 +"||"+ PID_7 +"|"+ PID_8 +"|||")
                .append(CARRIAGE_RETURN)
        //PV1||1|1007^^^||||0831||||||0||||||1||||||||||||||||||||H0002|||||20220105100100||||||
                .append("PV1||"+ PV1_2 +"|"+ PV1_3_1 +"^^^||||"+ PV1_7 +"||||||||||||"+ PV1_19 +"||||||||||||||||||||"+ PV1_39 +"|||||"+ PV1_44 +"||||||")
                .append(CARRIAGE_RETURN)
        //ORC|NW|02C2123141^^100834|||2|1|107||20220105100732|||101275^汤鑫|||||||||肝胆内科^^1007||||||||C|||检验科^^1218
                .append("ORC|"+ ORC_1 +"|"+ ORC_2 +"|||||||"+ ORC_9 +"|||"+ ORC_12 +"|||||||||"+ ORC_21 +"||||||||"+ ORC_29 +"|||"+ORC_32)
                .append(CARRIAGE_RETURN);
        //OBR|1|||JY011^肝功能全套|1||||||||临床信息||1&血||||180.00||||||||||||检验目的|||||||||||||||||||
                for(OBR obr : obrList){
                    str.append("OBR|"+ obr.OBR_1 +"|||"+ obr.OBR_4 +"|"+ obr.OBR_5 +"||||||||||"+ obr.OBR_15_1 +"||||"+ obr.OBR_19 +"|||||||||||||||||||||||||||||||");
                    str.append(CARRIAGE_RETURN);
                }
        //DG1|1||K72.905^肝功能不全|||A
                for(DG1 dg1 : dg1List){
                    str.append("DG1|"+ dg1.DG1_1 +"||"+ dg1.DG1_3 +"|||"+ dg1.DG1_6);
                    str.append(CARRIAGE_RETURN);
                }
        return str.toString();
    }
}
