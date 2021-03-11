package com.company.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect	// root-context에 설정완료
@Component
@Log4j
public class LogAdvice {
	// test1
	@Before("execution(* com.company.service.TestService*.*(..))"
			+ " or execution(* com.company.mvcproject.*HomeController.*(..))") 
	public void test1() {
		log.info("...........................test1");
	}
	// test2
	@AfterThrowing(pointcut = "execution(* com.company.service.TestService*.*(..))", throwing="exception") // 예외 발생 후 적용하는 부분
	public void test2(Exception exception) {
		log.info("...........................test2 : " + exception);
	}
	// test3
	@Around("execution(* com.company.service.TestService*.*(..))")
	public void test3(ProceedingJoinPoint pjp) {
		log.info("...........................test3");
		long start = System.currentTimeMillis();
		log.info("target : " + pjp.getTarget());
		log.info("param : " + Arrays.toString(pjp.getArgs()));
		
		Object result = null;
		try {result = pjp.proceed(); } catch (Throwable e) {e.printStackTrace();}
		long end = System.currentTimeMillis();
		log.info("time : " + (end-start));
		log.info("........end");
	}
}
