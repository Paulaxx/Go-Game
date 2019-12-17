package gogame;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Player implements Runnable{
	
	char color;
	Socket socket;
	ObjectInputStream input;
	ObjectOutputStream output;
	Player opponent;

    public Player(Socket socket, char color) throws IOException{
        this.socket = socket;
        this.color = color;
    }
    
    public void run() {

    	try {
    		
    		input = new ObjectInputStream(socket.getInputStream());
            output = new ObjectOutputStream(socket.getOutputStream());
            //GameLogic gamelogic = new GameLogic();
            
            while(true) {
            	@SuppressWarnings("unchecked")
				ArrayList<String> fromSocket = (ArrayList<String>)input.readObject();
            	String whatChoosen = fromSocket.get(0);
            	System.out.println("Player"+fromSocket);
        		
            	if(whatChoosen.contentEquals("click")) {
            		ArrayList<String> sent = new ArrayList<String>();
            		sent.add("T");
            		sent.add("black");
            		sent.add(fromSocket.get(1));
            		sent.add(fromSocket.get(2));
            		//gamelogic.Insert(Integer.parseInt(fromSocket.get(1)),Integer.parseInt(fromSocket.get(2)));
            		 
            		//System.out.println(GameLogic.message);
            		for (Player someplayer : Server.players) {
                        //someplayer.output.writeObject(gamelogic.message);
            			someplayer.output.writeObject(sent);
            			
                    }
            		//gamelogic.message.clear();
            		
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