package com.kgc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgc.mapper.PersonMapper;
import com.kgc.pojo.Person;
import com.kgc.service.PersonService;
import com.kgc.util.PageUtil;

@Service("personservice")
public class PersonServiceImpl implements PersonService{

	//���ݷ��ʲ����
	@Autowired
	PersonMapper pm;
	
	@Override
	public PageUtil<Person> getPersonBypage(Integer pageIndex, Integer pagesize) {
		
		PageUtil<Person> page=new PageUtil<Person>();
		page.setPageIndex(pageIndex);
		page.setPageSize(pagesize);
		// �������ݷ��ʲ㣬��ȡ������
		int totalCount=pm.getCount();
		page.setTotalCount(totalCount);
		//����ҵ��
		List<Person> list=pm.getPersonByPage((pageIndex-1)*pagesize, pagesize);
		page.setList(list);
		return page;
	
	}

	@Override
	public PageUtil<Person> getPersonByPagenamedept(String name, Integer deptno,
			Integer pageIndex, Integer pageSize) {
		
		PageUtil<Person> page=new PageUtil<Person>();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		//
		int totalCount=pm.getCountByname(name, deptno);
		page.setTotalCount(totalCount);
		//����ҵ��
		List<Person> list=pm.getPersonByPagename(name, deptno,(pageIndex-1)*pageSize, pageSize);
		page.setList(list);
		return page;
	}

	@Override
	public int addperson(Person person) {
		//�������ݷ��ʲ�
		
		return pm.addperson(person);
	}

	@Override
	public int delperson(Integer id) {
		// TODO Auto-generated method stub
		return pm.delperson(id);
	}

	@Override
	public int updateperson(Person person) {
		//����
		
		return pm.updateperson(person);
	}

	@Override
	public Person showpersonById(Integer id) {
		//��������ʾ����
		return pm.showpersonById(id);
	}
}
