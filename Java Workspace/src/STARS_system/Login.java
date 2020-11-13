package STARS_system;

import java.awt.Choice;
import java.awt.Container;
import java.io.IOException;
import java.util.Scanner;

public class Login {
	
	public Student currentStudent;
	public Login() throws IOException
	{	
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Login Mode(Student/Admin): ");
		String choice = sc.nextLine();
		if (choice.equals("Student") )
		{
			String matricNo = studentLogin();
			this.currentStudent = StudentDB.getStudentObj(matricNo);
		}
		
		
		
	}
	private String studentLogin() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		accVerify verifier = new accVerify();
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
						System.exit(0);
					}
				}
		}
	}
}
