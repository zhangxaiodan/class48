package com.kgc.service;



import com.kgc.pojo.Person;
import com.kgc.util.PageUtil;


//员工数据访问层
public interface PersonService {
    //分页
	public PageUtil<Person> getPersonBypage(Integer pageIndex,Integer pagesize);
	
	
    //分页显示当前集合
	public PageUtil<Person> getPersonByPagenamedept(String name,Integer deptno,Integer pageIndex,Integer pageSize);
	//实现添加功能
    public int addperson(Person person);
    //删除
  	public int delperson(Integer id);
   //更新之前先显示
  	public Person showpersonById(Integer id);
   //更新操作
  	public int updateperson(Person person);
}

