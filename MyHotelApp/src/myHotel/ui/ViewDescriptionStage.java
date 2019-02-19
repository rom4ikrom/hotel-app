package myHotel.ui;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import myHotel.Helpers.BookingTableViewHelper;
import myHotel.Helpers.FxDialogs;
import myHotel.app.ViewBookingDescriptionSystem;
import myHotel.domain.Booking;

public class ViewDescriptionStage {

	private Label lblName = new Label("Booking Information");
	
	//view booking list controls
	private Label lblCheckIn = new Label("Check In");
	private Label lblCheckOut = new Label("Check Out");
	private Label lblRoomType = new Label("Room Type");

	private DatePicker checkInDate = new DatePicker();
	private DatePicker checkOutDate = new DatePicker();

	private ComboBox<String> cbRoomType = new ComboBox<>();

	private Button btnSearch = new Button("Search");

	private FlowPane bookingListTablePane;
	private TableView<Booking> bookingListTable;
	
	private ScrollPane sp;
	
	//view booking details controls
	private Label lblBookingNo = new Label("Booking No");
	
	private static TextField txtBookingNo = new TextField();
	private static ComboBox<String> cbDescriptionCategories = new ComboBox<>();
	
	private Button btnViewCategories = new Button("View Categories");
	
	private Button btnViewDetails = new Button("View Details");
	
	private static TextArea taDetails = new TextArea();
	
	private Button btnMakeBooking = new Button("Confirm");

	Stage stage = new Stage();
	
	private static ViewBookingDescriptionSystem viewBookingDescriptionSystem = new ViewBookingDescriptionSystem();

