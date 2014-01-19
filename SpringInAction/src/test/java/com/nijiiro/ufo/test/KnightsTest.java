package com.nijiiro.ufo.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nijiiro.ufo.knights.BraveKnight;
import com.nijiiro.ufo.knights.DamselRescuingKnight;
import com.nijiiro.ufo.knights.Knight;
import com.nijiiro.ufo.knights.Quest;

public class KnightsTest {

	
	public void setUp() throws Exception {
		
	}

	/**
	 * Test for the tightly coupled application
	 */
	@Test
	public void testDamselKnight() {
		DamselRescuingKnight knight = new DamselRescuingKnight();
		knight.embarkOnQuest();
	}
	
	@Test
	public void testBraveKnight(){
		Quest mockQuest = mock(Quest.class);
		
		Knight knight = new BraveKnight(mockQuest);
		knight.embarkOnQuest();
		verify(mockQuest,times(1)).embark();
		
	}
	
	@SuppressWarnings("resource")
	@Test
	public void testDIForBraveknight(){
		ApplicationContext context = new ClassPathXmlApplicationContext("knights.xml");
		Knight knight = (Knight) context.getBean("knight");
		knight.embarkOnQuest();
	}
	
	
}
