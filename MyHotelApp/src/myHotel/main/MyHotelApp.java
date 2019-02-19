package myHotel.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

import myHotel.app.ViewBookingDescriptionSystem;
import myHotel.domain.Booking;
import myHotel.domain.Customer;
import myHotel.domain.DescriptionCategory;
import myHotel.domain.Room;
import myHotel.ui.AppUILaunch;

public class MyHotelApp {

	public static void main(String[] args) {
		
		/**
		 * Testing data
		*/
		
		/* 
		//uncomment this to add data to database
		//Create room objects
		
		Room single1 = new Room(101, "Single");
		Room single2 = new Room(102, "Single");
		Room double1 = new Room(201, "Double");
		Room double2 = new Room(202, "Double");
		Room double3 = new Room(203, "Double");
		Room function1 = new Room(301, "Function");
		
		//Create booking objects
		Booking b1 = new Booking(1, parseDate("10/01/2019"), parseDate("15/01/2019"), single1);
		Booking b2 = new Booking(2, parseDate("10/01/2019"), parseDate("16/01/2019"), single2);
		Booking b3 = new Booking(3, parseDate("12/01/2019"), parseDate("17/01/2019"), double1);
		Booking b4 = new Booking(4, parseDate("13/01/2019"), parseDate("18/01/2019"), double2);
		Booking b5 = new Booking(5, parseDate("13/01/2019"), parseDate("19/01/2019"), double3);
		Booking b6 = new Booking(6, parseDate("15/01/2019"), parseDate("20/01/2019"), function1);
		
		//Create description objects
		DescriptionCategory dc10 = new DescriptionCategory();
		dc10.setCategoryName("Weather");
		dc10.setCategoryInfo("Good forecast for the next this period. Sunny days.");
		
		DescriptionCategory dc11 = new DescriptionCategory();
		dc11.setCategoryName("Exchange Rates");
		dc11.setCategoryInfo("No information.");
		
		DescriptionCategory dc12 = new DescriptionCategory();
		dc12.setCategoryName("Parking");
		dc12.setCategoryInfo("Parking is available 24/7. £5 per day.");
		
		ArrayList<DescriptionCategory> dcArray1 = new ArrayList<>();
		dcArray1.add(dc10);
		dcArray1.add(dc11);
		dcArray1.add(dc12);
		
		b1.setCategoriesList(dcArray1);
		
		DescriptionCategory dc20 = new DescriptionCategory();
		dc20.setCategoryName("Weather");
		dc20.setCategoryInfo("Partly cloudy. Rains are likely.");
		
		DescriptionCategory dc21 = new DescriptionCategory();
		dc21.setCategoryName("Facilities");
		dc21.setCategoryInfo("There are a McDonalds and KFC near the hotel.");
		
		DescriptionCategory dc22 = new DescriptionCategory();
		dc22.setCategoryName("Parking");
		dc22.setCategoryInfo("Parking is available only from Monday to Friday.");
		
		DescriptionCategory dc23 = new DescriptionCategory();
		dc23.setCategoryName("Entertainment");
		dc23.setCategoryInfo("Circus show will be performed on next day.");
		
		ArrayList<DescriptionCategory> dcArray2 = new ArrayList<>();
		dcArray2.add(dc20);
		dcArray2.add(dc21);
		dcArray2.add(dc22);
		dcArray2.add(dc23);
		
		b2.setCategoriesList(dcArray2);
		
		//Create an instance of the system
		ViewBookingDescriptionSystem system = new ViewBookingDescriptionSystem();
		
		//add all data to database
		system.persist(single1);
		system.persist(single2);
		system.persist(double1);
		system.persist(double2);
		system.persist(double3);
		system.persist(function1);
		
		system.persist(dc10);
		system.persist(dc11);
		system.persist(dc12);
		
		system.persist(dc20);
		system.persist(dc21);
		system.persist(dc22);
		system.persist(dc23);
		
		system.persist(b1);
		system.persist(b2);
		system.persist(b3);
		system.persist(b4);
		system.persist(b5);
		system.persist(b6);
		
		//create an admin user
		Customer c = new Customer();
		
		c.setUsername("admin");
		c.setPassword("admin");
		
		//add admin user for testing purpose
		system.persist(c);
		*/
		
		
		//launch the GUI
		AppUILaunch.main(args);
		
	}
	
	//method to create dates which are used in booking objects
	public static Date parseDate(String date) {
	     try {
	         return new SimpleDateFormat("dd/MM/yyyy").parse(date);
	     } catch (ParseException e) {
	         return null;
	     }
	  }

}
