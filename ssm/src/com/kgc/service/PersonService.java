package com.kgc.service;



import com.kgc.pojo.Person;
import com.kgc.util.PageUtil;


//Ա�����ݷ��ʲ�
public interface PersonService {
    //��ҳ
	public PageUtil<Person> getPersonBypage(Integer pageIndex,Integer pagesize);
	
	
    //��ҳ��ʾ��ǰ����
	public PageUtil<Person> getPersonByPagenamedept(String name,Integer deptno,Integer pageIndex,Integer pageSize);
	//ʵ����ӹ���
    public int addperson(Person person);
    //ɾ��
  	public int delperson(Integer id);
   //����֮ǰ����ʾ
  	public Person showpersonById(Integer id);
   //���²���
  	public int updateperson(Person person);
}

