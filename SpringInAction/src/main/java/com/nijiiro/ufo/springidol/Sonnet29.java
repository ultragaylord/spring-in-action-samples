package com.nijiiro.ufo.springidol;

/**
 * Implementation class for {@link Poem} interface.
 * Demonstrate the constructor-arg using reference.
 * @author gvargas.local
 *
 */
public class Sonnet29 implements Poem {
	
	private static String [] LINES={
			"When,in disgrace with fortune and men's eyes,",
			"I all alone be weep my out cast state",
			"And trouble deaf heaven with my bootless cries",
			"And look upon myself and curse my fate,",
			"Wishing me like to one more rich in hope,",
			"Featured like him,like him with friends possess'd,",
			"Desiring this man's art and that man's scope,",
			"With what I mosten joy contented least;",
			"Yet in these thoughts myself almost despising,",
			"Haply I think on thee, and then my state,",
			"Like to the lark at break  of day arising",
			"From sullen earth,sings hymns at heaven'sgate;",
			"Forthy sweet love remember'd such wealth brings",
			"That then I scorn to change my state with kings."};
	
	public void recite() {
		for(String line: LINES){
			System.out.println(line);
		}

	}

}
