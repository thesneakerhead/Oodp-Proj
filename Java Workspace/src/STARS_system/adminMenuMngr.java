package STARS_system;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class adminMenuMngr {
	public adminMenuMngr(int choice) throws IOException
	{
		switch(choice)
		{
			case 1 :  
				
				break;
			case 2 :
				addStudent();
				break;
			case 3 :
				
				Scanner sc = new Scanner(System.in);
				System.out.println("=======================================================");
				System.out.println("|      1. Add a Course                                |");
				System.out.println("|      2. Add index for a Course                      |");
				System.out.println("|      3. Remove index for a Course                   |");
				System.out.println("=======================================================");
				System.out.println("Enter Choice:");
				int selection = sc.nextInt();
				sc.nextLine();
				switch(selection)
				{
				    case 1:
				    	System.out.println("Enter the followind details:");
				    	System.out.println("Course Name");
				    	String courseName = sc.nextLine();
				    	System.out.println("Course Code");
				    	String courseCode = sc.nextLine();
				    	System.out.println("Department:");
				    	String dptmnt = sc.nextLine();
				    	Department department = Department.valueOf(dptmnt);
				    	addCourse(courseName, courseCode, department);
				    	
				    	break;
				    	
				    case 2:
				    	System.out.println("Enter Course Code");
				    	String coursecode = sc.nextLine();
				    	System.out.println("Enter Index Id");
				    	String indexId = sc.nextLine();
				    	addIndex(coursecode, indexId);
				    	
				    	break;
				    	
				    case 3:
				    	System.out.println("Enter Course Code");
				    	String courscode = sc.nextLine();
				    	Course course = courseDB.getCourseObj(courscode);
				    	System.out.println("Current available indexes:");
				    	course.printIndexes();
				    	System.out.println("Enter the Index Id that you want to delete");
				    	String indexid = sc.nextLine();
				    	removeIndex(courscode, indexid);
				    	
				    	break;
				}
				
				break;
			case 4 :
				
				break;
				
			case 5 :
		        /*System.out.println("Enter Course Index");
		        String courseindex = sc.nextLine();
		        studentListbyIndex(courseindex);
				break;*/
			case 6 :
				
				break;
				
			case 7 :
				deleteStudent();
				break;
			
		}
	}
	
	private void addStudent() throws IOException {
		Scanner sc = new Scanner(System.in);
		Boolean valid = false;
		String matricNo=null;
		int year=0,month=0,day=0,hour=0,min=0,duration=0;
		while(!valid)
		{
			System.out.println("Enter Student's Matriculation Number(UXXXXXXXX):");
			matricNo = sc.nextLine();
			if(matricNo.length()!=9)
			{
				System.out.println("Invalid username, username must be 9 characters long!");
				continue;
			}
			valid = true;
		}
		valid = false;
		System.out.println("Enter Student's Name:");
		String name = sc.nextLine();
		System.out.println("Enter Student's Gender:");
		String gender = sc.nextLine();
		System.out.println("Enter Student's Nationality");
		String nationality = sc.nextLine();
		System.out.println("Please enter the following to set access period:");
		
		do {
			System.out.println("Year(yyyy)");
		    while (!sc.hasNextInt()) {
		        System.out.println("Invalid year!");
		        sc.next(); 
		    }
		    year = sc.nextInt();
		} while (year<2020||year>3000);
		
		do {
			System.out.println("Month(mm)");
		    while (!sc.hasNextInt()) {
		        System.out.println("Invalid month!");
		        sc.next();
		    }
		    month = sc.nextInt();
		} while (month<0||month>12);
		
		do {
			System.out.println("Day(dd)");
		    while (!sc.hasNextInt()) {
		        System.out.println("Invalid day!");
		        sc.next(); 
		    }
		    day = sc.nextInt();
		} while (day<1||day>31);
		
		do {
			System.out.println("Hour(hh)");
		    while (!sc.hasNextInt()) {
		        System.out.println("Invalid hour!");
		        sc.next(); 
		    }
		    hour = sc.nextInt();
		} while (hour<1||hour>23);
		
		do {
			System.out.println("Minute(mm)");
		    while (!sc.hasNextInt()) {
		        System.out.println("Invalid minute!");
		        sc.next(); 
		    }
		    min = sc.nextInt();
		    
		} while (min<0||min>59);
		do {
			System.out.println("Enter access duration(in hours):");
		    while (!sc.hasNextInt()) {
		        System.out.println("Please enter a positive number");
		        sc.next(); 
		    }
		    duration = sc.nextInt();
		} while (duration<0);
	
		Calendar regDate = new GregorianCalendar(year,month-1,day,hour,min,00);
		regDate.add(Calendar.HOUR, 0);
		Calendar regDate_end = (Calendar)regDate.clone();
        regDate_end.add(Calendar.HOUR, duration);
		
		new Student(matricNo, name, gender, nationality,regDate,regDate_end);
	}
	private void deleteStudent() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the matriculation number of the student you want to delete:");
		String matricNo = sc.nextLine();
		starsaccMngr.deleteAcc(matricNo, false);
		StudentDB.deleteStudent(matricNo);
	}
	private void addCourse(String courseName,String courseCode,Department department)
	{
		Course course = new Course(courseName, courseCode, department);
		System.out.println("Course added!");
	}
	private void addIndex(String courseCode,String indexId)
	{
		Course course = courseDB.getCourseObj(courseCode);
		course.addIndex(indexId);
	}
	private void removeIndex(String courseCode,String indexId)
	{
		Course course = courseDB.getCourseObj(courseCode);
		boolean removed = course.removeIndex(indexId);
		if (removed == true)
		{
			System.out.println("Index removed!");}
		else {
			{
				System.out.println("No such Index!");
			}
		}
	}
	/*private void studentListbyIndex(String courseIndex)
	  {
	    Dictionary tempDict = registeredcourses.registeredDict;
	    ArrayList<String> StudentListbyIndex = new ArrayList<String>();
	    
	    for(int i=0; i<tempDict.size; i++) {
	    if(tempDict.getvalue == courseIndex) {
	      StudentListbyIndex.add(tempDict.keys());
	    }
	  }
	    System.out.println(StudentListbyIndex);
	    }*/
	
}
