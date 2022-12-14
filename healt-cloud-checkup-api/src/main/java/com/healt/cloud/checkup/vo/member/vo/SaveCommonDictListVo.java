package com.healt.cloud.checkup.vo.member.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-05-12 16:15
 */
@Data
public class SaveCommonDictListVo implements Serializable {

    private static final long serialVersionUID=1L;

    List<SaveCommonDictVo> saveCommonDictList;
}
