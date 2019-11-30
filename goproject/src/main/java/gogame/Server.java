package gogame;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {
		
	static String[][] Board;
	static int size, bot, pas=0, x, y;
	static String actualColor="white", answer;
	
	ServerSocket server;
	Socket client;
	ObjectInputStream in;
	ObjectOutputStream out;
	
	
	public Server() {
		try {
			server = new ServerSocket(4444); 
		}
		catch (IOException e) {
			System.out.println("Could not listen on port 4444"); 
			System.exit(-1);
		}
		this.listenSocket();
	}
	
	
	public void listenSocket() {
		
        try {
            client = server.accept();
        } 
        catch (IOException e) {
        	System.out.println("Accept failed: 4444"); 
        	System.exit(-1);
        }
        
        
        try {
        	
            in = new ObjectInputStream(client.getInputStream());
            out = new ObjectOutputStream(client.getOutputStream());

            while(in != null) {
            	@SuppressWarnings("unchecked")
				ArrayList<String> fromSocket = (ArrayList<String>)in.readObject();
            	String whatChoosen = fromSocket.get(0);
        		
            	if(whatChoosen.contentEquals("size")) {
            		size=Integer.parseInt(fromSocket.get(1));
            		Board = new String[size][size];
            		out.writeObject(answer);
            	}
            	else if(whatChoosen.contentEquals("bot")) {
            		bot=Integer.parseInt(fromSocket.get(1));
            		out.writeObject(answer);
            	}
            	else if(whatChoosen.contentEquals("pas")) {
            		//TO DO: co robi kiedy pasują
            		out.writeObject(answer); //usunac przy wysylaniu innych danych
            	}
            	else if(whatChoosen.contentEquals("black")) {
            		System.out.println("Server send: "+answer);
            		x=Integer.parseInt(fromSocket.get(1));
            		y=Integer.parseInt(fromSocket.get(2));
            		//TO DO: sprawdza na podstawie tablicy Board czy na danych wspolrzednych(x,y) mozna tam postawic pionka
            		// jak mozna to wysyla do clienta 'T'  out.writeObject("T");
            		// jak nie to wysyla 'N' out.writeObject("N");
            		System.out.println("Server send: "+answer);
            		out.writeObject(answer); //usunac przy wysylaniu innych danych
            	}
            	else if(whatChoosen.contentEquals("white")) {
            		x=Integer.parseInt(fromSocket.get(1));
            		y=Integer.parseInt(fromSocket.get(2));
            		//TO DO: sprawdza na podstawie tablicy Board czy na danych wspolrzednych(x,y) mozna tam postawic pionka
            		// jak mozna to wysyla do clienta 'T'  out.writeObject("T");
            		// jak nie to wysyla 'N' out.writeObject("N");
            		out.writeObject(answer); //usunac przy wysylaniu innych danych
            	}
            	
            	
            	
            	
            }

        } 
        catch(IOException | ClassNotFoundException e) {
        	//System.out.println("Accept failed: 4444");
            System.exit(-1);
        }
	
	}
	
	
	
	protected void finalize() {
        try {
            in.close();
            out.close();
            client.close();
            server.close();
        } 
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
	
	
	
public static void main(String[] args){
		
		new Server();
	}		
}