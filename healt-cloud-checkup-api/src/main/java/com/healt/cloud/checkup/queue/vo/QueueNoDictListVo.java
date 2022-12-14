package com.healt.cloud.checkup.queue.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-06-19 11:35
 */
@Data
public class QueueNoDictListVo implements Serializable {

    private static final long serialVersionUID=1L;

    private List<QueueNoDictVo> queueNoDictVo;
}
