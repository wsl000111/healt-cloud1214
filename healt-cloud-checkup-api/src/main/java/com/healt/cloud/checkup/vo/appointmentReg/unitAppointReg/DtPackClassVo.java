package com.healt.cloud.checkup.vo.appointmentReg.unitAppointReg;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-04-15 12:45
 * @description: TODO
 */
@Data
public class DtPackClassVo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("CLASS_CODE")
    @JsonProperty("CLASS_CODE")
    private String classCode;

    @TableField("CLASS_NAME")
    @JsonProperty("CLASS_NAME")
    private String className;

}
