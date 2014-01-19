package com.nijiiro.ufo.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nijiiro.ufo.springidol.Performer;
import com.nijiiro.ufo.springidol.Stage;

public class SpringIdolTest {
	
	private static ApplicationContext context;
	
	@BeforeClass
	public static void initializeAppContext(){
		context = new ClassPathXmlApplicationContext("spring-idol.xml");
	}
	
	@Test
	public void performTest() {
		Performer duke = (Performer) context.getBean("duke");
		duke.perform();
	}
	
	@Test 
	public void poeticJugglerTest(){
		Performer poeticDuke = (Performer) context.getBean("poeticDuke");
		poeticDuke.perform();
	}
	
	@Test
	public void singletonBeanTest(){
		Stage firstStage = (Stage) context.getBean("theStage");
		Stage secondStage = (Stage) context.getBean("theStage");
		//Note that the println is called only once even though we get the bean twice.
		assertEquals(firstStage,secondStage);
	}
	
}
