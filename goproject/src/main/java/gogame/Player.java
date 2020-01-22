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
	static int gameId;

    public Player(Socket socket, char color, GameLogic gamelogic, int gameId) throws IOException{
        this.socket = socket;
        this.color = color;
        this.gamelogic = gamelogic;
        Player.gameId=gameId;
        
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
            		if(gamelogic.pas == 1) {
            			
            			gamelogic.changeColor();
            		}
            		gamelogic.pas=0;
            		if(gamelogic.bot == 0) {
            			gamelogic.Insert(Integer.parseInt(fromSocket.get(1))+1,Integer.parseInt(fromSocket.get(2))+1); 
            		}
            		else{
            			gamelogic.Insert(Integer.parseInt(fromSocket.get(1))+1,Integer.parseInt(fromSocket.get(2))+1);
            			gamelogic.updateBotBoard();
            			if(gamelogic.message2.get(0).equals("T")) {
            				gamelogic.Insert(gamelogic.xbot,gamelogic.ybot);
            			}
            			else
            				gamelogic.ifbot=0;
            		}
            	
            		
            		for (Player someplayer : Server.players) {
            			System.out.println("In player : " + gamelogic.message);
                        
            			if(gamelogic.bot == 0) {
            				
            			someplayer.output.writeObject(gamelogic.message2);
                        someplayer.output.reset();
            			}
            			else {
            				someplayer.output.writeObject(gamelogic.message2);
            				if(gamelogic.ifbot == 1) {
            					
            					someplayer.output.writeObject(gamelogic.message);	
            				}
                            someplayer.output.reset();
            				
            			}
                        
                    }
            		if(gamelogic.bot==0) {
            		gamelogic.message.clear();
            		gamelogic.message.removeAll(gamelogic.message);
            		}
            		else {
            		gamelogic.ifbot=1;	
            		gamelogic.message.clear();
                	gamelogic.message.removeAll(gamelogic.message);
                	gamelogic.message2.clear();
                	gamelogic.message2.removeAll(gamelogic.message2);
            			
            		}
            	}
            	else if(whatChoosen.contentEquals("bot")){
            		
            		gamelogic.bot = 1;
            		gamelogic.updateBotBoard();
            		ArrayList<String> Send = new ArrayList<>();
            		Send.add("bot");
            		for (Player someplayer : Server.players) {
            			System.out.println("Returned : " + Send);
                        
            			
            			someplayer.output.writeObject(Send);
            			
            			
            		}
            		Send.clear();
                	Send.removeAll(Send);
            		
            		
            		
            	}
            	else if(whatChoosen.contentEquals("size13")){
            		
            		//gamelogic.size = 13;
            		//gamelogic.resetBoard();
            		//gamelogic.CopyThe2Board();
            		//gamelogic.CopyTheBoard();
            		//gamelogic.resetBotBoard();
            		ArrayList<String> Sendsize = new ArrayList<>();
            		Sendsize.add("size13");
            		for (Player someplayer : Server.players) {
            			System.out.println("Returned : " + Sendsize);
                        
            			
            			someplayer.output.writeObject(Sendsize);
            			
            			
            		}
            		Sendsize.clear();
                	Sendsize.removeAll(Sendsize);
            		
            		
            		
            	}
            	else if(whatChoosen.contentEquals("size19")){
            		
            		//gamelogic.size = 19;
            		//gamelogic.resetBoard();
            		//gamelogic.CopyThe2Board();
            		//gamelogic.CopyTheBoard();
            		//gamelogic.resetBotBoard();
            		ArrayList<String> Sendsize2 = new ArrayList<>();
            		Sendsize2.add("size19");
            		for (Player someplayer : Server.players) {
            			System.out.println("Returned : " + Sendsize2);
                        
            			
            			someplayer.output.writeObject(Sendsize2);
            			
            			
            		}
            		Sendsize2.clear();
                	Sendsize2.removeAll(Sendsize2);
            		
            		
            		
            	}
            	else if(whatChoosen.contentEquals("pas")){
            		
            		ArrayList<String> Sendpas = new ArrayList<>();
            		
            		if(gamelogic.bot == 1) {
            			
            			Sendpas.add("koniec");
            			Sendpas.add(Integer.toString(gamelogic.black_score));
            			Sendpas.add(Integer.toString(gamelogic.white_score));
            			
            		}
            		else{
            			
            			gamelogic.pas++;
            			if(gamelogic.pas == 2) {
            				
            				Sendpas.add("koniec");
                			Sendpas.add(Integer.toString(gamelogic.black_score));
                			Sendpas.add(Integer.toString(gamelogic.white_score));
            				
            			}
            			else {
            				
            				Sendpas.add("pas");
            				
            			}
            			
            		}
            		
            		for (Player someplayer : Server.players) {
            			System.out.println("Returned : " + Sendpas);
                        
            			
            			someplayer.output.writeObject(Sendpas);
            			
            			
            		}
            		Sendpas.clear();
                	Sendpas.removeAll(Sendpas);
            		
            		
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