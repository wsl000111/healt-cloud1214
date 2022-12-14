package com.healt.cloud.checkup.vo.member.vo;

import com.healt.cloud.checkup.entity.CommonDict;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-05-12 16:16
 */
@Data
public class SaveCommonDictVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String stat;

    private List<CommonDict> commonDict;
}
