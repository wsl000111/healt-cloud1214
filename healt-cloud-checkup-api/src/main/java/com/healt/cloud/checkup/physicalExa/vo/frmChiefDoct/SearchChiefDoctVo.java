package com.healt.cloud.checkup.physicalExa.vo.frmChiefDoct;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.healt.cloud.common.pages.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-06-01 9:50
 * @description: TODO
 */
@Data
public class SearchChiefDoctVo extends PageRequest implements Serializable {

    private String hospitalId;

    private String tresult_status;

    private String tbegindate;

    private String tenddate;

    private String resultStatus; // 检查状态 RESULT_STATUS = 0-已预约 1-已执行2-待审核 7-已初审 9-已终审 的过滤，空 不参与过滤

    private String printFlag; // 打印状态的过滤，空不参与过滤 ，未打印是 print_date is null ,已打印 是print_date is not null

    private String personId;  // 只用personId与visitId过滤

    private String visitId; //体检次数

}
