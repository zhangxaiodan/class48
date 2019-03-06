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

	//ҵ�����
	@Autowired
	private PersonService ps;
	
	@Autowired
	private DeptService ds;
	
	//ҳ��ÿ�ζ�Ҫ����������������
	@RequestMapping("/show")
	public String show(String name,Integer deptno,@RequestParam(value="index",required=false,defaultValue="1")Integer index,Model model){
		//System.out.println("��ǰҳ��"+index);
		//����ҵ���ŵķ���,��Ϊҳ�滹��Ҫ�б�
		List<Dept> list=ds.getAllDept();
		//����ҵ�񷽷�
		PageUtil<Person> page=ps.getPersonByPagenamedept(name, deptno, index, 3);
		//��װpage, ���ݵ���ͼ
		model.addAttribute("page", page);
		//��װ���Ŵ��ݵ���ͼ
		model.addAttribute("list", list);
		//���ص�indexҳ��
		return "index";
	}
	
	@RequestMapping("/toadd")
	//���ص����ַ���
	public String toadd(Model model){
		//����ҵ����
		List<Dept> depts=ds.getAllDept();
		model.addAttribute("depts",depts);
		return "add";
	}
	
	//���ص���ͼ�������ַ�����Ȼ������ͼ���������н���
	@RequestMapping("/doadd")
	public String doadd(Person person){
		//����ҵ�����ӣ���ӵ�ʱ���Ǵ�ҳ��ӳ������ģ���÷�װ�ɶ���
		//Ҳ����һ��һ������ӳ�������
		//����ҵ���߼�ʵ�����
		ps.addperson(person);
		//����index���ҳ�治����
		//return "index";
		//����൱�����ض��򣬵��µ���������
		return "redirect:/show";//�����µ�����show����redirect��ʾ�ض���һ��url��ַ
	}
	
	
	//��ַҪ��ҳ�淢���������ַ����һ��
	@RequestMapping("/del")
	public String del(Integer id){
		//����,ҵ���ɾ��
		ps.delperson(id);
		//�����б���ʾҳ��
		return "redirect:/show";
	}
	
	//����ǰ������ʾ�����ݲ���ʹ�õ�rest�����ҳ�����棬����ʹ�õ�������һ�ַ��ɾ��������
	@RequestMapping("/toupdate/{id}")
	public String update(@PathVariable Integer id,Model model){
		//����ҵ���,����id��ȡ��ǰԱ������
		Person person=ps.showpersonById(id);
		//��������
		model.addAttribute("person",person);
		//����Ҫ�����б�
		List<Dept> depts=ds.getAllDept();
		model.addAttribute("depts",depts);
		//�����б�ҳ��
		return "update";
	}
	
	//���²���
	@RequestMapping("/doupdate")
	public String doupdate(Person person){
		//����ҵ��ʵ�ָ��²���,��ҳ���ȡ�Ĳ���ֱ�ӣ�ӳ��������Ͳ�����jsp֮ǰ�Ļ����������ȡ������
		ps.updateperson(person);
		//������ͼ
		return "redirect:/show";
	}

}
