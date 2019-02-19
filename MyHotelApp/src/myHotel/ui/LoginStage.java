package myHotel.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import myHotel.app.ViewBookingDescriptionSystem;

public class LoginStage {
	
	Label lblName = new Label("My Hotel App");
	
	Label lblLogin = new Label("Login");
	Label lblPass = new Label("Password");
	
	Label lblStatus = new Label();
	
	TextField txtLogin = new TextField();
	PasswordField txtPass = new PasswordField();
	
	Button btnLogin = new Button("Login");
	Button btnReg = new Button("Create Account");
	
	GridPane gPane = new GridPane();
	FlowPane fPane = new FlowPane();
	
	Stage stage = new Stage();

	public void showLoginStage() {
		
		lblName.setStyle(
				"-fx-font-family: Montserrat;" +
				"-fx-font-size: 25;");
		
		gPane.getChildren().add(lblName);
		
		GridPane.setConstraints(lblName, 0, 0, 2, 1);
		GridPane.setHalignment(lblName, HPos.CENTER);
		
		gPane.add(lblLogin, 0, 1);
		gPane.add(lblPass, 0, 2);
		gPane.add(txtLogin, 1, 1);
		gPane.add(txtPass, 1, 2);
		
		gPane.getChildren().addAll(lblStatus, btnLogin, btnReg);
		
		GridPane.setConstraints(lblStatus, 0, 3, 2, 1);
		GridPane.setHalignment(lblStatus, HPos.CENTER);
		
		lblStatus.setStyle("-fx-text-fill: red");
		
		GridPane.setConstraints(btnLogin, 0, 4, 2, 1);
		GridPane.setConstraints(btnReg, 0, 5, 2, 1);
		
		GridPane.setHalignment(btnLogin, HPos.CENTER);
		GridPane.setHalignment(btnReg, HPos.CENTER);
		
		gPane.setHgap(20);
		gPane.setVgap(15);
		
		fPane.getChildren().add(gPane);
		fPane.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(fPane, 600, 700);
		stage.setScene(scene);
		stage.setTitle("Login Stage");
		stage.show();
		
		btnLogin.setPrefWidth(btnReg.getWidth());
		
		
		btnLogin.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				//verify login information and if true - open a new stage
				//false set error text for lblStatus
				
				ViewBookingDescriptionSystem system = new ViewBookingDescriptionSystem();
				
				boolean status = system.findCustomer(txtLogin.getText().trim(), txtPass.getText().trim());
				
				if(status) {
					ViewDescriptionStage bookingStage = new ViewDescriptionStage();
					bookingStage.showBookingStage();
					stage.close();
				} else {
					lblStatus.setText("Invalid Login Details!");
				}
			}
		});
		
		btnReg.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				//open a new stage
				RegistrationStage regStage = new RegistrationStage();
				regStage.showRegisterStage();
				stage.close();
			}
		});
		
	}
}
