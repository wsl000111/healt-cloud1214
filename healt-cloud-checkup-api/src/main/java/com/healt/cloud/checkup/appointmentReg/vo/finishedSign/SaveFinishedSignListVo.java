package com.healt.cloud.checkup.appointmentReg.vo.finishedSign;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-05-20 16:32
 * @description: TODO
 */
@Data
public class SaveFinishedSignListVo implements Serializable {

    public List<UpdateHcPersonVistInfoFinishedVo> updateHcPersonVistInfoFinished;

}
