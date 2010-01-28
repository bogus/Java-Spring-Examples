package org.cevahir.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CalAspect {


	@Before("orkestraCal()")
	public void log(JoinPoint joinPoint) {
		System.out.println(joinPoint.getTarget().getClass().getSimpleName()
				+ " hazirlaniyor..");

	}

	@AfterReturning(pointcut = "orkestraCal()")
	public void log324(JoinPoint joinPoint) {
		System.out.println(joinPoint.getTarget().getClass().getSimpleName()
				+ " toparlaniyor..");

	}

	@Around("orkestraCal()")
	public void log3(ProceedingJoinPoint proceedingJoinPoint) {

		Long currTime = System.currentTimeMillis();

		try {
			proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Orkestra calmayi "
				+ (System.currentTimeMillis() - currTime) + "ms'da tamamladi.");
	}

	@Pointcut("execution(* org.cevahir..*Servisi.cal()) && "
			+ "bean(*Orkesutra)")
	public void orkestraCal() {
	}
	
	@Around("@target(org.springframework.stereotype.Repository)")
	public void log355(ProceedingJoinPoint proceedingJoinPoint) {

		Long txId = System.currentTimeMillis();
		
		if (proceedingJoinPoint.getTarget() instanceof OrkestraServisi) {
			try {
				proceedingJoinPoint.proceed();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		try {
			System.out.println( txId + " numarali transaction basladi.");
			proceedingJoinPoint.proceed();
			System.out.println( txId + " numarali transaction tamamlandi.");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println( txId + " numarali transaction tamamlanamadi.");
		}
		
	}
	
	@Around("@target(org.springframework.stereotype.Repository) && " +
			"execution(* *(String)) && " +
			"args(satirrr)")
	public void degistir(ProceedingJoinPoint proceedingJoinPoint, String satirrr) {
		
		String yeniSatir = "> " + satirrr + " <";
		try {
			proceedingJoinPoint.proceed(new Object[]{yeniSatir.toUpperCase()});
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
