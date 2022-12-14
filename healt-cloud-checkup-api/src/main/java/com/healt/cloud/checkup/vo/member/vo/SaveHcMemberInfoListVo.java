package com.healt.cloud.checkup.vo.member.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-05-09 17:05
 */
@Data
public class SaveHcMemberInfoListVo implements Serializable {

    private static final long serialVersionUID=1L;

    private List<SaveHcMemberInfoVo> saveHcMemberInfoList;
}
