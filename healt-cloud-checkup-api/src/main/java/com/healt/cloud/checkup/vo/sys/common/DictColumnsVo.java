package com.healt.cloud.checkup.vo.sys.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-03-08 17:49
 * @description: TODO
 */
@Data
public class DictColumnsVo implements Serializable {
    private static final long serialVersionUID=1L;

    private String dictUser;

    private String tableName;

}
