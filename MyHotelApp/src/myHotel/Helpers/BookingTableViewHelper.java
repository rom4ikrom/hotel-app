package myHotel.Helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import myHotel.domain.Booking;;

//it supports the following features
//creation of the data rows
//creation of the columns for the table
public class BookingTableViewHelper {

	//return booking no column
	public static TableColumn<Booking, Integer> getBookingNoColumn() {
		TableColumn<Booking, Integer> bookingNoCol = new TableColumn<>("Booking No");
		PropertyValueFactory<Booking, Integer> bookingNoCellValueFactory = new PropertyValueFactory<>("bookingNo");
		bookingNoCol.setCellValueFactory(bookingNoCellValueFactory);
		return bookingNoCol;
	}

	
	//return booking start date column
	public static TableColumn<Booking, Date> getBookingCheckInColumn() {
		TableColumn<Booking, Date> bookingCheckInCol = new TableColumn<>("Check In");
		PropertyValueFactory<Booking, Date> bookingCheckInCellValueFactory = new PropertyValueFactory<>("CheckInDate");
		bookingCheckInCol.setCellFactory(column -> {
			TableCell<Booking, Date> cell = new TableCell<Booking, Date>() {
				private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
				
				@Override
				protected void updateItem(Date item, boolean empty) {
					super.updateItem(item, empty);
					if(empty) {
						setText(null);
					} else {
						if(item != null)
							this.setText(dateFormat.format(item));
					}
				}
			};
			return cell;
		});
		bookingCheckInCol.setCellValueFactory(bookingCheckInCellValueFactory);
		return bookingCheckInCol;
	}


	//return booking end date column
	public static TableColumn<Booking, Date> getBookingCheckOutColumn() {
		TableColumn<Booking, Date> bookingCheckOutCol = new TableColumn<>("Check Out");
		PropertyValueFactory<Booking, Date> bookingCheckOutCellValueFactory = new PropertyValueFactory<>("CheckOutDate");
		bookingCheckOutCol.setCellFactory(column -> {
			TableCell<Booking, Date> cell = new TableCell<Booking, Date>() {
				private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
				
				@Override
				protected void updateItem(Date item, boolean empty) {
					super.updateItem(item, empty);
					if(empty) {
						setText(null);
					} else {
						if(item != null)
							this.setText(dateFormat.format(item));
					}
				}
			};
			return cell;
		});
		bookingCheckOutCol.setCellValueFactory(bookingCheckOutCellValueFactory);
		return bookingCheckOutCol;
	}

	//return booking room type column
	public static TableColumn<Booking, String> getBookingRoomTypeColumn() {
		TableColumn<Booking, String> bookingRoomTypeCol = new TableColumn<>("Room Type");
		PropertyValueFactory<Booking, String> bookingRoomTypeCellValueFactory = new PropertyValueFactory<>("roomType");
		bookingRoomTypeCol.setCellValueFactory(bookingRoomTypeCellValueFactory);
		return bookingRoomTypeCol;
	}

	//return booking price column
	public static TableColumn<Booking, Integer> getBookingPriceColumn() {
		TableColumn<Booking, Integer> bookingPriceCol = new TableColumn<>("Price");
		PropertyValueFactory<Booking, Integer> bookingPriceCellValueFactory = new PropertyValueFactory<>("bookingPrice");
		bookingPriceCol.setCellValueFactory(bookingPriceCellValueFactory);
		return bookingPriceCol;
	}
}
