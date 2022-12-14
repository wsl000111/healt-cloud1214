package com.healt.cloud.checkup.vo.sys.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-03-09 13:10
 * @description: TODO
 */
@Data
public class DtDictVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String tableName;

    private String hospitalCode;

}
