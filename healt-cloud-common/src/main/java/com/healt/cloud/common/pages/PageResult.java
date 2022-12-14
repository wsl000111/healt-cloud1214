package com.healt.cloud.common.pages;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * @author GuYue
 * @date 2022-02-15 17:23
 * @description: 分页返回结果
 */
@Data
public class PageResult<T> implements Serializable {

	/**
	 * 当前页码
	 */
	private long pageNum;
	
	/**
	 * 每页数量
	 */
	private long pageSize;
	
	/**
	 * 记录总数
	 */
	private long totalSize;
	
	/**
	 * 页码总数
	 */
	private long totalPages;
	
	/**
	 * 分页数据
	 */
	private List<T> content;

	public PageResult(long pageNum, long pageSize, long totalSize, long totalPages, List<T> content) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalPages = totalPages;
		this.totalSize = totalSize;
		this.content = content;
	}

	public PageResult(){}
}
