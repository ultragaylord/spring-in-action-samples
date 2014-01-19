package com.nijiiro.ufo.springidol;

public class Stage {
	
	private Stage(){
		System.out.println("You're in a single stage... ");
	}
		
		private static class StageSingletonHolder {
		static Stage instance = new Stage();
	}
	public static Stage getInstance(){
		return StageSingletonHolder.instance;
	}
}
