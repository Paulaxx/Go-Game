package gogame;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

//TO DO: dopisac wysylanie do przeciwnika zeby uaktualnial swoja plansze
//usuniecie actualColor
//zmienic wysylane komunikaty do klientow

public class Player implements Runnable{
	
	char color; //which player('B'-black, 'W'-white)
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
            output.writeObject(Server.answer);
            while(true) {
            	@SuppressWarnings("unchecked")
				ArrayList<String> fromSocket = (ArrayList<String>)input.readObject();
            	String whatChoosen = fromSocket.get(0);
        		
            	if(whatChoosen.contentEquals("size")) {
            		Server.size=Integer.parseInt(fromSocket.get(1));
            		//Server.Board = new String[Server.size][Server.size];
            		 for (Player someplayer : Server.players) {
                         someplayer.output.writeObject("size");
                     }
            	}
            	else if(whatChoosen.contentEquals("bot")) {
            		Server.bot=Integer.parseInt(fromSocket.get(1));
            		for (Player someplayer : Server.players) {
                        someplayer.output.writeObject("bot");
                    }
            	}
            	else if(whatChoosen.contentEquals("pass")) {
            		for (Player someplayer : Server.players) {
                        someplayer.output.writeObject("bot");
                    }        		
            	}
            	else if(whatChoosen.contentEquals("F5")) {
            		output.writeObject("F5");     		
            	}
            	else if(whatChoosen.contentEquals("movee")) {
            		Server.x=Integer.parseInt(fromSocket.get(1));
            		Server.y=Integer.parseInt(fromSocket.get(2));
         
            		for (Player someplayer : Server.players) {
                        someplayer.output.writeObject("bot");
                    }
            		
            		/*if(CanYouInsert(Server.x,Server.y) == true) {
            			
            			gamelogic.Board[x][y] = actualColor;
            			out1.writeObject("T");
            			System.out.println("Serwer wysyla do clienta1: " +"T");
                		out2.writeObject("T");
                		System.out.println("Serwer wysyla do clienta2: " +"T");
            		}
            		else {
            			
            			out1.writeObject("N");
            			System.out.println("Serwer wysyla do clienta1: " +"N");
                		out2.writeObject("N");
                		System.out.println("Serwer wysyla do clienta2: " +"N");
            		}
            		*/
            		
            		// jak nie to wysyla 'N' out.writeObject("N");
            		//out.writeObject(answer); //usunac przy wysylaniu innych danych
            	
            	}	
            }
        } 
        catch(IOException | ClassNotFoundException e) {
        	//System.out.println("Accept failed: 4444");
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