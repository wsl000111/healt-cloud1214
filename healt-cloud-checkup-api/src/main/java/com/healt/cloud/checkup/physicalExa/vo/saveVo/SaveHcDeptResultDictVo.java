package com.healt.cloud.checkup.physicalExa.vo.saveVo;

import com.healt.cloud.checkup.entity.HcDeptResultDict;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-05-23 11:31
 */
@Data
public class SaveHcDeptResultDictVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String stat;

    private Integer resStatus;

    private List<HcDeptResultDict> hcDeptResultDict;
}
