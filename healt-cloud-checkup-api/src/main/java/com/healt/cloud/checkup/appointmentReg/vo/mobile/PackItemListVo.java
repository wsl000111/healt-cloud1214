package com.healt.cloud.checkup.appointmentReg.vo.mobile;

import com.healt.cloud.common.pages.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-06-22 18:52
 * @description: TODO
 */
@Data
public class PackItemListVo extends PageRequest implements Serializable {

    private String hospitalId;

    private String classCode;

}
