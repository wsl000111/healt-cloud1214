package com.healt.cloud.checkup.vo.sys.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-03-08 17:48
 * @description: TODO
 */
@Data
public class DictColumnsVoResult implements Serializable {

    private static final long serialVersionUID=1L;

    private String TABLE_NAME;

    private String COMMENTS;

    private String COLUMN_NAME;
}
