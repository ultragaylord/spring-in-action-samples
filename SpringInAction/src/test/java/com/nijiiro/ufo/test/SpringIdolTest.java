package com.nijiiro.ufo.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nijiiro.ufo.springidol.Auditorium;
import com.nijiiro.ufo.springidol.Instrument;
import com.nijiiro.ufo.springidol.Instrumentalist;
import com.nijiiro.ufo.springidol.Performer;
import com.nijiiro.ufo.springidol.Stage;
import com.nijiiro.ufo.springidol.Ticket;

public class SpringIdolTest {
	
	private static ApplicationContext context;
	
	@BeforeClass
	public static void initializeAppContext(){
		context = new ClassPathXmlApplicationContext("spring-idol.xml");
	}
	
	/**
	 * Test for plain constructor-arg example.
	 */
	@Test
	public void performTest() {
		Performer duke = (Performer) context.getBean("duke");
		duke.perform();
	}
	/**
	 * Test for constructor-arg example with reference bean definition 
	 */
	@Test 
	public void poeticJugglerTest(){
		Performer poeticDuke = (Performer) context.getBean("poeticDuke");
		poeticDuke.perform();
	}
	
	/**
	 * Test for the singleton bean stage.
	 * Proves that we are getting the same instance every time this stage bean is called.
	 */
	@Test
	public void singletonBeanTest(){
		Stage firstStage = (Stage) context.getBean("theStage");
		Stage secondStage = (Stage) context.getBean("theStage");
		
		//Note that the println is called only once even though we get the bean twice.
		assertEquals(firstStage,secondStage);
		//These numbers will generate the same instance although the method called is a random double
		System.out.println(firstStage.getRandomNumber());
		//will be exactly same as the firststage.
		System.out.println(secondStage.getRandomNumber());
		
		assertNotNull(firstStage.getRandomNumber());
	}
	
	/**
	 * Test for prototype bean scope.
	 * If bean scope is default (singleton)
	 * myTicket will be same as yourTicket.
	 * 
	 */
	@Test
	public void protoTypeTest(){
		//This type of tickets are define as default (singeton bean) in bean definitions.
		Ticket myTicket = (Ticket) context.getBean("singletonTicket");
		Ticket yourTicket = (Ticket) context.getBean("singletonTicket");
		
		
		System.out.println("This is my singleton ticket :" +myTicket.getTicketNumber());
		System.out.println("This is your singleton ticket :" +yourTicket.getTicketNumber());
		//This assertion will be true for bean singletonTicket
		assertEquals(new BigDecimal(myTicket.getTicketNumber()), new BigDecimal(yourTicket.getTicketNumber()));
		
		//This type of tickets are define as default (singeton bean) in bean definitions.
		Ticket myUniqueTicket = (Ticket) context.getBean("uniqueTicket");
		Ticket yourUniqueTicket = (Ticket) context.getBean("uniqueTicket");
		

		System.out.println("This is my unique ticket :" +myUniqueTicket.getTicketNumber());
		//This will now have a different number since it is define as prototype.
		System.out.println("This is your unique ticket :" +yourUniqueTicket.getTicketNumber());
		//This assertion will be true for bean uniqueTicket defined as scope=prototype.
		assertNotEquals(new BigDecimal(myUniqueTicket.getTicketNumber()), new BigDecimal(yourUniqueTicket.getTicketNumber()));
		
	}
	
	/**
	 * Test for the init-method and destroy-method definition in
	 * spring bean configuration.
	 */
	@Test
	public void auditoriumTest(){
		Auditorium auditorium = (Auditorium) context.getBean("auditorium");
		assertNotNull(auditorium);
		//close the context for the destroy-method to be called.
		//use the impl ClassPathXmlApplicationContext instead of the interface ApplicationContext.
		//just to demonstrate the destroy-method.
		((ClassPathXmlApplicationContext) context).close();
	}
	
	/**
	 * Demonstrates the setter injection.
	 * Injects {@link Instrument} into {@link Instrumentalist} via setter injection
	 * define as property in spring configuration.
	 */
	@Test
	public void instrumentalistTest(){
		//Demonstrates the setter injection by value and reference in spring configuration.
		Instrumentalist kenny = (Instrumentalist) context.getBean("kenny");
		kenny.perform();
		
		/* 	Demonstrates the flexibility of coding by interfaces.
			note that we are still using the same class but different behavior.
			we can inject any Instrument which implements it.
		*/
		Instrumentalist kennyThePianist = (Instrumentalist) context.getBean("kennyThePianist");
		kennyThePianist.perform();
		
		//using namespace 'p' there is no notable difference. <property> and p namespace work equally well.
		Instrumentalist kennySax = (Instrumentalist) context.getBean("kennySax");
		kennySax.perform();
	}
}
