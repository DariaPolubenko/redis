package com.example.demo.redis.aop;

import com.example.demo.redis.aop.annotations.LogExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//aop - это аспектно-ориентированное программирование, когда до вызова метода обработать некую логику
//Аспекты разные существуют
@Component
@Aspect //совет, служебная логика отдельно подключается
public class AOP {
    /*
    @Before("execution(* com.example.demo.redis.aop.Service2.getUserData(int))") //если не хочется использовать метод proceed
    //@Around("execution(* com.example.demo.redis.aop.Service2.*(..))") //* - любой модификатор доступа , com.example.demo.redis.Service2. - любой класс, * - любой метод в классе, (..) - любые параметры
    //public void logAllServiceMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable { //proceedingJoinPoint - только в @Around
    public void logAllServiceMethod() {
        System.out.println("Запуск перед методом ");
        //proceedingJoinPoint.proceed();
        //System.out.println("После метода " + proceedingJoinPoint.getSignature().getName());
        // все что идет до метода proceed - запускается до вызова метода
        // все, что после - запускается после метода
    }

     */


    @Around("@annotation(logExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint, LogExecutionTime logExecutionTime) {
        System.out.println("Вызов метода");
        long start = System.currentTimeMillis();
        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("Завершение метода " + proceedingJoinPoint.getSignature().getName() + " " + (end - start));
        }

        /*
        @Around("execution(* com.example.demo.redis.aop.Service2.getUserData(int))")
        public void

         */
    }



}
