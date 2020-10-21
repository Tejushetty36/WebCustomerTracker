/*
 * package com.springdemo.aspect;
 * 
 * import java.util.logging.Logger;
 * 
 * import org.aspectj.lang.JoinPoint; import
 * org.aspectj.lang.annotation.AfterReturning; import
 * org.aspectj.lang.annotation.Aspect; import
 * org.aspectj.lang.annotation.Before; import
 * org.aspectj.lang.annotation.Pointcut; import
 * org.springframework.stereotype.Component;
 * 
 * @Aspect
 * 
 * @Component public class CRMLoggingAspect {
 * 
 * 
 * //set up a logger private Logger myLogger =
 * Logger.getLogger(getClass().getName());
 * 
 * //setup a pointcutdecleration
 * 
 * @Pointcut("execution(* com.springdemo.controller.*.*(..))") private void
 * forControllerPackage() {}
 * 
 * @Pointcut("execution(* com.springdemo.servicer.*.*(..))") private void
 * forServicePackage() {}
 * 
 * @Pointcut("execution(* com.springdemo.DAO.*.*(..))") private void
 * forDAOrPackage() {}
 * 
 * 
 * @Pointcut("forControllerPackage() || forServicePackage() || forDAOrPackage()"
 * ) private void forAppFlow() {}
 * 
 * 
 * //Add @Before advice
 * 
 * @Before("forAppFlow()") public void before(JoinPoint joinPoint) {
 * 
 * String method = joinPoint.getSignature().toShortString();
 * myLogger.info("=====>>>>>Calling @Before advice<<<====== "+ method);
 * 
 * Object[] args = joinPoint.getArgs();
 * 
 * for(Object tempArg : args) { myLogger.info("====>>> argument :"+ tempArg); }
 * 
 * }
 * 
 * //add @AfterReturning advice
 * 
 * @AfterReturning(pointcut = "forAppFlow()",returning = "theResult") public
 * void afterReturning(JoinPoint joinPoint,Object theResult) {
 * 
 * String method = joinPoint.getSignature().toShortString();
 * myLogger.info("=====>>>>>Calling @AfterReturning advice<<<====== "+ method);
 * 
 * myLogger.info("=====>>>>>Result : "+ theResult);
 * 
 * 
 * }
 * 
 * 
 * 
 * }
 */