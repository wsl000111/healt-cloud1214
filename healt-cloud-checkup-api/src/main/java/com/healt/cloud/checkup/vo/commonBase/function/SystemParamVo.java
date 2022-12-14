package com.healt.cloud.checkup.vo.commonBase.function;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-03-28 15:01
 * @description: TODO
 */
@Data
public class SystemParamVo implements Serializable {
    private static final long serialVersionUID=1L;

    private String deptCode;
    private String Oper;
    private String paraName;
    private String hospCode;
}
