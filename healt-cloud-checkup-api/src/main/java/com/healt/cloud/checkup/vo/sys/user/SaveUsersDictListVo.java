package com.healt.cloud.checkup.vo.sys.user;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-07 15:54
 * @description: TODO
 */
@Data
public class SaveUsersDictListVo implements Serializable {
    private static final long serialVersionUID=1L;

    private List<UsersDictVo> usersDictList;
}
