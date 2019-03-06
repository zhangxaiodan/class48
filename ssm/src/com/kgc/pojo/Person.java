package com.kgc.pojo;

public class Person {
    //ÊôĞÔ
	private Integer id;
	private String name;
	private Integer age;
	private String address;
	//private Integer dept_id;
	private Dept dept;
	
	//·â×°
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Integer getAge() {
		return age;
	}
	public String getAddress() {
		return address;
	}
	public Dept getDept() {
		return dept;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
}
