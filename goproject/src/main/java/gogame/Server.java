package gogame;
import java.io.*;
import org.hibernate.cfg.Configuration;
import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class Server {
	
	static int size=9, bot, pas=0, x, y;
	static String answer;
    static ArrayList<Player> players = new ArrayList<>();
    static Integer lastId;

   
	ServerSocket server;

	public Server() {

		Configuration con= new Configuration().configure().addAnnotatedClass(Game.class);
		con.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		ServiceRegistry reg =new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		@SuppressWarnings("deprecation")
		SessionFactory sf = con.buildSessionFactory();
	
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Game game = new Game();
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		game.setDate(sqlDate);
		session.save(game);
		
		tx.commit();
		
		final String sql = "SELECT max(id) FROM Game";
		lastId = (Integer) session.createQuery( sql ).uniqueResult();
		System.out.println(lastId);
		
		GameLogic gamelogic = new GameLogic(lastId);
		try {
			server = new ServerSocket(5011); 
			ExecutorService pool = Executors.newFixedThreadPool(200);
			while(true) {
				Player player1= new Player(server.accept(), 'B', gamelogic, lastId);
				players.add(player1);
				pool.execute(player1);
				Player player2= new Player(server.accept(), 'W', gamelogic, lastId);
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