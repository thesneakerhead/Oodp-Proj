package STARS_system;

import java.io.IOException;
import java.util.Scanner;
<<<<<<< HEAD:Java Workspace/src/STARS_system/StudentLogin.java
/**
 * Student login class
 *
 */
public class StudentLogin extends Login {
	/**
	 * Student username
	 */
=======

public class StudentLogin extends Login {

>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/studentLogin.java
	private String username;
	/**
	 * Student password
	 */
	private String password;
	/**
	 * Current student
	 */
	private Student currentStudent;
<<<<<<< HEAD:Java Workspace/src/STARS_system/StudentLogin.java
	/**
	 * Student login constructor
	 * @throws IOException Exception handling
	 */
=======
	
>>>>>>> fc3b94e5d4f07abbf8a276480c5dde9a6ed65697:Java Workspace/src/STARS_system/studentLogin.java
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
	/**
	 * System login method (check whether username and password entered are correct)
	 */
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
	/**
	 * Get student method
	 * @return Current student
	 */
	public Student getStudent()
	{
		String matricNo = this.username;
		this.currentStudent = StudentDB.getStudentObj(matricNo);
		return this.currentStudent;
	}

}
