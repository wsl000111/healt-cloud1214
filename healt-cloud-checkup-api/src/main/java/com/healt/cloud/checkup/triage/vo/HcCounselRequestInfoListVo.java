package com.healt.cloud.checkup.triage.vo;

import com.healt.cloud.checkup.entity.HcCounselRequestInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author linklee
 * @create 2022-06-19 11:19
 */
@Data
public class HcCounselRequestInfoListVo implements Serializable {

    private static final long serialVersionUID=1L;

    private List<HcCounselRequestInfo> hcCounselRequestInfo;
}
