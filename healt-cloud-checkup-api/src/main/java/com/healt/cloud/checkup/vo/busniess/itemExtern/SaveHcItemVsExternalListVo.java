package com.healt.cloud.checkup.vo.busniess.itemExtern;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-18 15:44
 * @description: TODO
 */
@Data
public class SaveHcItemVsExternalListVo implements Serializable {

    private static final long serialVersionUID=1L;

    private List<SaveHcItemVsExternalVo> saveHcItemVsExternalList;
}
