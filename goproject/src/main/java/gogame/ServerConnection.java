package gogame;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

import javafx.application.Platform;

public class ServerConnection implements Runnable{

	private Socket server;
    private ObjectInputStream in;
    Client client;
    int i;
    
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
				//@SuppressWarnings("unchecked")
				ArrayList<String> fromSocket = (ArrayList<String>) in.readObject();
				if(fromSocket.get(0).equals("T")) {
					
					if(fromSocket.get(4).equals("T")) {
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								Client.controller.buttonb(fromSocket.get(1), fromSocket.get(2), fromSocket.get(3));
								Client.controller.buttonb(fromSocket.get(5), fromSocket.get(6), fromSocket.get(7));
								for(i=8;i<fromSocket.size();i=i+2) {
									Client.controller.delete(fromSocket.get(i), fromSocket.get(i+1));
								}
								if(fromSocket.get(4).equals("N")) {
									Client.controller.endOfGame();
								}
							}
						});
					}
					else {
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							Client.controller.buttonb(fromSocket.get(1), fromSocket.get(2), fromSocket.get(3));
							for(i=4;i<fromSocket.size();i=i+2) {
								Client.controller.delete(fromSocket.get(i), fromSocket.get(i+1));
							}
						}
					});
					}
				}
				else if(fromSocket.get(0).equals("N")) {
					InfoBox.display("Illegal move");
				}
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
