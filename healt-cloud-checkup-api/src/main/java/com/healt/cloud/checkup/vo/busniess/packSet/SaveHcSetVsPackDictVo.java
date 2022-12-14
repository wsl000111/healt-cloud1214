package com.healt.cloud.checkup.vo.busniess.packSet;

import com.healt.cloud.checkup.entity.HcSetVsPackDict;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-17 10:43
 * @description: TODO
 */
@Data
public class SaveHcSetVsPackDictVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String stat;

    private List<HcSetVsPackDict> hcSetVsPackDict;

}
