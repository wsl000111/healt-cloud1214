package com.healt.cloud.checkup.vo.settlement.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-04-24 16:04
 */
@Data
public class SaveHcSettleListVo implements Serializable {

    private static final long serialVersionUID=1L;

    private List<SaveHcSettleVo> saveHcSettleList;
}
