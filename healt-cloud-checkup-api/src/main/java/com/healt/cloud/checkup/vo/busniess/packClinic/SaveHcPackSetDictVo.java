package com.healt.cloud.checkup.vo.busniess.packClinic;

import com.healt.cloud.checkup.entity.HcPackSetDict;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-17 15:32
 * @description: TODO
 */
@Data
public class SaveHcPackSetDictVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String stat;

    private List<HcPackSetDict> hcPackSetDict;
}
