package com.healt.cloud.checkup.queue.vo;

import com.healt.cloud.checkup.entity.HcRoomQueue;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-06-16 15:29
 */
@Data
public class SaveRoomQueueVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String stat;

    private List<HcRoomQueue> hcRoomQueue;
}
