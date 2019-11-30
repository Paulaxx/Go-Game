package gogame;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Player implements Runnable{
	
	char mark; //which player('B'-black, 'W'-white)
	Socket socket;
    Scanner input;
    PrintWriter output;

    public Player(Socket socket, char mark) {
        this.socket = socket;
        this.mark = mark;
    }
    
    public void run() {
        try {
        	input = new Scanner(socket.getInputStream());
            output = new PrintWriter(socket.getOutputStream(), true);
            
        } 
        catch (Exception e) {
            e.printStackTrace();
        } 
        finally {
            try {
            	socket.close();
            } 
            catch (IOException e) {}
        }
    }


	
}
