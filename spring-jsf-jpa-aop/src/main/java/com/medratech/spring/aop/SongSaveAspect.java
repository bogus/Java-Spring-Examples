package com.medratech.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SongSaveAspect {

	@Pointcut("execution(* com.medratech..*.persist(*))")
	public void savePointcut() {}
	
	@Before("savePointcut()")
	public void beforeSavePointcut() {
		System.out.println("----------- A New Song Has Been Submitted ------------");
	}
	
}
