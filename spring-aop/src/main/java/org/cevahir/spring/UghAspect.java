package org.cevahir.spring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UghAspect {
	
	@DeclareParents(value="org.cevahir.spring.*ServisiImpl",
					defaultImpl=DefaultUghImpl.class)
	public static Ugh ugh;
	
	@Before("org.cevahir.spring.CalAspect.orkestraCal() && " +
			"this(mixin)")
	public void before(Ugh mixin) {
		if (mixin instanceof OrkestraServisi)
			mixin.ugh();
	}
	
}
