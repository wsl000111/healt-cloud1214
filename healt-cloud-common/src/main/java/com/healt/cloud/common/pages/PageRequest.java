package com.healt.cloud.common.pages;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;

/**
 * @author GuYue
 * @date 2022-02-15 17:23
 * @description: 分页请求
 */
@Data
public class PageRequest implements Serializable {

	/**
	 * 当前页码
	 */
	@Getter
	@ApiModelProperty(name = "pageNum", value = "当前页码", required = true)
	private int pageNum;
	
	/**
	 * 每页数量
	 */
	@ApiModelProperty(name = "pageSize", value = "每页数量", required = true)
	private int pageSize;
	
	/**
	 * 查询参数
	 */
	//@ApiModelProperty(name = "params", value = "查询参数", required = true, dataType = "Map")
	//private Map<String, Object> params = new HashMap<String, Object>();

	/**
	 * 根据key查询请求参数值
	 * @param key
	 * @return
	 */
//	public Object getParam(String key) {
//		return getParams().get(key);
//	}
	
}
