package STARS_system;

import java.io.IOException;
import java.util.Scanner;

public class StudentLogin extends Login {

	private String username;
	private String password;
	private Student currentStudent;
	
	public StudentLogin()throws IOException
	{
		Boolean valid = false;
		while(valid == false)
		{
			super.askInput();
			this.username = super.getUsername();
			this.password = super.getPassword();
			valid = systemLogin(this.username,this.password);
		}
		
		
		
	}
	public Boolean systemLogin(String username, String password) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		AccVerify verifier = new AccVerify(false);
				
		if (verifier.verification(username, password)==true) 			
			return true;
			
		else 
		{
			System.out.println("Wrong Username/Password!");
			System.out.println("Continue(y/n)?");
			String again= sc.nextLine();
			if(again.equals("n"))
			{
				STARSApp.terminate();
			}
			return false;
		}
	}

	public Student getStudent()
	{
		String matricNo = this.username;
		this.currentStudent = StudentDB.getStudentObj(matricNo);
		return this.currentStudent;
	}

}
