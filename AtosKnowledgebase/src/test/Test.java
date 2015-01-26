package test;

import java.net.UnknownHostException;
//import java.rmi.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoException;

import database.User;
import database.UserDao;
import database.UserDaoImpl;

public class Test {

	public static void main(String[] args) throws UnknownHostException, MongoException {

		// Database database = new Database();
		UserDao userDao = new UserDaoImpl();

		userDao.deleteAllRecordsSelectedCollection();

		List<String> comp1 = new ArrayList<>();
		List<String> comp2 = new ArrayList<>();
		List<String> comp3 = new ArrayList<>();
		List<String> comp4 = new ArrayList<>();
		comp1.add("Java Development");
		comp1.add("Web Development");
		comp2.add("Java Development");
		comp2.add("Android App Development");
		comp3.add("Java Development");
		comp4.add("Java Development");
		comp4.add("Web Development");

		userDao.registerUser("A587809", "Kevin", "", "Rovers", "27-12-1987", "Java Developer",
				comp1);
		userDao.registerUser("A589768", "Michel", "", "Molijn", "02-08-1987", "Java Developer",
				comp2);
		userDao.registerUser("A583573", "Radjiv", "", "Raghoebier", "23-05-1985", "Java Developer",
				comp3);
		userDao.registerUser("A585465", "Bas", "", "Maartense", "21-02-1989", "Java Developer",
				comp4);
		System.out.println("Alle Records in de database usercollection:");

		List<User> users = userDao.displayUsers();
		for (User user : users) {
			System.out.println(user);
		}

		System.out.println("\n\nGevonden record, met als zoekactie Radjiv Raghoebier op id: \n"
				+ userDao.getRecordsByID("Radjiv Raghoebier"));
		System.out.println("\nGevonden record, met als zoekactie Bas op FirstName: \n"
				+ userDao.getRecordsByFirstName("Bas"));
		System.out.println("\nGevonden record, met als zoekactie Daniel op MiddleName: \n"
				+ userDao.getRecordsByMiddleName("Daniel"));
		System.out.println("\nGevonden record, met als zoekactie Rienstra op SurName: \n"
				+ userDao.getRecordsByLastName("Rienstra"));

	}
}
