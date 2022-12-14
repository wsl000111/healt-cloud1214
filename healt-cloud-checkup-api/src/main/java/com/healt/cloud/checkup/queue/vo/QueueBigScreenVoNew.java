package com.healt.cloud.checkup.queue.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-08-12 14:43
 * @description: TODO
 */
@Data
public class QueueBigScreenVoNew implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("ROOM_CODE")
    @JsonProperty("ROOM_CODE")
    private String roomCode;


    @TableField("QUEUE_NAME")
    @JsonProperty("QUEUE_NAME")
    private String queueName;

    @JsonProperty("xhname")
    private String xhname;

    @JsonProperty("QUEUE_NO")
    private String queueNo;
}
