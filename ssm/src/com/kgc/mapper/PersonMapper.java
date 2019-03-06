package com.kgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kgc.pojo.Person;

public interface PersonMapper {
    //分页先查询数量
	public int getCount();
	//当前页的集合
	public List<Person> getPersonByPage(@Param("from")Integer from,@Param("pagesize")Integer pagesize);
    
	//分页先查询数量，根据姓名，还有和部门编号查询
	public int getCountByname(@Param("name")String name,@Param("deptno")Integer deptno);
	
    //分页显示当前集合
	public List<Person> getPersonByPagename(@Param("name")String name,
			                            @Param("deptno")Integer deptno,
			                            @Param("from")Integer from,
			                            @Param("pageSize")Integer pageSize);
	//实现添加功能
	public int addperson(Person person);
	//删除
	public int delperson(Integer id);
	//更新之前先显示
	public Person showpersonById(Integer id);
	//更新操作
	public int updateperson(Person person);


}
