package STARS_system;

import java.awt.Choice;
import java.awt.Container;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public class Login {
	
	public Student currentStudent;
	public String loginType;
	public Login() throws IOException
	{	
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Login Mode(Student/Admin): ");
		String choice = sc.nextLine();
		if (choice.equals("Student") )
		{
			String matricNo = studentLogin();
			this.loginType = "Student";
			this.currentStudent = StudentDB.getStudentObj(matricNo);
			
			
			if (StarsApp.currentDate.after(this.currentStudent.accessStartTime) && StarsApp.currentDate.before(this.currentStudent.accessEndTime))
			{
				return;
			}
			else {
				System.out.println("Access Denied, login during your allocated access period");
				StarsApp.terminate();
			}
			
		}
		else if(choice.equals("Admin"))
		{
			adminLogin();
			this.loginType = "Admin";
		}
		
		
	}
	private String studentLogin() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		accVerify verifier = new accVerify(false);
		while(true)
			{
				System.out.println("Username: ");
				String username = sc.nextLine();
				System.out.println("Password: ");
				String password = sc.nextLine();
				
				if (verifier.verification(username, password)==true) {
					return username;
				} 
				else {
					System.out.println("Wrong Username/Password!");
					System.out.println("Continue(y/n)?");
					String again= sc.nextLine();
					if(again.equals("n"))
					{
						StarsApp.terminate();
					}
				}
		}
	}
	private void adminLogin() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		accVerify verifier = new accVerify(true);
		while(true)
			{
				System.out.println("Username: ");
				String username = sc.nextLine();
				System.out.println("Password: ");
				String password = sc.nextLine();
				
				if (verifier.verification(username, password)==true) {
					return;
				} 
				else {
					System.out.println("Wrong Username/Password!");
					System.out.println("Continue(y/n)?");
					String again= sc.nextLine();
					if(again.equals("n"))
					{
						StarsApp.terminate();
					}
				}
		}
	}
}
