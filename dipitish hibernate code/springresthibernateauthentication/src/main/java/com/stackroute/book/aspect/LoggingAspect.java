package com.stackroute.book.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/* Annotate this class with @Aspect and @Component */
@Component
@Aspect
public class LoggingAspect {

	// Singleton design pattern. 
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	/*
	/*
	 * Write loggers for each of the methods of controller, any particular method
	 * will have all the four aspectJ annotation
	 * (@Before, @After, @AfterReturning, @AfterThrowing).
	 */
	/**
	 * point cut which will execute for all the classes, methods under controller package
	 */
	@Pointcut("execution (* com.stackroute.book.controller..*(..))")
	public void controllerPointCut() {
	}
	
	
	/**
	 * point cut which will execute for all the classes, methods under service package
	 */
	@Pointcut("execution (* com.stackroute.book.service..*(..))")
	public void serviceClassPointCut() {
	}
	
	
	/**
	 * point cut which will execute for all the classes, methods under UserServiceImpl class
	 */
	/*
	 * @Pointcut("execution (* com.stackroute.keepnote.service.UserServiceImpl.*(..))"
	 * ) public void UserServiceImplPointCut() { }
	 */
	
	
	/**
	 * point cut which will execute for all the classes, methods under Dao packages
	 */
	@Pointcut("execution (* com.stackroute.book.dao.*.*(..))")
	public void daoImplPointCut() {
	}
	
	
	/**
	 * point cut which will execute for all the classes, methods under model packages
	 */
	@Pointcut("execution (* com.stackroute.keepnote.model.*.*(..))")
	public void modelPointCut() {
	}
	
	@Before("controllerPointCut()")
	public void logBeforeController(JoinPoint joinPoint) {
		logger.debug("******Execution of Before Advice on controller*****");
	}
	
	@After("controllerPointCut()")
	public void logAfterController(JoinPoint joinPoint) {
		logger.debug("******Execution of After Advice on controller*****");
	}
	
	@AfterReturning("controllerPointCut()")
	public void logAfterReturningController(JoinPoint joinPoint) {
		logger.debug("******Execution of After Returning Advice on controller******");
	}
	
	@AfterThrowing("controllerPointCut()")
	public void logAfterThrowingController(JoinPoint joinPoint) {
		logger.debug("******Execution of After throwing Advice on controller******");
	}
	
	
	
	
	@Before("serviceClassPointCut()")
	public void logBeforeService(JoinPoint joinPoint) {
		logger.debug("******Execution of Before Advice on Service*****");
	}
	
	@After("serviceClassPointCut()")
	public void logAfterService(JoinPoint joinPoint) {
		logger.debug("******Execution of After Advice on Service*****");
	}
	
	@AfterReturning("serviceClassPointCut()")
	public void logAfterReturningService(JoinPoint joinPoint) {
		logger.debug("******Execution of After Returning Advice on Service******");
	}
	
	@AfterThrowing("serviceClassPointCut()")
	public void logAfterThrowingService(JoinPoint joinPoint) {
		logger.debug("******Execution of After throwing Advice on Service******");
	}
	
	
	/*
	 * @Before("UserServiceImplPointCut()") public void
	 * logBeforeUserServiceImpl(JoinPoint joinPoint) {
	 * logger.info("******Execution of Before Advice on UserServiceImpl*****"); }
	 * 
	 * @After("UserServiceImplPointCut()") public void
	 * logAfterUserServiceImpl(JoinPoint joinPoint) {
	 * logger.info("******Execution of After Advice on UserServiceImpl*****"); }
	 * 
	 * @AfterReturning("UserServiceImplPointCut()") public void
	 * logAfterReturningUserServiceImpl(JoinPoint joinPoint) { logger.
	 * info("******Execution of After Returning Advice on UserServiceImpl******"); }
	 * 
	 * @AfterThrowing("UserServiceImplPointCut()") public void
	 * logAfterThrowingUserServiceImpl(JoinPoint joinPoint) { logger.
	 * info("******Execution of After throwing Advice on UserServiceImpl******"); }
	 */
	
	
	
	
	@Before("daoImplPointCut()")
	public void logBeforeDao(JoinPoint joinPoint) {
		logger.info("******Execution of Before Advice on Dao*****");
	}
	
	@After("daoImplPointCut()")
	public void logAfterDao(JoinPoint joinPoint) {
		logger.info("******Execution of After Advice on Dao*****");
	}
	
	@AfterReturning("daoImplPointCut()")
	public void logAfterReturningDao(JoinPoint joinPoint) {
		logger.info("******Execution of After Returning Advice on Dao******");
	}
	
	@AfterThrowing("daoImplPointCut()")
	public void logAfterThrowingDao(JoinPoint joinPoint) {
		logger.info("******Execution of After throwing Advice on DAo******");
	}
	
	
	
	
	@Before("modelPointCut()")
	public void logBeforeModel(JoinPoint joinPoint) {
		logger.info("******Execution of Before Advice on Model*****");
	}
	
	@After("modelPointCut()")
	public void logAfterModel(JoinPoint joinPoint) {
		logger.info("******Execution of After Advice on Model*****");
	}
	
	@AfterReturning("modelPointCut()")
	public void logAfterReturningModel(JoinPoint joinPoint) {
		logger.info("******Execution of After Returning Advice on Model******");
	}
	
	@AfterThrowing("modelPointCut()")
	public void logAfterThrowingModel(JoinPoint joinPoint) {
		logger.info("******Execution of After throwing Advice on Model******");
	}
	
	
	
	
	
	
}