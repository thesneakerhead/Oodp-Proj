package STARS_system;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class STARSApp {
	public static StudentDB studentDB;
/**
 * Stars App class
 *
 */
	/**
	 * Student database
	 */
	/**
	 * Current date
	 */
	public static Calendar currentDate;
	public static CourseDB courseDB;
	public static RegisteredCourses registeredcourses;
	public static SendEmail emailSender;

	/**
	 * Course database
	 */
	/**
	 * Registered courses
	 */
	/**
	 * Send email
	 */
	/**
	 * Main Method
	 * @throws ClassNotFoundException Class not found Exception handling
	 * @throws IOException Exception handling
	 */
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		init();
		
		start();
		
		
		terminate();
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Initialize method
	 * @throws ClassNotFoundException Class not found Exception handling
	 * @throws IOException Exception handling
	 */
	public static void init() throws ClassNotFoundException, IOException 
	{
		emailSender = new SendEmail();
		studentDB = new StudentDB();
		registeredcourses = new RegisteredCourses();
		courseDB = new CourseDB();
		currentDate = Calendar.getInstance();
		System.out.println("Welcome to STARS system");
		
	}
	/**
	 * Start method
	 * @throws IOException Exception handling
	 */
	public static void start() throws IOException
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Login Mode(Student/Admin): ");
		String choice = sc.nextLine();
		if (choice.equals("Admin")||choice.equals("admin") )
		{
			AdminLogin admin = new AdminLogin();
			new ActionMenu("Admin",null);
		}
		else if(choice.equals("Student")||choice.equals("student"))
		{
			LoginTimeCheck login = new LoginTimeCheck();
			System.out.println(login.getStudent().getMatricNo());
			new ActionMenu("Student",login.getStudent());
		}
		
	}
	/**
	 * Terminate method
	 */
	public static void terminate()
	{
		
		studentDB.serializeDB(studentDB.studentDB,"studentDB.ser");
		registeredcourses.serializeDB(registeredcourses.registerDict,"registeredCourses.ser");
		courseDB.serializeDB(courseDB.courseDB,"courseDB.ser");
		System.out.println("Exiting..........");
		System.exit(0);
	}
	

}
