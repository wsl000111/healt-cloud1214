package com.healt.cloud.checkup.vo.busniess.packClinic;

import com.healt.cloud.checkup.entity.HcPackVsClinic;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-16 15:32
 * @description: TODO
 */
@Data
public class SaveHcPackVsClincVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String stat;

    private List<HcPackVsClinic>  hcPackVsClinc;

}
