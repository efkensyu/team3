package com.example.demo.team3;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class Team3AOP {
	@Before("@annotation(getMapping)")
	public void beforeLog(JoinPoint jp,GetMapping getMapping) {
		log.info("【GET開始】");
		log.info("対象メソッド:{}",jp.getSignature());
		log.info("送ったデータ:{}" , Arrays.toString(jp.getArgs()));
	}
	
	@After("@annotation(postMapping)")
	public void afterLog(JoinPoint jp,PostMapping postMapping) {
		log.info("【POST開始】");
		log.info("対象メソッド:{}",jp.getSignature());
		log.info("送ったデータ:{}" , Arrays.toString(jp.getArgs()));
	}

}
