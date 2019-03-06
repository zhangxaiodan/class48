package com.kgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kgc.pojo.Person;

public interface PersonMapper {
    //��ҳ�Ȳ�ѯ����
	public int getCount();
	//��ǰҳ�ļ���
	public List<Person> getPersonByPage(@Param("from")Integer from,@Param("pagesize")Integer pagesize);
    
	//��ҳ�Ȳ�ѯ�������������������кͲ��ű�Ų�ѯ
	public int getCountByname(@Param("name")String name,@Param("deptno")Integer deptno);
	
    //��ҳ��ʾ��ǰ����
	public List<Person> getPersonByPagename(@Param("name")String name,
			                            @Param("deptno")Integer deptno,
			                            @Param("from")Integer from,
			                            @Param("pageSize")Integer pageSize);
	//ʵ����ӹ���
	public int addperson(Person person);
	//ɾ��
	public int delperson(Integer id);
	//����֮ǰ����ʾ
	public Person showpersonById(Integer id);
	//���²���
	public int updateperson(Person person);


}
