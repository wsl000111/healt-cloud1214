package com.healt.cloud.checkup.autoUpdate.vo;

import com.healt.cloud.checkup.entity.HealtUpdatePara;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-06-09 13:32
 * @description: TODO
 */
@Data
public class SaveHealtUpdateParaVo implements Serializable {

    private String stat;

    private List<HealtUpdatePara> healtUpdateParaList;

}
