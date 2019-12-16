package gogame;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

import javafx.application.Platform;

public class ServerConnection implements Runnable{

	private Socket server;
    private ObjectInputStream in;
    //Parent container;
    //Controller controller;
    //FXMLLoader loader;
    Client client;
    
    public ServerConnection(Socket s) {
		server=s;
		try {
			in = new ObjectInputStream(Client.Socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	
	@Override
	public void run() {
		try {
			/*loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource("/fxml/GameBorder9.fxml"));
			try {
				container=loader.load();
				controller=loader.getController();
			} catch (IOException e) {
				e.printStackTrace();
			}*/
			
			while(true) {
				@SuppressWarnings("unchecked")
				ArrayList<String> fromSocket = (ArrayList<String>)in.readObject();
				System.out.println("ServerConnection"+fromSocket);
				
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						Client.controller.buttonb(fromSocket.get(1), fromSocket.get(2), fromSocket.get(3));
					}
				});
			}
		}
		catch (Exception ex) {}
		finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
