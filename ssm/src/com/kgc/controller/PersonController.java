package com.kgc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kgc.pojo.Dept;
import com.kgc.pojo.Person;
import com.kgc.service.DeptService;
import com.kgc.service.PersonService;
import com.kgc.util.PageUtil;

@Controller
public class PersonController { 

	//业务对象
	@Autowired
	private PersonService ps;
	
	@Autowired
	private DeptService ds;
	
	//页面每次都要到这里来请求数据
	@RequestMapping("/show")
	public String show(String name,Integer deptno,@RequestParam(value="index",required=false,defaultValue="1")Integer index,Model model){
		//System.out.println("当前页码"+index);
		//调用业务部门的方法,因为页面还需要列表
		List<Dept> list=ds.getAllDept();
		//调用业务方法
		PageUtil<Person> page=ps.getPersonByPagenamedept(name, deptno, index, 3);
		//封装page, 传递到视图
		model.addAttribute("page", page);
		//封装部门传递到视图
		model.addAttribute("list", list);
		//返回到index页面
		return "index";
	}
	
	@RequestMapping("/toadd")
	//返回的是字符串
	public String toadd(Model model){
		//调用业务部门
		List<Dept> depts=ds.getAllDept();
		model.addAttribute("depts",depts);
		return "add";
	}
	
	//返回的视图名称是字符串，然后由视图解析器进行解析
	@RequestMapping("/doadd")
	public String doadd(Person person){
		//调用业务层添加，添加的时候是从页面映射过来的，最好封装成对象
		//也可以一个一个参数映射过来。
		//调用业务逻辑实现添加
		ps.addperson(person);
		//返回index这个页面不合适
		//return "index";
		//这个相当于是重定向，到新的请求上面
		return "redirect:/show";//发送新的请求到show请求，redirect表示重定向到一个url网址
	}
	
	
	//地址要和页面发来的请求地址保持一致
	@RequestMapping("/del")
	public String del(Integer id){
		//调用,业务层删除
		ps.delperson(id);
		//返回列表显示页面
		return "redirect:/show";
	}
	
	//更新前的先显示，传递参数使用的rest风格，在页面里面，上面使用的是另外一种风格（删除操作）
	@RequestMapping("/toupdate/{id}")
	public String update(@PathVariable Integer id,Model model){
		//调用业务层,根据id获取当前员工对象
		Person person=ps.showpersonById(id);
		//保存数据
		model.addAttribute("person",person);
		//还需要部门列表
		List<Dept> depts=ds.getAllDept();
		model.addAttribute("depts",depts);
		//返回列表页面
		return "update";
	}
	
	//更新操作
	@RequestMapping("/doupdate")
	public String doupdate(Person person){
		//调用业务实现更新操作,从页面获取的参数直接，映射过来，就不用像jsp之前的还在在另外获取数据了
		ps.updateperson(person);
		//返回视图
		return "redirect:/show";
	}

}
