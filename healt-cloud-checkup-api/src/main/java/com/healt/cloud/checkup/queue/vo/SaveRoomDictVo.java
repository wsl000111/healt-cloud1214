package com.healt.cloud.checkup.queue.vo;

import com.healt.cloud.checkup.entity.HcRoomDict;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-06-16 16:22
 */
@Data
public class SaveRoomDictVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String stat;

    private List<HcRoomDict> hcRoomDict;
}
