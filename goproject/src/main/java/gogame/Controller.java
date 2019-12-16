package gogame;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Controller {
	
	ArrayList<String> toSocket = new ArrayList<>();
	@FXML
	GridPane gridPane2;
	@FXML
	Circle button1;

	
	public void buttonb(char x, char y) {
	    button1.setFill(Color.BLACK);
	}
	
	public void clickmethod(MouseEvent e){
		
		Node node = (Node) e.getSource();
		Integer x=GridPane.getRowIndex(node);
		Integer y=GridPane.getColumnIndex(node);
		System.out.println(x+" "+y);
		if(x!=null && y!=null) {
			String X = Integer.toString(x);
			String Y = Integer.toString(y);
			toSocket.add("click");
			toSocket.add(X);
			toSocket.add(Y);
		}
		else if(x!=null) {
			String X = Integer.toString(x);
			toSocket.add("click");
			toSocket.add(X);
			toSocket.add("0");
		}
		else if(y!=null) {
			String Y = Integer.toString(y);
			toSocket.add("click");
			toSocket.add("0");
			toSocket.add(Y);
		}
		else {
			toSocket.add("click");
			toSocket.add("0");
			toSocket.add("0");
		}
		System.out.println(toSocket);
		
		try {
			Client.out.writeObject(toSocket);
			Client.out.flush();
		}
		catch (IOException ex) {
	        ex.printStackTrace();
		}

	}

}
