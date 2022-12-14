package com.healt.cloud.checkup.appointmentReg.vo.beforeSignIn;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-05-05 15:04
 * @description: TODO
 */
@Data
public class SaveBeforeSignInListVo implements Serializable {

    private List<UpdateHcPersonVistInfoVo> updateHcPersonVistInfo;

}