	public void showBookingStage() {

		VBox root = new VBox();
		//create booking search pane
		FlowPane fPaneViewBookings = new FlowPane();
		GridPane gPaneViewBookings = new GridPane();

		//create menu
		MenuBar menuBar = new MenuBar();
		menuBar.prefWidthProperty().bind(stage.widthProperty());

		//account menu - student can view courses, view timetable, log out and exit
		Menu accMenu = new Menu("Account");
		MenuItem logOutAccMenu = new MenuItem("Log Out");
		MenuItem exitAccMenu = new MenuItem("Exit");

		//add action to log out option in account menu
		logOutAccMenu.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				LoginStage loginStage = new LoginStage();
				loginStage.showLoginStage();
				stage.close();
			}

		});

		//add action to exit option in account menu
		exitAccMenu.setOnAction(actionEvent -> Platform.exit());

		//add all options to menu
		accMenu.getItems().addAll(logOutAccMenu, exitAccMenu);

		//add account menu to menu bar
		menuBar.getMenus().add(accMenu);

		//add menu bar to pane
		root.getChildren().add(menuBar);

		gPaneViewBookings.getChildren().add(lblName);

		//add label style
		lblName.setStyle(
				"-fx-font-family: Montserrat;" +
				"-fx-font-size: 25;");

		GridPane.setConstraints(lblName, 0, 0);

		gPaneViewBookings.add(lblCheckIn, 0, 1);
		gPaneViewBookings.add(lblCheckOut, 1, 1);
		gPaneViewBookings.add(lblRoomType, 2, 1);

		gPaneViewBookings.add(checkInDate, 0, 2);
		gPaneViewBookings.add(checkOutDate, 1, 2);
		gPaneViewBookings.add(cbRoomType, 2, 2);
		gPaneViewBookings.add(btnSearch, 3, 2);

		ObservableList<String> roomTypes = 
				FXCollections.observableArrayList(
						"Single",
						"Double",
						"Function",
						"All"
						);

		cbRoomType.setItems(roomTypes);

		gPaneViewBookings.setHgap(20);
		gPaneViewBookings.setVgap(15);

		fPaneViewBookings.getChildren().add(gPaneViewBookings);
		fPaneViewBookings.setAlignment(Pos.TOP_CENTER);

		fPaneViewBookings.setPadding(new Insets(10, 0, 0, 0));

		//bookings list table view

		sp = new ScrollPane();
		bookingListTablePane = new FlowPane();
		bookingListTablePane.setPadding(new Insets(15, 0, 0, 0));
		bookingListTable = new TableView<Booking>();

		sp.setPannable(true);

		sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

		//add columns to the table view
		bookingListTable.getColumns().add(BookingTableViewHelper.getBookingNoColumn());
		bookingListTable.getColumns().add(BookingTableViewHelper.getBookingCheckInColumn());
		bookingListTable.getColumns().add(BookingTableViewHelper.getBookingCheckOutColumn());
		bookingListTable.getColumns().add(BookingTableViewHelper.getBookingRoomTypeColumn());
		bookingListTable.getColumns().add(BookingTableViewHelper.getBookingPriceColumn());

		bookingListTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		bookingListTable.setPlaceholder(new Label("No visible columns and/or date exist."));

		sp.setContent(bookingListTable);

		bookingListTablePane.getChildren().add(sp);
		bookingListTablePane.setAlignment(Pos.CENTER);
		
		//create booking description pane
		FlowPane fPaneBookingDetails = new FlowPane();
		GridPane gPaneBookingDetails = new GridPane();
		
		gPaneBookingDetails.add(lblBookingNo, 0, 0);
		gPaneBookingDetails.add(txtBookingNo, 0, 1);
		gPaneBookingDetails.add(btnViewCategories, 0, 2);
		gPaneBookingDetails.add(cbDescriptionCategories, 0, 3);
		gPaneBookingDetails.add(btnViewDetails, 0, 4);
		
		txtBookingNo.setEditable(false);
		
		ObservableList<String> empty = 
				FXCollections.observableArrayList(
						"No Categories"
						);
		cbDescriptionCategories.setItems(empty);
		
		GridPane.setHalignment(btnViewCategories, HPos.CENTER);
		GridPane.setHalignment(btnViewDetails, HPos.CENTER);
		
		gPaneBookingDetails.getChildren().addAll(taDetails, btnMakeBooking);
		
		GridPane.setConstraints(taDetails, 1, 0, 1, 5);
		GridPane.setConstraints(btnMakeBooking, 0, 5, 2, 1);
		GridPane.setHalignment(btnMakeBooking, HPos.CENTER);
		
		gPaneBookingDetails.setHgap(20);
		gPaneBookingDetails.setVgap(15);

		fPaneBookingDetails.getChildren().add(gPaneBookingDetails);
		fPaneBookingDetails.setAlignment(Pos.TOP_CENTER);

		fPaneBookingDetails.setPadding(new Insets(10, 0, 0, 0));
		
		root.getChildren().addAll(fPaneViewBookings, bookingListTablePane, fPaneBookingDetails);

		Scene scene = new Scene(root, 800, 600);

		stage.setScene(scene);
		stage.setTitle("Booking Stage");
		stage.show();

		bookingListTable.setPrefWidth(gPaneViewBookings.getWidth());
		sp.setPrefHeight(150);
		bookingListTable.setPrefHeight(sp.getPrefHeight() - 1);
		
		double cbWidthDescriptionCategories = cbDescriptionCategories.getWidth();
		
		txtBookingNo.setPrefWidth(cbWidthDescriptionCategories);
		
		taDetails.setPrefWidth(gPaneViewBookings.getWidth() - txtBookingNo.getPrefWidth());
		
		btnSearch.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				if(checkInDate.getValue() == null && checkOutDate.getValue() == null) {
					FxDialogs.showWarning(null, "Please select Check In and Check Out Dates!");
				} else {
					LocalDate localDateCheckIn = checkInDate.getValue();
					LocalDate localDateCheckOut = checkOutDate.getValue();
					
					Instant instantCheckIn = Instant.from(localDateCheckIn.atStartOfDay(ZoneId.systemDefault()));
					Instant instantCheckOut = Instant.from(localDateCheckOut.atStartOfDay(ZoneId.systemDefault()));
					
					Date checkIn = Date.from(instantCheckIn);
					Date checkOut = Date.from(instantCheckOut);
					
					String roomType = cbRoomType.getValue();
					
					List<Booking> bookingsList = viewBookingDescriptionSystem.viewBookings(checkIn, checkOut, roomType);
					
					ObservableList<Booking> obBookingsList = FXCollections.observableArrayList(bookingsList);
					
					bookingListTable.setItems(obBookingsList);
					
					bookingListTable.setFixedCellSize(25);
					bookingListTable.prefHeightProperty().bind(
							Bindings.size(bookingListTable.getItems()).multiply(bookingListTable.getFixedCellSize()).add(51));
				}
			}
		});
		
		bookingListTable.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if(bookingListTable.getSelectionModel().getSelectedItem() != null) {
					txtBookingNo.setText(Integer.toString(bookingListTable.getSelectionModel().getSelectedItem().getBookingNo()));
				}
				
			}
		});
		
		btnViewCategories.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				Platform.runLater(new ViewCategoriesNamesTask());
				
			}
		});
		
		btnViewDetails.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				Platform.runLater(new ViewCategoriesInfoTask());
				
			}
		});
	}
	
	//create thread to get list of categories for specified booking
	private static class ViewCategoriesNamesTask implements Runnable {

		@Override
		public void run() {
			
			int bookingNo = Integer.parseInt(txtBookingNo.getText());
			
			ViewBookingDescriptionSystem system = new ViewBookingDescriptionSystem();
			
			ArrayList<String> descriptionNames = system.getBookingCategories(bookingNo);
			
			ObservableList<String> descriptonCategories = FXCollections.observableArrayList(descriptionNames);

			cbDescriptionCategories.setItems(descriptonCategories);
			
			//make sure that the appearance of application remain the same
			double cbWidthDescriptionCategories = cbDescriptionCategories.getWidth();
			
			cbDescriptionCategories.setPrefWidth(cbWidthDescriptionCategories);
			
			double taDetailsWidth = taDetails.getPrefWidth();
			taDetails.setPrefWidth(taDetailsWidth);	
		}
	}
	
	//create thread to get category information
	private static class ViewCategoriesInfoTask implements Runnable {
		
		@Override
		public void run() {
			
			int bookingNo = Integer.parseInt(txtBookingNo.getText());
			String categoryName = cbDescriptionCategories.getValue().trim();
			
			String bookingDescriptionDetails = viewBookingDescriptionSystem.viewDescriptionInfo(bookingNo, categoryName);
			
			taDetails.setText(bookingDescriptionDetails);		
		}
	}
}
