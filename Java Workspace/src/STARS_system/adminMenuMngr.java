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
				
				editStudentAccessPeriod();
				
				break;
			case 2 :
				addStudent();
				break;
			case 3 :
				addupdateCourse();
				break;
			case 4 :
				checkAvailableSlotsByIndex();
				
				break;
				
			case 5 :
				printStudentsByIndex();
				
				break;
			case 6 :
				printStudentsByCourse();
				break;
				
			case 7 :
				deleteStudent();
				break;
			
		}
	}
	private void addupdateCourse()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("=======================================================");
		System.out.println("|      1. Add a Course                                |");
		System.out.println("|      2. Add index for a Course                      |");
		System.out.println("|      3. Remove index for a Course                   |");
		System.out.println("|      4. Remove Course by Course Code                |");
		System.out.println("=======================================================");
		System.out.println("Enter Choice:");
		int selection = sc.nextInt();
		sc.nextLine();
		Boolean valid=false;
		String courseCode=null;
		switch(selection)
		{
		    case 1:
		    	System.out.println("Enter the followind details:");
		    	System.out.println("Course Name");
		    	String courseName = sc.nextLine();
		    	while(!valid)
		    	{
			    	System.out.println("Course Code");
			    	courseCode = sc.nextLine();
			    	Course course = courseDB.getCourseObj(courseCode);
			    	if(course!=null)
			    	{
			    		System.out.println("There is an existing course of the same course code");
			    		continue;
			    	}
			    	else
			    		valid=true;
		    	}
		    	String dptmnt=null;
		    	valid=false;
		    	String[] dept = new String[] {"CBE","EEE","CEE","SCSE","MSE","MAE","ADM","SSS","WKSCI","SBS","SPMS","LKCsoM","NIE","RSIS",
		    			"ASE","HSS","NBS"};
		    	
		    	while(!valid)
		    	{
			    	System.out.println("Department:");
			    	dptmnt = sc.nextLine();
			    	for(int i =0;i<17;i++)
			    	{
			    		if(dptmnt.equals(dept[i]))
			    		{
			    			valid=true;
			    			break;
			    		}
			    	}
			    	System.out.println("Invalid department!");

		    	}
		    	Department department = Department.valueOf(dptmnt);
		    	
		    	addCourse(courseName, courseCode, department);
		    	break;
		    	
		    case 2:
		    	Boolean same = true;
		    	int count=0;
		    	String indexId=null;
		    	System.out.println("Enter Course Code");
		    	String coursecode = sc.nextLine();
		    	Course course = courseDB.getCourseObj(coursecode);
		    	if(course==null)
		    	{
		    		System.out.println("There is no course of the course code "+coursecode);
		    		return;
		    	}
		    	while (same==true)
		    	{
			    	System.out.println("Enter Index Id");
			    	indexId = sc.nextLine();
			    	if(course.numIndex==0)
			    		same=false;
			    	for(int i=0;i<course.numIndex;i++)
			    	{
			    		
			    		if(!indexId.equals(course.courseIndex[i].indexID))
			    		{
			    			count++;
			    		}
			    		else
			    		{
			    			System.out.println("There is an existing course index "+indexId);
			    			break;
			    		}
			    		
			    	}
			    	
			    	
			    	if (count==course.numIndex)
			    		same=false;
		    	}
		    	addIndex(coursecode, indexId);
		    	
		    	break;
		    	
		    case 3:
		    	String indexid=null;
		    	System.out.println("Enter Course Code");
		    	String courscode = sc.nextLine();
		    	course = courseDB.getCourseObj(courscode);
		    	courseIndex cIndex=null;
		    	System.out.println("Current available indexes:");
		    	course.printIndexes();
		    	while(cIndex==null) 
		    	{
		    		System.out.println("Enter the Index Id from current available indexes that you want to delete");
		    		indexid = sc.nextLine();
			    	cIndex=course.getIndex(indexid);			    	
		    	}
		    	registeredCourses.deleteIndex(indexid);
		    	removeIndex(courscode, indexid);
		    	
		    	break;
		    case 4:
		    	courseDB.printCourses();
		    	String cCode=null;
		    	course =null;
		    	while(course==null)
		    	{
			    	System.out.println("Enter Course Code from existing courses to delete");
			    	cCode = sc.nextLine();
			    	course = courseDB.getCourseObj(cCode);
		    	}
		    	System.out.println("Press (y) to confirm deletion of course "+cCode);
		    	String sel = sc.nextLine();
		    	if (sel.equals("y")||sel.equals("Y"))
		    	{
		    		courseDB.deleteCourse(cCode);
		    		registeredCourses.deleteIndexFromCourse(cCode);
		    	}
		}
	}
	
	private void addStudent() throws IOException {
		Scanner sc = new Scanner(System.in);
		Boolean valid = false;
		String matricNo=null;
		String email = null;
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
		} while (hour<0||hour>23);
		
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
		} while (duration<1);
		sc.nextLine();
		Calendar regDate = new GregorianCalendar(year,month-1,day,hour,min,00);
		regDate.add(Calendar.HOUR, 0);
		Calendar regDate_end = (Calendar)regDate.clone();
        regDate_end.add(Calendar.HOUR, duration);
        do {
        System.out.println("Enter Student's email:");
        email = sc.nextLine();
        if (!(email.endsWith(".com")&&email.contains("@")))
        {
        	System.out.println("Invalid email! Please re-enter");
        }
        }while(!(email.endsWith(".com")&&email.contains("@")));
		new Student(matricNo, name, gender, nationality,regDate,regDate_end,email);
	}
	private void deleteStudent() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the matriculation number of the student you want to delete:");
		String matricNo = sc.nextLine();
		starsaccMngr.deleteAcc(matricNo, false);
		StudentDB.deleteStudent(matricNo);
		registeredCourses.removeStudentIndexes(matricNo);
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
	private void printStudentsByIndex()
	{	
		try {
			Scanner sc= new Scanner(System.in);
			System.out.println("Enter course code:");
			String courseCode = sc.nextLine();
			System.out.println("Enter course index:");
			String courseIndex = sc.nextLine();
			Course course = courseDB.getCourseObj(courseCode);
			System.out.println("Students in this index:");
			course.getIndex(courseIndex).printStudentList();}
		catch (Exception e) {
			System.out.println("Combination of course and index not found!");
		}
	}
	private void printStudentsByCourse()
	{
		try {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter course code:");
		String courseCode = sc.nextLine();
		Course course = courseDB.getCourseObj(courseCode);
		System.out.println("Students in this Course:");
		for (int i = 0;i<course.numIndex;i++)
		{
			course.courseIndex[i].printStudentList();
		}}
		catch (Exception e) {
			System.out.println("Course not found");
		}
	}
	private void checkAvailableSlotsByIndex()
	{
		try {
			Scanner sc= new Scanner(System.in);
			System.out.println("Enter course code:");
			String courseCode = sc.nextLine();
			System.out.println("Enter course index:");
			String courseIndex = sc.nextLine();
			Course course = courseDB.getCourseObj(courseCode);
			System.out.println("There are "+course.getIndex(courseIndex).indexVacancy+" vacant spots");}
		catch (Exception e) {
			System.out.println("Combination of course and index not found!");
		}
	}
	private void editStudentAccessPeriod()
	{
		int year=0,month=0,day=0,hour=0,min=0,duration=0;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Student's matricNo:");
		String matricNo = sc.nextLine();
		Student student = StudentDB.getStudentObj(matricNo);
		if (student == null)
		{
			System.out.println("Student is not in database!");
		}
		else {
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
			} while (hour<0||hour>23);
			
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
	        student.setAccessStartTime(regDate);
	        student.setAccessEndTime(regDate_end);
	        
		}
	}
	
}
