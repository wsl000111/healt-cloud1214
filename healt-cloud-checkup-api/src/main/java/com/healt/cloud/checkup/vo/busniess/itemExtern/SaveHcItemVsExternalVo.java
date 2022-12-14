package com.healt.cloud.checkup.vo.busniess.itemExtern;

import com.healt.cloud.checkup.entity.HcItemVsExternal;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-18 15:47
 * @description: TODO
 */
@Data
public class SaveHcItemVsExternalVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String stat;

    private List<HcItemVsExternal> hcItemVsExternal;

}
