package com.healt.cloud.checkup.physicalExa.vo;

import com.healt.cloud.common.pages.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-20 13:37
 */
@Data
public class PersonListDictVo extends PageRequest implements Serializable {

    private static final long serialVersionUID=1L;

    private String hospitalId;

    private String unitId;

    private String unitVisitId;

    private String personId;

    private String personVisitId;

    private String name;
}
