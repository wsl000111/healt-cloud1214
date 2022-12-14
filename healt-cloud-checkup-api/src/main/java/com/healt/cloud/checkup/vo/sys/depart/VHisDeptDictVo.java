package com.healt.cloud.checkup.vo.sys.depart;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author GuYue
 * @since 2022-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("V_HIS_DEPT_DICT")
@ApiModel(value="VHisDeptDictVo对象", description="")
public class VHisDeptDictVo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("SERIAL_NO")
    @JsonProperty("SERIAL_NO")
    private Integer serialNo;

    @TableField("DEPT_CODE")
    @JsonProperty("DEPT_CODE")
    private String deptCode;

    @TableField("DEPT_NAME")
    @JsonProperty("DEPT_NAME")
    private String deptName;

    @TableField("DEPT_CODE")
    @JsonProperty("CODE")
    private String code;

    @TableField("DEPT_NAME")
    @JsonProperty("NAME")
    private String name;

    @TableField("HOSPITAL_ID")
    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @TableField("INPUT_CODE")
    @JsonProperty("INPUT_CODE")
    private String inputCode;

    @TableField("CLINIC_ATTR")
    @JsonProperty("CLINIC_ATTR")
    private Integer clinicAttr;

    @TableField("OUTP_OR_INP")
    @JsonProperty("OUTP_OR_INP")
    private Integer outpOrInp;

    @TableField("POSITION")
    @JsonProperty("POSITION")
    private String position;


}
