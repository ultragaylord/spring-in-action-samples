package com.nijiiro.ufo.knights;

/**
 * An example implementation of loosely coupled object.
 * This type of knight also implements the Knight interface
 * and compared to {@link DamselRescuingKnight} this knight
 * accepts a {@link Quest} interface making it flexible
 * to anything which implements quest interface. Quest
 * is injected into BraveKnight which differs from
 * {@link DamselRescuingKnight} which creates his own
 * {@link RescueDamselQuest} object.
 * 
 * @author gAiL
 *
 */
public class BraveKnight implements Knight {

	private Quest quest;
	
	/**
	 * Injects Quest interface into {@link BraveKnight}
	 * so he can embark on a quest.
	 * 
	 * @param quest
	 */
	public BraveKnight(Quest quest){
		this.quest = quest;
	}
	
	public void embarkOnQuest() {
		quest.embark();
	}

}
