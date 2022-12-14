package com.healt.cloud.checkup.service.tcp.vo.lab;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-07-18 17:00
 */
@Data
public class LabQueryVo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "查询消息名称")
    private String QPD_1;
    @ApiModelProperty(value = "查询标记")
    private String QPD_2;
    @ApiModelProperty(value = "就诊次数")
    private String QPD_3_3;

    private static final char CARRIAGE_RETURN = 13;
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        //QPD|Z06^检验申请查询|Z0601|1^1008533000^2^3117&检验科^20220101235249^20220121235249^1^
        str.append("QPD|"+ QPD_1 +"|"+ QPD_2 +"|^^"+ QPD_3_3 +"^^^^^")
        .append(CARRIAGE_RETURN);
        return str.toString();
    }
}
