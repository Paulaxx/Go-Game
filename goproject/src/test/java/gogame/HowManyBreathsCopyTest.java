package gogame;

import static org.junit.Assert.*;

import org.junit.Test;

public class HowManyBreathsCopyTest {
	
	@Test
	public void Test() {
	
		GameLogic gamelogic = new GameLogic(9);
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		int i,j,expected=2;
		
		for(i=2;i<9;i++) {
			
			for(j=2;j<9;j++) {
				
				assertEquals(gamelogic.HowManyBreathsCopy(i, j),4);
			}
		}
		
		
		assertEquals(gamelogic.HowManyBreathsCopy(1, 1),expected);
		assertEquals(gamelogic.HowManyBreathsCopy(1, 9),expected);
		assertEquals(gamelogic.HowManyBreathsCopy(9, 1),expected);
		assertEquals(gamelogic.HowManyBreathsCopy(9, 9),expected);
		
		gamelogic.copyBoard[1][2]="black";
		gamelogic.copyBoard[2][1]="black";
		
		gamelogic.copyBoard[8][9]="white";
		gamelogic.copyBoard[9][8]="white";
		
		gamelogic.copyBoard[8][1]="white";
		gamelogic.copyBoard[9][2]="black";
		
		gamelogic.copyBoard[2][9]="black";
		gamelogic.copyBoard[1][8]="white";
		
		expected = 0;
		
		assertEquals(gamelogic.HowManyBreathsCopy(1, 1),expected);
		assertEquals(gamelogic.HowManyBreathsCopy(1, 9),expected);
		assertEquals(gamelogic.HowManyBreathsCopy(9, 1),expected);
		assertEquals(gamelogic.HowManyBreathsCopy(9, 9),expected);
	}	
}
