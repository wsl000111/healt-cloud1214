package com.healt.cloud.checkup.vo.sys.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-03-09 16:36
 * @description: TODO
 */
@Data
public class CommonTableColumnsDataVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String stat;

    private String tableColumnsData;

}
