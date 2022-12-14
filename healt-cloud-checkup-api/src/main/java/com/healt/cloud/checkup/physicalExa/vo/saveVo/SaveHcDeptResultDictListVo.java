package com.healt.cloud.checkup.physicalExa.vo.saveVo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-05-23 11:30
 */
@Data
public class SaveHcDeptResultDictListVo implements Serializable {

    private static final long serialVersionUID=1L;

    private List<SaveHcDeptResultDictVo> saveHcDeptResultDict;
}
