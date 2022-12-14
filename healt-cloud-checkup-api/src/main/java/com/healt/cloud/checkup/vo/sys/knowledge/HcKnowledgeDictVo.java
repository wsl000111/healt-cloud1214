package com.healt.cloud.checkup.vo.sys.knowledge;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-03-21 12:49
 * @description: TODO
 */
@Data
public class HcKnowledgeDictVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String hospitalCode;

    private String knowledgeType;

    private String itemCode;

    private String deptId;

}
