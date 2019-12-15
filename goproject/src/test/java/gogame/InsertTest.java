package gogame;

import static org.junit.Assert.*;

import org.junit.Test;

public class InsertTest {
	
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
		
		gamelogic.Insert(3,2);
		gamelogic.changeColor();
		gamelogic.Board[3][2]="empty";
		gamelogic.Insert(3,2);
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		
		gamelogic.Board[3][1]= "black";
		gamelogic.Board[4][2]= "black";
		gamelogic.Board[2][2]= "black";
		gamelogic.Board[3][3]= "black";
		
		gamelogic.changeColor();
		gamelogic.Insert(3,2);
		
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
		
		gamelogic.Insert(4,3);
		gamelogic.Insert(2,2);
		gamelogic.Insert(6,6);
		
		
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
		gamelogic.Insert(3,3);
		gamelogic.Board[3][3]= "empty";
		
		gamelogic.Board[3][2]= "white";
		
		gamelogic.Insert(3,3);
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		
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
		//System.out.println(gamelogic.ChainBreaths(3, 7, gamelogic.actualColor));
		gamelogic.showBoard();
		
		gamelogic.Insert(3,8);
		
		
		gamelogic.Board[4][6]= "empty";
		gamelogic.changeColor();
		gamelogic.Insert(4,6);
		
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		
		gamelogic.Board[2][1]= "white";
		gamelogic.Board[3][1]= "white";
		gamelogic.Board[1][2]= "white";
		gamelogic.Board[4][2]= "white";
		gamelogic.Board[1][3]= "white";
		gamelogic.Board[3][3]= "white";
		gamelogic.Board[1][4]= "white";
		gamelogic.Board[3][5]= "white";
		gamelogic.Board[1][5]= "white";
		gamelogic.Board[2][6]= "white";
		gamelogic.Board[2][2]= "black";
		gamelogic.Board[3][2]= "black";
		gamelogic.Board[2][3]= "black";
		gamelogic.Board[2][4]= "black";
		gamelogic.Board[2][5]= "black";
		
		gamelogic.changeColor();
		
		System.out.println(gamelogic.black_score);
		System.out.println(gamelogic.white_score);
		gamelogic.showBoard();
		
		gamelogic.Insert(3,4);
		gamelogic.changeColor();
		
		System.out.println(gamelogic.black_score);
		System.out.println(gamelogic.white_score);
		gamelogic.showBoard();
		
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		
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
		
		System.out.println(gamelogic.actualColor);
		gamelogic.Insert(3,8);
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		gamelogic.changeColor();
		
		gamelogic.Board[3][1]= "white";
		gamelogic.Board[2][2]= "white";
		gamelogic.Board[4][2]= "white";
		gamelogic.Board[1][3]= "white";
		gamelogic.Board[5][3]= "white";
		gamelogic.Board[2][4]= "white";
		gamelogic.Board[4][4]= "white";
		gamelogic.Board[3][5]= "white";
		gamelogic.Board[3][2]= "black";
		gamelogic.Board[2][3]= "black";
		gamelogic.Board[4][3]= "black";
		gamelogic.Board[3][4]= "black";
		System.out.println(gamelogic.actualColor);
		gamelogic.Insert(3,3);
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		gamelogic.changeColor();
		
		gamelogic.Board[3][1]= "white";
		gamelogic.Board[2][2]= "white";
		gamelogic.Board[4][2]= "white";
		gamelogic.Board[1][3]= "white";
		gamelogic.Board[5][3]= "white";
		gamelogic.Board[2][4]= "white";
		gamelogic.Board[4][4]= "white";
		gamelogic.Board[3][5]= "white";
		gamelogic.Board[3][2]= "black";
		gamelogic.Board[2][3]= "black";
		gamelogic.Board[4][3]= "black";
		gamelogic.Board[3][4]= "white";
		System.out.println(gamelogic.actualColor);
		gamelogic.Insert(3,3);
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		gamelogic.changeColor();
		
		gamelogic.Board[3][1]= "white";
		gamelogic.Board[2][2]= "white";
		gamelogic.Board[4][2]= "white";
		gamelogic.Board[1][3]= "white";
		gamelogic.Board[5][3]= "white";
		gamelogic.Board[2][4]= "white";
		gamelogic.Board[4][4]= "white";
		gamelogic.Board[3][5]= "white";
		gamelogic.Board[3][2]= "black";
		gamelogic.Board[2][3]= "black";
		gamelogic.Board[4][3]= "white";
		gamelogic.Board[3][4]= "black";
		System.out.println(gamelogic.actualColor);
		gamelogic.Insert(3,3);
		gamelogic.changeColor();
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		gamelogic.changeColor();
		
		gamelogic.Board[3][1]= "white";
		gamelogic.Board[2][2]= "white";
		gamelogic.Board[4][2]= "white";
		gamelogic.Board[1][3]= "white";
		gamelogic.Board[5][3]= "white";
		gamelogic.Board[2][4]= "white";
		gamelogic.Board[4][4]= "white";
		gamelogic.Board[3][5]= "white";
		gamelogic.Board[3][2]= "black";
		gamelogic.Board[2][3]= "white";
		gamelogic.Board[4][3]= "black";
		gamelogic.Board[3][4]= "black";
		gamelogic.changeColor();
		System.out.println(gamelogic.actualColor);
		gamelogic.Insert(3,3);
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		gamelogic.changeColor();
		
