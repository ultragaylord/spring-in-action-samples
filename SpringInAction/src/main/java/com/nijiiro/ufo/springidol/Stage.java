package com.nijiiro.ufo.springidol;

/**
 * Demonstrates Singleton class which provides a single Stage instance.
 * @author gvargas.local
 *
 */
public class Stage {
	
	private double randomNumber;
	
	/**
	 * sets to private to maintain centralize creation.
	 */
	private Stage(){
		//just set a sample distinction for each instance.
		setRandomNumber(Math.random());
		System.out.println("Stage : You're in a single stage... ");
		
	}
	
	/**
	 * Inner class which provides the single Stage Class creation.
	 * @author gvargas.local
	 *
	 */
	private static class StageSingletonHolder {
		static Stage instance = new Stage();
	}
	
	/**
	 * public method which dispenses a singleton instance.
	 * @return
	 */
	public static Stage getInstance(){
		return StageSingletonHolder.instance;
	}

	public double getRandomNumber() {
		return randomNumber;
	}

	public void setRandomNumber(double randomNumber) {
		this.randomNumber = randomNumber;
	}
}
