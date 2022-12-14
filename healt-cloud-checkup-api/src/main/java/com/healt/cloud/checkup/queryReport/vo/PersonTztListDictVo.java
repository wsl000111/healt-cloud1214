package com.healt.cloud.checkup.queryReport.vo;

import com.healt.cloud.common.pages.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-26 16:56
 */
@Data
public class PersonTztListDictVo extends PageRequest implements Serializable {

    private static final long serialVersionUID=1L;

    private String unitId;

    private String unitVisitId;

    private String tzt;
}
