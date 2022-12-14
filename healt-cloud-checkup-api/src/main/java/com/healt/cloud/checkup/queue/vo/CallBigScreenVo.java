package com.healt.cloud.checkup.queue.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-06-23 16:07
 */
@Data
public class CallBigScreenVo implements Serializable {

    private static final long serialVersionUID=1L;

    @JsonProperty("zzhj")
    private String zzhj;
}
