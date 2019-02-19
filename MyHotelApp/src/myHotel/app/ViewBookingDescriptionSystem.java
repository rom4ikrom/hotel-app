package myHotel.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import myHotel.domain.Booking;
import myHotel.domain.Customer;
import myHotel.domain.DescriptionCategory;

public class ViewBookingDescriptionSystem {
	
	//Pre-condition
	//The customer chose an available booking for the entered dates and
	//the customer must be registered in the system.
	
	private Customer customer = new Customer();
	
	//method to add customer details to database in order to make customer registered in the system
	public boolean register(Customer customer) {
		//send customer object to database
		boolean status = false;
		return status;
	}
	
	//method to view customer details
	public Customer getCustomerDetails(int customerID) {
		return customer;
	}
	
	//method to view all available bookings for a certain dates and root type
	@SuppressWarnings("unchecked")
	public List<Booking> viewBookings(Date sDate, Date eDate, String roomType) {
		List<Booking> bookingsList = new ArrayList<>();
		
		EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("simple-jpaPU");
		EntityManager em = emf.createEntityManager();
		
		try {
			String query = "select b from Booking b";
			bookingsList = em.createQuery(query).getResultList();
			
			List<Booking> updatedBookingsList = new ArrayList<>();
			
			for(Booking b : bookingsList) {
				
				if(roomType.equals("All")) {
					return bookingsList;
				} else if(b.getCheckInDate().equals(sDate) && b.getCheckOutDate().equals(eDate) && b.getRoomType().equals(roomType)) {
					updatedBookingsList.add(b);
				}
			}
			
			return updatedBookingsList;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
		return bookingsList;
	}
	
	//method to view all available description categories for one chosen booking
	public ArrayList<String> getBookingCategories(int bookingNo) {
		//get the array list of booking description categories from database
		
		
		EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("simple-jpaPU");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Booking> findBookingQuery = em.createQuery("SELECT b FROM Booking b WHERE "
				+ "b.bookingNo = ?1", Booking.class);
		
		findBookingQuery.setParameter(1, bookingNo);
		
		List<DescriptionCategory> listOfCategories = new ArrayList<>();
		
		listOfCategories = findBookingQuery.getSingleResult().getCategoriesList();
		
		ArrayList<String> listofCategoriesNames = new ArrayList<>();
		
		for(DescriptionCategory dc : listOfCategories) {
			listofCategoriesNames.add(dc.getCategoryName());
		}
		return listofCategoriesNames;
	}
	
	//method to view information about selected description category
	public String viewDescriptionInfo(int bookingNo, String categoryName) {
		//get booking details based on booking number and selected category from database
		String bookingDescriptionDetails = null;
		
		EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("simple-jpaPU");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Booking> findBookingQuery = em.createQuery("SELECT b FROM Booking b WHERE "
				+ "b.bookingNo = ?1", Booking.class);
		
		findBookingQuery.setParameter(1, bookingNo);
		
		List<DescriptionCategory> listOfCategories = new ArrayList<>();
		
		listOfCategories = findBookingQuery.getSingleResult().getCategoriesList();
		
		HashMap<String, String> name_info = new HashMap<>();
		
		for(DescriptionCategory dc : listOfCategories) {
			name_info.put(dc.getCategoryName(),dc.getCategoryInfo());
		}
		
		bookingDescriptionDetails = name_info.get(categoryName);
		
		return bookingDescriptionDetails;
	}
	
	//add object to database
	public void persist(Object object) {
		EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("simple-jpaPU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(object);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}	
	}
	
	//finds the customer object in database
	//used for log in
	public boolean findCustomer(String username, String password) {
		
		EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("simple-jpaPU");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Customer> findCustomerQuery = em.createQuery("SELECT c FROM Customer c WHERE "
				+ "c.username = ?1 AND c.password = ?2", Customer.class);
		
		findCustomerQuery.setParameter(1, username);
		findCustomerQuery.setParameter(2, password);
		
		List<Customer> result = findCustomerQuery.getResultList();
		
		if(result.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
}
