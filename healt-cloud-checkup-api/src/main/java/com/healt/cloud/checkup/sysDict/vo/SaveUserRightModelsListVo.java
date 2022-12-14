package com.healt.cloud.checkup.sysDict.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-05-28 9:20
 */
@Data
public class SaveUserRightModelsListVo implements Serializable {

    private static final long serialVersionUID=1L;

    private List<SaveUserRightModelsVo> saveUserRightModels;
}
