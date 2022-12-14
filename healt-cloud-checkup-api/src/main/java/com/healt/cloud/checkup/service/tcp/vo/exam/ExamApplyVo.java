package com.healt.cloud.checkup.service.tcp.vo.exam;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-07-18 10:24
 * @description: TODO
 */
@Getter
@Setter
public class ExamApplyVo {

    private static final char CARRIAGE_RETURN = 13;
//    PID||201532012|652101198612221332^^^^01||马志明^^^MA ZHI MING||19861222000000|1|||&华容文化路 179 号^华容^岳阳^湖南|||||^^2|||652101198612221332|||^汉族^1
    private String PID_2;    //患者 ID
    private String PID_5;    //患者姓名
    private String PID_7;    //出生日期
    private String PID_8;    //性别 参见 GB2261-80
    private String PID_13_1;
    private String PID_19;

    private String PV1_2;   // 患者类别
    private String PV1_3_1; // 科室
    private String PV1_7;   // 就诊医生
    private String PV1_19;  // 就诊次数
    private String PV1_39;  // 院区编码
    private String PV1_44;  // 就诊时间

    private String ORC_1;  //医嘱控制码
    private String ORC_2;  //医技申请单号^^医嘱号
    private String ORC_9;  //申请时间
    private String ORC_12; //申请医生
    private String ORC_21; //申请科室^^科室编码
    private String ORC_29; //医嘱类型 参见 YB0056
    private String ORC_32; //执行科室^^科室编码

    private List<ORB> orbList;


    public class ORB{
        private String ORB_1;   //序号, 从 1 开始，顺序增加
        private String ORB_4;   //诊疗项目代码^诊疗项目名称
        private String ORB_5;   //紧急标志 1 急 0 普通
        private String ORB_15_4;//检查部位代码&检查部位名称 参见 YB0083
        private String ORB_19;  //项目金额

        public String getORB_1() {
            return ORB_1;
        }

        public void setORB_1(String ORB_1) {
            this.ORB_1 = ORB_1;
        }

        public String getORB_4() {
            return ORB_4;
        }

        public void setORB_4(String ORB_4) {
            this.ORB_4 = ORB_4;
        }

        public String getORB_5() {
            return ORB_5;
        }

        public void setORB_5(String ORB_5) {
            this.ORB_5 = ORB_5;
        }

        public String getORB_15_4() {
            return ORB_15_4;
        }

        public void setORB_15_4(String ORB_15_4) {
            this.ORB_15_4 = ORB_15_4;
        }

        public String getORB_19() {
            return ORB_19;
        }

        public void setORB_19(String ORB_19) {
            this.ORB_19 = ORB_19;
        }
    }

    private String DG1_1;   //序号
    private String DG1_3;   //临床诊断
    private String DG1_6;   //诊断类型 默认值 1

//    PID||201532012|652101198612221332^^^^01||马志明^^^MA ZHI MING||19861222000000|1|||&华容文化路 179 号^华容^岳阳^湖南|||||^^2|||652101198612221332|||^汉族^1
//    PV1||1|101022101||||123123||||||0||||||2||||||||||||||||||||H0002|||||20220126094730
//    ORC|NW|01D2018050800001|||||||20210918135813|||101275^ 张 大 大 ||||||||| 产 科 病 区^^1300110||||||20210920183000||D|||放射科^^1801010
//    OBR|1|||0517100247^右膝关节 MRI(平扫)|0||||||||双膝关节隐痛 2 年,双膝关节运动疼痛，爬山及爬楼梯等活动受限，平路行走尚可，,双膝无明显肿胀，无明显压痛|||||1|574.00||||||1
//    DG1|1||QTZ221^虚眩|||1
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("PID||"+PID_2+"|||"+PID_5+"||"+ PID_7 +"|"+PID_8+"|||||"+PID_13_1+"||||||"+PID_19+"|||");
        sb.append(CARRIAGE_RETURN);
        sb.append("PV1||"+PV1_2+"|"+PV1_3_1+"||||"+PV1_7+"||||||||||||"+PV1_19+"||||||||||||||||||||"+PV1_39+"|||||"+PV1_44);
        sb.append(CARRIAGE_RETURN);
        sb.append("ORC|"+ORC_1+"|"+ORC_2+"|||||||"+ORC_9+"|||"+ORC_12+"|||||||||"+ORC_21+"||||||||"+ORC_29+"|||"+ORC_32);
        sb.append(CARRIAGE_RETURN);
        for(ORB orb : orbList){
            sb.append("OBR|"+orb.ORB_1+"|||"+orb.ORB_4+"|"+orb.ORB_5+"||||||||||"+orb.ORB_15_4+"||||"+orb.ORB_19+"||||||");
            sb.append(CARRIAGE_RETURN);
        }
        sb.append("DG1|"+DG1_1+"||"+DG1_3+"|||"+DG1_6);
        sb.append(CARRIAGE_RETURN);
        return sb.toString();
    }

}
