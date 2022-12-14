package com.healt.cloud.pdf.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author GuYue
 * @date 2022-09-16 9:05
 * @description: TODO
 */
@Data
public class UploadPdfVo implements Serializable {
    private String personId;
    private String visitId;
    private byte[] arraryByte;
}
