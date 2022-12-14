package com.healt.cloud.checkup.vo.busniess.itemPack;

import com.healt.cloud.common.pages.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-03-14 9:19
 * @description: TODO
 */
@Data
public class HcItemPackDictVo extends PageRequest implements Serializable{

    private static final long serialVersionUID=1L;

    private String hospitalId;

    private String deptClass;

    private String deptId;

    private String columnName;

    private String columnValue;
}
