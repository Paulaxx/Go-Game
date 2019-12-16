package gogame;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Controller {
	
	@FXML
	GridPane gridPane2;
	@FXML
	Circle button00, button01, button02, button03, button10, button11, button12, button13,button20,button21, button22, button23, button30, button31, button32,button33, button40, button41, button42, button43, button50, button51, button52, button53,button60,button61, button62, button63, button70, button71, button72,button73,button80, button81, button82,button83; 

	
	public void buttonb(String color, String x, String y) {
		System.out.println("Controller buttonb"+x+" "+y);
		switch (x) {
	    case "0":
	        if(y.contentEquals("0")) {
	        	if(color.contentEquals("white"))
	        		button00.setFill(Color.WHITE);
	        	else
	        		button00.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("1")) {
	        	if(color.contentEquals("white"))
	        		button01.setFill(Color.WHITE);
	        	else
	        		button01.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("2")) {
	        	if(color.contentEquals("white"))
	        		button02.setFill(Color.WHITE);
	        	else
	        		button02.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("3")) {
	        	if(color.contentEquals("white"))
	        		button03.setFill(Color.WHITE);
	        	else
	        		button03.setFill(Color.BLACK);
	        }
	        break;
	    case "1":
	    	if(y.contentEquals("0")) {
	        	if(color.contentEquals("white"))
	        		button10.setFill(Color.WHITE);
	        	else
	        		button10.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("1")) {
	        	if(color.contentEquals("white"))
	        		button11.setFill(Color.WHITE);
	        	else
	        		button11.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("2")) {
	        	if(color.contentEquals("white"))
	        		button12.setFill(Color.WHITE);
	        	else
	        		button12.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("3")) {
	        	if(color.contentEquals("white"))
	        		button13.setFill(Color.WHITE);
	        	else
	        		button13.setFill(Color.BLACK);
	        }
	        break;
	    case "2":
	    	if(y.contentEquals("0")) {
	        	if(color.contentEquals("white"))
	        		button20.setFill(Color.WHITE);
	        	else
	        		button20.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("1")) {
	        	if(color.contentEquals("white"))
	        		button21.setFill(Color.WHITE);
	        	else
	        		button21.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("2")) {
	        	if(color.contentEquals("white"))
	        		button22.setFill(Color.WHITE);
	        	else
	        		button22.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("3")) {
	        	if(color.contentEquals("white"))
	        		button23.setFill(Color.WHITE);
	        	else
	        		button23.setFill(Color.BLACK);
	        }
	        break;
	    case "3":
	    	if(y.contentEquals("0")) {
	        	if(color.contentEquals("white"))
	        		button30.setFill(Color.WHITE);
	        	else
	        		button30.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("1")) {
	        	if(color.contentEquals("white"))
	        		button31.setFill(Color.WHITE);
	        	else
	        		button31.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("2")) {
	        	if(color.contentEquals("white"))
	        		button32.setFill(Color.WHITE);
	        	else
	        		button32.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("3")) {
	        	if(color.contentEquals("white"))
	        		button33.setFill(Color.WHITE);
	        	else
	        		button33.setFill(Color.BLACK);
	        }
	        break;
	    case "4":
	    	if(y.contentEquals("0")) {
	        	if(color.contentEquals("white"))
	        		button40.setFill(Color.WHITE);
	        	else
	        		button40.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("1")) {
	        	if(color.contentEquals("white"))
	        		button41.setFill(Color.WHITE);
	        	else
	        		button41.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("2")) {
	        	if(color.contentEquals("white"))
	        		button42.setFill(Color.WHITE);
	        	else
	        		button42.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("3")) {
	        	if(color.contentEquals("white"))
	        		button43.setFill(Color.WHITE);
	        	else
	        		button43.setFill(Color.BLACK);
	        }
	        break;
	    case "5":
	    	if(y.contentEquals("0")) {
	        	if(color.contentEquals("white"))
	        		button50.setFill(Color.WHITE);
	        	else
	        		button50.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("1")) {
	        	if(color.contentEquals("white"))
	        		button51.setFill(Color.WHITE);
	        	else
	        		button51.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("2")) {
	        	if(color.contentEquals("white"))
	        		button52.setFill(Color.WHITE);
	        	else
	        		button52.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("3")) {
	        	if(color.contentEquals("white"))
	        		button53.setFill(Color.WHITE);
	        	else
	        		button53.setFill(Color.BLACK);
	        }
	        break;
	    case "6":
	    	if(y.contentEquals("0")) {
	        	if(color.contentEquals("white"))
	        		button60.setFill(Color.WHITE);
	        	else
	        		button60.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("1")) {
	        	if(color.contentEquals("white"))
	        		button61.setFill(Color.WHITE);
	        	else
	        		button61.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("2")) {
	        	if(color.contentEquals("white"))
	        		button62.setFill(Color.WHITE);
	        	else
	        		button62.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("3")) {
	        	if(color.contentEquals("white"))
	        		button63.setFill(Color.WHITE);
	        	else
	        		button63.setFill(Color.BLACK);
	        }
	        break;
	    case "7":
	    	if(y.contentEquals("0")) {
	        	if(color.contentEquals("white"))
	        		button70.setFill(Color.WHITE);
	        	else
	        		button70.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("1")) {
	        	if(color.contentEquals("white"))
	        		button71.setFill(Color.WHITE);
	        	else
	        		button71.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("2")) {
	        	if(color.contentEquals("white"))
	        		button72.setFill(Color.WHITE);
	        	else
	        		button72.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("3")) {
	        	if(color.contentEquals("white"))
	        		button73.setFill(Color.WHITE);
	        	else
	        		button73.setFill(Color.BLACK);
	        }
	        break;
	    case "8":
	    	if(y.contentEquals("0")) {
	        	if(color.contentEquals("white"))
	        		button80.setFill(Color.WHITE);
	        	else
	        		button80.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("1")) {
	        	if(color.contentEquals("white"))
	        		button81.setFill(Color.WHITE);
	        	else
	        		button81.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("2")) {
	        	if(color.contentEquals("white"))
	        		button82.setFill(Color.WHITE);
	        	else
	        		button82.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("3")) {
	        	if(color.contentEquals("white"))
	        		button83.setFill(Color.WHITE);
	        	else
	        		button83.setFill(Color.BLACK);
	        }
	        break;
		}
	}
	
	public void clickmethod(MouseEvent e){
		
		button00.setVisible(true);
		button00.setFill(Color.BLACK);
		
		ArrayList<String> toSocket = new ArrayList<>();
		Node node = (Node) e.getSource();
		Integer y=GridPane.getRowIndex(node);
		Integer x=GridPane.getColumnIndex(node);
		System.out.println();
		/*toSocket.clear();
		if(x!=null && y!=null) {
			String X = Integer.toString(x);
			String Y = Integer.toString(y);
			toSocket.add("click");
			toSocket.add(X);
			toSocket.add(Y);
		}
		else if(x!=null) {
			String X = Integer.toString(x);
			toSocket.add("click");
			toSocket.add(X);
			toSocket.add("0");
		}
		else if(y!=null) {
			String Y = Integer.toString(y);
			toSocket.add("click");
			toSocket.add("0");
			toSocket.add(Y);
		}
		else {
			toSocket.add("click");
			toSocket.add("0");
			toSocket.add("0");
		}
		System.out.println("Controller clickMethod"+toSocket);
		try {
			Client.out.writeObject(toSocket);
			Client.out.flush();
		}
		catch (IOException ex) {
	        ex.printStackTrace();
		}*/

	}

}
