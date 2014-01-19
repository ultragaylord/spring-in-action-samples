package com.nijiiro.ufo.knights;

/**
 * Lame class which describes the horrors of
 * coupling.
 * This type of knight can only do damsel-rescuing task.
 * And his quest is tighly coupled with him, meaning
 * We are forced to implement the RescueDamselQuest
 * in order for this knight to function.
 * 
 * 
 * @author gAiL
 *
 */
public class DamselRescuingKnight implements Knight{

	private RescueDamselQuest quest;
	
	/**
	 * Creates a new instance of his quest.
	 * This knight cannot exist without the existence
	 * of this quest.
	 */
	public DamselRescuingKnight(){
		quest = new RescueDamselQuest();
	}
	
	public void embarkOnQuest() {
		quest.embark();
	}

}
