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
		/*//获取业务对象
		PersonService ps=(PersonService)context.getBean("personservice");
        //调用业务方法
		PageUtil<Person> page=ps.getPersonBypage(2, 3);
		System.out.println("当前页码："+page.getPageIndex());
		System.out.println("每页条数："+page.getPageSize());
		System.out.println("总条数："+page.getTotalCount());
		System.out.println("总页数："+page.getTotalPage());
		for(Person p:page.getList()){
			System.out.println("id:"+p.getId()+"name:"+p.getName()+"部门编号："+p.getDept().getId()
					+"deptname:"+p.getDept().getDeptname()+p.getAge()+p.getAddress());
		}*/
		
		
		//获取部门所有信息
		/*DeptService ds=(DeptService)context.getBean("deptservice");
		//调用业务方法
		List<Dept> list=ds.getAllDept();
		for(Dept d:list){
			System.out.println("部门编号："+d.getId()+"部门名称："+d.getDeptname());
		}*/
		
		//
		PersonService ps=(PersonService)context.getBean("personservice");
        //调用业务方法
		PageUtil<Person> page=ps.getPersonByPagenamedept("李",-1, 1, 5);
		System.out.println("当前页码："+page.getPageIndex());
		System.out.println("每页条数："+page.getPageSize());
		System.out.println("总条数："+page.getTotalCount());
		System.out.println("总页数："+page.getTotalPage());
		for(Person p:page.getList()){
			System.out.println("id:"+p.getId()+"name:"+p.getName()+"部门编号："+p.getDept().getId()
					+"部门名称:"+p.getDept().getDeptname()+p.getAge()+p.getAddress());
		}
	}
}
