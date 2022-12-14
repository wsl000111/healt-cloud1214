package com.healt.cloud.checkup.sysDict.vo;

import com.healt.cloud.checkup.entity.UserRightModels;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-05-28 9:21
 */
@Data
public class SaveUserRightModelsVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String stat;

    private List<UserRightModels> userRightModels;
}
