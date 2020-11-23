package STARS_system;

import java.awt.Choice;
import java.awt.Container;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public abstract class Login {
	
	//public Student currentStudent;
	//public String loginType;
	private String username;
	private String password;
	public Login() throws IOException
	{	
		
		/*Scanner sc = new Scanner(System.in);
		System.out.println("Enter Login Mode(Student/Admin): ");
		String choice = sc.nextLine();
		if (choice.equals("Student")||choice.equals("student") )
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
		else if(choice.equals("Admin")||choice.equals("admin"))
		{
			adminLogin();
			this.loginType = "Admin";
		}
		*/
		
		
	}
	public abstract Boolean systemLogin(String username, String password)throws IOException;
	public void askInput()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Username: ");
		this.username = sc.nextLine();
		while(username.length()!=9)
		{
			System.out.println("Invalid username, username must be 9 characters long!");
			this.username = sc.nextLine();
		}
		System.out.println("Password: ");
		this.password = sc.nextLine();
	}
	public String getUsername()
	{
		return this.username;
	}
	public String getPassword()
	{
		return this.password;
	}
	/*private String studentLogin() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		accVerify verifier = new accVerify(false);
		while(true)
			{
				System.out.println("Username: ");
				String username = sc.nextLine();
				if(username.length()!=9)
				{
					System.out.println("Invalid username, username must be 9 characters long!");
					continue;
				}
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
				if(username.length()!=9)
				{
					System.out.println("Invalid username, username must be 9 characters long!");
					continue;
				}
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
	}*/
}
