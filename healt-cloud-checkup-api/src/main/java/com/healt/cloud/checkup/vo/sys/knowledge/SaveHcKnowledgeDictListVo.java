package com.healt.cloud.checkup.vo.sys.knowledge;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-21 14:58
 * @description: TODO
 */
@Data
public class SaveHcKnowledgeDictListVo implements Serializable {

    private static final long serialVersionUID=1L;

    public List<SaveHcKnowledgeDictVo> saveHcKnowledgeDictList;

}
