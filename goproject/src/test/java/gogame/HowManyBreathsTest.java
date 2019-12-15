package gogame;

import static org.junit.Assert.*;

import org.junit.Test;

public class HowManyBreathsTest {
	
	@Test
	public void Test() {
	
		GameLogic gamelogic = new GameLogic(9);
		gamelogic.resetBoard();
		int i,j,expected=2;
		
		for(i=2;i<9;i++) {
			
			for(j=2;j<9;j++) {
				
				assertEquals(gamelogic.HowManyBreaths(i, j),4);
			}
		}
		
		
		assertEquals(gamelogic.HowManyBreaths(1, 1),expected);
		assertEquals(gamelogic.HowManyBreaths(1, 9),expected);
		assertEquals(gamelogic.HowManyBreaths(9, 1),expected);
		assertEquals(gamelogic.HowManyBreaths(9, 9),expected);
		
		gamelogic.Board[1][2]="black";
		gamelogic.Board[2][1]="black";
		
		gamelogic.Board[8][9]="white";
		gamelogic.Board[9][8]="white";
		
		gamelogic.Board[8][1]="white";
		gamelogic.Board[9][2]="black";
		
		gamelogic.Board[2][9]="black";
		gamelogic.Board[1][8]="white";
		
		expected = 0;
		
		assertEquals(gamelogic.HowManyBreaths(1, 1),expected);
		assertEquals(gamelogic.HowManyBreaths(1, 9),expected);
		assertEquals(gamelogic.HowManyBreaths(9, 1),expected);
		assertEquals(gamelogic.HowManyBreaths(9, 9),expected);
	}	
}
