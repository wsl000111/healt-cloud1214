package com.healt.cloud.pdf.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-22 9:22
 * @description: TODO
 */
@Data
public class SaveHcPersonDictListVo implements Serializable {
    private static final long serialVersionUID=1L;

    private List<SaveHcPersonDictVo> saveHcPersonDictList;
}
