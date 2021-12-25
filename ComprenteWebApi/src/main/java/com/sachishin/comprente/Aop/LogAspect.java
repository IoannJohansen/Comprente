package com.sachishin.comprente.Aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("execution(public * com.sachishin.comprente.Controller.TechniqueController.CreateTechnique(..))")
    public void addTechniqueMethod() {}

    @Before("addTechniqueMethod()")
    public void beforeAddTechnique() {
        log.info("Start of create technique method");
    }

    @After("addTechniqueMethod()")
    public void afterAddTechnique() {
        log.info("End of create technique method");
    }

    @Around("addTechniqueMethod()")
    public Object aroundAddTechnique(ProceedingJoinPoint jp) throws Throwable {
        long start = System.currentTimeMillis();
        Object res = jp.proceed();
        long end = System.currentTimeMillis();
        log.info("Execution of create technique " + (end - start) + "msec.");
        return res;
    }

    @AfterThrowing(pointcut = "addTechniqueMethod()", throwing = "e")
    public void afterThrowingAddTechnique(Exception e) {
        log.info("Error: " + e.getMessage());
    }

    //---------

    @Pointcut("execution(public * com.sachishin.comprente.Controller.TechniqueController.UpdateTechnique(..))")
    public void updateTechniqueMethod() {}

    @Before("updateTechniqueMethod()")
    public void beforeUpdateTechnique() {
        log.info("Start of update technique method");
    }

    @After("updateTechniqueMethod()")
    public void afterUpdateTechnique() {
        log.info("End of update technique method");
    }

    @Around("updateTechniqueMethod()")
    public Object aroundUpdateTechnique(ProceedingJoinPoint jp) throws Throwable {
        long start = System.currentTimeMillis();
        Object res = jp.proceed();
        long end = System.currentTimeMillis();
        log.info("Execution of update technique " + (end - start) + "msec.");
        return res;
    }

    @AfterThrowing(pointcut = "updateTechniqueMethod()", throwing = "e")
    public void afterThrowingUpdateTechnique(Exception e) {
        log.info("Error: " + e.getMessage());
    }

    //--------------

    @Pointcut("execution(public * com.sachishin.comprente.Controller.TechniqueController.RemoveTechById(..))")
    public void removeTechniqueMethod() {}

    @Before("removeTechniqueMethod()")
    public void beforeRemoveTechnique() {
        log.info("Start of update technique method");
    }

    @After("removeTechniqueMethod()")
    public void afterRemoveTechnique() {
        log.info("End of update technique method");
    }

    @Around("removeTechniqueMethod()")
    public Object aroundRemoveTechnique(ProceedingJoinPoint jp) throws Throwable {
        long start = System.currentTimeMillis();
        Object res = jp.proceed();
        long end = System.currentTimeMillis();
        log.info("Execution of update technique " + (end - start) + "msec.");
        return res;
    }

    @AfterThrowing(pointcut = "removeTechniqueMethod()", throwing = "e")
    public void afterThrowingRemoveTechnique(Exception e) {
        log.info("Error: " + e.getMessage());
    }

    //---------------

    @Pointcut("execution(public * com.sachishin.comprente.Controller.RentController.ChangeRentStatus(..))")
    public void changeRentStatusMethod() {}

    @Before("changeRentStatusMethod()")
    public void beforeChangeRentStatus() {
        log.info("Start of change rent status method");
    }

    @After("changeRentStatusMethod()")
    public void afterChangeRentStatus() {
        log.info("End of change rent status method");
    }

    @Around("changeRentStatusMethod()")
    public Object aroundChangeRentStatus(ProceedingJoinPoint jp) throws Throwable {
        long start = System.currentTimeMillis();
        Object res = jp.proceed();
        long end = System.currentTimeMillis();
        log.info("Execution of change rent status " + (end - start) + "msec.");
        return res;
    }

    @AfterThrowing(pointcut = "changeRentStatusMethod()", throwing = "e")
    public void afterThrowingChangeRentStatus(Exception e) {
        log.info("Error: " + e.getMessage());
    }

    //--------------

    @Pointcut("execution(public * com.sachishin.comprente.Controller.BillController.AddBill(..))")
    public void addBillMethod() {}

    @Before("addBillMethod()")
    public void beforeAddBill() {
        log.info("Start of change rent status method");
    }

    @After("addBillMethod()")
    public void afterAddBill() {
        log.info("End of change rent status method");
    }

    @Around("addBillMethod()")
    public Object aroundAddBill(ProceedingJoinPoint jp) throws Throwable {
        long start = System.currentTimeMillis();
        Object res = jp.proceed();
        long end = System.currentTimeMillis();
        log.info("Execution of change rent status " + (end - start) + "msec.");
        return res;
    }

    @AfterThrowing(pointcut = "addBillMethod()", throwing = "e")
    public void afterThrowingAddBill(Exception e) {
        log.info("Error: " + e.getMessage());
    }

    //--------------------

    @Pointcut("execution(public * com.sachishin.comprente.Controller.BillController.*(..))")
    public void billMethods() {}

    @AfterThrowing(pointcut = "billMethods()", throwing = "e")
    public void afterBillThrowing(Exception e){
        log.error("Error in bill controller: " + e.getMessage());
    }

    //---------------------

    @Pointcut("execution(public * com.sachishin.comprente.Controller.AuthController.*(..))")
    public void authMethods() {}

    @AfterThrowing(pointcut = "authMethods()", throwing = "e")
    public void afterAuthThrowing(Exception e){
        log.error("Error in auth controller: " + e.getMessage());
    }

    //-------------------

    @Pointcut("execution(public * com.sachishin.comprente.Controller.RentController.*(..))")
    public void rentMethods() {}

    @AfterThrowing(pointcut = "rentMethods()", throwing = "e")
    public void afterRentThrowing(Exception e){
        log.error("Error in rent controller: " + e.getMessage());
    }

    //---------------------

    @Pointcut("execution(public * com.sachishin.comprente.Controller.TechniqueController.*(..))")
    public void techMethods() {}

    @AfterThrowing(pointcut = "techMethods()", throwing = "e")
    public void afterAnyThrowing(Exception e){
        log.error("Error in technique controller: " + e.getMessage());
    }
}
