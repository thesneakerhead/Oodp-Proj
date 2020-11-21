package STARS_system;

import java.awt.Choice;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class actionMenu {
	public actionMenu(Login login) throws IOException
	{
		if (login.loginType == "Student")
		{
			StarsApp.emailSender.loginNotification(login.currentStudent);
			login.currentStudent.getSaccount().printNotifications();
			int choice = 0;
			while(true) {
				
				try {
				choice = student_menu();}
				
				catch (Exception e)
				{ StarsApp.terminate();}
				
				try {
					new studentMenuMngr(choice,login.currentStudent);	
				} catch (Exception e) {
					StarsApp.terminate();
				}
				
				
			
			
			}
		}
		else if(login.loginType == "Admin")
		{
			int choice = 0;
			while(true) {
				
				try {
				choice = admin_menu();}
				
				catch (Exception e)
				{ StarsApp.terminate();}
				
				try {
					new adminMenuMngr(choice);	
				} catch (Exception e) {
					StarsApp.terminate();
				}
				
				
			
			
			}
			
		}
		
		else
		{
			System.exit(0);
		}
		
	}
	public int student_menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=======================================================");
		System.out.println("|      1. Add Course                                  |");
		System.out.println("|      2. Drop Course                                 |");
		System.out.println("|      3. Check/Print Courses Registered              |");
		System.out.println("|      4. Check Vacancies Available                   |");
		System.out.println("|      5. Change Index Number of Course               |");
		System.out.println("|      6. Swap Index Number with Another Student      |");
		System.out.println("|      7. Change Account Details                      |");
		System.out.println("|                                                     |");
		System.out.println("|      Enter any other key to exit!                   |");
		System.out.println("=======================================================");
		System.out.println("Select an option:");
		int Choice = sc.nextInt();
		return Choice;
	}
	public int admin_menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=======================================================");
		System.out.println("|      1. Edit Student Access Period                  |");
		System.out.println("|      2. Add a Student                               |");
		System.out.println("|      3. Add/Update a course                         |");
		System.out.println("|      4. Check Available Vacancy for an index number |");
		System.out.println("|      5. Print Student List by index number          |");
		System.out.println("|      6. Print Student List by course                |");
		System.out.println("|      7. Delete a Student                            |");
		System.out.println("|                                                     |");
		System.out.println("|      Enter any other key to exit!                   |");
		System.out.println("=======================================================");
		System.out.println("Select an option:");
		int Choice = sc.nextInt();
		return Choice;
	}	
	
}
