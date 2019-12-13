package gogame;

import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;

public class Controller {
	
	static String message;
	ArrayList<String> toSocket = new ArrayList<>();

	public void send(ActionEvent e){
		message = "klikniety";
		toSocket.add(message);
		
		try {
			Client.out.writeObject(toSocket);
			Client.out.flush();
		}
		catch (IOException ex) {
	        ex.printStackTrace();
		}
	}

}
