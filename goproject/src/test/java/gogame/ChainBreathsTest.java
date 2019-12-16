package gogame;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChainBreathsTest {
	
	@Test
	public void Test() {
	
		GameLogic gamelogic = new GameLogic();
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		
		gamelogic.Board[1][1]="black";
		assertTrue(gamelogic.ChainBreaths(1,1,gamelogic.opponentColor)>0);
		
		gamelogic.Board[2][1]="black";
		gamelogic.Board[1][2]="black";
		
		assertTrue(gamelogic.ChainBreaths(1,2,gamelogic.opponentColor)>0);
		assertTrue(gamelogic.ChainBreaths(2,1,gamelogic.opponentColor)>0);
		
		gamelogic.Board[1][3]="white";
		gamelogic.Board[2][2]="white";
		gamelogic.Board[3][1]="white";
		
		
		assertFalse(gamelogic.ChainBreaths(1,1,gamelogic.actualColor)>0);
		assertFalse(gamelogic.ChainBreaths(1,2,gamelogic.actualColor)>0);
		assertFalse(gamelogic.ChainBreaths(2,1,gamelogic.actualColor)>0);
		
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		
		gamelogic.Board[3][4]="white";
		gamelogic.Board[3][3]="white";
		gamelogic.Board[3][2]="white";
		gamelogic.Board[4][2]="white";
		gamelogic.Board[4][3]="white";
		gamelogic.Board[4][1]="white";
		gamelogic.Board[5][2]="white";
		gamelogic.Board[5][3]="white";
		gamelogic.Board[2][3]="white";
		assertTrue(gamelogic.ChainBreaths(4,2,gamelogic.opponentColor)>0);
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		
		gamelogic.Board[4][1]="white";
		gamelogic.Board[3][2]="white";
		assertTrue(gamelogic.ChainBreaths(4,2,gamelogic.opponentColor)>0);
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		
		gamelogic.Board[4][1]="white";
		gamelogic.Board[5][2]="white";
		assertTrue(gamelogic.ChainBreaths(4,2,gamelogic.opponentColor)>0);
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		
		gamelogic.Board[4][1]="white";
		gamelogic.Board[3][2]="white";
		assertTrue(gamelogic.ChainBreaths(4,2,gamelogic.opponentColor)>0);
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		
		gamelogic.Board[5][2]="white";
		gamelogic.Board[4][1]="white";
		gamelogic.Board[3][2]="white";
		assertTrue(gamelogic.ChainBreaths(4,2,gamelogic.opponentColor)>0);
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		
		gamelogic.Board[5][2]="white";
		gamelogic.Board[3][2]="white";
		gamelogic.Board[4][3]="white";
		assertTrue(gamelogic.ChainBreaths(4,2,gamelogic.opponentColor)>0);
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		
		gamelogic.Board[4][1]="white";
		gamelogic.Board[3][2]="white";
		gamelogic.Board[4][3]="white";
		assertTrue(gamelogic.ChainBreaths(4,2,gamelogic.opponentColor)>0);
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		
		gamelogic.Board[4][1]="white";
		gamelogic.Board[5][2]="white";
		gamelogic.Board[4][3]="white";
		assertTrue(gamelogic.ChainBreaths(4,2,gamelogic.opponentColor)>0);
		
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		
		gamelogic.Board[4][1]="white";
		gamelogic.Board[4][3]="white";
		assertTrue(gamelogic.ChainBreaths(4,2,gamelogic.opponentColor)>0);
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		
		gamelogic.Board[5][2]="white";
		gamelogic.Board[3][2]="white";
		assertTrue(gamelogic.ChainBreaths(4,2,gamelogic.opponentColor)>0);
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		
		gamelogic.Board[4][3]="white";
		gamelogic.Board[3][2]="white";
		assertTrue(gamelogic.ChainBreaths(4,2,gamelogic.opponentColor)>0);
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		
		gamelogic.Board[5][2]="white";
		gamelogic.Board[4][3]="white";
		assertTrue(gamelogic.ChainBreaths(4,2,gamelogic.opponentColor)>0);
	}	
}
