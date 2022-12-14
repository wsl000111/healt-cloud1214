package com.healt.cloud.checkup.vo.settlement;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liyongfei
 * @date 2022-09-03 13:24
 */
@Data
public class PersonsInfoDictVo implements Serializable {

    @JsonProperty("HOSPITAL_ID")
    private String hospitalId;

    @JsonProperty("UNIT_ID")
    private String unitId;

    @JsonProperty("BEGIN_DATE")
    private String beginDate;

    @JsonProperty("END_DATE")
    private String endDate;

}
