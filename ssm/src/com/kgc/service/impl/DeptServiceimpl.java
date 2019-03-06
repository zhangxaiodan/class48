package com.kgc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgc.mapper.DeptMapper;
import com.kgc.pojo.Dept;
import com.kgc.service.DeptService;


@Service("deptservice")
public class DeptServiceimpl implements DeptService{

	//�������ݷ��ʲ����,�����Զ�װ��
	@Autowired
	private DeptMapper dm;
	
	
	@Override
	public List<Dept> getAllDept() {
		//��ȡ����������Ϣ
		return dm.getAllDept();
	}
     
	
	
}
