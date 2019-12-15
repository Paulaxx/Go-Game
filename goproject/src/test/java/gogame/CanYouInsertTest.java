package gogame;

import static org.junit.Assert.*;

import org.junit.Test;

public class CanYouInsertTest {
	
	@Test
	public void Test() {
	
		GameLogic gamelogic = new GameLogic(9);
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		
		gamelogic.Board[2][1]= "black";
		gamelogic.Board[3][1]= "black";
		gamelogic.Board[4][1]= "black";
		gamelogic.Board[4][2]= "black";
		gamelogic.Board[2][2]= "black";
		gamelogic.Board[3][3]= "black";
		gamelogic.Board[2][3]= "white";
		gamelogic.Board[3][4]= "white";
		gamelogic.Board[4][3]= "white";
		
		assertTrue(gamelogic.CanYouInsert(3,2));
		gamelogic.changeColor();
		assertTrue(gamelogic.CanYouInsert(3,2));
		gamelogic.changeColor();
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		
		gamelogic.Board[3][1]= "black";
		gamelogic.Board[4][2]= "black";
		gamelogic.Board[2][2]= "black";
		gamelogic.Board[3][3]= "black";
		
		assertTrue(gamelogic.CanYouInsert(3,2));
		gamelogic.changeColor();
		assertFalse(gamelogic.CanYouInsert(3,2));
		
		
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		
		gamelogic.Board[3][1]= "white";
		gamelogic.Board[4][1]= "white";
		gamelogic.Board[5][1]= "white";
		gamelogic.Board[6][2]= "white";
		gamelogic.Board[2][2]= "white";
		gamelogic.Board[5][3]= "white";
		gamelogic.Board[2][3]= "white";
		gamelogic.Board[4][4]= "white";
		gamelogic.Board[2][4]= "white";
		gamelogic.Board[3][5]= "white";
		gamelogic.Board[4][2]= "black";
		gamelogic.Board[3][2]= "black";
		gamelogic.Board[5][2]= "black";
		gamelogic.Board[3][3]= "black";
		gamelogic.Board[3][4]= "black";

		assertTrue(gamelogic.CanYouInsert(4,3));
		
		
		assertFalse(gamelogic.CanYouInsert(2,2));
		assertTrue(gamelogic.CanYouInsert(6,6));
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		
		gamelogic.Board[2][2]= "white";
		gamelogic.Board[3][4]= "white";
		gamelogic.Board[4][4]= "white";
		gamelogic.Board[2][1]= "black";
		gamelogic.Board[1][2]= "black";
		gamelogic.Board[3][1]= "black";
		gamelogic.Board[4][2]= "black";
		gamelogic.Board[4][3]= "black";
		gamelogic.Board[5][4]= "black";
		gamelogic.Board[4][5]= "black";
		gamelogic.Board[3][5]= "black";
		gamelogic.Board[4][3]= "black";
		gamelogic.Board[2][3]= "black";
		gamelogic.Board[2][4]= "black";
		assertTrue(gamelogic.CanYouInsert(3,3));
		
		gamelogic.Board[3][2]= "white";
		
		assertFalse(gamelogic.CanYouInsert(3,3));
		
		
	}	
}
