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
    
    
    //���췽��
    public User(){
    	
    }
    
    public User(String id, String name,Integer age) {
		this.id=id;
		this.name=name;
		this.age=age;
	}
	//��װ
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

	//��ת����return����д��ע��,��Date���͵�get���������ע��
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
