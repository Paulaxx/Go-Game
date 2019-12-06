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
	Socket client1, client2;
	ObjectInputStream in1, in2;
	ObjectOutputStream out1, out2;
	
	//TO DO: przemyslec przelaczanie miedzy klientami zeby serwer wiedzial
	
	
	public Server() {
		try {
			server = new ServerSocket(5001); 
		}
		catch (IOException e) {
			System.out.println("Could not listen on port 5001"); 
			System.exit(-1);
		}
		this.listenSocket();
	}
	
	
	public void listenSocket() {
		
        try {
            client1 = server.accept();
            client2 = server.accept();
        } 
        catch (IOException e) {
        	System.out.println("Accept failed: 4444"); 
        	System.exit(-1);
        }
        
        
        try {
        	//pierwszy- czarny
            in1 = new ObjectInputStream(client1.getInputStream());
            out1 = new ObjectOutputStream(client1.getOutputStream());

            while(in1 != null) {
            	@SuppressWarnings("unchecked")
				ArrayList<String> fromSocket = (ArrayList<String>)in1.readObject();
            	String whatChoosen = fromSocket.get(0);
        		
            	if(whatChoosen.contentEquals("size")) {
            		size=Integer.parseInt(fromSocket.get(1));
            		Board = new String[size][size];
            		out1.writeObject(answer);
            	}
            	else if(whatChoosen.contentEquals("bot")) {
            		bot=Integer.parseInt(fromSocket.get(1));
            		out1.writeObject(answer);
            	}
            	else if(whatChoosen.contentEquals("pass")) {
            		//TO DO: co robi kiedy pasują
            		out1.writeObject(answer); //usunac przy wysylaniu innych danych
            	}
            	else if(whatChoosen.contentEquals("black")) {
            		//System.out.println("Server send: "+answer);
            		x=Integer.parseInt(fromSocket.get(1));
            		y=Integer.parseInt(fromSocket.get(2));
            		actualColor="black";
            		//TO DO: sprawdza na podstawie tablicy Board czy na danych wspolrzednych(x,y) mozna tam postawic pionka
            		
            		if(CanYouInsert(x,y) == true) {
            			
            			Board[x][y] = actualColor;
            			out1.writeObject("T");
            		}
            		else {
            			
            			out1.writeObject("N");
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
            			out1.writeObject("T");
            		}
            		else {
            			
            			out1.writeObject("N");
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
            	System.out.println("from client1:");
            	System.out.println(fromSocket);
            	
            	
            	
            	
            	
            }

            
            while(in2 != null) {
            	@SuppressWarnings("unchecked")
				ArrayList<String> fromSocket2 = (ArrayList<String>)in2.readObject();
            	String whatChoosen = fromSocket2.get(0);
        		
            	if(whatChoosen.contentEquals("size")) {
            		size=Integer.parseInt(fromSocket2.get(1));
            		Board = new String[size][size];
            		out2.writeObject(answer);
            	}
            	else if(whatChoosen.contentEquals("bot")) {
            		bot=Integer.parseInt(fromSocket2.get(1));
            		out2.writeObject(answer);
            	}
            	else if(whatChoosen.contentEquals("pass")) {
            		//TO DO: co robi kiedy pasują
            		out2.writeObject(answer); //usunac przy wysylaniu innych danych
            	}
            	else if(whatChoosen.contentEquals("black")) {
            		//System.out.println("Server send: "+answer);
            		x=Integer.parseInt(fromSocket2.get(1));
            		y=Integer.parseInt(fromSocket2.get(2));
            		actualColor="black";
            		//TO DO: sprawdza na podstawie tablicy Board czy na danych wspolrzednych(x,y) mozna tam postawic pionka
            		
            		if(CanYouInsert(x,y) == true) {
            			
            			Board[x][y] = actualColor;
            			out2.writeObject("T");
            		}
            		else {
            			
            			out2.writeObject("N");
            		}
            		
            		//showBoard();
            		
            		
            		// jak mozna to wysyla do clienta 'T'  out.writeObject("T");
            		// jak nie to wysyla 'N' out.writeObject("N");
            		//System.out.println("Server send: "+answer);
            		//out.writeObject(answer); //usunac przy wysylaniu innych danych
            	}
            	else if(whatChoosen.contentEquals("white")) {
            		x=Integer.parseInt(fromSocket2.get(1));
            		y=Integer.parseInt(fromSocket2.get(2));
            		actualColor="white";
            		//TO DO: sprawdza na podstawie tablicy Board czy na danych wspolrzednych(x,y) mozna tam postawic pionka
            		// jak mozna to wysyla do clienta 'T'  out.writeObject("T");
            		
            		if(CanYouInsert(x,y) == true) {
            			
            			Board[x][y] = actualColor;
            			out2.writeObject("T");
            		}
            		else {
            			
            			out2.writeObject("N");
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
            	System.out.println("from client2:");
            	System.out.println(fromSocket2);
            	
            	
            }
        } 
        catch(IOException | ClassNotFoundException e) {
        	//System.out.println("Accept failed: 4444");
            System.exit(-1);
        }
	
	}
	
	
	
	protected void finalize() {
        try {
            in1.close();
            out1.close();
            client1.close();
            in2.close();
            out2.close();
            client2.close();
            server.close();
        } 
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
	
	
	
	public static void main(String[] args){
		
		//resetBoard();
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
				// nie do poprawy
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