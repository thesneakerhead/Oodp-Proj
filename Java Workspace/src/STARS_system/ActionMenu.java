package STARS_system;

import java.awt.Choice;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


<<<<<<< HEAD:Java Workspace/src/STARS_system/actionMenu.java
<<<<<<< HEAD:Java Workspace/src/STARS_system/ActionMenu.java
=======
public class ActionMenu {
	public ActionMenu(String loginType, Student currentStudent) throws IOException
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/actionMenu.java
=======
public class ActionMenu {
	public ActionMenu(String loginType, Student currentStudent) throws IOException
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/ActionMenu.java
/**
 * Action menu class
 *
 */
<<<<<<< HEAD:Java Workspace/src/STARS_system/actionMenu.java
<<<<<<< HEAD:Java Workspace/src/STARS_system/ActionMenu.java
public class ActionMenu {
	/**
	 * Action menu constructor (choose to login as Administrator or Student)
	 * @param loginType Student type
	 * @param currentStudent Current student
	 * @throws IOException Exception handling
	 */
	public ActionMenu(String loginType, Student currentStudent) throws IOException
=======
=======
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/ActionMenu.java
	/**
	 * Action menu constructor (choose to login as Administrator or Student)
	 * @param login - Administrator/Student login
	 * @throws IOException Exception handling
	 */
<<<<<<< HEAD:Java Workspace/src/STARS_system/actionMenu.java
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/actionMenu.java
=======
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/ActionMenu.java
	{
		if (loginType == "Student")
		{
			STARSApp.emailSender.loginNotification(currentStudent);
			currentStudent.getSaccount().printNotifications();
			int choice = 0;
			while(true) {
				
				try {
				choice = student_menu();}
				
				catch (Exception e)
				{ STARSApp.terminate();}
				
				try {
					new StudentMenuMngr(choice,currentStudent);	
				} catch (Exception e) {
					STARSApp.terminate();
				}
				
				
			
			
			}
		}
		else if(loginType == "Admin")
		{
			int choice = 0;
			while(true) {
				
				try {
				choice = admin_menu();}
				
				catch (Exception e)
				{ STARSApp.terminate();}
				
				try {
					new AdminMenuMngr(choice);	
				} catch (Exception e) {
					STARSApp.terminate();
				}
				
				
			
			
			}
			
		}
		
		else
		{
			System.exit(0);
		}
		
	}
	/**
<<<<<<< HEAD:Java Workspace/src/STARS_system/actionMenu.java
<<<<<<< HEAD:Java Workspace/src/STARS_system/ActionMenu.java
	 * Print student menu method
	 * @return Choice of student
=======
	 * print student menu
	 * @return - choice selection
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/actionMenu.java
=======
	 * print student menu
	 * @return - choice selection
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/ActionMenu.java
	 */
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
	/**
<<<<<<< HEAD:Java Workspace/src/STARS_system/actionMenu.java
<<<<<<< HEAD:Java Workspace/src/STARS_system/ActionMenu.java
	 * Print administrator menu method
	 * @return Choice of administrator
=======
	 * print admin menu
	 * @return - choice selection
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/actionMenu.java
=======
	 * print admin menu
	 * @return - choice selection
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/ActionMenu.java
	 */
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
