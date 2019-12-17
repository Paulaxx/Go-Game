package gogame;

import org.junit.Test;

public class BotTest {
	
	@Test
	public void Test() {
	
		GameLogic gamelogic = new GameLogic();
		gamelogic.resetBoard();
		gamelogic.resetBotBoard();
		gamelogic.changeColor();
		gamelogic.Board[3][1]= "white";
		gamelogic.Board[4][1]= "white";
		gamelogic.Board[5][1]= "white";
		gamelogic.Board[2][2]= "white";
		gamelogic.Board[6][2]= "white";
		gamelogic.Board[1][3]= "white";
		gamelogic.Board[4][3]= "white";
		gamelogic.Board[5][3]= "white";
		gamelogic.Board[2][4]= "white";
		gamelogic.Board[4][4]= "white";
		gamelogic.Board[5][4]= "white";
		gamelogic.Board[6][4]= "white";
		gamelogic.Board[1][5]= "white";
		gamelogic.Board[7][5]= "white";
		gamelogic.Board[1][6]= "white";
		gamelogic.Board[4][6]= "white";
		gamelogic.Board[6][6]= "white";
		gamelogic.Board[2][7]= "white";
		gamelogic.Board[4][7]= "white";
		gamelogic.Board[5][7]= "white";

		gamelogic.Board[3][2]= "black";
		gamelogic.Board[4][2]= "black";
		gamelogic.Board[5][2]= "black";
		gamelogic.Board[2][3]= "black";
		gamelogic.Board[3][3]= "black";
		gamelogic.Board[3][4]= "black";
		gamelogic.Board[2][5]= "black";
		gamelogic.Board[3][5]= "black";
		gamelogic.Board[4][5]= "black";
		gamelogic.Board[5][5]= "black";
		gamelogic.Board[6][5]= "black";
		gamelogic.Board[2][6]= "black";
		gamelogic.Board[3][6]= "black";
		gamelogic.Board[5][6]= "black";
		gamelogic.Board[3][7]= "black";
		gamelogic.CopyTheBoard();
		gamelogic.CopyThe2Board();

	
		gamelogic.updateBotBoard();
		gamelogic.showBotBoard();
		
		System.out.println(gamelogic.botBoard[3][8]);
		
		
	}	
}

