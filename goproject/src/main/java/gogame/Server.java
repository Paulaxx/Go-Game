package gogame;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {
	
	static int size=9, bot, pas=0, x, y;
	static String answer;
    static ArrayList<Player> players = new ArrayList<>();

   
	ServerSocket server;

	public Server() {
		
		GameLogic gamelogic = new GameLogic();
		
		try {
			server = new ServerSocket(5011); 
			ExecutorService pool = Executors.newFixedThreadPool(200);
			while(true) {
				Player player1= new Player(server.accept(), 'B', gamelogic);
				players.add(player1);
				pool.execute(player1);
				Player player2= new Player(server.accept(), 'W', gamelogic);
				players.add(player2);
				pool.execute(player2);
			}
		}
		catch (IOException e) {
			System.out.println("Could not listen on port 5001"); 
			System.exit(-1);
		}
	}
	
	
	public static void main(String[] args){
		
		new Server();
			
	}	

}