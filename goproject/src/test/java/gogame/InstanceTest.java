package gogame;

import static org.junit.Assert.*;

import org.junit.Test;

public class InstanceTest {
	
	@Test
	public void Test() {
	
		GameLogic gamelogic = new GameLogic();
		gamelogic.resetBoard();
		gamelogic.CopyTheBoard();
		gamelogic.Insert(2,2);
		System.out.println(gamelogic.message);
		
		gamelogic.message.clear();
		
		System.out.println(gamelogic.message);
		
		
	}	
}
