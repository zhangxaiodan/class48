package com.kgc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kgc.pojo.User;


@Controller
public class AjaxController {
     
	//ajax需要用到@ResponseBody这个注解,地址是传来的地址
	@RequestMapping("/showperson")
	@ResponseBody
	public User showPerson(){
		User user=new User("s01","张三",25);
		user.setBirth("1990-1-1");
		user.setBirthday(new Date());
		//System.out.println();
		return user;
	}
	
	//列表，地址是传来的地址
	@RequestMapping("/showlist")
	@ResponseBody
	public List<User> showlist(){
		List<User> list=new ArrayList<User>();
		User user1=new User("s01","张三1",25);
		User user2=new User("s02","张三2",25);
		User user3=new User("s03","张三3",25);
		
		list.add(user1);
		list.add(user2);
		list.add(user3);
		//System.out.println();
		return list;
	}
	
	
	//地址是传来的地址
	@RequestMapping("/valid")
	@ResponseBody
	public String validate(String name){
		if(name.equals("admin")){
			return "not";
		}else{
			return "ok";
		}
	}

	
}
