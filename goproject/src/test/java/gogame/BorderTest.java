package gogame;

import static org.junit.Assert.*;

import org.junit.Test;

public class BorderTest {
	
	@Test
	public void Test() {
	
		GameLogic gamelogic = new GameLogic();
		gamelogic.resetBoard();
		String output1 = gamelogic.Board[0][0];
		String output2 = gamelogic.Board[10][0];
		String output3 = gamelogic.Board[0][10];
		String output4 = gamelogic.Board[10][10];
		assertTrue(output1.equals("border"));
		assertTrue(output2.equals("border"));
		assertTrue(output3.equals("border"));
		assertTrue(output4.equals("border"));
		
	}	
}
