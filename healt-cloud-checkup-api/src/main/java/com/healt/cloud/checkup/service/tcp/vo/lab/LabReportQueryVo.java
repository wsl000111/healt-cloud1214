package com.healt.cloud.checkup.service.tcp.vo.lab;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-07-19 15:57
 */
@Data
public class LabReportQueryVo implements Serializable {

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

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        //QPD|Z08^检验报告查询|Z0801|1^1008533000^2^20220101235249^20220121235249
        str.append("QPD|"+ QPD_1 +"|"+ QPD_2 +"|"+QPD_3_1+"^"+QPD_3_2+"^"+QPD_3_3+"^"+QPD_3_4+"^"+QPD_3_5);

        return str.toString();
    }
}
