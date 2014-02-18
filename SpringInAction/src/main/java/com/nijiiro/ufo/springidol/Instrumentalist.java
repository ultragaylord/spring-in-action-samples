package com.nijiiro.ufo.springidol;

/**
 * Demonstrates the setter injection.
 * @author gvargas.local
 *
 */
public class Instrumentalist implements Performer {
	
	private String song;
	private Instrument instrument;
	
	public Instrumentalist(){
	}
	
	public void perform() {
		System.out.println("Performer: Playing " +song +" : ");
		instrument.play();
	}
	
	public void setSong(String song){
		this.song = song;
	}
	
	public String getSong(){
		return song;
	}
	
	public String screamSong(){
		return song;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	
	
	
}
