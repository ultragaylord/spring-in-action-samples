package com.nijiiro.ufo.springidol;

/**
 * Demonstrates the contructor-arg with ref and value.
 * {@link PoeticJuggler} depends on {@link Poem} 
 * this describes the injection of {@link Poem} into {@link PoeticJuggler}
 * via contructor-arg.
 * 
 * @author gvargas.local
 *
 */
public class PoeticJuggler extends Juggler {

	private Poem poem;
	
	public PoeticJuggler(Poem poem) {
		super();
		this.poem = poem;
	}
	
	public PoeticJuggler(int beanBags,Poem poem){
		super(beanBags);
		this.poem=poem;
	}
	
	public void perform() {
		super.perform();
		System.out.println("While Reciting...");
		poem.recite();
	}

}
