package com.healt.cloud.checkup.vo.appointmentReg.unitPersons;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-04-02 15:34
 */
@Data
public class DtAreaVo implements Serializable{

    private static final long serialVersionUID=1L;

    @TableField("CODE")
    @JsonProperty("CODE")
    private String code;

    @TableField("NAME")
    @JsonProperty("NAME")
    private String name;

    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;
}
