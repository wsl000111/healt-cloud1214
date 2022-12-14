package com.healt.cloud.checkup.vo.appointmentReg.changeVSItem;

import com.healt.cloud.checkup.entity.HcChangeVsItem;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-05-13 14:51
 */
@Data
public class SaveHcChangeVsItemVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String stat;

    private List<HcChangeVsItem> hcChangeVsItem;
}
