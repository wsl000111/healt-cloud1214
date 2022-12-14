package com.healt.cloud.checkup.vo.sys.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-09 15:44
 * @description: TODO
 */
@Data
public class SaveCommonTableVo  implements Serializable {

    private static final long serialVersionUID=1L;

    private String commonTableName;

    private List<CommonTableColumnsVo> commonTableColumns;

    private List<CommonTableColumnsDataVo> commonTableColumnsData;
}
