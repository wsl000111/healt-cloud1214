package com.healt.cloud.checkup.autoUpdate.vo;

import com.healt.cloud.checkup.entity.HealtUpdateLog;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-06-10 14:10
 * @description: TODO
 */
@Data
public class HealtUpdateLogListVo implements Serializable {
    private List<HealtUpdateLog> healtUpdateLogList;
}
