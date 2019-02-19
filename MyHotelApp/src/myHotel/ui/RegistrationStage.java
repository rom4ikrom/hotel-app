package myHotel.ui;

import java.util.ArrayList;

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
import myHotel.domain.Customer;

public class RegistrationStage {
	
	private Label lblName = new Label("Create Account");
	
	private Label lblFname = new Label("First Name");
	private Label lblLname = new Label("Last Name");
	private Label lblUsername = new Label("Username");
	private Label lblPass = new Label("Password");
	
	private Label lblTel = new Label("Telephone");
	private Label lblEmail = new Label("Email");
	private Label lblAddress = new Label("Address");
	private Label lblPostcode = new Label("Postcode");
	
	private Label lblStatus = new Label();
	
	private TextField txtFname = new TextField();
	private TextField txtLname = new TextField();
	private TextField txtUsername = new TextField();
	private PasswordField txtPass = new PasswordField();
	
	private TextField txtTel = new TextField();
	private TextField txtEmail = new TextField();
	private TextField txtAddress = new TextField();
	private TextField txtPostcode = new TextField();
	
	protected ArrayList<TextField> txtArray = new ArrayList<>();
	
	private Button btnReg = new Button("Create Account");
	private Button btnLogin = new Button("Back to Login");
	
	Stage stage = new Stage();
	
	public void showRegisterStage() {
		
		GridPane gPane = new GridPane();
		
		lblName.setStyle(
				"-fx-font-family: Montserrat;" +
				"-fx-font-size: 25;");
		
		gPane.getChildren().addAll(lblName, lblStatus, btnReg, btnLogin);
		
		gPane.add(lblFname, 0, 1);
		gPane.add(lblLname, 0, 2);
		gPane.add(lblUsername, 0, 3);
		gPane.add(lblPass, 0, 4);
		
		gPane.add(txtFname, 1, 1);
		gPane.add(txtLname, 1, 2);
		gPane.add(txtUsername, 1, 3);
		gPane.add(txtPass, 1, 4);
		
		gPane.add(lblTel, 2, 1);
		gPane.add(lblEmail, 2, 2);
		gPane.add(lblAddress, 2, 3);
		gPane.add(lblPostcode, 2, 4);
		
		gPane.add(txtTel, 3, 1);
		gPane.add(txtEmail, 3, 2);
		gPane.add(txtAddress, 3, 3);
		gPane.add(txtPostcode, 3, 4);
		
		GridPane.setConstraints(lblName, 0, 0, 4, 1);
		GridPane.setConstraints(lblStatus, 0, 5, 4, 1);
		GridPane.setHalignment(lblStatus, HPos.CENTER);
		
		GridPane.setConstraints(btnReg, 0, 6, 4, 1);
		GridPane.setHalignment(btnReg, HPos.CENTER);
		
		GridPane.setConstraints(btnLogin, 0, 7, 4, 1);
		GridPane.setHalignment(btnLogin, HPos.CENTER);
		
		lblStatus.setStyle("-fx-text-fill: red");
		
		gPane.setHgap(20);
		gPane.setVgap(15);
		
		FlowPane fPane = new FlowPane();
		
		fPane.getChildren().add(gPane);
		fPane.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(fPane, 700, 500);
		stage.setScene(scene);
		stage.setTitle("Registration Stage");
		stage.show();
		
		txtArray.add(txtFname);
		txtArray.add(txtLname);
		txtArray.add(txtUsername);
		txtArray.add(txtPass);
		
		txtArray.add(txtTel);
		txtArray.add(txtEmail);
		txtArray.add(txtAddress);
		txtArray.add(txtPostcode);
		//btnLogin.setPrefWidth(btnReg.getWidth());
		
		btnReg.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				//check for empty field and if false register to server and save info to database
				
				int count = 0;
				
				for(TextField tf : txtArray) {
					if(!tf.getText().trim().isEmpty() && tf.getText() != null && count == 7) {
						String name = txtFname.getText().trim() + " " + txtLname.getText().trim();
						int tel = Integer.parseInt(txtTel.getText().trim());
						String email = txtEmail.getText().trim();
						String address = txtAddress.getText().trim();
						String postcode = txtPostcode.getText().trim();
						
						String username = txtUsername.getText().trim();
						String password = txtPass.getText().trim();
						
						Customer c = new Customer(name, tel, email, address, postcode);
						
						c.setUsername(username);
						c.setPassword(password);
						
						ViewBookingDescriptionSystem system = new ViewBookingDescriptionSystem();
						
						system.persist(c);
						
						lblStatus.setText("Account has been created!");
						lblStatus.setStyle("-fx-text-fill: green");
						
						for(TextField t : txtArray) {
							t.clear();
						}
						
					} else if(count < 7 && !tf.getText().trim().isEmpty() && tf.getText() != null){
						count++;
						lblStatus.setStyle("-fx-text-fill: red");
						lblStatus.setText("Enter all details please.");
					} else {
						lblStatus.setStyle("-fx-text-fill: red");
						lblStatus.setText("Enter all details please.");
						break;
					}
				}
				
				
			}
		});
		
		btnLogin.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				//return back to login stage
				LoginStage loginStage = new LoginStage();
				loginStage.showLoginStage();
				stage.close();
				
			}
		});
	}

}
