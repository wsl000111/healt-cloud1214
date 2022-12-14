package com.healt.cloud.checkup.vo.member;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-09 14:58
 */
@Data
public class UserListVo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("USER_ID")
    @JsonProperty("USER_ID")
    private String userId;

    @TableField("USER_NAME")
    @JsonProperty("USER_NAME")
    private String userName;
}
