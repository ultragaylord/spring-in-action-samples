package com.nijiiro.ufo.springidol;

/**
 * Demonstrates the constructor-arg in spring bean configuration which injects
 * value/s to constructor.
 * 
 * @author gvargas.local
 *
 */
public class Juggler implements Performer {
	
	private int beanBags = 3;
	
	public Juggler(){
		
	}
	
	public Juggler(int beanBags){
		this.beanBags = beanBags;
	}
	public void perform() {
		System.out.println("Juggling "+beanBags + " BeanBags");

	}

}
