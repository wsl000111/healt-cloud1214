package com.healt.cloud.pdf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GuYue
 * @date 2022-09-16 15:49
 * @description: TODO
 */
@Data
public class PersonReportListResVo implements Serializable {

    @ApiModelProperty(value = "人员编号")
    private String personId;

    private String name;

    private String idNo;

    @ApiModelProperty(value = "插入日期")
    private String insertDate;

    @ApiModelProperty(value = "体检次数")
    private String personVisitId;

    @ApiModelProperty(value = "检前签到时间")
    private String beforeDate;

    @ApiModelProperty(value = "体检类型")
    private String personType;
}
