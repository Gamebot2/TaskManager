package com.ansh.test.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
	
	public  LoggingAspect() {
		System.out.println("Constructor.....................");
	}

	@Before("com.ansh.test.controller.SpringRestController.*")
	public void logEntry() {
		System.out.println("METHOD INVOKED-----------------------------------------------");
	}
	
}
