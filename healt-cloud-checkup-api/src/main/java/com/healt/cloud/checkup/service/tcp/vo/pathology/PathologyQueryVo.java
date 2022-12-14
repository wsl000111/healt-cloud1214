package com.healt.cloud.checkup.service.tcp.vo.pathology;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-07-27 16:15
 */
@Data
public class PathologyQueryVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "查询消息名称")
    private String QPD_1;
    @ApiModelProperty(value = "查询标记")
    private String QPD_2;
    @ApiModelProperty(value = "患者类别")
    private String QPD_3_1;
    @ApiModelProperty(value = "患者 ID")
    private String QPD_3_2;
    @ApiModelProperty(value = "就诊次数")
    private String QPD_3_3;
    @ApiModelProperty(value = "申请时间开始时间")
    private String QPD_3_4;
    @ApiModelProperty(value = "申请时间结束时间")
    private String QPD_3_5;

    private static final char CARRIAGE_RETURN = 13;
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        //QPD|Z15^查询检查报告|Z1602|02D609270684069
        str.append("QPD|"+ QPD_1 +"|"+ QPD_2 +"|"+ QPD_3_1 +"^"+ QPD_3_2 +"^"+ QPD_3_3 +"^"+ QPD_3_4 +"^"+ QPD_3_5 +"^");
        str.append(CARRIAGE_RETURN);
        return str.toString();
    }
}
