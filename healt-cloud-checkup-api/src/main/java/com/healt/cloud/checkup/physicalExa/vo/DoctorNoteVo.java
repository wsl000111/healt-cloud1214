package com.healt.cloud.checkup.physicalExa.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linklee
 * @create 2022-05-20 17:14
 */
@Data
public class DoctorNoteVo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("VERIFIED_BY")
    @JsonProperty("VERIFIED_BY")
    private String verifiedBy;

    @TableField("NOTES_FOR_SPCM")
    @JsonProperty("NOTES_FOR_SPCM")
    private String notesForSpcm;

}
