package gogame;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {
		
	static String[][] Board;
	static int size, bot, pas=0, x, y;
	static String actualColor="white";
	
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
            	if(fromSocket.get(0)=="pas") {
            		//TO DO: co robi kiedy pasują
            	}
            	else if(fromSocket.get(0)=="black") {
            		x=Integer.parseInt(fromSocket.get(1));
            		y=Integer.parseInt(fromSocket.get(2));
            		//TO DO: sprawdza na podstawie tablicy Board czy na danych wspolrzednych(x,y) mozna tam postawic pionka
            		// jak mozna to wysyla do clienta 'T'  out.writeObject("T");
            		// jak nie to wysyla 'N' out.writeObject("N");
            	}
            	else if(fromSocket.get(0)=="white") {
            		x=Integer.parseInt(fromSocket.get(1));
            		y=Integer.parseInt(fromSocket.get(2));
            		//TO DO: sprawdza na podstawie tablicy Board czy na danych wspolrzednych(x,y) mozna tam postawic pionka
            		// jak mozna to wysyla do clienta 'T'  out.writeObject("T");
            		// jak nie to wysyla 'N' out.writeObject("N");
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
	
	
	
public static void main(String[] args) throws IOException{
		ServerSocket ss=new ServerSocket(4994);
		Socket s=ss.accept();
		
		InputStreamReader in = new InputStreamReader(s.getInputStream());
		BufferedReader bf = new BufferedReader(in);
		String properties=bf.readLine();
		size=Integer.parseInt(properties);
		Board = new String [size][size];
		
		new Server();
	}		
}