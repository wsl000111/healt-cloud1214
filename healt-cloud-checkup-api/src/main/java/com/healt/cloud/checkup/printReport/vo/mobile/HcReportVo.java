package com.healt.cloud.checkup.printReport.vo.mobile;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class HcReportVo implements Serializable {

	private List<HcResultDictVo> hcResultDictVoList;
	
	private List<HcDiagnosisRecordVo> hcDiagnosisRecordVoList;
	
	private List<HcResultExpVo> exceptionList;
	
}
