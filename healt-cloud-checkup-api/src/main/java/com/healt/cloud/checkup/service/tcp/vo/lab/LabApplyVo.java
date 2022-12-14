package com.healt.cloud.checkup.service.tcp.vo.lab;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-07-18 14:36
 */
@Data
public class LabApplyVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "患者 ID")
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
    public class OBR implements Serializable{
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

    @ApiModelProperty(value = "序号")
    private String DG1_1;
    @ApiModelProperty(value = "临床诊断")
    private String DG1_3;
    @ApiModelProperty(value = "诊断类型")
    private String DG1_6;

    private static final char CARRIAGE_RETURN = 13;
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("PID||"+ PID_2 +"|||"+ PID_5 +"||"+ PID_7 +"|"+ PID_8 +"||||||||||||||")
                .append(CARRIAGE_RETURN)
                .append("PV1||"+ PV1_2 +"|"+ PV1_3_1 +"^^^||||"+ PV1_7 +"||||||||||||"+ PV1_19 +"||||||||||||||||||||"+ PV1_39 +"|||||"+ PV1_44 +"||||||")
                .append(CARRIAGE_RETURN)
                .append("ORC|"+ ORC_1 +"|"+ ORC_2 +"|||||||"+ ORC_9 +"|||"+ ORC_12 +"|||||||||"+ ORC_21 +"||||||||"+ ORC_29 +"|||"+ ORC_32)
                .append(CARRIAGE_RETURN);
                for(OBR obr : obrList){
                    str.append("OBR|"+ obr.OBR_1 +"|||"+ obr.OBR_4 +"|"+ obr.OBR_5 +"||||||||||"+ obr.OBR_15_1 +"||||"+ obr.OBR_19 +"|||||||||||||||||||||||||||||||");
                    str.append(CARRIAGE_RETURN);
                }
                str.append("DG1|"+ DG1_1 +"||"+ DG1_3 +"|||"+ DG1_6);
                str.append(CARRIAGE_RETURN);
        return str.toString();
    }
}
