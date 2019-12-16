package gogame;

import java.util.ArrayList;

import org.junit.Test;

public class ArrayTest {
	
	@Test
	public void Test() {
	
		ArrayList<String> message = new ArrayList<>();
		
		message.add("1");
		message.add("2");
		message.add("3");
		message.add("4");
		message.add("5");
		
		message.clear();
		
		message.add("1");
		message.add("2");
		
		System.out.println(message);
		
	}	
}