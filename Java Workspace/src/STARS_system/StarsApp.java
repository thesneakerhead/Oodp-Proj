package STARS_system;

import java.io.IOException;
import java.util.Calendar;

public class StarsApp {
	private static StudentDB studentDB;
	public static Calendar currentDate;

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		init();
		
		start();
		
		terminate();
	}
	
	
	
	
	
	
	
	
	
	public static void init() throws ClassNotFoundException, IOException 
	{
		studentDB = new StudentDB();
		currentDate = Calendar.getInstance();
		System.out.println("Welcome to STARS system");
		
	}
	public static void start() throws IOException
	{
		Login login = new Login();
		new actionMenu(login);
	}
	public static void terminate()
	{
		studentDB.serializeStudentDB(studentDB.studentDB);
		System.out.println("Exiting..........");
		System.exit(0);
	}
	

}
