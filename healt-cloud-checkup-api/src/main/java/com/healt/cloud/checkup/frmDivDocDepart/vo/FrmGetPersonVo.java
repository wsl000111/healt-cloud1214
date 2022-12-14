package com.healt.cloud.checkup.frmDivDocDepart.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.healt.cloud.common.pages.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-05-24 9:24
 * @description: TODO
 */
@Data
public class FrmGetPersonVo extends PageRequest implements Serializable {

    /// <param name="stype">查询类型 1报道 2预约  完成状态：3本人完成的和体检科室查询4按体检号和体检次数查本次体检</param>
    /// <param name="begin_Date">起始日期</param>
    /// <param name="end_Date">结束日期</param>
    /// <param name="person_id">体检号</param>
    /// <param name="person_visit_id">体检次数</param>
    /// <param name="dept_id">体检科室</param>
    /// <param name="operater">操作员</param>

    @JsonProperty("HospitalCode")
    private String hospitalId;

    @JsonProperty("stype")
    private String stype;

    @JsonProperty("begin_Date")
    private String beginDate;

    @JsonProperty("end_Date")
    private String endDate;

    @JsonProperty("person_id")
    private String personId;

    @JsonProperty("person_visit_id")
    private String personVisitId;

    @JsonProperty("dept_id")
    private String deptId;

    @JsonProperty("operater")
    private String operater;
}
