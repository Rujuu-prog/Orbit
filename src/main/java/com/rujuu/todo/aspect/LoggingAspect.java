package com.rujuu.todo.aspect;

import com.rujuu.todo.service.task.TaskEntityNotFoundException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @AfterThrowing(pointcut = "execution(* com.rujuu.todo.service.*.*(..))", throwing = "exception")
    public void logAfterThrowingException(TaskEntityNotFoundException exception) {
        logger.error("TaskEntityNotFoundException was thrown: {}", exception.getMessage(), exception);
    }

    // AuthControllerのtokenメソッド呼び出し前のログ出力
    @Before("execution(* com.rujuu.todo.controller.auth.AuthController.token(..)) && args(authentication)")
    public void logBefore(JoinPoint joinPoint, Authentication authentication) {
        logger.debug("Token requested for user: '{}'", authentication.getName());
    }

    // AuthControllerのtokenメソッドの戻り値に対するログ出力
    @AfterReturning(pointcut = "execution(* com.rujuu.todo.controller.auth.AuthController.token(..))", returning = "result")
    public void logAfter(JoinPoint joinPoint, String result) {
        logger.debug("Token granted: {}", result);
    }
}
