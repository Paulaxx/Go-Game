package gogame;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

public class Controller {
	
	static String message= "klikniety";;
	ArrayList<String> toSocket = new ArrayList<>();
	@FXML
	Button button1;


	public void clickmethod(ActionEvent e){
		//toSocket.add(message);
		//circle1.setVisible(false);
		System.out.println("clik");
		
		/*try {
			Client.out.writeObject(toSocket);
			Client.out.flush();
		}
		catch (IOException ex) {
	        ex.printStackTrace();
		}*/
	}

}
