package com.healt.cloud.checkup.vo.sys.user;

import com.healt.cloud.checkup.entity.UsersDict;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-07 15:55
 * @description: TODO
 */
@Data
public class UsersDictVo implements Serializable {
    private static final long serialVersionUID=1L;

    private String stat;

    private List<UsersDict> usersDict;
}
