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
    int i,j,Tposition, Nposition;
    
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
				@SuppressWarnings("unchecked")
				ArrayList<String> fromSocket = (ArrayList<String>) in.readObject();
				if(fromSocket.get(0).equals("T")) {
					
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							if(fromSocket.size()==5)
								Client.controller.buttonb(fromSocket.get(1), fromSocket.get(2), fromSocket.get(3), fromSocket.get(4));
							else if(fromSocket.size()>5)
							{
								Tposition=0;
								for(j=5;j<fromSocket.size();j++) {
									if(fromSocket.get(j).equals("T")) {
										Tposition=j;
									}
								}
								
								Nposition=0;
								for(j=5;j<fromSocket.size();j++) {
									if(fromSocket.get(j).equals("N")) {
										Nposition=j;
									}
								}
								if(Nposition!=0) {
									Client.controller.botpas();
								}
								
								if(Tposition==0) {
									
									Client.controller.buttonb(fromSocket.get(1), fromSocket.get(2), fromSocket.get(3), fromSocket.get(4));
									for(i=5;i<fromSocket.size();i=i+2) {
										Client.controller.delete(fromSocket.get(i), fromSocket.get(i+1));
									}
								}
								else {
									Client.controller.buttonb(fromSocket.get(1), fromSocket.get(2), fromSocket.get(3), fromSocket.get(4));
									for(i=5;i<fromSocket.size();i=i+2) {
										
										if(i<Tposition) {
											Client.controller.delete(fromSocket.get(i), fromSocket.get(i+1));
										}
										else if(i==Tposition){
											Client.controller.buttonb(fromSocket.get(i+1), fromSocket.get(i+2), fromSocket.get(i+3), fromSocket.get(4));
											i=i+2;
										}
										else {
											Client.controller.delete(fromSocket.get(i), fromSocket.get(i+1));
										}
									}

								}
								
								
							}							
						}
					});
					
					
				}
				
				else if(fromSocket.get(0).equals("N")) {
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							Client.controller.illegalmove();
						}
					});
				}
				
				else if(fromSocket.get(0).equals("pas")) {
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							Client.controller.pas();
						}
					});
				}
				
				else if(fromSocket.get(0).equals("koniec")) {
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							Client.controller.end(Integer.parseInt(fromSocket.get(1)), Integer.parseInt(fromSocket.get(2)));
						}
					});
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
