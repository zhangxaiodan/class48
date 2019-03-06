package com.kgc.util;

import java.util.ArrayList;
import java.util.List;

public class PageUtil<T> {
   //��ҳ
   private Integer pageIndex=1;//ҳ��
   private Integer pageSize;//ÿҳ����
   private Integer totalCount;//�ܹ�����
   private Integer totalPage;//�ܹ�ҳ��
   private List<T> list=new ArrayList<T>();//��ǰҳ���ݼ���
   //��װ
   
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
