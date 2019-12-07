package gogame;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//TO DO: dopisac obsluge tego co zwraca serwer

public class Client extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	Socket Socket;
    ObjectInputStream in;
    ObjectOutputStream out;
	
	static String firstanswer="";
	JMenu move, properties;
	JMenuItem pas, movee, size, bot;
	static String toSocket, Size, Bot;
	JLabel label;
	
	public Client(){
		setTitle("Go Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		move = new JMenu("Move");
		properties = new JMenu("properties");
		pas = new JMenuItem("pas");
		movee = new JMenuItem("movee");
		size = new JMenuItem("size");
		bot = new JMenuItem("bot");
		
		label = new JLabel();
		label.setBounds(0, 0, 5000, 200);
		add(label);
		
		setJMenuBar(menuBar);
		menuBar.add(move);
		menuBar.add(properties);
		move.add(pas);
		move.add(movee);
		properties.add(size);
		properties.add(bot);
		
		move.addActionListener(this);
		properties.addActionListener(this);
		pas.addActionListener(this);
		movee.addActionListener(this);
		size.addActionListener(this);
		bot.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		setLocationRelativeTo(null);
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object z = e.getSource();
		ArrayList<String> toSocket = new ArrayList<>();
		String x,y;
		
		if(z==size) {
			toSocket.add("size");
			Size=JOptionPane.showInputDialog("enter size of the board");
			toSocket.add(Size);
		}
		else if(z==bot) {
			toSocket.add("bot");
			Bot=JOptionPane.showInputDialog("Do you want to play with bot?");
			toSocket.add(Bot);
		}
		
		else if(z==pas)
			toSocket.add("pass");
		else if(z==movee) {
			toSocket.add("white");
			x=JOptionPane.showInputDialog("enter the x coordinate:");
			toSocket.add(x);
			y=JOptionPane.showInputDialog("enter the y coordinate:");
			toSocket.add(y);			
		}
		
		try {
			
			String fromSocket = (String)in.readObject(); 
	    } 
		catch(Exception ex) {}
		
		try {
			out.writeObject(toSocket);
			out.flush();
		}
		catch (IOException ex) {
	        ex.printStackTrace();
		}
	}
	
	
	private void listenSocket() {
        try {
            Socket = new Socket("localhost", 5001);
            out = new ObjectOutputStream(Socket.getOutputStream());
            in = new ObjectInputStream(Socket.getInputStream());
        } 
        catch(IOException ex) {
        	System.out.println("No I/O");
            System.exit(-1);
        }
	}
	

	
public static void main(String[] args) throws IOException{
		
		Client client = new Client();
		client.setVisible(true);
		client.listenSocket();		
	}
}