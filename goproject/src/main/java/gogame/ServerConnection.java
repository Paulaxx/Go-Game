package gogame;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ServerConnection implements Runnable{

	private Socket server;
    private ObjectInputStream in;
	
	public ServerConnection(Socket s) {
		server=s;
		try {
			in = new ObjectInputStream(Client.Socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		try {
			while(true) {
				String fromSocket = (String)in.readObject();
				Client.label.setText(fromSocket);
			}
		}
		catch (Exception ex) {}
		finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
