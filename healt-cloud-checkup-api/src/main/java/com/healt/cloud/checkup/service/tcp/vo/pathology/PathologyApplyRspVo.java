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
public class PathologyApplyRspVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "查询标记, 当 QPD-2 有值时必须填写相应 QPD-2 值")
    private String QAK_1;
    @ApiModelProperty(value = "匹配的记录总数")
    private String QAK_4;
    @ApiModelProperty(value = "本次回应中的记录数")
    private String QAK_5;
    @ApiModelProperty(value = "剩余记录总数")
    private String QAK_6;

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
    @ApiModelProperty(value = "电话号码")
    private String PID_13_1;
    @ApiModelProperty(value = "婚姻状况")
    private String PID_16;
    @ApiModelProperty(value = "身份证号")
    private String PID_19;
    @ApiModelProperty(value = "民族  ^汉族^1  GB3304-91")
    private String PID_22;

    private List<ITEM> itemList;
    @Data
    public class ITEM implements Serializable{
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

        @ApiModelProperty(value = "序号")
        private String OBR_1;
        @ApiModelProperty(value = "项目代码^项目名称")
        private String OBR_4;
        @ApiModelProperty(value = "优先级（紧急标志）")
        private String OBR_5;

        @ApiModelProperty(value = "序号")
        private String DG1_1;
        @ApiModelProperty(value = "临床诊断")
        private String DG1_3;
        @ApiModelProperty(value = "诊断类型")
        private String DG1_6;

        @ApiModelProperty(value = "序号")
        private String SPM_1;
        @ApiModelProperty(value = "标本流水号")
        private String SPM_2_1;
        @ApiModelProperty(value = "标本类型")
        private String SPM_4;
        @ApiModelProperty(value = "手术所见")
        private String SPM_5;
        @ApiModelProperty(value = "送检日期 ")
        private String SPM_6_1;
        @ApiModelProperty(value = "申请日期")
        private String SPM_6_2;
        @ApiModelProperty(value = "送检人编号")
        private String SPM_7_1;
        @ApiModelProperty(value = "送检人名称")
        private String SPM_7_2;
        @ApiModelProperty(value = "标本名称（送检材料）")
        private String SPM_14;
    }

    @ApiModelProperty(value = "试管条码")
    private String SAC_3;

    private static final char CARRIAGE_RETURN = 13;
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("QAK|"+QAK_1+"|||"+QAK_4+"|"+QAK_5+"|"+QAK_6)
                .append(CARRIAGE_RETURN);
        str.append("QPD|"+ QPD_1 +"|"+ QPD_2 +"|"+QPD_3_1+"^"+QPD_3_2+"^"+QPD_3_3+"^"+QPD_3_4+"^"+QPD_3_5+"^"+QPD_3_6+"^"+QPD_3_7)
                .append(CARRIAGE_RETURN)
                .append("PID||"+ PID_2 +"|||"+ PID_5 +"||"+ PID_7 +"|"+ PID_8 +"|||||"+PID_13_1+"||||||"+PID_19)
                .append(CARRIAGE_RETURN);
        for(ITEM item : itemList){
            str.append("PV1||"+ item.PV1_2 +"|"+ item.PV1_3_1 +"^^^||||"+ item.PV1_7 +"||||||||||||"+ item.PV1_19 +"||||||||||||||||||||"+ item.PV1_39 +"|||||"+ item.PV1_44 +"||||||")
            .append(CARRIAGE_RETURN)
            .append("ORC|"+ item.ORC_1 +"|"+ item.ORC_2 +"|||||||"+ item.ORC_9 +"|||"+ item.ORC_12 +"|||||||||"+ item.ORC_21 +"||||||||"+ item.ORC_29 +"|||"+item.ORC_32)
            .append(CARRIAGE_RETURN)
            .append("OBR|"+ item.OBR_1 +"|||"+ item.OBR_4 +"|"+ item.OBR_5 +"|||||||||||||||||||||||||||||||||||||||||||||")
            .append(CARRIAGE_RETURN)
            .append("DG1|"+ item.DG1_1 +"||"+ item.DG1_3 +"|||"+ item.DG1_6)
            .append(CARRIAGE_RETURN)
            //SPM|1|||1| 刮 出 子 宫 内 膜 组 织 5G, 出 血 少 |20220206000000^20220206000000|||||||| 子 宫 内 膜|||20220206000000^20220206000000
            .append("SPM|"+ item.SPM_1 +"|"+ item.SPM_2_1 +"||"+ item.SPM_4 +"|"+ item.SPM_5 +"|"+ item.SPM_6_1 +"^"+ item.SPM_6_2 +"|"+ item.SPM_7_1 +"^"+ item.SPM_7_2 +"|||||||"+ item.SPM_14+ "|||")
            .append(CARRIAGE_RETURN);
        }
        str.append("SAC|||"+SAC_3);
        str.append(CARRIAGE_RETURN);
        return str.toString();
    }
}
