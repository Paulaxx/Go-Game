package gogame;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Controller {
	
	ArrayList<String> toSocket = new ArrayList<>();
	@FXML
	Circle button1;

	
	public void buttonb() {
	    button1.setFill(Color.BLACK);
	}
	
	public void clickmethod(MouseEvent e){
		toSocket.add("click");
		try {
			Client.out.writeObject(toSocket);
			Client.out.flush();
		}
		catch (IOException ex) {
	        ex.printStackTrace();
		}
	}

}
