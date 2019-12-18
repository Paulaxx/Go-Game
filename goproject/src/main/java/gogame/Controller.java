package gogame;

import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
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
	Circle button00, button01, button02, button03, button10, button11, button12, button13,button20,button21, button22, button23, button30, button31, button32,button33, button40, button41, button42, button43, button50, button51, button52, button53,button60,button61, button62, button63, button70, button71, button72,button73,button80, button81, button82,button83, button04, button05, button06, button07, button08, button14, button15, button16, button17, button18, button24, button25, button26, button27, button28, button34, button35, button36, button37, button38, button44, button45, button46, button47, button48, button54, button55, button56, button57, button58, button64, button65, button66, button67, button68, button74, button75, button76, button77, button78, button84, button85, button86, button87, button88; 
	
	public void delete(String x, String y) {
		System.out.println("delete"+x+" "+y);
		switch(x) {
		case "0":
	        if(y.contentEquals("0")) {
	        	button00.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("1")) {
        		button01.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("2")) {
	        	button02.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("3")) {
	        	button03.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("4")) {
	        	button04.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("5")) {
	        	button05.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("6")) {
	        	button06.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("7")) {
	        	button07.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("8")) {
	        	button08.setFill(Color.TRANSPARENT);
	        }
	        break;
	    case "1":
	    	if(y.contentEquals("0")) {
	    		button10.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("1")) {
	        	button11.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("2")) {
	        	button12.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("3")) {
	        	button13.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("4")) {
	        	button14.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("5")) {
	        	button15.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("6")) {
	        	button16.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("7")) {
	        	button17.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("8")) {
	        	button18.setFill(Color.TRANSPARENT);
	        }
	        break;
	    case "2":
	    	if(y.contentEquals("0")) {
	    		button20.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("1")) {
	        	button21.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("2")) {
	        	button22.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("3")) {
	        	button23.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("4")) {
	        	button24.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("5")) {
	        	button25.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("6")) {
	        	button26.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("7")) {
	        	button27.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("8")) {
	        	button28.setFill(Color.TRANSPARENT);
	        }
	        break;
	    case "3":
	    	if(y.contentEquals("0")) {
	    		button30.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("1")) {
	        	button31.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("2")) {
	        	button32.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("3")) {
	        	button33.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("4")) {
	        	button34.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("5")) {
	        	button35.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("6")) {
	        	button36.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("7")) {
	        	button37.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("8")) {
	        	button38.setFill(Color.TRANSPARENT);
	        }
	        break;
	    case "4":
	    	if(y.contentEquals("0")) {
	    		button40.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("1")) {
	        	button41.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("2")) {
	        	button42.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("3")) {
	        	button43.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("4")) {
	        	button44.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("5")) {
	        	button45.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("6")) {
	        	button46.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("7")) {
	        	button47.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("8")) {
	        	button48.setFill(Color.TRANSPARENT);
	        }
	        break;
	    case "5":
	    	if(y.contentEquals("0")) {
	    		button50.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("1")) {
	        	button51.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("2")) {
	        	button52.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("3")) {
	        	button53.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("4")) {
	        	button54.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("5")) {
	        	button55.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("6")) {
	        	button56.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("7")) {
	        	button57.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("8")) {
	        	button58.setFill(Color.TRANSPARENT);
	        }
	        break;
	    case "6":
	    	if(y.contentEquals("0")) {
	    		button60.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("1")) {
	        	button61.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("2")) {
	        	button62.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("3")) {
	        	button63.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("4")) {
	        	button64.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("5")) {
	        	button65.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("6")) {
	        	button66.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("7")) {
	        	button67.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("8")) {
	        	button68.setFill(Color.TRANSPARENT);
	        }
	        break;
	    case "7":
	    	if(y.contentEquals("0")) {
	    		button70.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("1")) {
	        	button71.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("2")) {
	        	button72.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("3")) {
	        	button73.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("4")) {
	        	button74.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("5")) {
	        	button75.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("6")) {
	        	button76.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("7")) {
	        	button77.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("8")) {
	        	button78.setFill(Color.TRANSPARENT);
	        }
	        break;
	    case "8":
	    	if(y.contentEquals("0")) {
	    		button80.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("1")) {
	        	button81.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("2")) {
	        	button82.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("3")) {
	        	button83.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("4")) {
	        	button84.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("5")) {
	        	button85.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("6")) {
	        	button86.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("7")) {
	        	button87.setFill(Color.TRANSPARENT);
	        }
	        else if(y.contentEquals("8")) {
	        	button88.setFill(Color.TRANSPARENT);
	        }
	        break;
		}
		
	}
	
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
	        else if(y.contentEquals("4")) {
	        	if(color.contentEquals("white"))
	        		button04.setFill(Color.WHITE);
	        	else
	        		button04.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("5")) {
	        	if(color.contentEquals("white"))
	        		button05.setFill(Color.WHITE);
	        	else
	        		button05.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("6")) {
	        	if(color.contentEquals("white"))
	        		button06.setFill(Color.WHITE);
	        	else
	        		button06.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("7")) {
	        	if(color.contentEquals("white"))
	        		button07.setFill(Color.WHITE);
	        	else
	        		button07.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("8")) {
	        	if(color.contentEquals("white"))
	        		button08.setFill(Color.WHITE);
	        	else
	        		button08.setFill(Color.BLACK);
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
	        else if(y.contentEquals("4")) {
	        	if(color.contentEquals("white"))
	        		button14.setFill(Color.WHITE);
	        	else
	        		button14.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("5")) {
	        	if(color.contentEquals("white"))
	        		button15.setFill(Color.WHITE);
	        	else
	        		button15.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("6")) {
	        	if(color.contentEquals("white"))
	        		button16.setFill(Color.WHITE);
	        	else
	        		button16.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("7")) {
	        	if(color.contentEquals("white"))
	        		button17.setFill(Color.WHITE);
	        	else
	        		button17.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("8")) {
	        	if(color.contentEquals("white"))
	        		button18.setFill(Color.WHITE);
	        	else
	        		button18.setFill(Color.BLACK);
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
	        else if(y.contentEquals("4")) {
	        	if(color.contentEquals("white"))
	        		button24.setFill(Color.WHITE);
	        	else
	        		button24.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("5")) {
	        	if(color.contentEquals("white"))
	        		button25.setFill(Color.WHITE);
	        	else
	        		button25.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("6")) {
	        	if(color.contentEquals("white"))
	        		button26.setFill(Color.WHITE);
	        	else
	        		button26.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("7")) {
	        	if(color.contentEquals("white"))
	        		button27.setFill(Color.WHITE);
	        	else
	        		button27.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("8")) {
	        	if(color.contentEquals("white"))
	        		button28.setFill(Color.WHITE);
	        	else
	        		button28.setFill(Color.BLACK);
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
	        else if(y.contentEquals("4")) {
	        	if(color.contentEquals("white"))
	        		button34.setFill(Color.WHITE);
	        	else
	        		button34.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("5")) {
	        	if(color.contentEquals("white"))
	        		button35.setFill(Color.WHITE);
	        	else
	        		button35.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("6")) {
	        	if(color.contentEquals("white"))
	        		button36.setFill(Color.WHITE);
	        	else
	        		button36.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("7")) {
	        	if(color.contentEquals("white"))
	        		button37.setFill(Color.WHITE);
	        	else
	        		button37.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("8")) {
	        	if(color.contentEquals("white"))
	        		button38.setFill(Color.WHITE);
	        	else
	        		button38.setFill(Color.BLACK);
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
	        else if(y.contentEquals("4")) {
	        	if(color.contentEquals("white"))
	        		button44.setFill(Color.WHITE);
	        	else
	        		button44.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("5")) {
	        	if(color.contentEquals("white"))
	        		button45.setFill(Color.WHITE);
	        	else
	        		button45.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("6")) {
	        	if(color.contentEquals("white"))
	        		button46.setFill(Color.WHITE);
	        	else
	        		button46.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("7")) {
	        	if(color.contentEquals("white"))
	        		button47.setFill(Color.WHITE);
	        	else
	        		button47.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("8")) {
	        	if(color.contentEquals("white"))
	        		button48.setFill(Color.WHITE);
	        	else
	        		button48.setFill(Color.BLACK);
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
	        else if(y.contentEquals("4")) {
	        	if(color.contentEquals("white"))
	        		button54.setFill(Color.WHITE);
	        	else
	        		button54.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("5")) {
	        	if(color.contentEquals("white"))
	        		button55.setFill(Color.WHITE);
	        	else
	        		button55.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("6")) {
	        	if(color.contentEquals("white"))
	        		button56.setFill(Color.WHITE);
	        	else
	        		button56.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("7")) {
	        	if(color.contentEquals("white"))
	        		button57.setFill(Color.WHITE);
	        	else
	        		button57.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("8")) {
	        	if(color.contentEquals("white"))
	        		button58.setFill(Color.WHITE);
	        	else
	        		button58.setFill(Color.BLACK);
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
	        else if(y.contentEquals("4")) {
	        	if(color.contentEquals("white"))
	        		button64.setFill(Color.WHITE);
	        	else
	        		button64.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("5")) {
	        	if(color.contentEquals("white"))
	        		button65.setFill(Color.WHITE);
	        	else
	        		button65.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("6")) {
	        	if(color.contentEquals("white"))
	        		button66.setFill(Color.WHITE);
	        	else
	        		button66.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("7")) {
	        	if(color.contentEquals("white"))
	        		button67.setFill(Color.WHITE);
	        	else
	        		button67.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("8")) {
	        	if(color.contentEquals("white"))
	        		button68.setFill(Color.WHITE);
	        	else
	        		button68.setFill(Color.BLACK);
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
	        else if(y.contentEquals("4")) {
	        	if(color.contentEquals("white"))
	        		button74.setFill(Color.WHITE);
	        	else
	        		button74.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("5")) {
	        	if(color.contentEquals("white"))
	        		button75.setFill(Color.WHITE);
	        	else
	        		button75.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("6")) {
	        	if(color.contentEquals("white"))
	        		button76.setFill(Color.WHITE);
	        	else
	        		button76.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("7")) {
	        	if(color.contentEquals("white"))
	        		button77.setFill(Color.WHITE);
	        	else
	        		button77.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("8")) {
	        	if(color.contentEquals("white"))
	        		button78.setFill(Color.WHITE);
	        	else
	        		button78.setFill(Color.BLACK);
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
	        else if(y.contentEquals("4")) {
	        	if(color.contentEquals("white"))
	        		button84.setFill(Color.WHITE);
	        	else
	        		button84.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("5")) {
	        	if(color.contentEquals("white"))
	        		button85.setFill(Color.WHITE);
	        	else
	        		button85.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("6")) {
	        	if(color.contentEquals("white"))
	        		button86.setFill(Color.WHITE);
	        	else
	        		button86.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("7")) {
	        	if(color.contentEquals("white"))
	        		button87.setFill(Color.WHITE);
	        	else
	        		button87.setFill(Color.BLACK);
	        }
	        else if(y.contentEquals("8")) {
	        	if(color.contentEquals("white"))
	        		button88.setFill(Color.WHITE);
	        	else
	        		button88.setFill(Color.BLACK);
	        }
	        break;
		}
	}
	
	public void clickmethod(MouseEvent e){
		
		ArrayList<String> toSocket = new ArrayList<>();
		Node node = (Node) e.getSource();
		Integer y=GridPane.getRowIndex(node);
		Integer x=GridPane.getColumnIndex(node);
		System.out.println(x+" "+y);
		toSocket.clear();
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
		try {
			Client.out.writeObject(toSocket);
			Client.out.flush();
		}
		catch (IOException ex) {
	        ex.printStackTrace();
		}

	}
	
	public void bot(ActionEvent en) {
		ArrayList<String> toSocket = new ArrayList<>();
		toSocket.add("bot");
		try {
			Client.out.writeObject(toSocket);
			Client.out.flush();
		}
		catch (IOException ex) {
	        ex.printStackTrace();
		}
		InfoBox.display("You're playing with a bot");
	}
	
	public void pas(ActionEvent en) {
		ArrayList<String> toSocket = new ArrayList<>();
		toSocket.add("pas");
		try {
			Client.out.writeObject(toSocket);
			Client.out.flush();
		}
		catch (IOException ex) {
	        ex.printStackTrace();
		}
		
	}
	
	public void size13(ActionEvent en) {
		ArrayList<String> toSocket = new ArrayList<>();
		toSocket.add("size13");
		try {
			Client.out.writeObject(toSocket);
			Client.out.flush();
		}
		catch (IOException ex) {
	        ex.printStackTrace();
		}
	}
	
	public void size19(ActionEvent en) {
		ArrayList<String> toSocket = new ArrayList<>();
		toSocket.add("size19");
		try {
			Client.out.writeObject(toSocket);
			Client.out.flush();
		}
		catch (IOException ex) {
	        ex.printStackTrace();
		}
		
	}
	
	public void endOfGame() {
		ArrayList<String> toSocket = new ArrayList<>();
		toSocket.add("koniec");
		try {
			Client.out.writeObject(toSocket);
			Client.out.flush();
		}
		catch (IOException ex) {
	        ex.printStackTrace();
		}
	}
	
	public void illegalmove() {
		InfoBox.display("Illegal move");
	}
	
	public void botpas(){
		InfoBox.display("Bot has passed, end of the game");
	}
	
	public void pas(){
		InfoBox.display("One player has passed");
	}
	
	public void end(int b, int w){
		if(b>w) {
			InfoBox.display("Black player won!\n"+ "Black score: "+ b+ "\nWhite score: "+w);
		}
		else if(b<w) {
			InfoBox.display("White player won!\n"+ "White score: "+ w+ "\nBlack score: "+b);
		}
		else
			InfoBox.display("Draw\n"+ "Score: "+b);
	}

}
