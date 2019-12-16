package gogame;
import java.awt.event.ActionEvent;
import java.io.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.net.*;
import java.util.ArrayList;

import javax.swing.*;


public class Client extends Application { //extends JFrame implements ActionListener
	
	static Socket Socket;
    static ObjectOutputStream out;
    static ObjectInputStream input;
	
	static String firstanswer="";
	JMenu move, properties;
	JMenuItem pas, movee, size, bot, F5;
	static String toSocket, Size, Bot;
	static JLabel label;
	static FXMLLoader loader;
	static StackPane stackPane;
	static Controller controller;
	
	public Client(){
		/*setTitle("Go Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		move = new JMenu("Move");
		properties = new JMenu("properties");
		pas = new JMenuItem("pas");
		movee = new JMenuItem("movee");
		size = new JMenuItem("size");
		bot = new JMenuItem("bot");
		F5 = new JMenuItem("F5");
		
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
		properties.add(F5);
		
		move.addActionListener(this);
		properties.addActionListener(this);
		pas.addActionListener(this);
		movee.addActionListener(this);
		size.addActionListener(this);
		bot.addActionListener(this);
		F5.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		setLocationRelativeTo(null);
		*/
		
		
		
	}
	
	public void start(Stage primaryStage) throws Exception {
		
		loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("/fxml/GameBorder9.fxml"));
		stackPane = loader.load();
		controller=loader.getController();
		
		Scene scene = new Scene(stackPane);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Go Game");
		primaryStage.show();
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
			toSocket.add("movee");
			x=JOptionPane.showInputDialog("enter the x coordinate:");
			toSocket.add(x);
			y=JOptionPane.showInputDialog("enter the y coordinate:");
			toSocket.add(y);	
			System.out.println(toSocket);
		}
		else if(z==F5) {
			toSocket.add("F5");
		}			
		
		
		try {
			out.writeObject(toSocket);
			out.flush();
		}
		catch (IOException ex) {
	        ex.printStackTrace();
		}
	}
	
	

	
public static void main(String[] args) throws IOException{
		
		//Client client = new Client();
		//client.setVisible(true);	
	try {
        Socket = new Socket("localhost", 5011);
        out = new ObjectOutputStream(Socket.getOutputStream());
        ServerConnection servenConn = new ServerConnection(Socket);
        new Thread(servenConn).start();
        launch(args);
    } 
    catch(IOException ex) {
    	System.out.println("No I/O");
        System.exit(-1);
    }
	
	}
}