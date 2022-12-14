package com.healt.cloud.checkup.queryReport.vo;

import com.healt.cloud.common.pages.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-26 14:02
 */
@Data
public class StrWherePageVo extends PageRequest implements Serializable {

    private static final long serialVersionUID=1L;

    private String strWhere;
}
