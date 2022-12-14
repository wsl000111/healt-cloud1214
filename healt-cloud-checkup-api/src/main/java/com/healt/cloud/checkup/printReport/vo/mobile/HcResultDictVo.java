package com.healt.cloud.checkup.printReport.vo.mobile;

import java.util.List;

import lombok.Data;

@Data
public class HcResultDictVo {

	private String deptName;
	private String itemAssemName;
	private String condusionText;
	private List<HcResultDictVo> children;
	
	private String hcItemCode;
	private String hcItemName;
	private String abnormalIndicator;
	private String printContext;
	private String unit;
	private String resultDecimal;
	private String hcResult;
	private String showType;
	
}
