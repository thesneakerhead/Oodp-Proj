package STARS_system;

import java.io.IOException;
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
				
				break;
			case 4 :
				
				break;
				
			case 5 :
				
				break;
			case 6 :
				
				break;
				
			case 7 :
				deleteStudent();
				break;
			
		}
	}
	
	public void addStudent() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student's Matriculation Number(UXXXXXXXX):");
		String matricNo = sc.nextLine();
		System.out.println("Enter Student's Name:");
		String name = sc.nextLine();
		System.out.println("Enter Student's Gender:");
		String gender = sc.nextLine();
		System.out.println("Enter Student's Nationality");
		String nationality = sc.nextLine();
		System.out.println("Please enter the following to set access period:");
		System.out.println("Year(yyyy)");
		int year = sc.nextInt();
		System.out.println("Month(mm)");
		int month = sc.nextInt();
		System.out.println("Day(dd)");
		int day = sc.nextInt();
		System.out.println("Hour(hh)");
		int hour = sc.nextInt();
		System.out.println("Minute(mm)");
		int min = sc.nextInt();
		System.out.println("Enter access duration(in hours):");
		int duration = sc.nextInt();
		Calendar regDate = new GregorianCalendar(year,month-1,day,hour,min,00);
		regDate.add(Calendar.HOUR, 0);
		Calendar regDate_end = (Calendar)regDate.clone();
        regDate_end.add(Calendar.HOUR, duration);
		
		new Student(matricNo, name, gender, nationality,regDate,regDate_end);
	}
	public void deleteStudent() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the matriculation number of the student you want to delete:");
		String matricNo = sc.nextLine();
		starsaccMngr.deleteAcc(matricNo, false);
		StudentDB.deleteStudent(matricNo);
	}
}
