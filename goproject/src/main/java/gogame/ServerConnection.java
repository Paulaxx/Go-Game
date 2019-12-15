package gogame;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ServerConnection implements Runnable{

	private Socket server;
    private ObjectInputStream in;
    Parent container;
    Controller controller;
    static FXMLLoader loader;
    
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
			loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource("/fxml/GameBorder9.fxml"));
			try {
				container=loader.load();
				controller=loader.getController();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			while(true) {
				String fromSocket = (String)in.readObject();
				System.out.println(fromSocket+"powinien zniknac pionek");
				
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						controller.button1.setVisible(false);
					}
				});
				
				System.out.println(fromSocket+"zniknal?");
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
