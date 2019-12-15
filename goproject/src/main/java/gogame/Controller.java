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
	Circle button1;
	@FXML
	GridPane gridPane;

	
	public void buttonb() {
	    button1.setFill(Color.BLACK);
	}
	
	public void clickmethod(MouseEvent e){
		/*toSocket.add("click");
		try {
			Client.out.writeObject(toSocket);
			Client.out.flush();
		}
		catch (IOException ex) {
	        ex.printStackTrace();
		}*/
		Node node = (Node) e.getSource();
    	int x = GridPane.getRowIndex(button1);
    	int y = GridPane.getColumnIndex(button1);
    	System.out.println(x + " " + y);
	}

}
