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
public class PathologyApplyRspVo_old implements Serializable {

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
        @ApiModelProperty(value = "项目代码^项目名称")
        private String OBR_4;
        @ApiModelProperty(value = "优先级（紧急标志）")
        private String OBR_5;
    }

    private List<DG1> dg1List;
    @Data
    public class DG1 implements Serializable{
        @ApiModelProperty(value = "序号")
        private String DG1_1;
        @ApiModelProperty(value = "临床诊断")
        private String DG1_3;
        @ApiModelProperty(value = "诊断类型")
        private String DG1_6;
    }

    private List<SPM> spmList;
    @Data
    public class SPM implements Serializable{
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
        for(DG1 dg1 : dg1List){
            str.append("DG1|"+ dg1.DG1_1 +"||"+ dg1.DG1_3 +"|||"+ dg1.DG1_6);
            str.append(CARRIAGE_RETURN);
        }
        for(SPM spm : spmList){
            //SPM|1|||1| 刮 出 子 宫 内 膜 组 织 5G, 出 血 少 |20220206000000^20220206000000|||||||| 子 宫 内 膜|||20220206000000^20220206000000
            str.append("SPM|"+ spm.SPM_1 +"|"+ spm.SPM_2_1 +"||"+ spm.SPM_4 +"|"+ spm.SPM_5 +"|"+ spm.SPM_6_1 +"^"+ spm.SPM_6_2 +"|"+ spm.SPM_7_1 +"^"+ spm.SPM_7_2 +"|||||||"+ spm.SPM_14+ "|||");
            str.append(CARRIAGE_RETURN);
        }
        str.append("SAC|||"+SAC_3);
        str.append(CARRIAGE_RETURN);
        return str.toString();
    }
}