		gamelogic.Board[3][1]= "white";
		gamelogic.Board[2][2]= "white";
		gamelogic.Board[4][2]= "white";
		gamelogic.Board[1][3]= "white";
		gamelogic.Board[5][3]= "white";
		gamelogic.Board[2][4]= "white";
		gamelogic.Board[4][4]= "white";
		gamelogic.Board[3][5]= "white";
		gamelogic.Board[3][2]= "white";
		gamelogic.Board[2][3]= "black";
		gamelogic.Board[4][3]= "black";
		gamelogic.Board[3][4]= "black";
		System.out.println(gamelogic.actualColor);
		gamelogic.Insert(3,3);
	
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		gamelogic.changeColor();
		
		gamelogic.Board[3][1]= "white";
		gamelogic.Board[2][2]= "white";
		gamelogic.Board[4][2]= "white";
		gamelogic.Board[1][3]= "white";
		gamelogic.Board[5][3]= "white";
		gamelogic.Board[2][4]= "white";
		gamelogic.Board[4][4]= "white";
		gamelogic.Board[3][5]= "white";
		gamelogic.Board[3][2]= "black";
		gamelogic.Board[2][3]= "black";
		gamelogic.Board[4][3]= "white";
		gamelogic.Board[3][4]= "white";
		System.out.println(gamelogic.actualColor);
		gamelogic.Insert(3,3);
		
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		gamelogic.changeColor();
		
		gamelogic.Board[3][1]= "white";
		gamelogic.Board[2][2]= "white";
		gamelogic.Board[4][2]= "white";
		gamelogic.Board[1][3]= "white";
		gamelogic.Board[5][3]= "white";
		gamelogic.Board[2][4]= "white";
		gamelogic.Board[4][4]= "white";
		gamelogic.Board[3][5]= "white";
		gamelogic.Board[3][2]= "black";
		gamelogic.Board[2][3]= "white";
		gamelogic.Board[4][3]= "black";
		gamelogic.Board[3][4]= "white";
		System.out.println(gamelogic.actualColor);
		gamelogic.Insert(3,3);
		
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		gamelogic.changeColor();
		
		gamelogic.Board[3][1]= "white";
		gamelogic.Board[2][2]= "white";
		gamelogic.Board[4][2]= "white";
		gamelogic.Board[1][3]= "white";
		gamelogic.Board[5][3]= "white";
		gamelogic.Board[2][4]= "white";
		gamelogic.Board[4][4]= "white";
		gamelogic.Board[3][5]= "white";
		gamelogic.Board[3][2]= "white";
		gamelogic.Board[2][3]= "black";
		gamelogic.Board[4][3]= "black";
		gamelogic.Board[3][4]= "white";
		System.out.println(gamelogic.actualColor);
		gamelogic.Insert(3,3);
		
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		gamelogic.changeColor();
		
		gamelogic.Board[3][1]= "white";
		gamelogic.Board[2][2]= "white";
		gamelogic.Board[4][2]= "white";
		gamelogic.Board[1][3]= "white";
		gamelogic.Board[5][3]= "white";
		gamelogic.Board[2][4]= "white";
		gamelogic.Board[4][4]= "white";
		gamelogic.Board[3][5]= "white";
		gamelogic.Board[3][2]= "black";
		gamelogic.Board[2][3]= "white";
		gamelogic.Board[4][3]= "white";
		gamelogic.Board[3][4]= "black";
		System.out.println(gamelogic.actualColor);
		gamelogic.Insert(3,3);
		
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		gamelogic.changeColor();
		
		gamelogic.Board[3][1]= "white";
		gamelogic.Board[2][2]= "white";
		gamelogic.Board[4][2]= "white";
		gamelogic.Board[1][3]= "white";
		gamelogic.Board[5][3]= "white";
		gamelogic.Board[2][4]= "white";
		gamelogic.Board[4][4]= "white";
		gamelogic.Board[3][5]= "white";
		gamelogic.Board[3][2]= "white";
		gamelogic.Board[2][3]= "black";
		gamelogic.Board[4][3]= "white";
		gamelogic.Board[3][4]= "black";
		System.out.println(gamelogic.actualColor);
		gamelogic.Insert(3,3);
		
		
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		gamelogic.changeColor();
		
		gamelogic.Board[3][1]= "white";
		gamelogic.Board[2][2]= "white";
		gamelogic.Board[4][2]= "white";
		gamelogic.Board[1][3]= "white";
		gamelogic.Board[5][3]= "white";
		gamelogic.Board[2][4]= "white";
		gamelogic.Board[4][4]= "white";
		gamelogic.Board[3][5]= "white";
		gamelogic.Board[3][2]= "white";
		gamelogic.Board[2][3]= "white";
		gamelogic.Board[4][3]= "black";
		gamelogic.Board[3][4]= "black";
	
		gamelogic.Insert(3,3);
		
		
		
		
		
		
	}	
}
