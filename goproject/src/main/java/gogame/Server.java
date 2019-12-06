package gogame;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {
	
	//static String[][] Board;
	static int size=9,suma=0,breath_count=0,breath1=-1,breath2=-1,breath3=-1,breath4=-1, bot, pas=0, x, y;
	static String actualColor="white",opponentColor="black",empty="", answer;
    static String[][] Board = new String[size+1][size+1];
    static String[][] copyBoard = new String[size+1][size+1];
   
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
            	else if(whatChoosen.contentEquals("pass")) {
            		//TO DO: co robi kiedy pasują
            		out.writeObject(answer); //usunac przy wysylaniu innych danych
            	}
            	else if(whatChoosen.contentEquals("black")) {
            		//System.out.println("Server send: "+answer);
            		x=Integer.parseInt(fromSocket.get(1));
            		y=Integer.parseInt(fromSocket.get(2));
            		actualColor="black";
            		//TO DO: sprawdza na podstawie tablicy Board czy na danych wspolrzednych(x,y) mozna tam postawic pionka
            		
            		if(CanYouInsert(x,y) == true) {
            			
            			Board[x][y] = actualColor;
            			out.writeObject("T");
            		}
            		else {
            			
            			out.writeObject("N");
            		}
            		
            		//showBoard();
            		
            		
            		// jak mozna to wysyla do clienta 'T'  out.writeObject("T");
            		// jak nie to wysyla 'N' out.writeObject("N");
            		//System.out.println("Server send: "+answer);
            		//out.writeObject(answer); //usunac przy wysylaniu innych danych
            	}
            	else if(whatChoosen.contentEquals("white")) {
            		x=Integer.parseInt(fromSocket.get(1));
            		y=Integer.parseInt(fromSocket.get(2));
            		actualColor="white";
            		//TO DO: sprawdza na podstawie tablicy Board czy na danych wspolrzednych(x,y) mozna tam postawic pionka
            		// jak mozna to wysyla do clienta 'T'  out.writeObject("T");
            		
            		if(CanYouInsert(x,y) == true) {
            			
            			Board[x][y] = actualColor;
            			out.writeObject("T");
            		}
            		else {
            			
            			out.writeObject("N");
            		}
            		
            		//showBoard();
            		//System.out.println(HowManyBreaths(3,4));
            		//System.out.println(CanYouInsert(3,4));
            		//System.out.println(CanTakeOpponentChain(3,4));
            		//changeColor();
            		//System.out.println(CanTakeOpponentChain(3,4));
            		//System.out.println(ChainBreaths(3,3));
            		// jak nie to wysyla 'N' out.writeObject("N");
            		//out.writeObject(answer); //usunac przy wysylaniu innych danych
            	
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
		
		resetBoard();
		new Server();
			
	}	

	static void resetBoard() {
	
		for(int i=0;i<size+1;i++) {
			for(int j=0;j<size+1;j++) {
			 
				if(i == 0 || j == 0 || i == size || j == size) {
					Board[i][j] = "border";	
				}
				else {
					Board[i][j] = "empty";
				}
			}
		}
		
	}
	
	static void showBoard() {
		
		for(int i=0;i<size+1;i++) {
			for(int j=0;j<size+1;j++) {
			 
			System.out.println(Board[i][j]);
			}
			System.out.println(" ");
		}
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
	}

	public void changeColor(){
	
		if(actualColor == "white") {
			opponentColor = actualColor;
			actualColor = "black";
		}
		else {
			opponentColor = actualColor;
			actualColor = "white";	
		}
	
		
	}
	
	public boolean CanYouInsert(int x,int y) {
		
		if(Board[x][y].equals("empty")) {
			
			
			if(HowManyBreaths(x,y) == 0) {
				
				if(CanTakeOpponentChain(x+1,y) == true || CanTakeOpponentChain(x-1,y) == true || CanTakeOpponentChain(x,y+1) == true || CanTakeOpponentChain(x,y-1) == true) {
					
					return true;	
				}
				else {
					
					if(Board[x + 1][y].equals(opponentColor) && Board[x][y + 1].equals(opponentColor) && Board[x - 1][y].equals(opponentColor) && Board[x][y - 1].equals(opponentColor)) {
						
						return false;
					}
					else
					{
						changeColor();
						if(CanTakeOpponentChain(x,y) == true) {
							changeColor();
							return false;
							
						}
						else {
							changeColor();
							return true;
						}
						
					}
							
					
				}
				
			}
			else {
				
				return true;
				
			}
		}
		else {	
			
			return false;		
		}
		
	}
	
	public int HowManyBreaths(int x,int y) {
		
		int breath=0;
		
		if(Board[x + 1][y].equals("empty"))
			breath++;
		if(Board[x][y + 1].equals("empty"))
			breath++;
		if(Board[x - 1][y].equals("empty"))
			breath++;
		if(Board[x][y - 1].equals("empty"))
			breath++;
		
		return breath;
	}
	
	public int ChainBreaths(int x,int y) {
	
		String curColor = copyBoard[x][y];
		
		if(copyBoard[x+1][y].equals(curColor) ) {
			
			copyBoard[x][y]="checked";
			if(HowManyBreaths(x,y) > 0) {
				
				return 1;
				// do poprawy
			}
				
			return ChainBreaths(x+1,y);	
			
		}
		 if(copyBoard[x-1][y].equals(curColor) ) {
			
			 copyBoard[x][y]="checked";
			if(HowManyBreaths(x,y) > 0) {
					
				return 1;
			}
					
			return ChainBreaths(x-1,y);	
			
			
		}
		 if(copyBoard[x][y+1].equals(curColor) ) {
				
			 copyBoard[x][y]="checked";
			if(HowManyBreaths(x,y) > 0) {
					
				return 1;
			}
					
			return ChainBreaths(x,y+1);	
			
			
		}
		 if(copyBoard[x][y-1].equals(curColor) ) {
				
			 copyBoard[x][y]="checked";
			if(HowManyBreaths(x,y) > 0) {
					
				return 1;
			}
					
			return ChainBreaths(x,y-1);	
			
			
		}
		 return 0;
		
	}
	
	public boolean CanTakeOpponentChain(int x,int y) {
		
		
		CopyTheBoard();
		copyBoard[x][y]="checking";
		if(CanTakeOpponentChain2(x,y) == 1) {
			breath_count=0;
			return true;
		}
		else {
			breath_count=0;
			return false;
		}
		
	}
	
	public int CanTakeOpponentChain2(int x,int y) {
		
		if(copyBoard[x+1][y].equals(opponentColor)) {
		
			breath_count+=HowManyBreaths(x+1,y);
			if(breath_count > 0) {
			
				return 0;
			}
			else {
				copyBoard[x+1][y]="checked";
				return  CanTakeOpponentChain2(x+1,y) + CanTakeOpponentChain2(x-1,y) + CanTakeOpponentChain2(x,y+1) + CanTakeOpponentChain2(x,y-1);
			}
		}
		
		if(breath_count > 0) {
			return 0;
		}
	
		if(copyBoard[x-1][y].equals(opponentColor)) {
		
			breath_count+=HowManyBreaths(x-1,y);
			if(breath_count > 0) {
			
				return 0;
			}
			else {
				copyBoard[x-1][y]="checked";
				return CanTakeOpponentChain2(x+1,y) + CanTakeOpponentChain2(x-1,y) + CanTakeOpponentChain2(x,y+1) + CanTakeOpponentChain2(x,y-1);
			}
		}
		
		if(breath_count > 0) {
			return 0;
		}
	
		if(copyBoard[x][y+1].equals(opponentColor)) {
		
			breath_count+=HowManyBreaths(x,y+1);
			if(breath_count > 0) {
			
				return 0;
			}
			else {
				copyBoard[x][y+1]="checked";
				return CanTakeOpponentChain2(x+1,y) + CanTakeOpponentChain2(x-1,y) + CanTakeOpponentChain2(x,y+1) + CanTakeOpponentChain2(x,y-1);
			}
		}
		
		if(breath_count > 0) {
			return 0;
		}
		
		if(copyBoard[x][y-1].equals(opponentColor)) {
		
			breath_count+=HowManyBreaths(x,y-1);
			if(breath_count > 0) {
			
				return 0;
			}
			else {
				copyBoard[x][y-1]="checked";
				return CanTakeOpponentChain2(x+1,y) + CanTakeOpponentChain2(x-1,y) + CanTakeOpponentChain2(x,y+1) + CanTakeOpponentChain2(x,y-1);
			}
		}
		
		if(breath_count > 0) {
			return 0;
		}
		
	return 1;
		
		
		
	}
	
	static void CopyTheBoard() {
		
		int i,j;
		for(i=0;i<size+1;i++) {
			
			for(j=0;j<size+1;j++) {
				
				copyBoard[i][j]=Board[i][j];
				
			}
			
		}
			
		
		
	}
	
	
		
		
	
	
	
//funkcja liczaca punkty
//funkcja sprawdzajaca czy mozna wstawic (czy nic tam nie stoi i czy nie samobojstwo)


//public 

}