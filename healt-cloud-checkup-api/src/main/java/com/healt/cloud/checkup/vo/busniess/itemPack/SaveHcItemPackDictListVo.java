package com.healt.cloud.checkup.vo.busniess.itemPack;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-15 13:40
 * @description: TODO
 */
@Data
public class SaveHcItemPackDictListVo implements Serializable {

    private static final long serialVersionUID=1L;

    List<SaveHcItemPackDicVo> saveHcItemPackDictList;
}
