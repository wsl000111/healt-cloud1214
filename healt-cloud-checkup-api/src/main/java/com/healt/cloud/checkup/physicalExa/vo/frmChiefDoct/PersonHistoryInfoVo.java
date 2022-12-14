package com.healt.cloud.checkup.physicalExa.vo.frmChiefDoct;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-06-02 11:11
 * @description: TODO
 */
@Data
public class PersonHistoryInfoVo implements Serializable {
    private String person_id;

    private String name;

    private String sex;

    private String unit_name;

    private String unit_id;

    private String person_visit_id;

    private String unit_visit_id;

    private String age;

    private String marital_status;

    private String before_date;

    private String appoints_date;

    private String result_status;
}
