package com.healt.cloud.checkup.queue.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-06-18 17:13
 */
@Data
public class IntervalRecordDictVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String beginTime;
    private String roomCode;
    private String hospitalId;
}
