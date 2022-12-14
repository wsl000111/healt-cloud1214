package com.healt.cloud.checkup.queue.vo;

import com.healt.cloud.checkup.entity.HcIntervalRecord;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-06-16 17:32
 */
@Data
public class SaveIntervalRecordVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String stat;

    private List<HcIntervalRecord> hcIntervalRecord;
}
