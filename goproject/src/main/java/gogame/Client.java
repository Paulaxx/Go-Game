package gogame;
import java.io.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.net.*;

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
	}
	
	public void start(Stage primaryStage) throws Exception {
		
		loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("/fxml/GameBoard9.fxml"));
		stackPane = loader.load();
		controller=loader.getController();
		
		Scene scene = new Scene(stackPane);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Go Game");
		primaryStage.show();
	}

	
public static void main(String[] args) throws IOException{

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