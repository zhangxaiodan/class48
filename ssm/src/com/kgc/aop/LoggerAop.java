package com.kgc.aop;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 * ��־��ǿ�����������
 * �Ȳ���daoҲ����service����ǣ�ʹ��component��ע��
 */
//��ǿ�������ڵ���
@Aspect
@Component("mylogger")
public class LoggerAop {
  //������־����
  private static Logger logger=Logger.getLogger(LoggerAop.class);
  //ǰ����ǿ
  //JoinPoint���ӵ�
  @Before("execution(* com.kgc.service.impl.*.*(..))")
  public void before(JoinPoint jp){
	  logger.info("ǰ����ǿ,���ã�"+jp.getTarget()+"��ķ�������"
                  +jp.getSignature().getName()
                  +"�����ǣ�"+Arrays.toString(jp.getArgs()));
  }
  
  //������ǿ
  //JoinPoint���ӵ�
  @AfterReturning(pointcut="execution(* com.kgc.service.impl.*.*(..))",returning="result")
  public void afterReturing(JoinPoint jp,Object result){
	  logger.info("������ǿ,���ã�"+jp.getTarget()
			  +"��ķ�������"+jp.getSignature().getName()
			  +"�����ǣ�"+Arrays.toString(jp.getArgs())
			  +"����ֵ��"+result);
  } 
  
  //�쳣
  @AfterThrowing(pointcut="execution(* com.kgc.service.impl.*.*(..))",throwing="e")
  public void afterThrowing(JoinPoint jp,RuntimeException e){
	  logger.info("�쳣��ǿ,���ã�"+jp.getTarget()
			  +"��ķ�������"+jp.getSignature().getName()
			  +"�������ֵ��쳣��Ϊ��"+e);
  }
  
  //������ǿ
  @After("execution(* com.kgc.service.impl.*.*(..))")
  public void after(JoinPoint jp){
	  logger.info("������ǿ,���ã�"+jp.getTarget()
			  +"��ķ�������"+jp.getSignature().getName()
			  +"����ִ�����");
  }
  
  //������ǿ
  @Around("execution(* com.kgc.service.impl.*.*(..))")
  public Object around(ProceedingJoinPoint jp){
	  Object result =null;

	  try {
		  logger.info("������ǿ��ǰ�����,���ã�"+jp.getTarget()+"��ķ�������"
	              +jp.getSignature().getName()
	              +"�����ǣ�"+Arrays.toString(jp.getArgs()));
		  //ִ��Ŀ�귽��������ȡ����ֵ
		  result=jp.proceed();
		  logger.info("������ǿ�ĺ������,���ã�"+jp.getTarget()
				  +"��ķ�������"+jp.getSignature().getName()
				  +"�����ǣ�"+Arrays.toString(jp.getArgs())
				  +"����ֵ��"+result);
		  
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		 logger.info("������ǿ���쳣���,���ã�"+jp.getTarget()
				  +"��ķ�������"+jp.getSignature().getName()
				  +"�������ֵ��쳣��Ϊ��"+e);
	}finally{
		logger.info("������ǿ���������,���ã�"+jp.getTarget()
				  +"��ķ�������"+jp.getSignature().getName()
				  +"����ִ�����");
	}
	  return result;
  }
}
