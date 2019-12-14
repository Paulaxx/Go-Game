package gogame;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

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
    FXMLLoader loader = new FXMLLoader();
    Parent container;
    Controller controller;
    
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
			while(true) {
				String fromSocket = (String)in.readObject();
				System.out.println(fromSocket+"powinien zniknac pionek");
				loader.setLocation(getClass().getResource("/fxml/GameBorder9.fxml"));
				try {
					container=loader.load();
					controller=loader.getController();
				} catch (IOException e) {
					e.printStackTrace();
				}
				controller.buttonb().setVisible(false);
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
