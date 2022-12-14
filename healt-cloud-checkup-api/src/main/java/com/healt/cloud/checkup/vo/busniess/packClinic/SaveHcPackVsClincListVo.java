package com.healt.cloud.checkup.vo.busniess.packClinic;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-16 15:31
 * @description: TODO
 */
@Data
public class SaveHcPackVsClincListVo implements Serializable {

    private static final long serialVersionUID=1L;

    private List<SaveHcPackVsClincVo> saveHcPackVsClincList;

}
