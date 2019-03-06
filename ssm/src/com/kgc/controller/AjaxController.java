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
     
	//ajax��Ҫ�õ�@ResponseBody���ע��,��ַ�Ǵ����ĵ�ַ
	@RequestMapping("/showperson")
	@ResponseBody
	public User showPerson(){
		User user=new User("s01","����",25);
		user.setBirth("1990-1-1");
		user.setBirthday(new Date());
		//System.out.println();
		return user;
	}
	
	//�б���ַ�Ǵ����ĵ�ַ
	@RequestMapping("/showlist")
	@ResponseBody
	public List<User> showlist(){
		List<User> list=new ArrayList<User>();
		User user1=new User("s01","����1",25);
		User user2=new User("s02","����2",25);
		User user3=new User("s03","����3",25);
		
		list.add(user1);
		list.add(user2);
		list.add(user3);
		//System.out.println();
		return list;
	}
	
	
	//��ַ�Ǵ����ĵ�ַ
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
