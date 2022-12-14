package com.healt.cloud.checkup.vo.member.vo;

import com.healt.cloud.checkup.entity.HcMemberInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-05-09 17:10
 */
@Data
public class SaveHcMemberInfoVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String stat;

    private String pay;

    private List<HcMemberInfo> hcMemberInfo;
}
