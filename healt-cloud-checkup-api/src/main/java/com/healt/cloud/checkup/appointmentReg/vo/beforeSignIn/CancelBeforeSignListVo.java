package com.healt.cloud.checkup.appointmentReg.vo.beforeSignIn;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-05-23 19:06
 * @description: TODO
 */
@Data
public class CancelBeforeSignListVo implements Serializable {

    private List<CancelBeforeSignVo> cancelBeforeSignList;
}
