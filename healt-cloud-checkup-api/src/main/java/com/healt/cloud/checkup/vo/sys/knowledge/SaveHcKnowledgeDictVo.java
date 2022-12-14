package com.healt.cloud.checkup.vo.sys.knowledge;

import com.healt.cloud.checkup.entity.HcKnowledgeDict;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-21 15:03
 * @description: TODO
 */
@Data
public class SaveHcKnowledgeDictVo implements Serializable {

    private static final long serialVersionUID=1L;

    private String stat;

    private List<HcKnowledgeDict> hcKnowledgeDict;

}
