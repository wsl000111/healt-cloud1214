package com.healt.cloud.checkup.service.tcp.vo.pathology;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-07-27 17:17
 */
@Data
public class PathologyQueryRspVo implements Serializable {

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
    @ApiModelProperty(value = "申请单号")
    private String QPD_3_7;

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
        @ApiModelProperty(value = "项目代码^项目名称")
        private String OBR_4;
        @ApiModelProperty(value = "优先级（紧急标志）")
        private String OBR_5;
    }

    private List<OBX> obxList;
    @Data
    public static class OBX implements Serializable{
        @ApiModelProperty(value = "序号")
        private String OBX_1;
        @ApiModelProperty(value = "值类型")
        private String OBX_2;
        @ApiModelProperty(value = "项目代码^项目名称")
        private String OBX_3;
        @ApiModelProperty(value = "检查所见")
        private String OBX_5_1;
        @ApiModelProperty(value = "检查结果")
        private String OBX_5_2;
        @ApiModelProperty(value = "检查结果状态（报告状态）")
        private String OBX_11;
    }

    private static final char CARRIAGE_RETURN = 13;
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("QPD|"+ QPD_1 +"|"+ QPD_2 +"|"+QPD_3_1+"^"+QPD_3_2+"^"+QPD_3_3+"^"+QPD_3_4+"^"+QPD_3_5+"^"+QPD_3_6+"^"+QPD_3_7)
                .append(CARRIAGE_RETURN)
                .append("PID||"+ PID_2 +"|||"+ PID_5 +"||"+ PID_7 +"|"+ PID_8 +"|||")
                .append(CARRIAGE_RETURN)
                .append("PV1||"+ PV1_2 +"|"+ PV1_3_1 +"^^^||||"+ PV1_7 +"||||||||||||"+ PV1_19 +"||||||||||||||||||||"+ PV1_39 +"|||||"+ PV1_44 +"||||||")
                .append(CARRIAGE_RETURN)
                .append("ORC|"+ ORC_1 +"|"+ ORC_2 +"|||||||"+ ORC_9 +"|||"+ ORC_12 +"|||||||||"+ ORC_21 +"||||||||"+ ORC_29 +"|||"+ORC_32)
                .append(CARRIAGE_RETURN);
                for(OBR obr : obrList){
                    str.append("OBR|"+ obr.OBR_1 +"|||"+ obr.OBR_4 +"|"+ obr.OBR_5 +"|||||||||||||||||||||||||||||||||||||||||||||");
                    str.append(CARRIAGE_RETURN);
                }
                for(OBX obx : obxList){
                    str.append("OBX|"+ obx.OBX_1 +"|"+ obx.OBX_2 +"|"+ obx.OBX_3 +"||"+ obx.OBX_5_1 +"^"+ obx.OBX_5_2 +"||||||"+ obx.OBX_11 +"||||||");
                    str.append(CARRIAGE_RETURN);
                }
        return str.toString();
    }
}
