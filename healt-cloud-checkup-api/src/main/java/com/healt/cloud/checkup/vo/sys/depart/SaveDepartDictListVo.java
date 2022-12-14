package com.healt.cloud.checkup.vo.sys.depart;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-06 15:34
 * @description: TODO
 */
@Data
public class SaveDepartDictListVo implements Serializable {
    private static final long serialVersionUID=1L;

    private List<DepartDictVo> departDictList;

}
