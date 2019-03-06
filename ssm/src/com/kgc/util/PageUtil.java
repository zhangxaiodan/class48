package com.kgc.util;

import java.util.ArrayList;
import java.util.List;

public class PageUtil<T> {
   //分页
   private Integer pageIndex=1;//页码
   private Integer pageSize;//每页条数
   private Integer totalCount;//总共条数
   private Integer totalPage;//总共页数
   private List<T> list=new ArrayList<T>();//当前页数据集合
   //封装
   
	public Integer getPageSize() {
		return pageSize;
	}
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
		
		//
		this.totalPage=this.totalCount%this.pageSize==0?
				this.totalCount/this.pageSize:
					this.totalCount/this.pageSize+1;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
