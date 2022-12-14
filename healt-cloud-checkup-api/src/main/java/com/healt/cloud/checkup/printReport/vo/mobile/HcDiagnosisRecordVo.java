package com.healt.cloud.checkup.printReport.vo.mobile;

import lombok.Data;

import java.io.Serializable;

@Data
public class HcDiagnosisRecordVo implements Serializable {
	
    private String recContent;

    private String guideContent;
	
}
