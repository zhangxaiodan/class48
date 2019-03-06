package com.kgc.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kgc.pojo.Dept;
import com.kgc.pojo.Person;
import com.kgc.service.DeptService;
import com.kgc.service.PersonService;
import com.kgc.util.PageUtil;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring_mybatis.xml");
		/*//��ȡҵ�����
		PersonService ps=(PersonService)context.getBean("personservice");
        //����ҵ�񷽷�
		PageUtil<Person> page=ps.getPersonBypage(2, 3);
		System.out.println("��ǰҳ�룺"+page.getPageIndex());
		System.out.println("ÿҳ������"+page.getPageSize());
		System.out.println("��������"+page.getTotalCount());
		System.out.println("��ҳ����"+page.getTotalPage());
		for(Person p:page.getList()){
			System.out.println("id:"+p.getId()+"name:"+p.getName()+"���ű�ţ�"+p.getDept().getId()
					+"deptname:"+p.getDept().getDeptname()+p.getAge()+p.getAddress());
		}*/
		
		
		//��ȡ����������Ϣ
		/*DeptService ds=(DeptService)context.getBean("deptservice");
		//����ҵ�񷽷�
		List<Dept> list=ds.getAllDept();
		for(Dept d:list){
			System.out.println("���ű�ţ�"+d.getId()+"�������ƣ�"+d.getDeptname());
		}*/
		
		//
		PersonService ps=(PersonService)context.getBean("personservice");
        //����ҵ�񷽷�
		PageUtil<Person> page=ps.getPersonByPagenamedept("��",-1, 1, 5);
		System.out.println("��ǰҳ�룺"+page.getPageIndex());
		System.out.println("ÿҳ������"+page.getPageSize());
		System.out.println("��������"+page.getTotalCount());
		System.out.println("��ҳ����"+page.getTotalPage());
		for(Person p:page.getList()){
			System.out.println("id:"+p.getId()+"name:"+p.getName()+"���ű�ţ�"+p.getDept().getId()
					+"��������:"+p.getDept().getDeptname()+p.getAge()+p.getAddress());
		}
	}
}
