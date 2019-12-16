package gogame;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColorChangeTest {
	
	@Test
	public void Test() {
	
		GameLogic gamelogic = new GameLogic();
		String kolor1 = gamelogic.actualColor;
		gamelogic.changeColor();
		String kolor2 = gamelogic.actualColor;
		
		assertFalse(kolor1.equals(kolor2));
		gamelogic.changeColor();
		String kolor3 = gamelogic.actualColor;
		assertTrue(kolor1.equals(kolor3));
	}	
}
