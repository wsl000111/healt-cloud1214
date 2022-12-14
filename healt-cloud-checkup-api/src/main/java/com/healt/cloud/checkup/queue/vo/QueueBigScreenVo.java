package com.healt.cloud.checkup.queue.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-06-23 15:34
 */
@Data
public class QueueBigScreenVo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("QUEUE_NAME")
    @JsonProperty("QUEUE_NAME")
    private String queueName;

    @JsonProperty("Firstlist")
    private String Firstlist;
}
