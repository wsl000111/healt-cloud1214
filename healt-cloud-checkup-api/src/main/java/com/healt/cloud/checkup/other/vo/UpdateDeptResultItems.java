package com.healt.cloud.checkup.other.vo;

import lombok.Data;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-08-30 12:52
 * @description: TODO
 */
@Data
public class UpdateDeptResultItems implements Serializable {

    private String hospitalId;
    private String personId;
    private String personVisitId;
    private String contentClass;
    private String content;
}
