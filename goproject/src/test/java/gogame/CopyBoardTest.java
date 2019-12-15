package gogame;

import static org.junit.Assert.*;

import org.junit.Test;

public class CopyBoardTest {
	
	@Test
	public void Test() {
	
		GameLogic gamelogic = new GameLogic(9);
		int i=0,j=0;
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		
		for (i=0;i<11;i++) {
			
			for (j=0;j<11;j++) {
				String kamien1=gamelogic.Board[i][j];
				String kamien2=gamelogic.copyBoard[i][j];
				assertTrue(kamien1.equals(kamien2));
				
			}
			
		}
	
	}	
}
