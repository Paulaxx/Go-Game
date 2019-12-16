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
            /*for (Player someplayer : Server.players) {
                someplayer.output.writeObject("1");
            }*/
            
            while(true) {
            	@SuppressWarnings("unchecked")
				ArrayList<String> fromSocket = (ArrayList<String>)input.readObject();
            	String whatChoosen = fromSocket.get(0);
            	System.out.println("Player"+fromSocket);
        		
            	if(whatChoosen.contentEquals("size")) {
            		Server.size=Integer.parseInt(fromSocket.get(1));
            		 for (Player someplayer : Server.players) {
                         someplayer.output.writeObject(color+"size"+Server.size);
                     }
            	}
            	if(whatChoosen.contentEquals("move")) {
            		 for (Player someplayer : Server.players) {
                         someplayer.output.writeObject(color+"move"+fromSocket.get(1)+fromSocket.get(2));
                     }
            	}
            	else if(whatChoosen.contentEquals("bot")) {
            		Server.bot=Integer.parseInt(fromSocket.get(1));
            		for (Player someplayer : Server.players) {
                        someplayer.output.writeObject(color+"bot"+Server.bot);
                    }
            	}
            	else if(whatChoosen.contentEquals("pass")) {
            		for (Player someplayer : Server.players) {
                        someplayer.output.writeObject(color+"pass");
                    }        		
            	}
            	else if(whatChoosen.contentEquals("F5")) {
            		for (Player someplayer : Server.players) {
                        someplayer.output.writeObject(color+"F5");
                    }  		
            	}
            	else if(whatChoosen.contentEquals("movee")) {
            		//Server.x=Integer.parseInt(fromSocket.get(1));
            		//Server.y=Integer.parseInt(fromSocket.get(2));
         
            		for (Player someplayer : Server.players) {
                        someplayer.output.writeObject(color+"move");
                    }
            		           	
            	}	
            	else if(whatChoosen.contentEquals("click")) {
            		//sprawdzanie czy mozna
            		ArrayList<String> sent = new ArrayList<String>();
            		sent.add("T");
            		sent.add("black");
            		sent.add(fromSocket.get(1));
            		sent.add(fromSocket.get(2));
            		for (Player someplayer : Server.players) {
                        someplayer.output.writeObject(sent);
                    }
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