package com.kgc.pojo;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.kgc.util.ClientDateFormat;

public class User {
    private String id;
    private String name;
    private Integer age;
    private String birth;
    private Date birthday;
    
    
    //构造方法
    public User(){
    	
    }
    
    public User(String id, String name,Integer age) {
		this.id=id;
		this.name=name;
		this.age=age;
	}
	//封装
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Integer getAge() {
		return age;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	public String getBirth() {
		return birth;
	}

	//在转化的return上面写上注释,在Date类型的get方法上添加注释
	@JsonSerialize(using=ClientDateFormat.class)
	public Date getBirthday() {
		return birthday;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
