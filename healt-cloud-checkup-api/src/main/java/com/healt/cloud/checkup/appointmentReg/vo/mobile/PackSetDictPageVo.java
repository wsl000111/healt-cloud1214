package com.healt.cloud.checkup.appointmentReg.vo.mobile;

import com.healt.cloud.common.pages.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-06-22 14:39
 * @description: TODO
 */
@Data
public class PackSetDictPageVo extends PageRequest implements Serializable {

    private String hospitalId;

}
