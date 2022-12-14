package com.healt.cloud.checkup.vo.busniess.packClinic;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-17 15:27
 * @description: TODO
 */
@Data
public class SaveHcPackSetDictListVo implements Serializable {

    private static final long serialVersionUID=1L;

    private List<SaveHcPackSetDictVo> saveHcPackSetDictList;

}
