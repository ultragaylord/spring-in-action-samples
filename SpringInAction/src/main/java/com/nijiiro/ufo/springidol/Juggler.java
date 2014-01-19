package com.nijiiro.ufo.springidol;

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
