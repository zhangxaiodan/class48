package com.kgc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgc.mapper.DeptMapper;
import com.kgc.pojo.Dept;
import com.kgc.service.DeptService;


@Service("deptservice")
public class DeptServiceimpl implements DeptService{

	//创建数据访问层对象,并且自动装配
	@Autowired
	private DeptMapper dm;
	
	
	@Override
	public List<Dept> getAllDept() {
		//获取部门所有信息
		return dm.getAllDept();
	}
     
	
	
}
