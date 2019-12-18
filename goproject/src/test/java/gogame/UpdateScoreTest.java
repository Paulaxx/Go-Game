package gogame;

import static org.junit.Assert.*;

import org.junit.Test;

public class UpdateScoreTest {
	
	@Test
	public void Test() {
	
		GameLogic gamelogic = new GameLogic();
		int bialywynik1=0,bialywynik2=0,czarnywynik1=0,czarnywynik2=0;
		
		bialywynik1=gamelogic.white_score;
		czarnywynik1=gamelogic.black_score;
		if(gamelogic.actualColor.equals("white")) {
			
			gamelogic.UpdateScore(5);
			bialywynik2=gamelogic.white_score;
			
		}
		else if(gamelogic.actualColor.equals("black")) {
			
			gamelogic.UpdateScore(5);
			czarnywynik2=gamelogic.black_score;
			
		}
		
		gamelogic.changeColor();
		
		if(gamelogic.actualColor.equals("white")) {
			
			gamelogic.UpdateScore(5);
			bialywynik2=gamelogic.white_score;
			
		}
		else if(gamelogic.actualColor.equals("black")) {
			
			gamelogic.UpdateScore(5);
			czarnywynik2=gamelogic.black_score;
			
		}
		
		assertEquals(czarnywynik2,5);
		assertEquals(bialywynik2,11);
		gamelogic.changeColor();
		if(gamelogic.actualColor.equals("black")) {
			
			gamelogic.UpdateScore(5);
			czarnywynik2=gamelogic.black_score;
		}
		
		assertEquals(czarnywynik2,10);
		
		
	}	
}
