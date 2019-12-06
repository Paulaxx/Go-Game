package gogame;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Client extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	Socket Socket;
    ObjectInputStream in;
    ObjectOutputStream out;
	
	static String firstanswer="";
	JMenu move, properties;
	JMenuItem pas, black, white, size, bot;
	static String toSocket, Size, Bot;
	
	public Client(){
		setTitle("Go Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		move = new JMenu("Move");
		properties = new JMenu("properties");
		pas = new JMenuItem("pas");
		black = new JMenuItem("black");
		white = new JMenuItem("white");
		size = new JMenuItem("size");
		bot = new JMenuItem("bot");
		
		setJMenuBar(menuBar);
		menuBar.add(move);
		menuBar.add(properties);
		move.add(pas);
		move.add(black);
		move.add(white);
		properties.add(size);
		properties.add(bot);
		
		move.addActionListener(this);
		properties.addActionListener(this);
		pas.addActionListener(this);
		black.addActionListener(this);
		white.addActionListener(this);
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
		else if(z==black) {
			toSocket.add("black");
			x=JOptionPane.showInputDialog("enter the x coordinate:");
			toSocket.add(x);
			y=JOptionPane.showInputDialog("enter the y coordinate:");
			toSocket.add(y);			
		}
		else if(z==white) {
			toSocket.add("white");
			x=JOptionPane.showInputDialog("enter the x coordinate:");
			toSocket.add(x);
			y=JOptionPane.showInputDialog("enter the y coordinate:");
			toSocket.add(y);			
		}
		
		System.out.println("Client wysłał:"+toSocket);
		try {
			out.writeObject(toSocket);
			out.flush();
		}
		catch (IOException ex) {
	        ex.printStackTrace();
		}
		

		try {
			String fromSocket = (String)in.readObject(); 
			System.out.println("Client otrzymuje: "+fromSocket);
	    } 
		catch(Exception ex) {}
		
		/*if(fromSocket.get(0)=="T") {
			//TO DO: wstawianie fromSocket.get(1) i fromSocket.get(2) (to sa wspolrzedne x i y) na nich wstawiamy pionka
		}
		if(fromSocket.get(0)=="N") {
			//TO DO: wyswietl informacje zeby ktos jeszcze raz wstawil pionka
		}*/
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
	
	//TO DO: dopracowac przesylanie informacji miedzy klientem i botem
	
	

	
	
	
public static void main(String[] args) throws IOException{
		
		Client client = new Client();
		client.setVisible(true);
		client.listenSocket();		
	}
}