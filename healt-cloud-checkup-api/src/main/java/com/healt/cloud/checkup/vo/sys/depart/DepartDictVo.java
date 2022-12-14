package com.healt.cloud.checkup.vo.sys.depart;

import com.healt.cloud.checkup.entity.DepartDict;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-07 13:24
 * @description: TODO
 */
@Data
public class DepartDictVo implements Serializable {
    private static final long serialVersionUID=1L;

    private String stat;

    private List<DepartDict> departDict;
}
