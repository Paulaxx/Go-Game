package gogame;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Client extends JFrame implements ActionListener{
	
	Socket Socket;
    ObjectInputStream in;
    ObjectOutputStream out;
	
	static String firstanswer="", size, bot;
	JMenu move;
	JMenuItem pas, black, white;
	static String toSocket;
	
	public Client(){
		setTitle("Go Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		move = new JMenu("Move");
		pas = new JMenuItem("pas");
		black = new JMenuItem("black");
		white = new JMenuItem("white");
		
		setJMenuBar(menuBar);
		menuBar.add(move);
		move.add(pas);
		move.add(black);
		move.add(white);
		
		move.addActionListener(this);
		pas.addActionListener(this);
		black.addActionListener(this);
		white.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		setLocationRelativeTo(null);
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object z = e.getSource();
		ArrayList<String> toSocket = new ArrayList<>();
		String x,y;
		
		if(z==pas)
			toSocket.add("pass");
		if(z==black) {
			toSocket.add("black");
			x=JOptionPane.showInputDialog("enter the x coordinate:");
			toSocket.add(x);
			y=JOptionPane.showInputDialog("enter the y coordinate:");
			toSocket.add(y);			
		}
		if(z==white) {
			toSocket.add("white");
			x=JOptionPane.showInputDialog("enter the x coordinate:");
			toSocket.add(x);
			y=JOptionPane.showInputDialog("enter the y coordinate:");
			toSocket.add(y);			
		}
		
		try {
			out.writeObject(toSocket);
			out.flush();
		}
		catch (IOException ex) {
	        ex.printStackTrace();
		}
		
		//waiting for data from server
		/*try {
	         String fromSocket = (String)in.readObject(); 
	         label.setText(fromSocket);
	    } 
		catch(Exception ex) {}*/
	}
	
	
	private void listenSocket() {
        try {
            Socket = new Socket("localhost", 4444);
            out = new ObjectOutputStream(Socket.getOutputStream());
            in = new ObjectInputStream(Socket.getInputStream());
        } 
        catch(IOException ex) {
        	System.out.println("No I/O");
            System.exit(-1);
        }
	}
	
	

	
	
	
public static void main(String[] args) throws IOException{
		Socket s=new Socket("localhost", 4994);
		
		PrintWriter out= new PrintWriter (s.getOutputStream());
		size=JOptionPane.showInputDialog("enter size of the board");
		bot=JOptionPane.showInputDialog("Do you want to play with bot?");
		out.println(size);
		out.flush();
		
		Client client = new Client();
		client.setVisible(true);
		client.listenSocket();		
	}
}