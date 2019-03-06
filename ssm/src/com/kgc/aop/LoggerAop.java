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
 * 日志增强处理的切面类
 * 既不是dao也不是service因此是，使用component来注解
 */
//增强方法所在的类
@Aspect
@Component("mylogger")
public class LoggerAop {
  //创建日志对象
  private static Logger logger=Logger.getLogger(LoggerAop.class);
  //前置增强
  //JoinPoint连接点
  @Before("execution(* com.kgc.service.impl.*.*(..))")
  public void before(JoinPoint jp){
	  logger.info("前置增强,调用："+jp.getTarget()+"类的方法名："
                  +jp.getSignature().getName()
                  +"参数是："+Arrays.toString(jp.getArgs()));
  }
  
  //后置增强
  //JoinPoint连接点
  @AfterReturning(pointcut="execution(* com.kgc.service.impl.*.*(..))",returning="result")
  public void afterReturing(JoinPoint jp,Object result){
	  logger.info("后置增强,调用："+jp.getTarget()
			  +"类的方法名："+jp.getSignature().getName()
			  +"参数是："+Arrays.toString(jp.getArgs())
			  +"返回值："+result);
  } 
  
  //异常
  @AfterThrowing(pointcut="execution(* com.kgc.service.impl.*.*(..))",throwing="e")
  public void afterThrowing(JoinPoint jp,RuntimeException e){
	  logger.info("异常增强,调用："+jp.getTarget()
			  +"类的方法名："+jp.getSignature().getName()
			  +"方法出现的异常，为："+e);
  }
  
  //最终增强
  @After("execution(* com.kgc.service.impl.*.*(..))")
  public void after(JoinPoint jp){
	  logger.info("最终增强,调用："+jp.getTarget()
			  +"类的方法名："+jp.getSignature().getName()
			  +"方法执行完毕");
  }
  
  //环绕增强
  @Around("execution(* com.kgc.service.impl.*.*(..))")
  public Object around(ProceedingJoinPoint jp){
	  Object result =null;

	  try {
		  logger.info("环绕增强的前置输出,调用："+jp.getTarget()+"类的方法名："
	              +jp.getSignature().getName()
	              +"参数是："+Arrays.toString(jp.getArgs()));
		  //执行目标方法，并获取返回值
		  result=jp.proceed();
		  logger.info("环绕增强的后置输出,调用："+jp.getTarget()
				  +"类的方法名："+jp.getSignature().getName()
				  +"参数是："+Arrays.toString(jp.getArgs())
				  +"返回值："+result);
		  
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		 logger.info("环绕增强的异常输出,调用："+jp.getTarget()
				  +"类的方法名："+jp.getSignature().getName()
				  +"方法出现的异常，为："+e);
	}finally{
		logger.info("环绕增强的最终输出,调用："+jp.getTarget()
				  +"类的方法名："+jp.getSignature().getName()
				  +"方法执行完毕");
	}
	  return result;
  }
}
