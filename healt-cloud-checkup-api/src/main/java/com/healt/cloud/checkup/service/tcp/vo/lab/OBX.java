package com.healt.cloud.checkup.service.tcp.vo.lab;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-07-19 16:42
 */
@Data
public class OBX implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "序号")
    private String OBX_1;
    @ApiModelProperty(value = "值类型")
    private String OBX_2;
    @ApiModelProperty(value = "项目结果")
    private String OBX_5_1;
    @ApiModelProperty(value = "项目英文名称")
    private String OBX_5_2;
    @ApiModelProperty(value = "参考范围")
    private String OBX_7;
    @ApiModelProperty(value = "结果日期")
    private String OBX_14;
    @ApiModelProperty(value = "项目观测方法")
    private String OBX_17;

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        //OBX|1|CWE|30281^白细胞||10.7^WBC|10\S\CCU/ml|3.5-9.5|↑||||||20220224151646||101751\S\蒋婧婧|N||||||||
        str.append("OBX|"+ OBX_1 +"|"+ OBX_2 +"|||"+ OBX_5_1 +"^"+ OBX_5_2 +"||"+ OBX_7 +"|||||||"+ OBX_14 +"|||"+ OBX_17 +"||||||||");
        return str.toString();
    }

}
