package com.healt.cloud.checkup.appointmentReg.vo.beforeSignIn;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-05-23 19:03
 * @description: TODO
 */
@Data
public class CancelBeforeSignVo implements Serializable {

    private String personId;

    private String visitId;

    private String hospitalId;

    private String name;

}
