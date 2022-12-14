package com.healt.cloud.checkup.autoUpdate.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-06-09 13:33
 * @description: TODO
 */
@Data
public class SaveHealtUpdateParaListVo implements Serializable {

    List<SaveHealtUpdateParaVo> saveHealtUpdateParaList;

}
