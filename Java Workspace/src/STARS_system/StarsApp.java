package STARS_system;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class StarsApp {
	private static StudentDB studentDB;
	public static Calendar currentDate;
	private static courseDB courseDB;
	private static registeredCourses registeredcourses;

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		init();
		
		start();
		
		
		terminate();
	}
	
	
	
	
	
	
	
	
	
	public static void init() throws ClassNotFoundException, IOException 
	{
		studentDB = new StudentDB();
		registeredcourses = new registeredCourses();
		courseDB = new courseDB();
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
		registeredcourses.serializeRegisterDict(registeredcourses.registerDict);
		courseDB.serializeCourseDB(courseDB.courseDB);
		System.out.println("Exiting..........");
		System.exit(0);
	}
	

}
