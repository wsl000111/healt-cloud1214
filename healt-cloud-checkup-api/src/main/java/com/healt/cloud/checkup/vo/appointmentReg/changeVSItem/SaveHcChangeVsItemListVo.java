package com.healt.cloud.checkup.vo.appointmentReg.changeVSItem;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-05-13 14:49
 */
@Data
public class SaveHcChangeVsItemListVo implements Serializable {

    private static final long serialVersionUID=1L;

    private List<SaveHcChangeVsItemVo> saveHcChangeVsItem;
}
