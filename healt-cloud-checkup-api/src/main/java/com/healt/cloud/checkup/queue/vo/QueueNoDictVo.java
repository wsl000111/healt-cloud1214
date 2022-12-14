package com.healt.cloud.checkup.queue.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-06-16 16:45
 */
@Data
public class QueueNoDictVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String queueLevel;
    private String queueDate;
    private String hcDeptCode;
    private String roomCode;
    private String hospitalId;
    //private List<HcQueueCode> hcQueueCode;
}
