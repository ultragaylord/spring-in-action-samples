package com.nijiiro.ufo.springidol;

/**
 * Sample Ticket Class which generates a random number
 * upon creation.
 * 
 * Normally if access as default bean this will return a same ticket number (singleton)
 * But will be define as prototype in bean configuration
 * and will test that scope="prototype" will return a different numbers.
 * 
 * @author gvargas.local
 *
 */
public class Ticket {
	
	private double ticketNumber;
	
	public double getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(double ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	private Ticket(){
		//sets a random number for checking of the bean scoping.
		setTicketNumber(Math.random());
		System.out.println("issued ticket : " +getTicketNumber());
	}
	
}
