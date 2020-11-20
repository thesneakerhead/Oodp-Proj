package STARS_system;

import java.io.IOException;
import java.util.Scanner;

public class Login2 {

public Student currentStudent;

public Login2() throws IOException
{
	String matricNo = studentLogin();
	this.currentStudent = StudentDB.getStudentObj(matricNo);
}
	
private String studentLogin() throws IOException
{
	Scanner sc = new Scanner(System.in);
	accVerify verifier = new accVerify(false);
	while(true)
		{
			System.out.println("Student 2 login ");
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
					return null;
				}
			}
	}
}
}