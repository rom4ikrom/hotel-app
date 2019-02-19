package myHotel.ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class AppUILaunch extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		LoginStage loginStage = new LoginStage();
		loginStage.showLoginStage();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
