package com.healt.cloud.checkup.queue.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-06-16 15:29
 */
@Data
public class SaveRoomQueueListVo implements Serializable {

    private static final long serialVersionUID=1L;

    private List<SaveRoomQueueVo> saveRoomQueue;
}
