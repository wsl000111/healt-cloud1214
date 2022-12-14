package com.healt.cloud.checkup.vo.appointmentReg.changeVSItem;

import com.healt.cloud.common.pages.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-18 9:45
 */
@Data
public class ChangeVSItemVo extends PageRequest implements Serializable {

    private static final long serialVersionUID=1L;

    private String hospitalCode;

}
