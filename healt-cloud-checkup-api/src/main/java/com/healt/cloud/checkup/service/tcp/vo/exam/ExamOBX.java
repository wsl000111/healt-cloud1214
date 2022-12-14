package com.healt.cloud.checkup.service.tcp.vo.exam;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-07-19 16:42
 */
@Data
public class ExamOBX implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "序号")
    private String OBX_1;
    @ApiModelProperty(value = "值类型")
    private String OBX_2;
    @ApiModelProperty(value = "检查所见")
    private String OBX_5_1;
    @ApiModelProperty(value = "检查结果")
    private String OBX_5_2;
    @ApiModelProperty(value = "异常标记")
    private String OBX_8;
    @ApiModelProperty(value = "检查结果状态（报告状态）")
    private String OBX_11;

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        //OBX|1|CWE|02760^妇彩-子宫||子宫形态正常，切面内径 4.4x3.2x3.8cm，肌壁回声均匀，未见局限性光
        //团，内膜线居中，厚度 0.6cm。\X0D0A\\X0D0A\ 双侧附件区未见异常回声。^子宫及附件未见异常
        //||www.weigao.com\123.jpg|N|||F||||||妇彩-子宫、附件
        str.append("OBX|"+ OBX_1 +"|"+ OBX_2 +"|||"+ OBX_5_1 +"^"+ OBX_5_2 +"|||"+ OBX_8 +"|||"+ OBX_11 +"||||||");
        return str.toString();
    }

}
