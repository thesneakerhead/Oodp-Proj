package STARS_system;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class StarsApp {
	public static StudentDB studentDB;
	public static Calendar currentDate;
	public static courseDB courseDB;
	public static registeredCourses registeredcourses;
	public static sendEmail emailSender;

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		init();
		
		start();
		
		
		terminate();
	}
	
	
	
	
	
	
	
	
	
	public static void init() throws ClassNotFoundException, IOException 
	{
		emailSender = new sendEmail();
		studentDB = new StudentDB();
		registeredcourses = new registeredCourses();
		courseDB = new courseDB();
		currentDate = Calendar.getInstance();
		System.out.println("Welcome to STARS system");
		
	}
	public static void start() throws IOException
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Login Mode(Student/Admin): ");
		String choice = sc.nextLine();
		if (choice.equals("Admin")||choice.equals("admin") )
		{
			adminLogin admin = new adminLogin();
			new actionMenu("Admin",null);
		}
		else if(choice.equals("Student")||choice.equals("student"))
		{
			loginTimeCheck login = new loginTimeCheck();
			System.out.println(login.getStudent().getMatricNo());
			new actionMenu("Student",login.getStudent());
		}
		
	}
	public static void terminate()
	{
		
		studentDB.serializeDB(studentDB.studentDB,"studentDB.ser");
		registeredcourses.serializeDB(registeredcourses.registerDict,"registeredCourses.ser");
		courseDB.serializeDB(courseDB.courseDB,"courseDB.ser");
		System.out.println("Exiting..........");
		System.exit(0);
	}
	

}
