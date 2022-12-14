package com.healt.cloud.checkup.printReport.vo.mobile;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class HcResultExpVo implements Serializable {
	
	private String itemAssemName;
	private List<HcResultDictVo> hcResultDictVoList;
	
}
