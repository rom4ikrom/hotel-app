package myHotel.Helpers;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;

//this class is used to create alerts and show them to user
public class FxDialogs {
	
	public static void showWarning(String title, String message) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.initStyle(StageStyle.UTILITY);
		alert.setTitle("Warning");
		alert.setHeaderText(title);
		alert.setContentText(message);
		
		alert.showAndWait();
	}
	
	public static void showInformation(String title, String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.initStyle(StageStyle.UTILITY);
		alert.setTitle("Information");
		alert.setHeaderText(title);
		alert.setContentText(message);
		
		alert.showAndWait();
	}

}
