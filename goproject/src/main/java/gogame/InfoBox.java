package gogame;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InfoBox{

	public static void display(String message) {
		
		Stage window = new Stage();
		window.setMinWidth(200);
		window.setMinHeight(200);
		
		Label label=new Label();
		label.setText(message);
		
		Button closebutton = new Button("OK");
		closebutton.setOnAction(e->window.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, closebutton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
	
}
