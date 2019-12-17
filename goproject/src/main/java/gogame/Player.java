package gogame;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Player implements Runnable{
	
	char color;
	Socket socket;
	GameLogic gamelogic;
	ObjectInputStream input;
	ObjectOutputStream output;
	Player opponent;

    public Player(Socket socket, char color, GameLogic gamelogic) throws IOException{
        this.socket = socket;
        this.color = color;
        this.gamelogic = gamelogic;
        
    }
    
    public void run() {

    	try {
    		
    		input = new ObjectInputStream(socket.getInputStream());
            output = new ObjectOutputStream(socket.getOutputStream());
            
            
            
            while(true) {
            	@SuppressWarnings("unchecked")
				ArrayList<String> fromSocket = (ArrayList<String>)input.readObject();
            	String whatChoosen = fromSocket.get(0);
            	System.out.println("Player"+fromSocket);
        		
            	if(whatChoosen.contentEquals("click")) {
            		gamelogic.Insert(Integer.parseInt(fromSocket.get(1))+1,Integer.parseInt(fromSocket.get(2))+1); 
            		
            		for (Player someplayer : Server.players) {
            			System.out.println("In player : " + gamelogic.message);
                        someplayer.output.writeObject(gamelogic.message);
                        someplayer.output.reset();
                        
                    }
            		
            		gamelogic.message.clear();
            		gamelogic.message.removeAll(gamelogic.message);
            	}
            }
        } 
        catch(IOException | ClassNotFoundException e) {
            System.exit(-1);
        }    
    	finally {
    		try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
    		try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    }

}