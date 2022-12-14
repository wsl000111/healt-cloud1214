package com.healt.cloud.checkup.vo.sys.role;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-03-08 13:57
 * @description: TODO
 */
@Data
public class RoleMenuVoResult implements Serializable {
    private static final long serialVersionUID=1L;

    private String MENU_CODE;

    private String DISPLAY_TEXT;

    private String PARENT_MENU_CODE;

}
